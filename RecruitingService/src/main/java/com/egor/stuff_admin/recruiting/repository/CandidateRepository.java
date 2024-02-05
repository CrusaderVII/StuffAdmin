package com.egor.stuff_admin.recruiting.repository;

import com.egor.stuff_admin.recruiting.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    public List<Candidate> findAllByDepartment(String department);
}
