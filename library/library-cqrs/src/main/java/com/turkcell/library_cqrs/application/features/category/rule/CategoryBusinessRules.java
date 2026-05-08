package com.turkcell.library_cqrs.application.features.category.rule;

import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.persistence.repository.CategoryRepository;

@Component
public class CategoryBusinessRules {
    private final CategoryRepository categoryRepository;

    public CategoryBusinessRules(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void categoryWithSameNameMustNotExist(String categoryName) {
    if (categoryRepository.findByCategoryNameIgnoreCase(categoryName).isPresent()) {
        throw new RuntimeException("Bu isimde bir kategori zaten mevcut: " + categoryName);
    }
}
}
