package com.turkcell.library_cqrs.domain;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @Column(name = "dept_name", nullable = false, length = 100)
    private String deptName;

    @Column(name = "faculty", length = 100)
    private String faculty;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }
    public String getFaculty() { return faculty; }
    public void setFaculty(String faculty) { this.faculty = faculty; }
}
