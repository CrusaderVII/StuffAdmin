package com.egor.stuff_admin.stuff_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
@Entity
@Table (name = "employee")
public class Employee {

    @Column(name = "employee_id")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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
    @JsonIgnore
    private Department department;
}
