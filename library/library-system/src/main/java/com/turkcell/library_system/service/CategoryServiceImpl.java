package com.turkcell.library_system.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.library_system.dto.*;
import com.turkcell.library_system.entity.Category;
import com.turkcell.library_system.exception.NotFoundException;
import com.turkcell.library_system.repository.CategoryRepository;

@Service
public class CategoryServiceImpl {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CreatedCategoryResponse create(CreateCategoryRequest request) {
        Category category = new Category();
        category.setCategoryName(request.getCategoryName());
        category.setDescription(request.getDescription());
        category = categoryRepository.save(category);

        CreatedCategoryResponse response = new CreatedCategoryResponse();
        response.setId(category.getId());
        response.setCategoryName(category.getCategoryName());
        response.setDescription(category.getDescription());
        return response;
    }

    public List<ListCategoryResponse> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> {
                    ListCategoryResponse response = new ListCategoryResponse();
                    response.setId(category.getId());
                    response.setCategoryName(category.getCategoryName());
                    response.setDescription(category.getDescription());
                    return response;
                })
                .toList();
    }

    public GetByIdCategoryResponse getById(UUID id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Kategori bulunamadı. ID: " + id));

        GetByIdCategoryResponse response = new GetByIdCategoryResponse();
        response.setId(category.getId());
        response.setCategoryName(category.getCategoryName());
        response.setDescription(category.getDescription());
        return response;
    }

    public UpdatedCategoryResponse update(UUID id, UpdateCategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Kategori bulunamadı. ID: " + id));
        category.setCategoryName(request.getCategoryName());
        category.setDescription(request.getDescription());
        category = categoryRepository.save(category);

        UpdatedCategoryResponse response = new UpdatedCategoryResponse();
        response.setId(category.getId());
        response.setCategoryName(category.getCategoryName());
        response.setDescription(category.getDescription());
        return response;
    }

    public void delete(UUID id) {
        if (!categoryRepository.existsById(id))
            throw new NotFoundException("Kategori bulunamadı. ID: " + id);

        categoryRepository.deleteById(id);
    }
}
