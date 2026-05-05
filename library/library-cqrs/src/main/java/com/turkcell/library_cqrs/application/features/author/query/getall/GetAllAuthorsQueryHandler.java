package com.turkcell.library_cqrs.application.features.author.query.getall;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;
import com.turkcell.library_cqrs.core.mediator.cqrs.QueryHandler;

@Component
public class GetAllAuthorsQueryHandler implements QueryHandler<GetAllAuthorsQuery, List<GetAllAuthorsQueryResponse>> {
    @Override
    public List<GetAllAuthorsQueryResponse> handle(GetAllAuthorsQuery query) {
        System.out.println("Tüm yazarlar listelendi.");
        return List.of(new GetAllAuthorsQueryResponse(UUID.randomUUID(), "Stefan", "Zweig", 1881));
    }
}