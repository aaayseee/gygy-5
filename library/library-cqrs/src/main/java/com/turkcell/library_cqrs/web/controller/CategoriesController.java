package com.turkcell.library_cqrs.web.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_cqrs.core.mediator.Mediator;
import com.turkcell.library_cqrs.application.features.category.command.create.CreateCategoryCommand;
import com.turkcell.library_cqrs.application.features.category.query.getall.GetAllCategoriesQuery;
import com.turkcell.library_cqrs.application.features.category.query.getall.GetAllCategoriesQueryResponse;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    private final Mediator mediator;

    public CategoriesController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public UUID create(@RequestBody CreateCategoryCommand command) {
        return mediator.send(command);
    }

    @GetMapping
    public List<GetAllCategoriesQueryResponse> getAll() {
        return mediator.send(new GetAllCategoriesQuery());
    }
}