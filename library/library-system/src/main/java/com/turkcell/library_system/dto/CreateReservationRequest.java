package com.turkcell.library_system.dto;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public class CreateReservationRequest {
    @NotNull(message = "Öğrenci ID boş olamaz.")
    private UUID studentId;

    @NotNull(message = "Kitap ID boş olamaz.")
    private UUID bookId;

    @NotNull(message = "Talep tarihi boş olamaz.")
    @PastOrPresent(message = "Talep tarihi gelecekte olamaz.")
    private LocalDate requestDate;

    @Size(max = 30, message = "Durum en fazla 30 karakter olabilir.")
    private String status;

    public UUID getStudentId() { return studentId; }
    public void setStudentId(UUID studentId) { this.studentId = studentId; }
    public UUID getBookId() { return bookId; }
    public void setBookId(UUID bookId) { this.bookId = bookId; }
    public LocalDate getRequestDate() { return requestDate; }
    public void setRequestDate(LocalDate requestDate) { this.requestDate = requestDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
