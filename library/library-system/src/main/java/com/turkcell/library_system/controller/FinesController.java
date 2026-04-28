package com.turkcell.library_system.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_system.dto.*;
import com.turkcell.library_system.service.FineServiceImpl;

@RestController
@RequestMapping("/api/fines")
public class FinesController {
    private final FineServiceImpl fineServiceImpl;

    public FinesController(FineServiceImpl fineServiceImpl) {
        this.fineServiceImpl = fineServiceImpl;
    }

    @PostMapping
    public CreatedFineResponse create(@RequestBody CreateFineRequest request) {
        return fineServiceImpl.create(request);
    }

    @GetMapping
    public List<ListFineResponse> getAll() {
        return fineServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdFineResponse getById(@PathVariable UUID id) {
        return fineServiceImpl.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedFineResponse update(@PathVariable UUID id, @RequestBody UpdateFineRequest request) {
        return fineServiceImpl.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        fineServiceImpl.delete(id);
    }
}
