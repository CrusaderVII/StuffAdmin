package com.egor.stuff_admin.stuff_service.repository.service;

import com.egor.stuff_admin.stuff_service.model.Department;
import com.egor.stuff_admin.stuff_service.model.Employee;
import com.egor.stuff_admin.stuff_service.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository repository;

    public Department addDepartment(Department department) {
        return repository.save(department);
    }

    public Department getDepartmentById(long id) {
        return repository.findById(id)
                .get();
    }

    public Department updateEmployee(Department newDepartment) {
        //TODO: check if such department exists
        Department oldDepartment = getDepartmentById(newDepartment.getId());
        oldDepartment = newDepartment;
        return repository.save(oldDepartment);
    }

    public void deleteDepartment(Department department) {
        repository.delete(department);
    }
}
