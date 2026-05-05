package com.turkcell.library_cqrs.application.features.author.command.delete;

import java.util.UUID;
import com.turkcell.library_cqrs.core.mediator.cqrs.Command;

public record DeleteAuthorCommand(UUID id) implements Command<Void> {}
