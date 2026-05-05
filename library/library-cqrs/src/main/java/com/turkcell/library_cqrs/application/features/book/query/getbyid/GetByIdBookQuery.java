package com.turkcell.library_cqrs.application.features.book.query.getbyid;

import java.util.UUID;
import com.turkcell.library_cqrs.core.mediator.cqrs.Query;

public record GetByIdBookQuery(UUID id) implements Query<GetByIdBookQueryResponse> {}
