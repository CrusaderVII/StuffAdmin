package com.egor.stuff_admin.stuff_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @ToString
@Entity
public class Department {
    @Column(name = "department_id")
    @Id
    private long id;
    @Column(name = "department_name")
    private String name;
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

}
