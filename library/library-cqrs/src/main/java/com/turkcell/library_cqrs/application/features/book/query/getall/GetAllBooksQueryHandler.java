package com.turkcell.library_cqrs.application.features.book.query.getall;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;
import com.turkcell.library_cqrs.core.mediator.cqrs.QueryHandler;

@Component
public class GetAllBooksQueryHandler implements QueryHandler<GetAllBooksQuery, List<GetAllBooksQueryResponse>> {
    @Override
    public List<GetAllBooksQueryResponse> handle(GetAllBooksQuery query) {
        System.out.println("Tüm kitaplar listelendi.");
        return List.of(new GetAllBooksQueryResponse(
                UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(),
                "978-0451524935", "1984", 1949, "Secker & Warburg", "English", 328, 5, 3));
    }
}
