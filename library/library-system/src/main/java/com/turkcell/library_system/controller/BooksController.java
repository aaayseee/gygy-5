package com.turkcell.library_system.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_system.dto.*;
import com.turkcell.library_system.service.BookServiceImpl;

@RestController
@RequestMapping("/api/books")
public class BooksController {
    private final BookServiceImpl bookServiceImpl;

    public BooksController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @PostMapping
    public CreatedBookResponse create(@RequestBody CreateBookRequest request) {
        return bookServiceImpl.create(request);
    }

    @GetMapping
    public List<ListBookResponse> getAll() {
        return bookServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBookResponse getById(@PathVariable UUID id) {
        return bookServiceImpl.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedBookResponse update(@PathVariable UUID id, @RequestBody UpdateBookRequest request) {
        return bookServiceImpl.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        bookServiceImpl.delete(id);
    }
}
