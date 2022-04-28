package com.example.app.service.Employee;

import com.example.app.domain.Employee;
import com.example.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        return employeeRepository.findAll();// pridat funkciu do repositry
    }

    @Override
    public Optional<Employee> getEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void addEmployee(String name, String surname, String project, Date date, boolean isDone) {
        employeeRepository.save(new Employee(name, surname, project, date, isDone));
    }

    @Override
    public void deleteEmployee(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        employee.ifPresent(value -> employeeRepository.delete(value));
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

}
