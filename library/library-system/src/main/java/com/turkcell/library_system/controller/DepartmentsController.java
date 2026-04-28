package com.turkcell.library_system.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_system.dto.*;
import com.turkcell.library_system.service.DepartmentServiceImpl;

@RestController
@RequestMapping("/api/departments")
public class DepartmentsController {
    private final DepartmentServiceImpl departmentServiceImpl;

    public DepartmentsController(DepartmentServiceImpl departmentServiceImpl) {
        this.departmentServiceImpl = departmentServiceImpl;
    }

    @PostMapping
    public CreatedDepartmentResponse create(@RequestBody CreateDepartmentRequest request) {
        return departmentServiceImpl.create(request);
    }

    @GetMapping
    public List<ListDepartmentResponse> getAll() {
        return departmentServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdDepartmentResponse getById(@PathVariable UUID id) {
        return departmentServiceImpl.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedDepartmentResponse update(@PathVariable UUID id, @RequestBody UpdateDepartmentRequest request) {
        return departmentServiceImpl.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        departmentServiceImpl.delete(id);
    }
}
