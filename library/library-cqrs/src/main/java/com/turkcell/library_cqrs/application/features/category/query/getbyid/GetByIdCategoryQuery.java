package com.turkcell.library_cqrs.application.features.category.query.getbyid;

import java.util.UUID;
import com.turkcell.library_cqrs.core.mediator.cqrs.Query;

public record GetByIdCategoryQuery(UUID id) implements Query<GetByIdCategoryQueryResponse> {}
