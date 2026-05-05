package com.turkcell.library_cqrs.application.features.author.command.create;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;

@Component
public class CreateAuthorCommandHandler implements CommandHandler<CreateAuthorCommand, UUID> {
    @Override
    public UUID handle(CreateAuthorCommand command) {
        System.out.println("Author oluşturuldu: " + command.firstName() + " " + command.lastName());
        return UUID.randomUUID();
    }
}
