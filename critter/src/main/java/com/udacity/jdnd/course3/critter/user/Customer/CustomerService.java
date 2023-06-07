package com.udacity.jdnd.course3.critter.user.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    Customer getCustomerByPetsId(Long petId); 
}
