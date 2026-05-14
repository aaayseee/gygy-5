package com.turkcell.library_cqrs.application.features.category.query.getall;

import java.util.List;

import com.turkcell.library_cqrs.core.mediator.cqrs.Query;
import com.turkcell.library_cqrs.core.security.authorization.AuthorizableRequest;

public record GetAllCategoriesQuery()
        implements Query<List<GetAllCategoriesQueryResponse>>, AuthorizableRequest {}
