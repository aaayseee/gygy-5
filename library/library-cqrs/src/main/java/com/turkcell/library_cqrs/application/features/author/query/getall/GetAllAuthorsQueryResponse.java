package com.turkcell.library_cqrs.application.features.author.query.getall;

import java.util.UUID;

public record GetAllAuthorsQueryResponse(UUID id, String firstName, String lastName, Integer birthYear) {}