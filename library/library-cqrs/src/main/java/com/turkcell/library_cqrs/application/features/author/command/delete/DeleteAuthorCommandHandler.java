package com.turkcell.library_cqrs.application.features.author.command.delete;

import org.springframework.stereotype.Component;
import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;

@Component
public class DeleteAuthorCommandHandler implements CommandHandler<DeleteAuthorCommand, Void> {
    @Override
    public Void handle(DeleteAuthorCommand command) {
        System.out.println("Author silindi: " + command.id());
        return null;
    }
}
