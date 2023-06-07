package com.udacity.jdnd.course3.critter.user.Employee;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.time.DayOfWeek;


public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findByDaysAvailable(DayOfWeek day);
}
