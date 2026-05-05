package com.turkcell.library_cqrs.application.features.category.command.update;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;

@Component
public class UpdateCategoryCommandHandler implements CommandHandler<UpdateCategoryCommand, UUID> {
    @Override
    public UUID handle(UpdateCategoryCommand command) {
        System.out.println("Category güncellendi: " + command.id());
        return command.id();
    }
}
