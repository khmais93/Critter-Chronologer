package com.udacity.jdnd.course3.critter.user.Employee;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.udacity.jdnd.course3.critter.shared.BaseEntityMapper;

@Component
public class EmployeeDTOConverter implements BaseEntityMapper<EmployeeDTO, Employee> {

    @Override
    public EmployeeDTO modelToDto(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee, employeeDTO);
        return employeeDTO;
    }

    @Override
    public Employee dtoToModel(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        return employee;
    }
}
