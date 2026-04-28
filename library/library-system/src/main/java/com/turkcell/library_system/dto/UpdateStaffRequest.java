package com.turkcell.library_system.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public class UpdateStaffRequest {
    @NotBlank(message = "Rozet numarası boş olamaz.")
    @Size(max = 20, message = "Rozet numarası en fazla 20 karakter olabilir.")
    private String badgeNo;

    @NotBlank(message = "Ad boş olamaz.")
    @Size(max = 50, message = "Ad en fazla 50 karakter olabilir.")
    private String firstName;

    @NotBlank(message = "Soyad boş olamaz.")
    @Size(max = 50, message = "Soyad en fazla 50 karakter olabilir.")
    private String lastName;

    @Email(message = "Geçerli bir e-posta adresi giriniz.")
    @Size(max = 100, message = "E-posta en fazla 100 karakter olabilir.")
    private String email;

    @Size(max = 50, message = "Rol en fazla 50 karakter olabilir.")
    private String role;

    @PastOrPresent(message = "İşe başlama tarihi gelecekte olamaz.")
    private LocalDate hireDate;

    public String getBadgeNo() { return badgeNo; }
    public void setBadgeNo(String badgeNo) { this.badgeNo = badgeNo; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public LocalDate getHireDate() { return hireDate; }
    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }
}
