package com.turkcell.library_system.entity;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "categories")
public class Category {
    @Id
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @Column(name = "category_name", nullable = false, length = 50)
    private String categoryName;

    @Column(name = "description", length = 255)
    private String description;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

}
