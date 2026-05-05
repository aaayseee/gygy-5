package com.turkcell.library_cqrs.application.features.category.query.getall;

import java.util.UUID;

public record GetAllCategoriesQueryResponse(UUID id, String categoryName, String description) {}