package com.udacity.jdnd.course3.critter.user.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer getCustomerByPetsId(Long petId) {
        return customerRepository.findCustomerByPetsId(petId);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    
}
