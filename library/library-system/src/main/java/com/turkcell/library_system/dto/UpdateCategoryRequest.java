package com.turkcell.library_system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateCategoryRequest {
    @NotBlank(message = "Kategori adı boş olamaz.")
    @Size(max = 50, message = "Kategori adı en fazla 50 karakter olabilir.")
    private String categoryName;

    @Size(max = 255, message = "Açıklama en fazla 255 karakter olabilir.")
    private String description;

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
