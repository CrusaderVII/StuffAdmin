package com.egor.stuff_admin.stuff_service.repository;

import com.egor.stuff_admin.stuff_service.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
