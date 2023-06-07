package com.udacity.jdnd.course3.critter.pet;

import java.util.List;

import org.springframework.stereotype.Service;

import com.udacity.jdnd.course3.critter.user.Customer.Customer;
import com.udacity.jdnd.course3.critter.user.Customer.CustomerRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class PetServiceImpl implements PetService {

    PetRepository petRepository;
    CustomerRepository customerRepository;

    @Override
    public Pet getPet(Long petId) {
        return petRepository.findById(petId).orElse(null);
    }

    @Override
    public List<Pet> getPets() {
        return (List<Pet>) petRepository.findAll();
    }

    @Override
    public List<Pet> getPetsByOwner(Long ownerId) {
        return petRepository.findByOwnerId(ownerId);
    }

    @Override
    public Pet savePet(Pet pet) {
        Pet petToSave = petRepository.save(pet);
        Customer owner = petToSave.getOwner();
        owner.addPet(petToSave);
        customerRepository.save(owner);
        return  petToSave;
    }
}
