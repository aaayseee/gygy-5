package com.turkcell.library_cqrs.application.features.author.query.getall;

import java.util.List;
import com.turkcell.library_cqrs.core.mediator.cqrs.Query;

public record GetAllAuthorsQuery() implements Query<List<GetAllAuthorsQueryResponse>> {}