package com.udacity.jdnd.course3.critter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.user.Customer.CustomerDTO;
import com.udacity.jdnd.course3.critter.user.Customer.CustomerDTOConverter;
import com.udacity.jdnd.course3.critter.user.Customer.CustomerService;
import com.udacity.jdnd.course3.critter.user.Employee.Employee;
import com.udacity.jdnd.course3.critter.user.Employee.EmployeeDTO;
import com.udacity.jdnd.course3.critter.user.Employee.EmployeeDTOConverter;
import com.udacity.jdnd.course3.critter.user.Employee.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.user.Employee.EmployeeService;

import lombok.AllArgsConstructor;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Users.
 *
 * Includes requests for both customers and employees. Splitting this into separate user and customer controllers
 * would be fine too, though that is not part of the required scope for this class.
 */
@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    CustomerService customerService;
    EmployeeService employeeService;
    CustomerDTOConverter customerDTOConverter;
    EmployeeDTOConverter employeeDTOConverter;

    @PostMapping("/customer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return customerDTOConverter.convertCustomerToDTO(customerService.saveCustomer(customerDTOConverter.convertDTOToCustomer(customerDTO)));
    }

    @GetMapping("/customer")
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers().stream()
                .map(customerDTOConverter::convertCustomerToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/customer/{customerId}")
    public CustomerDTO getCustomer(@PathVariable Long customerId){
        return customerDTOConverter.convertCustomerToDTO(customerService.getCustomerById(customerId));
    }

    @GetMapping("/customer/pet/{petId}")
    public CustomerDTO getOwnerByPet(@PathVariable long petId){
        return customerDTOConverter.convertCustomerToDTO(customerService.getCustomerByPetsId(petId));
    }

    @PostMapping("/employee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeDTOConverter.convertEmployeeToDTO(employeeService.saveEmployee(employeeDTOConverter.convertDTOToEmployee(employeeDTO)));
    }

    @GetMapping("/employee")
    public List<EmployeeDTO> getAllEmployees()  {
        return employeeService.getAllEmployees().stream()
        .map(employeeDTOConverter::convertEmployeeToDTO)
        .collect(Collectors.toList());
    }
    
    @GetMapping("/employee/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable long employeeId) {
        return employeeDTOConverter.convertEmployeeToDTO(employeeService.getEmployee(employeeId));
    }

    @PutMapping("/employee/{employeeId}")
    public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
        employeeService.setAvailability(daysAvailable, employeeId);
    }

    @GetMapping("/employee/availability")
    public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeDTO) {
        throw new UnsupportedOperationException();
    }

}
