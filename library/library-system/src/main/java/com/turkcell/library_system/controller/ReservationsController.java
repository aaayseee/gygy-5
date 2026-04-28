package com.turkcell.library_system.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_system.dto.*;
import com.turkcell.library_system.service.ReservationServiceImpl;

@RestController
@RequestMapping("/api/reservations")
public class ReservationsController {
    private final ReservationServiceImpl reservationServiceImpl;

    public ReservationsController(ReservationServiceImpl reservationServiceImpl) {
        this.reservationServiceImpl = reservationServiceImpl;
    }

    @PostMapping
    public CreatedReservationResponse create(@RequestBody CreateReservationRequest request) {
        return reservationServiceImpl.create(request);
    }

    @GetMapping
    public List<ListReservationResponse> getAll() {
        return reservationServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdReservationResponse getById(@PathVariable UUID id) {
        return reservationServiceImpl.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedReservationResponse update(@PathVariable UUID id, @RequestBody UpdateReservationRequest request) {
        return reservationServiceImpl.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        reservationServiceImpl.delete(id);
    }
}
