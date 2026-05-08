package com.turkcell.library_cqrs.application.features.student.command.register;

import java.util.UUID;
import com.turkcell.library_cqrs.core.mediator.cqrs.Command;

public record RegisterStudentCommand(
    String studentNo,
    String firstName,
    String lastName,
    String email,
    String phone,
    String password
) implements Command<UUID> {}