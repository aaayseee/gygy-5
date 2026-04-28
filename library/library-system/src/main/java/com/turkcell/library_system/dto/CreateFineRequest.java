package com.turkcell.library_system.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class CreateFineRequest {
    private UUID borrowId;
    private LocalDate overdueDate;
    private BigDecimal fineAmount;
    private String paymentStatus;
    private LocalDate paymentDate;

    public UUID getBorrowId() { return borrowId; }
    public void setBorrowId(UUID borrowId) { this.borrowId = borrowId; }
    public LocalDate getOverdueDate() { return overdueDate; }
    public void setOverdueDate(LocalDate overdueDate) { this.overdueDate = overdueDate; }
    public BigDecimal getFineAmount() { return fineAmount; }
    public void setFineAmount(BigDecimal fineAmount) { this.fineAmount = fineAmount; }
    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
    public LocalDate getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDate paymentDate) { this.paymentDate = paymentDate; }
}
