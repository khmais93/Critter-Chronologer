package com.udacity.jdnd.course3.critter.user.Customer;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.udacity.jdnd.course3.critter.pet.Pet;

import lombok.Data;

@Entity
@Data
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String phoneNumber;

    private String notes;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Pet> pets = new LinkedList<>();

    public void addPet(Pet pet) {
        pets.add(pet);
        pet.setOwner(this);
    }
    
    public void removePet(Pet pet) {
        pets.remove(pet);
        pet.setOwner(null);
    }
}
