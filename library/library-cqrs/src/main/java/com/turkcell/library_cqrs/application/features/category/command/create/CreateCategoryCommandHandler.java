package com.turkcell.library_cqrs.application.features.category.command.create;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.library_cqrs.domain.Category;
import com.turkcell.library_cqrs.application.features.category.rule.CategoryBusinessRules;
import com.turkcell.library_cqrs.persistence.repository.CategoryRepository;

@Component
public class CreateCategoryCommandHandler implements CommandHandler<CreateCategoryCommand, UUID> {
    private final CategoryRepository categoryRepository;
    private final CategoryBusinessRules categoryBusinessRules;

    public CreateCategoryCommandHandler(CategoryRepository categoryRepository,
            CategoryBusinessRules categoryBusinessRules) {
        this.categoryRepository = categoryRepository;
        this.categoryBusinessRules = categoryBusinessRules;
    }

    @Override
    public UUID handle(CreateCategoryCommand command) {
        categoryBusinessRules.categoryWithSameNameMustNotExist(command.categoryName());

        Category category = new Category();
        category.setCategoryName(command.categoryName());
        category.setDescription(command.description());
        category = categoryRepository.save(category);
        return category.getId();
    }
}