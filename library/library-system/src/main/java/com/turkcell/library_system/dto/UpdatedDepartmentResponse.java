package com.turkcell.library_system.dto;

import java.util.UUID;

public class UpdatedDepartmentResponse {
    private UUID id;
    private String deptName;
    private String faculty;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }
    public String getFaculty() { return faculty; }
    public void setFaculty(String faculty) { this.faculty = faculty; }

}
