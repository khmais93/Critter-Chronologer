package com.udacity.jdnd.course3.critter.pet;

import org.springframework.web.bind.annotation.*;

import com.udacity.jdnd.course3.critter.user.Customer.CustomerService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Pets.
 */
@AllArgsConstructor
@RestController
@RequestMapping("/pet")
public class PetController {

    PetService petService;
    CustomerService customerService;
    PetDTOConverter petDTOConverter;

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        return petDTOConverter.modelToDto(petService.savePet(petDTOConverter.dtoToModel(petDTO)));
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        return petDTOConverter.modelToDto(petService.getPet(petId));
    }

    @GetMapping
    public List<PetDTO> getPets(){
        return petService.getPets().stream().map(petDTOConverter::modelToDto).collect(Collectors.toList());
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        return petService.getPetsByOwner(ownerId).stream().map(petDTOConverter::modelToDto).collect(Collectors.toList());
    }
}
