package com.turkcell.spring_starter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.spring_starter.dto.CreateCategoryRequest;
import com.turkcell.spring_starter.dto.CreatedCategoryResponse;
import com.turkcell.spring_starter.dto.GetByIdCategoryResponse;
import com.turkcell.spring_starter.dto.ListCategoryResponse;
import com.turkcell.spring_starter.dto.UpdateCategoryRequest;
import com.turkcell.spring_starter.dto.UpdatedCategoryResponse;
import com.turkcell.spring_starter.entity.Category;
import com.turkcell.spring_starter.repository.CategoryRepository;

import jakarta.persistence.EntityManager;

@Service
public class CategoryServiceImpl {
    private final CategoryRepository categoryRepository;
    private final EntityManager entityManager;

    public CategoryServiceImpl(CategoryRepository categoryRepository, EntityManager entityManager) {
        this.categoryRepository = categoryRepository;
        this.entityManager = entityManager;
    }

    public CreatedCategoryResponse create(CreateCategoryRequest createCategoryRequest) {
        // Veritabanında insert-update çalıştır.
        // entity id'e sahipse update
        // entity id'si null ise insert

        Category category = new Category();
        category.setName(createCategoryRequest.getName());

        category = this.categoryRepository.save(category); // ekledikten sonraki halini al

        CreatedCategoryResponse response = new CreatedCategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());

        return response;
    } 

    public List<ListCategoryResponse> getAll() {
        return categoryRepository.findAll().stream().map(category -> 
            {
            ListCategoryResponse response = new ListCategoryResponse();
            response.setId(category.getId());
            response.setName(category.getName());
            return response;
            })
            .toList();
    }


    public GetByIdCategoryResponse getById(UUID id) {
        Category category = categoryRepository.findById(id).orElseThrow();

        GetByIdCategoryResponse response = new GetByIdCategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        return response;
    }

    public UpdatedCategoryResponse update(UUID id, UpdateCategoryRequest request) {
        Category category = categoryRepository.findById(id).orElseThrow();
        category.setName(request.getName());
        category = categoryRepository.save(category);

        UpdatedCategoryResponse response = new UpdatedCategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        return response;
    }

    public void delete(UUID id) {
        categoryRepository.deleteById(id);
    }

    public List<ListCategoryResponse> search(String query)
    {
        //Set<Category> categories = categoryRepository.findByNameLike("%" + query + "%");

        // String Concatination (birleştimre "a" + user_input + "b") -> KESİNLİKLE YASAK
        //String jpql = "Select c from Category c Where c.name LIKE '%" + query + "%'";

        String jpql = "Select c from Category c Where c.name like :query";

        List<Category> categories = entityManager
        .createQuery(jpql, Category.class)
        .setParameter("query", "%" + query + "%")
        .getResultList();

        List<ListCategoryResponse> responseList = new ArrayList<>();

        for (Category category : categories) {
            ListCategoryResponse response = new ListCategoryResponse();
            response.setId(category.getId());
            response.setName(category.getName());
            responseList.add(response);
        }

        return responseList;
    }

    
}
