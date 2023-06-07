package com.udacity.jdnd.course3.critter.user.Employee;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findEmployeesForService(EmployeeRequestDTO employeeDTO) {
        Set<EmployeeSkill> skills = employeeDTO.getSkills();
        LocalDate date = employeeDTO.getDate();
        List<Employee> employees = employeeRepository.findByDaysAvailable(date.getDayOfWeek());
        return employees.stream()
        .filter(employee -> employee.getSkills().containsAll(skills))
        .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void setAvailability(Set<DayOfWeek> daysAvailable, long employeeId) {
        
        Employee employee = getEmployee(employeeId);
        employee.setDaysAvailable(daysAvailable);
        saveEmployee(employee);
        
    }

    
    
}
