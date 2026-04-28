package com.turkcell.library_system.dto;

import java.time.LocalDate;
import java.util.UUID;

public class CreatedBorrowResponse {
    private UUID id;
    private UUID studentId;
    private UUID bookId;
    private UUID staffId;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private Integer extensionCount;
    private String status;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
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
