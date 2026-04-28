package com.turkcell.library_system.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_system.dto.*;
import com.turkcell.library_system.service.StudentServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentsController {
    private final StudentServiceImpl studentServiceImpl;

    public StudentsController(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    @PostMapping
    public CreatedStudentResponse create(@RequestBody @Valid CreateStudentRequest request) {
        return studentServiceImpl.create(request);
    }

    @GetMapping
    public List<ListStudentResponse> getAll() {
        return studentServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdStudentResponse getById(@PathVariable UUID id) {
        return studentServiceImpl.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedStudentResponse update(@PathVariable UUID id, @RequestBody @Valid UpdateStudentRequest request) {
        return studentServiceImpl.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        studentServiceImpl.delete(id);
    }
}
