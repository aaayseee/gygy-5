package com.turkcell.library_system.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_system.dto.*;
import com.turkcell.library_system.service.ReturnServiceImpl;

@RestController
@RequestMapping("/api/returns")
public class ReturnsController {
    private final ReturnServiceImpl returnServiceImpl;

    public ReturnsController(ReturnServiceImpl returnServiceImpl) {
        this.returnServiceImpl = returnServiceImpl;
    }

    @PostMapping
    public CreatedReturnResponse create(@RequestBody CreateReturnRequest request) {
        return returnServiceImpl.create(request);
    }

    @GetMapping
    public List<ListReturnResponse> getAll() {
        return returnServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdReturnResponse getById(@PathVariable UUID id) {
        return returnServiceImpl.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedReturnResponse update(@PathVariable UUID id, @RequestBody UpdateReturnRequest request) {
        return returnServiceImpl.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        returnServiceImpl.delete(id);
    }
}