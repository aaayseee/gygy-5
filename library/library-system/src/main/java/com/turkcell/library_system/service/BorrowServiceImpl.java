package com.turkcell.library_system.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.library_system.dto.*;
import com.turkcell.library_system.entity.*;
import com.turkcell.library_system.exception.NotFoundException;
import com.turkcell.library_system.repository.*;

@Service
public class BorrowServiceImpl {
    private final BorrowRepository borrowRepository;
    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;
    private final StaffRepository staffRepository;

    public BorrowServiceImpl(BorrowRepository borrowRepository, StudentRepository studentRepository,
            BookRepository bookRepository, StaffRepository staffRepository) {
        this.borrowRepository = borrowRepository;
        this.studentRepository = studentRepository;
        this.bookRepository = bookRepository;
        this.staffRepository = staffRepository;
    }

    public CreatedBorrowResponse create(CreateBorrowRequest request) {
        Student student = studentRepository.findById(request.getStudentId()).orElseThrow();
        Book book = bookRepository.findById(request.getBookId()).orElseThrow();
        Staff staff = staffRepository.findById(request.getStaffId()).orElseThrow();

        Borrow borrow = new Borrow();
        borrow.setStudent(student);
        borrow.setBook(book);
        borrow.setStaff(staff);
        borrow.setBorrowDate(request.getBorrowDate());
        borrow.setDueDate(request.getDueDate());
        borrow.setExtensionCount(request.getExtensionCount());
        borrow.setStatus(request.getStatus());
        borrow = borrowRepository.save(borrow);

        CreatedBorrowResponse response = new CreatedBorrowResponse();
        response.setId(borrow.getId());
        response.setStudentId(borrow.getStudent().getId());
        response.setBookId(borrow.getBook().getId());
        response.setStaffId(borrow.getStaff().getId());
        response.setBorrowDate(borrow.getBorrowDate());
        response.setDueDate(borrow.getDueDate());
        response.setExtensionCount(borrow.getExtensionCount());
        response.setStatus(borrow.getStatus());
        return response;
    }

    public List<ListBorrowResponse> getAll() {
        return borrowRepository.findAll()
                .stream()
                .map(borrow -> {
                    ListBorrowResponse response = new ListBorrowResponse();
                    response.setId(borrow.getId());
                    response.setStudentId(borrow.getStudent().getId());
                    response.setBookId(borrow.getBook().getId());
                    response.setStaffId(borrow.getStaff().getId());
                    response.setBorrowDate(borrow.getBorrowDate());
                    response.setDueDate(borrow.getDueDate());
                    response.setExtensionCount(borrow.getExtensionCount());
                    response.setStatus(borrow.getStatus());
                    return response;
                })
                .toList();
    }

    public GetByIdBorrowResponse getById(UUID id) {
        Borrow borrow = borrowRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ödünç bulunamadı. ID: " + id));

        GetByIdBorrowResponse response = new GetByIdBorrowResponse();
        response.setId(borrow.getId());
        response.setStudentId(borrow.getStudent().getId());
        response.setBookId(borrow.getBook().getId());
        response.setStaffId(borrow.getStaff().getId());
        response.setBorrowDate(borrow.getBorrowDate());
        response.setDueDate(borrow.getDueDate());
        response.setExtensionCount(borrow.getExtensionCount());
        response.setStatus(borrow.getStatus());
        return response;
    }

    public UpdatedBorrowResponse update(UUID id, UpdateBorrowRequest request) {
        Borrow borrow = borrowRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ödünç bulunamadı. ID: " + id));
        Student student = studentRepository.findById(request.getStudentId()).orElseThrow();
        Book book = bookRepository.findById(request.getBookId()).orElseThrow();
        Staff staff = staffRepository.findById(request.getStaffId()).orElseThrow();

        borrow.setStudent(student);
        borrow.setBook(book);
        borrow.setStaff(staff);
        borrow.setBorrowDate(request.getBorrowDate());
        borrow.setDueDate(request.getDueDate());
        borrow.setExtensionCount(request.getExtensionCount());
        borrow.setStatus(request.getStatus());
        borrow = borrowRepository.save(borrow);

        UpdatedBorrowResponse response = new UpdatedBorrowResponse();
        response.setId(borrow.getId());
        response.setStudentId(borrow.getStudent().getId());
        response.setBookId(borrow.getBook().getId());
        response.setStaffId(borrow.getStaff().getId());
        response.setBorrowDate(borrow.getBorrowDate());
        response.setDueDate(borrow.getDueDate());
        response.setExtensionCount(borrow.getExtensionCount());
        response.setStatus(borrow.getStatus());
        return response;
    }

    public void delete(UUID id) {
        if (!borrowRepository.existsById(id))
            throw new NotFoundException("Ödünç bulunamadı. ID: " + id);

        borrowRepository.deleteById(id);
    }
}
