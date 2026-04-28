package com.turkcell.library_system.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_system.dto.*;
import com.turkcell.library_system.service.BorrowServiceImpl;

@RestController
@RequestMapping("/api/borrows")
public class BorrowsController {
    private final BorrowServiceImpl borrowServiceImpl;

    public BorrowsController(BorrowServiceImpl borrowServiceImpl) {
        this.borrowServiceImpl = borrowServiceImpl;
    }

    @PostMapping
    public CreatedBorrowResponse create(@RequestBody CreateBorrowRequest request) {
        return borrowServiceImpl.create(request);
    }

    @GetMapping
    public List<ListBorrowResponse> getAll() {
        return borrowServiceImpl.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBorrowResponse getById(@PathVariable UUID id) {
        return borrowServiceImpl.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedBorrowResponse update(@PathVariable UUID id, @RequestBody UpdateBorrowRequest request) {
        return borrowServiceImpl.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        borrowServiceImpl.delete(id);
    }
}