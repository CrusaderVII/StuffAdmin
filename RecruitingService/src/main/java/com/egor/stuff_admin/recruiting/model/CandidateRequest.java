package com.egor.stuff_admin.recruiting.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "request")
public class CandidateRequest{
    @Column(name = "request_id")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @Column(name = "request_department", nullable = false)
    public String department;
    @Column(name = "request_priority", columnDefinition = "integer default 1")
    public int priority;
    @Column(name = "request_time", nullable = false)
    private Timestamp time;

    public CandidateRequest(String department, int priority, Timestamp time) {
        this.department = department;
        this.priority = priority;
        this.time = time;
    }
}
