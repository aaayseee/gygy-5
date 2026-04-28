package com.turkcell.library_system.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.library_system.dto.*;
import com.turkcell.library_system.entity.Staff;
import com.turkcell.library_system.exception.NotFoundException;
import com.turkcell.library_system.repository.StaffRepository;

@Service
public class StaffServiceImpl {
    private final StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public CreatedStaffResponse create(CreateStaffRequest request) {
        Staff staff = new Staff();
        staff.setBadgeNo(request.getBadgeNo());
        staff.setFirstName(request.getFirstName());
        staff.setLastName(request.getLastName());
        staff.setEmail(request.getEmail());
        staff.setRole(request.getRole());
        staff.setHireDate(request.getHireDate());
        staff = staffRepository.save(staff);

        CreatedStaffResponse response = new CreatedStaffResponse();
        response.setId(staff.getId());
        response.setBadgeNo(staff.getBadgeNo());
        response.setFirstName(staff.getFirstName());
        response.setLastName(staff.getLastName());
        response.setEmail(staff.getEmail());
        response.setRole(staff.getRole());
        response.setHireDate(staff.getHireDate());
        return response;
    }

    public List<ListStaffResponse> getAll() {
        return staffRepository.findAll()
                .stream()
                .map(staff -> {
                    ListStaffResponse response = new ListStaffResponse();
                    response.setId(staff.getId());
                    response.setBadgeNo(staff.getBadgeNo());
                    response.setFirstName(staff.getFirstName());
                    response.setLastName(staff.getLastName());
                    response.setEmail(staff.getEmail());
                    response.setRole(staff.getRole());
                    response.setHireDate(staff.getHireDate());
                    return response;
                })
                .toList();
    }

    public GetByIdStaffResponse getById(UUID id) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Personel bulunamadı. ID: " + id));

        GetByIdStaffResponse response = new GetByIdStaffResponse();
        response.setId(staff.getId());
        response.setBadgeNo(staff.getBadgeNo());
        response.setFirstName(staff.getFirstName());
        response.setLastName(staff.getLastName());
        response.setEmail(staff.getEmail());
        response.setRole(staff.getRole());
        response.setHireDate(staff.getHireDate());
        return response;
    }

    public UpdatedStaffResponse update(UUID id, UpdateStaffRequest request) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Personel bulunamadı. ID: " + id));
        staff.setBadgeNo(request.getBadgeNo());
        staff.setFirstName(request.getFirstName());
        staff.setLastName(request.getLastName());
        staff.setEmail(request.getEmail());
        staff.setRole(request.getRole());
        staff.setHireDate(request.getHireDate());
        staff = staffRepository.save(staff);

        UpdatedStaffResponse response = new UpdatedStaffResponse();
        response.setId(staff.getId());
        response.setBadgeNo(staff.getBadgeNo());
        response.setFirstName(staff.getFirstName());
        response.setLastName(staff.getLastName());
        response.setEmail(staff.getEmail());
        response.setRole(staff.getRole());
        response.setHireDate(staff.getHireDate());
        return response;
    }

    public void delete(UUID id) {
        if (!staffRepository.existsById(id))
            throw new NotFoundException("Personel bulunamadı. ID: " + id);
        staffRepository.deleteById(id);
    }
}
