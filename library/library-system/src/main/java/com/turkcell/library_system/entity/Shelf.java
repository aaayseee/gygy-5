package com.turkcell.library_system.entity;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shelves")
public class Shelf {
    @Id
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @Column(name = "shelf_code", nullable = false, unique = true, length = 20)
    private String shelfCode;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "section", length = 50)
    private String section;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getShelfCode() { return shelfCode; }
    public void setShelfCode(String shelfCode) { this.shelfCode = shelfCode; }
    public Integer getFloor() { return floor; }
    public void setFloor(Integer floor) { this.floor = floor; }
    public String getSection() { return section; }
    public void setSection(String section) { this.section = section; }
}
