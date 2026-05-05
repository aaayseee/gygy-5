package com.turkcell.library_cqrs.application.features.category.query.getbyid;

import java.util.UUID;

public record GetByIdCategoryQueryResponse(UUID id, String categoryName, String description) {}
