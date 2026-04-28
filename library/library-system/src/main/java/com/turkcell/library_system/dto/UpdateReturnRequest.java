package com.turkcell.library_system.dto;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public class UpdateReturnRequest {
    @NotNull(message = "Ödünç ID boş olamaz.")
    private UUID borrowId;

    @NotNull(message = "Personel ID boş olamaz.")
    private UUID staffId;

    @NotNull(message = "İade tarihi boş olamaz.")
    @PastOrPresent(message = "İade tarihi gelecekte olamaz.")
    private LocalDate returnDate;

    @Size(max = 50, message = "Kitap durumu en fazla 50 karakter olabilir.")
    private String bookCondition;

    private String note;

    public UUID getBorrowId() { return borrowId; }
    public void setBorrowId(UUID borrowId) { this.borrowId = borrowId; }
    public UUID getStaffId() { return staffId; }
    public void setStaffId(UUID staffId) { this.staffId = staffId; }
    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
    public String getBookCondition() { return bookCondition; }
    public void setBookCondition(String bookCondition) { this.bookCondition = bookCondition; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}
