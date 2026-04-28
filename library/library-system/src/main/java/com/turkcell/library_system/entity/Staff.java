package com.turkcell.library_system.entity;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @Column(name = "badge_no", nullable = false, unique = true, length = 20)
    private String badgeNo;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "email", unique = true, length = 100)
    private String email;

    @Column(name = "role", length = 50)
    private String role;

    @Column(name = "hire_date")
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
