package com.turkcell.library_cqrs.application.features.book.query.getbyid;

import java.util.UUID;

public record GetByIdBookQueryResponse(
    UUID id, UUID authorId, UUID categoryId, UUID shelfId,
    String isbn, String title, Integer publishYear,
    String publisher, String language, Integer pageCount,
    Integer totalCopies, Integer availableCopies
) {}
