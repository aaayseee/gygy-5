package com.turkcell.library_cqrs.application.features.author.query.getbyid;

import org.springframework.stereotype.Component;
import com.turkcell.library_cqrs.core.mediator.cqrs.QueryHandler;

@Component
public class GetByIdAuthorQueryHandler implements QueryHandler<GetByIdAuthorQuery, GetByIdAuthorQueryResponse> {
    @Override
    public GetByIdAuthorQueryResponse handle(GetByIdAuthorQuery query) {
        System.out.println("Author getirildi: " + query.id());
        return new GetByIdAuthorQueryResponse(query.id(), "Stefan", "Zweig", 1881);
    }
}