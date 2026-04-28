package com.turkcell.library_system.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.library_system.dto.*;
import com.turkcell.library_system.entity.*;
import com.turkcell.library_system.exception.NotFoundException;
import com.turkcell.library_system.repository.*;

@Service
public class FineServiceImpl {
    private final FineRepository fineRepository;
    private final BorrowRepository borrowRepository;

    public FineServiceImpl(FineRepository fineRepository, BorrowRepository borrowRepository) {
        this.fineRepository = fineRepository;
        this.borrowRepository = borrowRepository;
    }

    public CreatedFineResponse create(CreateFineRequest request) {
        Borrow borrow = borrowRepository.findById(request.getBorrowId()).orElseThrow();

        Fine fine = new Fine();
        fine.setBorrow(borrow);
        fine.setOverdueDate(request.getOverdueDate());
        fine.setFineAmount(request.getFineAmount());
        fine.setPaymentStatus(request.getPaymentStatus());
        fine.setPaymentDate(request.getPaymentDate());
        fine = fineRepository.save(fine);

        CreatedFineResponse response = new CreatedFineResponse();
        response.setId(fine.getId());
        response.setBorrowId(fine.getBorrow().getId());
        response.setOverdueDate(fine.getOverdueDate());
        response.setFineAmount(fine.getFineAmount());
        response.setPaymentStatus(fine.getPaymentStatus());
        response.setPaymentDate(fine.getPaymentDate());
        return response;
    }

    public List<ListFineResponse> getAll() {
        return fineRepository.findAll()
                .stream()
                .map(fine -> {
                    ListFineResponse response = new ListFineResponse();
                    response.setId(fine.getId());
                    response.setBorrowId(fine.getBorrow().getId());
                    response.setOverdueDate(fine.getOverdueDate());
                    response.setFineAmount(fine.getFineAmount());
                    response.setPaymentStatus(fine.getPaymentStatus());
                    response.setPaymentDate(fine.getPaymentDate());
                    return response;
                })
                .toList();
    }

    public GetByIdFineResponse getById(UUID id) {
        Fine fine = fineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ceza bulunamadı. ID: " + id));

        GetByIdFineResponse response = new GetByIdFineResponse();
        response.setId(fine.getId());
        response.setBorrowId(fine.getBorrow().getId());
        response.setOverdueDate(fine.getOverdueDate());
        response.setFineAmount(fine.getFineAmount());
        response.setPaymentStatus(fine.getPaymentStatus());
        response.setPaymentDate(fine.getPaymentDate());
        return response;
    }

    public UpdatedFineResponse update(UUID id, UpdateFineRequest request) {
        Fine fine = fineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ceza bulunamadı. ID: " + id));
        Borrow borrow = borrowRepository.findById(request.getBorrowId())
                .orElseThrow(() -> new NotFoundException("Ödünç bulunamadı. ID: " + request.getBorrowId()));

        fine.setBorrow(borrow);
        fine.setOverdueDate(request.getOverdueDate());
        fine.setFineAmount(request.getFineAmount());
        fine.setPaymentStatus(request.getPaymentStatus());
        fine.setPaymentDate(request.getPaymentDate());
        fine = fineRepository.save(fine);

        UpdatedFineResponse response = new UpdatedFineResponse();
        response.setId(fine.getId());
        response.setBorrowId(fine.getBorrow().getId());
        response.setOverdueDate(fine.getOverdueDate());
        response.setFineAmount(fine.getFineAmount());
        response.setPaymentStatus(fine.getPaymentStatus());
        response.setPaymentDate(fine.getPaymentDate());
        return response;
    }

    public void delete(UUID id) {
        if (!fineRepository.existsById(id))
            throw new NotFoundException("Ceza bulunamadı. ID: " + id);

        fineRepository.deleteById(id);
    }
}
