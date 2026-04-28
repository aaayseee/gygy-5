package com.turkcell.library_system.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.library_system.entity.Borrow;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, UUID> {
}
