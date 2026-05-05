package com.turkcell.library_cqrs.application.features.book.command.update;

import java.util.UUID;
import com.turkcell.library_cqrs.core.mediator.cqrs.Command;

public record UpdateBookCommand(
    UUID id, UUID authorId, UUID categoryId, UUID shelfId,
    String isbn, String title, Integer publishYear,
    String publisher, String language, Integer pageCount,
    Integer totalCopies, Integer availableCopies
) implements Command<UUID> {}
