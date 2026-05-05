package com.turkcell.library_cqrs.application.features.book.command.delete;

import org.springframework.stereotype.Component;
import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;

@Component
public class DeleteBookCommandHandler implements CommandHandler<DeleteBookCommand, Void> {
    @Override
    public Void handle(DeleteBookCommand command) {
        System.out.println("Kitap silindi: " + command.id());
        return null;
    }
}
