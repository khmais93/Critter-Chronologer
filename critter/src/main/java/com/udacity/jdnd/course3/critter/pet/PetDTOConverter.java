package com.udacity.jdnd.course3.critter.pet;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.udacity.jdnd.course3.critter.shared.BaseEntityMapper;
import com.udacity.jdnd.course3.critter.user.Customer.CustomerService;

import lombok.AllArgsConstructor;


/**
 * Refactored convert methods here to make controller class cleaner.
 */
@AllArgsConstructor
@Service
public class PetDTOConverter implements BaseEntityMapper<PetDTO, Pet> {

    CustomerService customerService;

    @Override
    public PetDTO modelToDto(Pet pet){
        PetDTO petDTO = new PetDTO();
        BeanUtils.copyProperties(pet, petDTO);
        petDTO.setOwnerId(pet.getOwner().getId());
        return petDTO;
    }

    @Override
    public Pet dtoToModel(PetDTO petDTO){
        Pet pet = new Pet();
        BeanUtils.copyProperties(petDTO, pet);
        pet.setOwner(customerService.getCustomerById(petDTO.getOwnerId()));
        return pet;
    }
}
