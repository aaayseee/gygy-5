package com.turkcell.library_cqrs.application.features.category.query.getbyid;

import org.springframework.stereotype.Component;
import com.turkcell.library_cqrs.core.mediator.cqrs.QueryHandler;

@Component
public class GetByIdCategoryQueryHandler implements QueryHandler<GetByIdCategoryQuery, GetByIdCategoryQueryResponse> {
    @Override
    public GetByIdCategoryQueryResponse handle(GetByIdCategoryQuery query) {
        System.out.println("Category getirildi: " + query.id());
        return new GetByIdCategoryQueryResponse(query.id(), "Örnek Kategori", "Açıklama");
    }
}