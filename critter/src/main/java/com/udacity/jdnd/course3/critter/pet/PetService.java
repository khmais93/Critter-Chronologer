package com.udacity.jdnd.course3.critter.pet;

import java.util.List;

public interface PetService {
    Pet savePet(Pet pet);
    Pet getPet(Long petId);
    List<Pet> getPets();
    List<Pet> getPetsByOwner(Long ownerId);
}
