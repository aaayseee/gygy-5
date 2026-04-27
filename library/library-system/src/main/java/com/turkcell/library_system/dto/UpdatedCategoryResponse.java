package com.turkcell.library_system.dto;

import java.util.UUID;

public class UpdatedCategoryResponse {
    private UUID id;
    private String categoryName;
    private String description;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

}
