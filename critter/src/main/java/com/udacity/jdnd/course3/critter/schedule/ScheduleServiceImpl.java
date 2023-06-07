package com.udacity.jdnd.course3.critter.schedule;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.user.Customer.Customer;
import com.udacity.jdnd.course3.critter.user.Customer.CustomerService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ScheduleServiceImpl implements ScheduleService{

    ScheduleRepository scheduleRepository;
    CustomerService customerService;

    @Override
    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return (List<Schedule>) scheduleRepository.findAll();
    }

    @Override
    public List<Schedule> getScheduleForPet(long petId) {
        return scheduleRepository.findScheduleByPetsId(petId);
    }

    @Override
    public List<Schedule> getScheduleForCustomer(Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        List<Pet> pets = customer.getPets();

        // for(Pet pet : pets){
        //     List<Schedule> schedule = scheduleRepository.findScheduleByPetsId(pet.getId());
        // }

        return pets.stream()
        .map(pet->scheduleRepository.findScheduleByPetsId(pet.getId()))
        .flatMap(List::stream)
        .collect(Collectors.toList());

    }

    @Override
    public List<Schedule> getScheduleForEmployee(Long employeeId) {
        return scheduleRepository.findScheduleByEmployeesId(employeeId);

    }
    
}
