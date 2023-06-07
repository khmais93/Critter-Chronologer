package com.udacity.jdnd.course3.critter.pet;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
public interface PetRepository extends CrudRepository<Pet, Long> {

    List<Pet> findByOwnerId(Long ownerId);
    
} 
    

