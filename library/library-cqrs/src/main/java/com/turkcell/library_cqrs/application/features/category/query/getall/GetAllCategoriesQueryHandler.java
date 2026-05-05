package com.turkcell.library_cqrs.application.features.category.query.getall;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;
import com.turkcell.library_cqrs.core.mediator.cqrs.QueryHandler;

@Component
public class GetAllCategoriesQueryHandler implements QueryHandler<GetAllCategoriesQuery, List<GetAllCategoriesQueryResponse>> {
    @Override
    public List<GetAllCategoriesQueryResponse> handle(GetAllCategoriesQuery query) {
        System.out.println("Tüm kategoriler listelendi.");
        return List.of(new GetAllCategoriesQueryResponse(UUID.randomUUID(), "Örnek Kategori", "Açıklama"));
    }
}
