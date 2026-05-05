package com.turkcell.library_cqrs.application.features.book.command.update;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;

@Component
public class UpdateBookCommandHandler implements CommandHandler<UpdateBookCommand, UUID> {
    @Override
    public UUID handle(UpdateBookCommand command) {
        System.out.println("Kitap güncellendi: " + command.id());
        return command.id();
    }
}
