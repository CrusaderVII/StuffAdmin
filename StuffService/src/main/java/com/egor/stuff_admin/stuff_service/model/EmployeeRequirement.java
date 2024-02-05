package com.egor.stuff_admin.stuff_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "employee_requirement")
public class EmployeeRequirement {
    @Column(name = "requirement_id")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;
    @Column(name = "requirement_salary", nullable = false)
    private String salary;
}
