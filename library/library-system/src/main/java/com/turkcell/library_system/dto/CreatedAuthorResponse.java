package com.turkcell.library_system.dto;

import java.util.UUID;

public class CreatedAuthorResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private Integer birthYear;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public Integer getBirthYear() { return birthYear; }
    public void setBirthYear(Integer birthYear) { this.birthYear = birthYear; }

}
