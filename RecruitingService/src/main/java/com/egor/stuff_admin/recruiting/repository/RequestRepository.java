package com.egor.stuff_admin.recruiting.repository;

import com.egor.stuff_admin.recruiting.model.CandidateRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<CandidateRequest, Long> {

    @Query(value = "SELECT * FROM request WHERE request_department = ?1 " +
            "ORDER BY request_priority, request_time",
            nativeQuery = true)
    public List<CandidateRequest> findRequests(String department);
}