package com.example.app.service.Employee;

import com.example.app.domain.Employee;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getEmployeeByName(String name);

    Optional<Employee> getEmployeeById(long id);

    void updateEmployee(Employee Employee);

    void addEmployee(String name, String surname,
                     String project, Date date,
                     boolean isDone);

    void deleteEmployee(long id);

    void saveEmployee(Employee Employee);

}
