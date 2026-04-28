package com.turkcell.library_system.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateAuthorRequest {
    @NotBlank(message = "Ad boş olamaz.")
    @Size(max = 50, message = "Ad en fazla 50 karakter olabilir.")
    private String firstName;

    @NotBlank(message = "Soyad boş olamaz.")
    @Size(max = 50, message = "Soyad en fazla 50 karakter olabilir.")
    private String lastName;

    @Min(value = 0, message = "Doğum yılı 0'dan küçük olamaz.")
    @Max(value = 2025, message = "Doğum yılı geçersiz.")
    private Integer birthYear;

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public Integer getBirthYear() { return birthYear; }
    public void setBirthYear(Integer birthYear) { this.birthYear = birthYear; }
}
