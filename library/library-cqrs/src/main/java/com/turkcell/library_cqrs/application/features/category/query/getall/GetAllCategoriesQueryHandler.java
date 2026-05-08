package com.turkcell.library_cqrs.application.features.category.query.getall;

import java.util.List;
import org.springframework.stereotype.Component;
import com.turkcell.library_cqrs.core.mediator.cqrs.QueryHandler;
import com.turkcell.library_cqrs.persistence.repository.CategoryRepository;

@Component
public class GetAllCategoriesQueryHandler implements QueryHandler<GetAllCategoriesQuery, List<GetAllCategoriesQueryResponse>> {
    private final CategoryRepository categoryRepository;

    public GetAllCategoriesQueryHandler(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<GetAllCategoriesQueryResponse> handle(GetAllCategoriesQuery query) {
        return categoryRepository.findAll()
                .stream()
                .map(c -> new GetAllCategoriesQueryResponse(c.getId(), c.getCategoryName(), c.getDescription()))
                .toList();
    }
}
