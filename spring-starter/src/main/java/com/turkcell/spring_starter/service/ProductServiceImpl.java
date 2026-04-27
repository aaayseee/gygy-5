package com.turkcell.spring_starter.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.spring_starter.dto.*;
import com.turkcell.spring_starter.entity.Category;
import com.turkcell.spring_starter.entity.Product;
import com.turkcell.spring_starter.repository.CategoryRepository;
import com.turkcell.spring_starter.repository.ProductRepository;

@Service
public class ProductServiceImpl {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public CreatedProductResponse create(CreateProductRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow();

        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setCategory(category);
        product = productRepository.save(product);

        CreatedProductResponse response = new CreatedProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setCategoryId(product.getCategory().getId());
        return response;
    }

    public List<ListProductResponse> getAll() {
        return productRepository.findAll()
                .stream()
                .map(product -> {
                    ListProductResponse response = new ListProductResponse();
                    response.setId(product.getId());
                    response.setName(product.getName());
                    response.setDescription(product.getDescription());
                    response.setCategoryId(product.getCategory().getId());
                    return response;
                })
                .toList();
    }

    public GetByIdProductResponse getById(UUID id) {
        Product product = productRepository.findById(id).orElseThrow();

        GetByIdProductResponse response = new GetByIdProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setCategoryId(product.getCategory().getId());
        return response;
    }

    public UpdatedProductResponse update(UUID id, UpdateProductRequest request) {
        Product product = productRepository.findById(id).orElseThrow();
        Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow();

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setCategory(category);
        product = productRepository.save(product);

        UpdatedProductResponse response = new UpdatedProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setCategoryId(product.getCategory().getId());
        return response;
    }

    public void delete(UUID id) {
        productRepository.deleteById(id);
    }
}
