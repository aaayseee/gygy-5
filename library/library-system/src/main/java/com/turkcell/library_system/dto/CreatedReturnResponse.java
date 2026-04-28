package com.turkcell.library_system.dto;

import java.time.LocalDate;
import java.util.UUID;

public class CreatedReturnResponse {
    private UUID id;
    private UUID borrowId;
    private UUID staffId;
    private LocalDate returnDate;
    private String bookCondition;
    private String note;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
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
