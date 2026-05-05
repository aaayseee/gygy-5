package com.turkcell.library_cqrs.web.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_cqrs.application.features.author.command.create.CreateAuthorCommand;
import com.turkcell.library_cqrs.application.features.author.command.delete.DeleteAuthorCommand;   
import com.turkcell.library_cqrs.application.features.author.command.update.UpdateAuthorCommand;
import com.turkcell.library_cqrs.application.features.author.query.getall.GetAllAuthorsQuery;
import com.turkcell.library_cqrs.application.features.author.query.getall.GetAllAuthorsQueryResponse;
import com.turkcell.library_cqrs.application.features.author.query.getbyid.GetByIdAuthorQuery;
import com.turkcell.library_cqrs.application.features.author.query.getbyid.GetByIdAuthorQueryResponse;
import com.turkcell.library_cqrs.core.mediator.Mediator;

@RestController
@RequestMapping("/api/authors")
public class AuthorsController {
    private final Mediator mediator;

    public AuthorsController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public UUID create(@RequestBody CreateAuthorCommand command) {
        return mediator.send(command);
    }

    @PutMapping("/{id}")
    public UUID update(@PathVariable UUID id, @RequestBody UpdateAuthorCommand command) {
        return mediator.send(new UpdateAuthorCommand(id, command.firstName(), command.lastName(), command.birthYear()));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        mediator.send(new DeleteAuthorCommand(id));
    }

    @GetMapping
    public List<GetAllAuthorsQueryResponse> getAll() {
        return mediator.send(new GetAllAuthorsQuery());
    }

    @GetMapping("/{id}")
    public GetByIdAuthorQueryResponse getById(@PathVariable UUID id) {
        return mediator.send(new GetByIdAuthorQuery(id));
    }
}
