package com.turkcell.library_system.dto;

import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateStudentRequest {
    @NotNull(message = "Bölüm ID boş olamaz.")
    private UUID departmentId;

    @NotBlank(message = "Öğrenci numarası boş olamaz.")
    @Size(max = 20, message = "Öğrenci numarası en fazla 20 karakter olabilir.")
    private String studentNo;

    @NotBlank(message = "Ad boş olamaz.")
    @Size(max = 50, message = "Ad en fazla 50 karakter olabilir.")
    private String firstName;

    @NotBlank(message = "Soyad boş olamaz.")
    @Size(max = 50, message = "Soyad en fazla 50 karakter olabilir.")
    private String lastName;

    @Email(message = "Geçerli bir e-posta adresi giriniz.")
    @Size(max = 100, message = "E-posta en fazla 100 karakter olabilir.")
    private String email;

    @Size(max = 20, message = "Telefon en fazla 20 karakter olabilir.")
    private String phone;

    @Size(max = 20, message = "Durum en fazla 20 karakter olabilir.")
    private String status;

    public UUID getDepartmentId() { return departmentId; }
    public void setDepartmentId(UUID departmentId) { this.departmentId = departmentId; }
    public String getStudentNo() { return studentNo; }
    public void setStudentNo(String studentNo) { this.studentNo = studentNo; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
