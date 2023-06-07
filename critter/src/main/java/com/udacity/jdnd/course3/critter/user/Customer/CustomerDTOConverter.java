package com.udacity.jdnd.course3.critter.user.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.pet.PetService;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Refactored convert methods here to make controller class cleaner.
 */
@AllArgsConstructor
@Service
public class CustomerDTOConverter {

    PetService petService;

    public CustomerDTO convertCustomerToDTO(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);

        List<Long> petIds = new ArrayList<>();

        if (customer.getPets() != null){
            customer.getPets().forEach(pet -> petIds.add(pet.getId()));
        }

        customerDTO.setPetIds(petIds);

        return customerDTO;
    }

    public Customer convertDTOToCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);

        List<Long> petIds = customerDTO.getPetIds();

        if (petIds != null){
            List<Pet> pets = petService.getPets();
            customer.setPets(pets);
        }

        return customer;
    }
}
