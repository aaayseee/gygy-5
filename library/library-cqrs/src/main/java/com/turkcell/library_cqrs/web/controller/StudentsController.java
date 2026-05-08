package com.turkcell.library_cqrs.web.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.turkcell.library_cqrs.core.mediator.Mediator;
import com.turkcell.library_cqrs.application.features.student.command.login.LoginStudentCommand;
import com.turkcell.library_cqrs.application.features.student.command.register.RegisterStudentCommand;

@RestController
@RequestMapping("/api/students")
public class StudentsController {
    private final Mediator mediator;

    public StudentsController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping("/register")
    public UUID register(@RequestBody RegisterStudentCommand command) {
        return mediator.send(command);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginStudentCommand command) {
        return mediator.send(command);
    }
}