package com.turkcell.library_system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateDepartmentRequest {
    @NotBlank(message = "Bölüm adı boş olamaz.")
    @Size(max = 100, message = "Bölüm adı en fazla 100 karakter olabilir.")
    private String deptName;

    @Size(max = 100, message = "Fakülte adı en fazla 100 karakter olabilir.")
    private String faculty;

    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }
    public String getFaculty() { return faculty; }
    public void setFaculty(String faculty) { this.faculty = faculty; }
}
