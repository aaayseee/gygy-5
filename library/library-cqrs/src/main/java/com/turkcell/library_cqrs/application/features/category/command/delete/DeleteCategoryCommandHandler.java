package com.turkcell.library_cqrs.application.features.category.command.delete;

import org.springframework.stereotype.Component;
import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;

@Component
public class DeleteCategoryCommandHandler implements CommandHandler<DeleteCategoryCommand, Void> {
    @Override
    public Void handle(DeleteCategoryCommand command) {
        System.out.println("Category silindi: " + command.id());
        return null;
    }
}