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

    public void addEmployee (Employee employee) {
        if (employees==null) employees = new ArrayList<>();
        employees.add(employee);
    }
}
