package com.turkcell.library_system.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.library_system.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, UUID> {
}
