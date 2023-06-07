package com.udacity.jdnd.course3.critter.schedule;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {

    List<Schedule> findScheduleByPetsId(Long petId);
    List<Schedule> findScheduleByEmployeesId(Long employeeId);
    
}
