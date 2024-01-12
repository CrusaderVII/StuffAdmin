package com.egor.stuff_admin.stuff_service.controller;

import com.egor.stuff_admin.stuff_service.model.Department;
import com.egor.stuff_admin.stuff_service.model.Employee;
import com.egor.stuff_admin.stuff_service.repository.service.DepartmentService;
import com.egor.stuff_admin.stuff_service.repository.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("stuff-admin/api/v1/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable long id) {
        Department department = departmentService.getDepartmentById(id);
        return department;
    }

    @PostMapping("/save")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

     @PostMapping("/{departmentId}/add-employee")
    public Employee addEmployee(@PathVariable long departmentId, @RequestParam long employeeId) {
        Department department = departmentService.getDepartmentById(departmentId);
        Employee employee = employeeService.getEmployeeById(employeeId);

        department.addEmployee(employee);
        employee.setDepartment(department);

        departmentService.updateDepartment(department);
        employeeService.updateEmployee(employee);

        return employee;
     }
}
