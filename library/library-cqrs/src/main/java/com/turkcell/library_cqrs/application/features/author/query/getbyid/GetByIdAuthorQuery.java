package com.turkcell.library_cqrs.application.features.author.query.getbyid;

import java.util.UUID;
import com.turkcell.library_cqrs.core.mediator.cqrs.Query;

public record GetByIdAuthorQuery(UUID id) implements Query<GetByIdAuthorQueryResponse> {}
