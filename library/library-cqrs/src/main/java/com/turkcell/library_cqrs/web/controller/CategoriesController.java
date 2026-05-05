package com.turkcell.library_cqrs.web.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_cqrs.core.mediator.Mediator;
import com.turkcell.library_cqrs.application.features.category.command.create.CreateCategoryCommand;
import com.turkcell.library_cqrs.application.features.category.command.delete.DeleteCategoryCommand;
import com.turkcell.library_cqrs.application.features.category.command.update.UpdateCategoryCommand;
import com.turkcell.library_cqrs.application.features.category.query.getall.GetAllCategoriesQuery;
import com.turkcell.library_cqrs.application.features.category.query.getall.GetAllCategoriesQueryResponse;
import com.turkcell.library_cqrs.application.features.category.query.getbyid.GetByIdCategoryQuery;
import com.turkcell.library_cqrs.application.features.category.query.getbyid.GetByIdCategoryQueryResponse;

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

    @PutMapping("/{id}")
    public UUID update(@PathVariable UUID id, @RequestBody UpdateCategoryCommand command) {
        return mediator.send(new UpdateCategoryCommand(id, command.categoryName(), command.description()));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        mediator.send(new DeleteCategoryCommand(id));
    }

    @GetMapping
    public List<GetAllCategoriesQueryResponse> getAll() {
        return mediator.send(new GetAllCategoriesQuery());
    }

    @GetMapping("/{id}")
    public GetByIdCategoryQueryResponse getById(@PathVariable UUID id) {
        return mediator.send(new GetByIdCategoryQuery(id));
    }
}
