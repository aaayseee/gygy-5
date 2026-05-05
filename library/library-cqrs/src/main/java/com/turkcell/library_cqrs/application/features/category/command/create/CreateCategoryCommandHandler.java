package com.turkcell.library_cqrs.application.features.category.command.create;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;

@Component
public class CreateCategoryCommandHandler implements CommandHandler<CreateCategoryCommand, UUID> {
    @Override
    public UUID handle(CreateCategoryCommand command) {
        System.out.println("Category oluşturuldu: " + command.categoryName());
        return UUID.randomUUID();
    }
}
