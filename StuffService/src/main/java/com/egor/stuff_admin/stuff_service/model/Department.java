package com.egor.stuff_admin.stuff_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "department")
public class Department {
    @Column(name = "department_id")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @Column(name = "department_name")
    private String name;
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
    @OneToMany(mappedBy = "department")
    private List<EmployeeRequirement> requirements;
    public void addEmployee (Employee employee) {
        if (employees==null) employees = new ArrayList<>();
        employees.add(employee);
    }

    public void deleteEmployee(Employee employee) {
        if (requirements==null) return;
        employees.remove(employee);
    }

    public void addRequirement (EmployeeRequirement requirement) {
        if (requirements==null) requirements = new ArrayList<>();
        requirements.add(requirement);
    }

    public void deleteRequirement(EmployeeRequirement requirement) {
        if (requirements==null) return;
        requirements.remove(requirement);
    }
}
