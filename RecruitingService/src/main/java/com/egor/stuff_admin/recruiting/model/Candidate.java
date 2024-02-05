package com.egor.stuff_admin.recruiting.model;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "candidate")
public class Candidate {
    @Column(name = "employee_id")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @Column(name = "candidate_first_name", nullable = false)
    private String firstName;
    @Column(name = "candidate_last_name", nullable = false)
    private String lastName;
    @Column(name = "candidate_phone", nullable = false)
    private String phone;
    @Column(name = "candidate_email", nullable = false)
    private String email;
    @Column(name = "candidate_department", nullable = false)
    private String department;
    @Column(name = "candidate_experience")
    private String experience;
}
