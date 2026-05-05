package com.turkcell.library_cqrs.application.features.book.query.getbyid;

import java.util.UUID;

import org.springframework.stereotype.Component;
import com.turkcell.library_cqrs.core.mediator.cqrs.QueryHandler;

@Component
public class GetByIdBookQueryHandler implements QueryHandler<GetByIdBookQuery, GetByIdBookQueryResponse> {
    @Override
    public GetByIdBookQueryResponse handle(GetByIdBookQuery query) {
        System.out.println("Book getirildi: " + query.id());
        return new GetByIdBookQueryResponse(
                query.id(), UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(),
                "978-0451524935", "1984", 1949, "Secker & Warburg", "English", 328, 5, 3);
    }
}