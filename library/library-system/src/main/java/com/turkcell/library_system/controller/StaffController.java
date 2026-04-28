package com.turkcell.library_system.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_system.dto.*;
import com.turkcell.library_system.service.StaffServiceImpl;

@RestController
@RequestMapping("/api/staff")
public class StaffController {
    private final StaffServiceImpl staffServiceImpl;

    public StaffController(StaffServiceImpl staffServiceImpl) {
        this.staffServiceImpl = staffServiceImpl;
    }

    @PostMapping
    public CreatedStaffResponse create(@RequestBody CreateStaffRequest request) {
        return staffServiceImpl.create(request);
    }

    @GetMapping
    public List<ListStaffResponse> getAll() {
        return staffServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdStaffResponse getById(@PathVariable UUID id) {
        return staffServiceImpl.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedStaffResponse update(@PathVariable UUID id, @RequestBody UpdateStaffRequest request) {
        return staffServiceImpl.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        staffServiceImpl.delete(id);
    }
}