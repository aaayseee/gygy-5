package com.turkcell.library_cqrs.application.features.author.command.update;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;

@Component
public class UpdateAuthorCommandHandler implements CommandHandler<UpdateAuthorCommand, UUID> {
    @Override
    public UUID handle(UpdateAuthorCommand command) {
        System.out.println("Author güncellendi: " + command.id());
        return command.id();
    }
}