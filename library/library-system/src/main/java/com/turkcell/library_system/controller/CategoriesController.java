package com.turkcell.library_system.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_system.dto.*;
import com.turkcell.library_system.service.CategoryServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    private final CategoryServiceImpl categoryServiceImpl;

    public CategoriesController(CategoryServiceImpl categoryServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @PostMapping
    public CreatedCategoryResponse create(@RequestBody @Valid CreateCategoryRequest request) {
        return categoryServiceImpl.create(request);
    }

    @GetMapping
    public List<ListCategoryResponse> getAll() {
        return categoryServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdCategoryResponse getById(@PathVariable UUID id) {
        return categoryServiceImpl.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedCategoryResponse update(@PathVariable UUID id, @RequestBody @Valid UpdateCategoryRequest request) {
        return categoryServiceImpl.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        categoryServiceImpl.delete(id);
    }
}