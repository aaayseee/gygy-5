package com.turkcell.library_system.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.library_system.dto.*;
import com.turkcell.library_system.entity.Department;
import com.turkcell.library_system.entity.Student;
import com.turkcell.library_system.repository.DepartmentRepository;
import com.turkcell.library_system.repository.StudentRepository;

@Service
public class StudentServiceImpl {
    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;

    public StudentServiceImpl(StudentRepository studentRepository, DepartmentRepository departmentRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    public CreatedStudentResponse create(CreateStudentRequest request) {
        Department department = departmentRepository.findById(request.getDepartmentId()).orElseThrow();

        Student student = new Student();
        student.setDepartment(department);
        student.setStudentNo(request.getStudentNo());
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setPhone(request.getPhone());
        student.setStatus(request.getStatus());
        student = studentRepository.save(student);

        CreatedStudentResponse response = new CreatedStudentResponse();
        response.setId(student.getId());
        response.setDepartmentId(student.getDepartment().getId());
        response.setStudentNo(student.getStudentNo());
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        response.setEmail(student.getEmail());
        response.setPhone(student.getPhone());
        response.setStatus(student.getStatus());
        return response;
    }

    public List<ListStudentResponse> getAll() {
        return studentRepository.findAll()
                .stream()
                .map(student -> {
                    ListStudentResponse response = new ListStudentResponse();
                    response.setId(student.getId());
                    response.setDepartmentId(student.getDepartment().getId());
                    response.setStudentNo(student.getStudentNo());
                    response.setFirstName(student.getFirstName());
                    response.setLastName(student.getLastName());
                    response.setEmail(student.getEmail());
                    response.setPhone(student.getPhone());
                    response.setStatus(student.getStatus());
                    return response;
                })
                .toList();
    }

    public GetByIdStudentResponse getById(UUID id) {
        Student student = studentRepository.findById(id).orElseThrow();

        GetByIdStudentResponse response = new GetByIdStudentResponse();
        response.setId(student.getId());
        response.setDepartmentId(student.getDepartment().getId());
        response.setStudentNo(student.getStudentNo());
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        response.setEmail(student.getEmail());
        response.setPhone(student.getPhone());
        response.setStatus(student.getStatus());
        return response;
    }

    public UpdatedStudentResponse update(UUID id, UpdateStudentRequest request) {
        Student student = studentRepository.findById(id).orElseThrow();
        Department department = departmentRepository.findById(request.getDepartmentId()).orElseThrow();

        student.setDepartment(department);
        student.setStudentNo(request.getStudentNo());
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setPhone(request.getPhone());
        student.setStatus(request.getStatus());
        student = studentRepository.save(student);

        UpdatedStudentResponse response = new UpdatedStudentResponse();
        response.setId(student.getId());
        response.setDepartmentId(student.getDepartment().getId());
        response.setStudentNo(student.getStudentNo());
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        response.setEmail(student.getEmail());
        response.setPhone(student.getPhone());
        response.setStatus(student.getStatus());
        return response;
    }

    public void delete(UUID id) {
        studentRepository.deleteById(id);
    }
}
