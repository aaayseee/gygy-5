package com.turkcell.library_system.dto;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateBorrowRequest {
    @NotNull(message = "Öğrenci ID boş olamaz.")
    private UUID studentId;

    @NotNull(message = "Kitap ID boş olamaz.")
    private UUID bookId;

    @NotNull(message = "Personel ID boş olamaz.")
    private UUID staffId;

    @NotNull(message = "Ödünç tarihi boş olamaz.")
    private LocalDate borrowDate;

    @NotNull(message = "Son iade tarihi boş olamaz.")
    private LocalDate dueDate;

    @Min(value = 0, message = "Uzatma sayısı 0'dan küçük olamaz.")
    private Integer extensionCount;

    @Size(max = 30, message = "Durum en fazla 30 karakter olabilir.")
    private String status;

    public UUID getStudentId() { return studentId; }
    public void setStudentId(UUID studentId) { this.studentId = studentId; }
    public UUID getBookId() { return bookId; }
    public void setBookId(UUID bookId) { this.bookId = bookId; }
    public UUID getStaffId() { return staffId; }
    public void setStaffId(UUID staffId) { this.staffId = staffId; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public void setBorrowDate(LocalDate borrowDate) { this.borrowDate = borrowDate; }
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    public Integer getExtensionCount() { return extensionCount; }
    public void setExtensionCount(Integer extensionCount) { this.extensionCount = extensionCount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}