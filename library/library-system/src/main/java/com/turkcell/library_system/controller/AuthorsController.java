package com.turkcell.library_system.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_system.dto.*;
import com.turkcell.library_system.service.AuthorServiceImpl;

@RestController
@RequestMapping("/api/authors")
public class AuthorsController {
    private final AuthorServiceImpl authorServiceImpl;

    public AuthorsController(AuthorServiceImpl authorServiceImpl) {
        this.authorServiceImpl = authorServiceImpl;
    }

    @PostMapping
    public CreatedAuthorResponse create(@RequestBody CreateAuthorRequest request) {
        return authorServiceImpl.create(request);
    }

    @GetMapping
    public List<ListAuthorResponse> getAll() {
        return authorServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdAuthorResponse getById(@PathVariable UUID id) {
        return authorServiceImpl.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedAuthorResponse update(@PathVariable UUID id, @RequestBody UpdateAuthorRequest request) {
        return authorServiceImpl.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        authorServiceImpl.delete(id);
    }
}
