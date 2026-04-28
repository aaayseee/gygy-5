package com.turkcell.library_system.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateFineRequest {
    @NotNull(message = "Ödünç ID boş olamaz.")
    private UUID borrowId;

    private LocalDate overdueDate;

    @NotNull(message = "Ceza miktarı boş olamaz.")
    @DecimalMin(value = "0.0", inclusive = false, message = "Ceza miktarı 0'dan büyük olmalıdır.")
    private BigDecimal fineAmount;

    @Size(max = 30, message = "Ödeme durumu en fazla 30 karakter olabilir.")
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
