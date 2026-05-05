package com.turkcell.library_cqrs.application.features.author.command.update;

import java.util.UUID;
import com.turkcell.library_cqrs.core.mediator.cqrs.Command;

public record UpdateAuthorCommand(UUID id, String firstName, String lastName, Integer birthYear) implements Command<UUID> {}
