package com.turkcell.library_system.dto;

import java.time.LocalDate;
import java.util.UUID;

public class UpdatedStaffResponse {
    private UUID id;
    private String badgeNo;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private LocalDate hireDate;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
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
