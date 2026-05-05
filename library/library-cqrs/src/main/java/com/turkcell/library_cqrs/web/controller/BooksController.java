package com.turkcell.library_cqrs.web.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_cqrs.core.mediator.Mediator;
import com.turkcell.library_cqrs.application.features.book.command.create.CreateBookCommand;
import com.turkcell.library_cqrs.application.features.book.command.delete.DeleteBookCommand;
import com.turkcell.library_cqrs.application.features.book.command.update.UpdateBookCommand;
import com.turkcell.library_cqrs.application.features.book.query.getall.GetAllBooksQuery;
import com.turkcell.library_cqrs.application.features.book.query.getall.GetAllBooksQueryResponse;
import com.turkcell.library_cqrs.application.features.book.query.getbyid.GetByIdBookQuery;
import com.turkcell.library_cqrs.application.features.book.query.getbyid.GetByIdBookQueryResponse; 

@RestController
@RequestMapping("/api/books")
public class BooksController {
    private final Mediator mediator;

    public BooksController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public UUID create(@RequestBody CreateBookCommand command) {
        return mediator.send(command);
    }

    @PutMapping("/{id}")
    public UUID update(@PathVariable UUID id, @RequestBody UpdateBookCommand command) {
        return mediator.send(new UpdateBookCommand(
                id, command.authorId(), command.categoryId(), command.shelfId(),
                command.isbn(), command.title(), command.publishYear(), command.publisher(),
                command.language(), command.pageCount(), command.totalCopies(), command.availableCopies()));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        mediator.send(new DeleteBookCommand(id));
    }

    @GetMapping
    public List<GetAllBooksQueryResponse> getAll() {
        return mediator.send(new GetAllBooksQuery());
    }

    @GetMapping("/{id}")
    public GetByIdBookQueryResponse getById(@PathVariable UUID id) {
        return mediator.send(new GetByIdBookQuery(id));
    }
}
