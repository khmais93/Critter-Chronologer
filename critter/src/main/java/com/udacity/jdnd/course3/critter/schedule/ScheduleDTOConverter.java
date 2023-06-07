package com.udacity.jdnd.course3.critter.schedule;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.pet.PetService;
import com.udacity.jdnd.course3.critter.shared.BaseEntityMapper;
import com.udacity.jdnd.course3.critter.user.Employee.Employee;
import com.udacity.jdnd.course3.critter.user.Employee.EmployeeService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ScheduleDTOConverter implements BaseEntityMapper<ScheduleDTO, Schedule> {

    EmployeeService employeeService;
    PetService petService;

    @Override
    public ScheduleDTO modelToDto(Schedule schedule) {
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        BeanUtils.copyProperties(schedule, scheduleDTO);

        List<Employee> employees = schedule.getEmployees();
        List<Pet> pets = schedule.getPets();

        scheduleDTO.setEmployeeIds(employees.stream().map(Employee::getId).collect(Collectors.toList()));
        scheduleDTO.setPetIds(pets.stream().map(Pet::getId).collect(Collectors.toList()));

        return scheduleDTO;
    }

    @Override
    public Schedule dtoToModel(ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();
        BeanUtils.copyProperties(scheduleDTO, schedule);

        List<Long> employeeIds = scheduleDTO.getEmployeeIds();
        List<Long> petIds = scheduleDTO.getPetIds();

        schedule.setEmployees(employeeIds.stream().map(id -> employeeService.getEmployee(id))
        .collect(Collectors.toList()));   
        
        schedule.setPets(petIds.stream().map(id -> petService.getPet(id))
        .collect(Collectors.toList()));

        return schedule;
    }
    
}
