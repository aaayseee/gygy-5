package com.turkcell.library_system.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.library_system.dto.*;
import com.turkcell.library_system.entity.*;
import com.turkcell.library_system.exception.NotFoundException;
import com.turkcell.library_system.repository.*;

@Service
public class ReturnServiceImpl {
    private final ReturnRepository returnRepository;
    private final BorrowRepository borrowRepository;
    private final StaffRepository staffRepository;

    public ReturnServiceImpl(ReturnRepository returnRepository,
            BorrowRepository borrowRepository, StaffRepository staffRepository) {
        this.returnRepository = returnRepository;
        this.borrowRepository = borrowRepository;
        this.staffRepository = staffRepository;
    }

    public CreatedReturnResponse create(CreateReturnRequest request) {
        Borrow borrow = borrowRepository.findById(request.getBorrowId()).orElseThrow();
        Staff staff = staffRepository.findById(request.getStaffId()).orElseThrow();

        Return returnEntity = new Return();
        returnEntity.setBorrow(borrow);
        returnEntity.setStaff(staff);
        returnEntity.setReturnDate(request.getReturnDate());
        returnEntity.setBookCondition(request.getBookCondition());
        returnEntity.setNote(request.getNote());
        returnEntity = returnRepository.save(returnEntity);

        CreatedReturnResponse response = new CreatedReturnResponse();
        response.setId(returnEntity.getId());
        response.setBorrowId(returnEntity.getBorrow().getId());
        response.setStaffId(returnEntity.getStaff().getId());
        response.setReturnDate(returnEntity.getReturnDate());
        response.setBookCondition(returnEntity.getBookCondition());
        response.setNote(returnEntity.getNote());
        return response;
    }

    public List<ListReturnResponse> getAll() {
        return returnRepository.findAll()
                .stream()
                .map(returnEntity -> {
                    ListReturnResponse response = new ListReturnResponse();
                    response.setId(returnEntity.getId());
                    response.setBorrowId(returnEntity.getBorrow().getId());
                    response.setStaffId(returnEntity.getStaff().getId());
                    response.setReturnDate(returnEntity.getReturnDate());
                    response.setBookCondition(returnEntity.getBookCondition());
                    response.setNote(returnEntity.getNote());
                    return response;
                })
                .toList();
    }

    public GetByIdReturnResponse getById(UUID id) {
        Return returnEntity = returnRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("İade bulunamadı. ID: " + id));

        GetByIdReturnResponse response = new GetByIdReturnResponse();
        response.setId(returnEntity.getId());
        response.setBorrowId(returnEntity.getBorrow().getId());
        response.setStaffId(returnEntity.getStaff().getId());
        response.setReturnDate(returnEntity.getReturnDate());
        response.setBookCondition(returnEntity.getBookCondition());
        response.setNote(returnEntity.getNote());
        return response;
    }

    public UpdatedReturnResponse update(UUID id, UpdateReturnRequest request) {
        Return returnEntity = returnRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("İade bulunamadı. ID: " + id));
        Borrow borrow = borrowRepository.findById(request.getBorrowId())
                .orElseThrow(() -> new NotFoundException("Ödünç bulunamadı. ID: " + request.getBorrowId()));
        Staff staff = staffRepository.findById(request.getStaffId())
                .orElseThrow(() -> new NotFoundException("Personel bulunamadı. ID: " + request.getStaffId()));

        returnEntity.setBorrow(borrow);
        returnEntity.setStaff(staff);
        returnEntity.setReturnDate(request.getReturnDate());
        returnEntity.setBookCondition(request.getBookCondition());
        returnEntity.setNote(request.getNote());
        returnEntity = returnRepository.save(returnEntity);

        UpdatedReturnResponse response = new UpdatedReturnResponse();
        response.setId(returnEntity.getId());
        response.setBorrowId(returnEntity.getBorrow().getId());
        response.setStaffId(returnEntity.getStaff().getId());
        response.setReturnDate(returnEntity.getReturnDate());
        response.setBookCondition(returnEntity.getBookCondition());
        response.setNote(returnEntity.getNote());
        return response;
    }

    public void delete(UUID id) {
        if (!returnRepository.existsById(id))
            throw new NotFoundException("İade bulunamadı. ID: " + id);
        returnRepository.deleteById(id);
    }
}