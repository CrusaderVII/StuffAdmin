package com.egor.stuff_admin.stuff_service.repository.service;

import com.egor.stuff_admin.stuff_service.model.Department;
import com.egor.stuff_admin.stuff_service.model.Employee;
import com.egor.stuff_admin.stuff_service.model.EmployeeRequirement;
import com.egor.stuff_admin.stuff_service.repository.DepartmentRepository;
import com.egor.stuff_admin.stuff_service.repository.RequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    RequirementRepository requirementRepository;

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(long id) {
        return departmentRepository.findById(id)
                .get();
    }

    public Department getDepartmentByName(String name) {
        return departmentRepository.findByName(name);
    }

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    public Department updateDepartment(Department newDepartment) {
        //TODO: check if such department exists
        Department oldDepartment = getDepartmentById(newDepartment.getId());
        oldDepartment = newDepartment;
        return departmentRepository.save(oldDepartment);
    }

    public void deleteDepartment(Department department) {
        departmentRepository.delete(department);
    }

    public EmployeeRequirement getRequirementById(long id) {
        return requirementRepository.findById(id)
                .get();
    }
    public EmployeeRequirement addEmployeeRequirement (EmployeeRequirement requirement) {
        return requirementRepository.save(requirement);
    }

    public void deleteEmployeeRequirement(EmployeeRequirement requirement) {
        requirementRepository.delete(requirement);
    }
}
