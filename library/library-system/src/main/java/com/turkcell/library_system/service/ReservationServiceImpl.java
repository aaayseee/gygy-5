package com.turkcell.library_system.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.library_system.dto.*;
import com.turkcell.library_system.entity.*;
import com.turkcell.library_system.exception.NotFoundException;
import com.turkcell.library_system.repository.*;

@Service
public class ReservationServiceImpl {
    private final ReservationRepository reservationRepository;
    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository,
            StudentRepository studentRepository, BookRepository bookRepository) {
        this.reservationRepository = reservationRepository;
        this.studentRepository = studentRepository;
        this.bookRepository = bookRepository;
    }

    public CreatedReservationResponse create(CreateReservationRequest request) {
        Student student = studentRepository.findById(request.getStudentId()).orElseThrow();
        Book book = bookRepository.findById(request.getBookId()).orElseThrow();

        Reservation reservation = new Reservation();
        reservation.setStudent(student);
        reservation.setBook(book);
        reservation.setRequestDate(request.getRequestDate());
        reservation.setStatus(request.getStatus());
        reservation = reservationRepository.save(reservation);

        CreatedReservationResponse response = new CreatedReservationResponse();
        response.setId(reservation.getId());
        response.setStudentId(reservation.getStudent().getId());
        response.setBookId(reservation.getBook().getId());
        response.setRequestDate(reservation.getRequestDate());
        response.setStatus(reservation.getStatus());
        return response;
    }

    public List<ListReservationResponse> getAll() {
        return reservationRepository.findAll()
                .stream()
                .map(reservation -> {
                    ListReservationResponse response = new ListReservationResponse();
                    response.setId(reservation.getId());
                    response.setStudentId(reservation.getStudent().getId());
                    response.setBookId(reservation.getBook().getId());
                    response.setRequestDate(reservation.getRequestDate());
                    response.setStatus(reservation.getStatus());
                    return response;
                })
                .toList();
    }

    public GetByIdReservationResponse getById(UUID id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Rezervasyon bulunamadı. ID: " + id));

        GetByIdReservationResponse response = new GetByIdReservationResponse();
        response.setId(reservation.getId());
        response.setStudentId(reservation.getStudent().getId());
        response.setBookId(reservation.getBook().getId());
        response.setRequestDate(reservation.getRequestDate());
        response.setStatus(reservation.getStatus());
        return response;
    }

    public UpdatedReservationResponse update(UUID id, UpdateReservationRequest request) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Rezervasyon bulunamadı. ID: " + id));
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new NotFoundException("Öğrenci bulunamadı. ID: " + request.getStudentId()));
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new NotFoundException("Kitap bulunamadı. ID: " + request.getBookId()));

        reservation.setStudent(student);
        reservation.setBook(book);
        reservation.setRequestDate(request.getRequestDate());
        reservation.setStatus(request.getStatus());
        reservation = reservationRepository.save(reservation);

        UpdatedReservationResponse response = new UpdatedReservationResponse();
        response.setId(reservation.getId());
        response.setStudentId(reservation.getStudent().getId());
        response.setBookId(reservation.getBook().getId());
        response.setRequestDate(reservation.getRequestDate());
        response.setStatus(reservation.getStatus());
        return response;
    }

    public void delete(UUID id) {
        if (!reservationRepository.existsById(id))
            throw new NotFoundException("Rezervasyon bulunamadı. ID: " + id);
        reservationRepository.deleteById(id);
    }
}
