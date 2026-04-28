package com.turkcell.library_system.dto;

public class CreateDepartmentRequest {
    private String deptName;
    private String faculty;

    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }
    public String getFaculty() { return faculty; }
    public void setFaculty(String faculty) { this.faculty = faculty; }

}
