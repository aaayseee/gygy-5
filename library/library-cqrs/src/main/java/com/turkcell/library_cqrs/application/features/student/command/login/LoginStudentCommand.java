package com.turkcell.library_cqrs.application.features.student.command.login;

import com.turkcell.library_cqrs.core.mediator.cqrs.Command;
import com.turkcell.library_cqrs.core.logging.NotLoggableRequest;

public record LoginStudentCommand(String email, String password)
    implements Command<String>, NotLoggableRequest {}