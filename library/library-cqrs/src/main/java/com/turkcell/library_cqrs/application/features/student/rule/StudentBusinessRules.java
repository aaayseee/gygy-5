package com.turkcell.library_cqrs.application.features.student.rule;

import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.persistence.repository.StudentRepository;

@Component
public class StudentBusinessRules {
    private final StudentRepository studentRepository;

    public StudentBusinessRules(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void studentWithSameEmailMustNotExist(String email) {
        if (studentRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Bu e-posta adresi zaten kayıtlı: " + email);
        }
    }
}
