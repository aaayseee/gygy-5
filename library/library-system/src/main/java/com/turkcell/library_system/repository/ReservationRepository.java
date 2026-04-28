package com.turkcell.library_system.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.library_system.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {
}
