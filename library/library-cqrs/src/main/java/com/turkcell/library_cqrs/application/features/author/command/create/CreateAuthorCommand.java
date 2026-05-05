package com.turkcell.library_cqrs.application.features.author.command.create;

import java.util.UUID;
import com.turkcell.library_cqrs.core.mediator.cqrs.Command;

public record CreateAuthorCommand(String firstName, String lastName, Integer birthYear) implements Command<UUID> {}
