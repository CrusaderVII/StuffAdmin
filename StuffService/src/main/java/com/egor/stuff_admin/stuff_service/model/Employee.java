package com.egor.stuff_admin.stuff_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Entity
public class Employee {

    @Column(name = "employee_id")
    @Id
    private long id;
    @Column(name = "employee_first_name", nullable = false)
    private String firstName;
    @Column(name = "employee_last_name", nullable = false)
    private String lastName;
    @Column(name = "employee_phone", nullable = false)
    private String phone;
    @Column(name = "employee_salary", nullable = false)
    private int salary;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
