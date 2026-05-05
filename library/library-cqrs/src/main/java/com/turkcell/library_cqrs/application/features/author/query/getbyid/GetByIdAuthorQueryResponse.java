package com.turkcell.library_cqrs.application.features.author.query.getbyid;

import java.util.UUID;

public record GetByIdAuthorQueryResponse(UUID id, String firstName, String lastName, Integer birthYear) {}
