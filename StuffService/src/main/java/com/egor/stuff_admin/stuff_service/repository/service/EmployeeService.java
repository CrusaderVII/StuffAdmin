package com.egor.stuff_admin.stuff_service.repository.service;

import com.egor.stuff_admin.stuff_service.model.Employee;
import com.egor.stuff_admin.stuff_service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repository;

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee getEmployeeById(long id) {
        return repository.findById(id)
                .get();
    }

    public Employee updateEmployee(Employee newEmployee) {
        //TODO: check if such employee exists
        Employee oldEmployee = getEmployeeById(newEmployee.getId());
        oldEmployee = newEmployee;
        return repository.save(oldEmployee);
    }

    public void deleteEmployee(Employee employee) {
        repository.delete(employee);
    }
}
