package com.egor.stuff_admin.stuff_service.controller;

import com.egor.stuff_admin.stuff_service.model.Employee;
import com.egor.stuff_admin.stuff_service.repository.feign.StorageFeignClient;
import com.egor.stuff_admin.stuff_service.repository.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("stuff-admin/api/v1/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    StorageFeignClient storageFeignClient;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return employee;
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping(value = "/save",
                 consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Employee saveEmployee(@RequestParam("employee") Employee employee,
                                 @RequestParam("photo") MultipartFile photo) {
        String id = employee.getId()+"_"+employee.getFirstName()+"_"+employee.getLastName();
        String result = storageFeignClient.uploadPhoto(photo, id).getBody();

        logger.info(result);

        return employeeService.addEmployee(employee);
    }
}
