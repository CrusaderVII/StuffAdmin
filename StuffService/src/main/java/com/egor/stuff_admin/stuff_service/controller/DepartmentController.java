package com.egor.stuff_admin.stuff_service.controller;

import com.egor.stuff_admin.stuff_service.model.Department;
import com.egor.stuff_admin.stuff_service.model.Employee;
import com.egor.stuff_admin.stuff_service.model.EmployeeRequirement;
import com.egor.stuff_admin.stuff_service.repository.feign.RecruitingFeignClient;
import com.egor.stuff_admin.stuff_service.repository.service.DepartmentService;
import com.egor.stuff_admin.stuff_service.repository.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stuff-admin/api/v1/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;

    @Autowired
    RecruitingFeignClient recruitingFeignClient;

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable long id) {
        Department department = departmentService.getDepartmentById(id);
        return department;
    }

    @GetMapping("/all")
    public List<Department> getAllDepartment() {
        List<Department> departments = departmentService.getAllDepartment();
        return departments;
    }

    @PostMapping("/save")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    @PostMapping("/{departmentName}/add-employee")
    public Employee addEmployee(@PathVariable String departmentName, @RequestParam long employeeId) {
        Department department = departmentService.getDepartmentByName(departmentName);
        Employee employee = employeeService.getEmployeeById(employeeId);

        department.addEmployee(employee);
        employee.setDepartment(department);

        departmentService.updateDepartment(department);
        employeeService.updateEmployee(employee);

        return employee;
    }

    @PostMapping("/{departmentName}/add-requirement")
    public ResponseEntity<Object> addEmployeeRequirement(@PathVariable String departmentName,
                                                         @RequestBody EmployeeRequirement requirement) {
        Department department = departmentService.getDepartmentByName(departmentName);

        requirement.setDepartment(department);
        department.addRequirement(requirement);

        departmentService.updateDepartment(department);
        departmentService.addEmployeeRequirement(requirement);

        return recruitingFeignClient.getCandidates(department.getName(), requirement.getPriority());
    }

    @DeleteMapping("/{departmentName}/delete-requirement/{requirementId}")
    public void deleteEmployeeRequirement(@PathVariable String departmentName,
                                          @PathVariable long requirementId) {
        //TODO: implement deleting request from recruiting service

        Department department = departmentService.getDepartmentByName(departmentName);
        EmployeeRequirement requirement = departmentService.getRequirementById(requirementId);

        department.deleteRequirement(requirement);

        departmentService.updateDepartment(department);
        departmentService.deleteEmployeeRequirement(requirement);
    }
}
