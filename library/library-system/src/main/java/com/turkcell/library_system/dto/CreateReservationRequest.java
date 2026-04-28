package com.turkcell.library_system.dto;

import java.time.LocalDate;
import java.util.UUID;

public class CreateReservationRequest {
    private UUID studentId;
    private UUID bookId;
    private LocalDate requestDate;
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
