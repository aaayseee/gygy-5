package com.turkcell.library_system.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_system.dto.*;
import com.turkcell.library_system.service.ShelfServiceImpl;

@RestController
@RequestMapping("/api/shelves")
public class ShelvesController {
    private final ShelfServiceImpl shelfServiceImpl;

    public ShelvesController(ShelfServiceImpl shelfServiceImpl) {
        this.shelfServiceImpl = shelfServiceImpl;
    }

    @PostMapping
    public CreatedShelfResponse create(@RequestBody CreateShelfRequest request) {
        return shelfServiceImpl.create(request);
    }

    @GetMapping
    public List<ListShelfResponse> getAll() {
        return shelfServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdShelfResponse getById(@PathVariable UUID id) {
        return shelfServiceImpl.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedShelfResponse update(@PathVariable UUID id, @RequestBody UpdateShelfRequest request) {
        return shelfServiceImpl.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        shelfServiceImpl.delete(id);
    }
}
