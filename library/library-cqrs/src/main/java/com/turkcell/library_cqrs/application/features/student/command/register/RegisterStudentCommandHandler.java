package com.turkcell.library_cqrs.application.features.student.command.register;

import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.library_cqrs.domain.Student;
import com.turkcell.library_cqrs.application.features.student.rule.StudentBusinessRules;
import com.turkcell.library_cqrs.persistence.repository.StudentRepository;

@Component
public class RegisterStudentCommandHandler implements CommandHandler<RegisterStudentCommand, UUID> {
    private final StudentRepository studentRepository;
    private final StudentBusinessRules studentBusinessRules;
    private final PasswordEncoder passwordEncoder;

    public RegisterStudentCommandHandler(StudentRepository studentRepository,
            StudentBusinessRules studentBusinessRules, PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.studentBusinessRules = studentBusinessRules;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UUID handle(RegisterStudentCommand command) {
        studentBusinessRules.studentWithSameEmailMustNotExist(command.email());

        Student student = new Student();
        student.setStudentNo(command.studentNo());
        student.setFirstName(command.firstName());
        student.setLastName(command.lastName());
        student.setEmail(command.email());
        student.setPhone(command.phone());
        student.setPassword(passwordEncoder.encode(command.password()));
        student.setStatus("Active");
        student = studentRepository.save(student);
        return student.getId();
    }
}
