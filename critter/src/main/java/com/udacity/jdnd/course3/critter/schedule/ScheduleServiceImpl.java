package com.udacity.jdnd.course3.critter.schedule;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ScheduleServiceImpl implements ScheduleService{

    ScheduleRepository scheduleRepository;

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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Schedule> getScheduleForCustomer(Long customerId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Schedule> getScheduleForEmployee(Long employeeId) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
