package com.turkcell.library_cqrs.application.features.student.command.login;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.library_cqrs.core.security.jwt.JwtService;
import com.turkcell.library_cqrs.domain.Student;
import com.turkcell.library_cqrs.persistence.repository.StudentRepository;

@Component
public class LoginStudentCommandHandler implements CommandHandler<LoginStudentCommand, String> {
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginStudentCommandHandler(StudentRepository studentRepository,
            PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public String handle(LoginStudentCommand command) {
        Student student = studentRepository.findByEmail(command.email())
                .orElseThrow(() -> new RuntimeException("Geçersiz kimlik bilgileri."));

        if (!passwordEncoder.matches(command.password(), student.getPassword())) {
            throw new RuntimeException("Geçersiz kimlik bilgileri.");
        }

        return jwtService.generate(student.getId(), student.getEmail());
    }
}
