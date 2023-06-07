package com.udacity.jdnd.course3.critter.schedule;

import java.util.List;

public interface ScheduleService {
    
    Schedule createSchedule(Schedule schedule);
    List<Schedule> getAllSchedules();
    List<Schedule> getScheduleForPet(long petId);
    List<Schedule> getScheduleForEmployee(Long employeeId) ;
    List<Schedule> getScheduleForCustomer(Long customerId);

}
