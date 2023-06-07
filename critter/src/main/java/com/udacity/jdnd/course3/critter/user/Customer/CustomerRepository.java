package com.udacity.jdnd.course3.critter.user.Customer;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {

    Customer findCustomerByPetsId(Long id);
    
}
