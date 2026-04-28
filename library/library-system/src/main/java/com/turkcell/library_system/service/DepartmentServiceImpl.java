package com.turkcell.library_system.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.library_system.dto.*;
import com.turkcell.library_system.entity.Author;
import com.turkcell.library_system.entity.Department;
import com.turkcell.library_system.exception.NotFoundException;
import com.turkcell.library_system.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl {
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public CreatedDepartmentResponse create(CreateDepartmentRequest request) {
        Department department = new Department();
        department.setDeptName(request.getDeptName());
        department.setFaculty(request.getFaculty());
        department = departmentRepository.save(department);

        CreatedDepartmentResponse response = new CreatedDepartmentResponse();
        response.setId(department.getId());
        response.setDeptName(department.getDeptName());
        response.setFaculty(department.getFaculty());
        return response;
    }

    public List<ListDepartmentResponse> getAll() {
        return departmentRepository.findAll()
                .stream()
                .map(department -> {
                    ListDepartmentResponse response = new ListDepartmentResponse();
                    response.setId(department.getId());
                    response.setDeptName(department.getDeptName());
                    response.setFaculty(department.getFaculty());
                    return response;
                })
                .toList();
    }

    public GetByIdDepartmentResponse getById(UUID id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Departman bulunamadı. ID: " + id));

        GetByIdDepartmentResponse response = new GetByIdDepartmentResponse();
        response.setId(department.getId());
        response.setDeptName(department.getDeptName());
        response.setFaculty(department.getFaculty());
        return response;
    }

    public UpdatedDepartmentResponse update(UUID id, UpdateDepartmentRequest request) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Departman bulunamadı. ID: " + id));
        department.setDeptName(request.getDeptName());
        department.setFaculty(request.getFaculty());
        department = departmentRepository.save(department);

        UpdatedDepartmentResponse response = new UpdatedDepartmentResponse();
        response.setId(department.getId());
        response.setDeptName(department.getDeptName());
        response.setFaculty(department.getFaculty());
        return response;
    }

    public void delete(UUID id) {
        if (!departmentRepository.existsById(id))
            throw new NotFoundException("Departman bulunamadı. ID: " + id);
        departmentRepository.deleteById(id);
    }
}