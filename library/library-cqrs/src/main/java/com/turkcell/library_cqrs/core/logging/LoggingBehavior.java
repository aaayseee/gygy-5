package com.turkcell.library_cqrs.core.logging;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.core.mediator.pipeline.PipelineBehavior;
import com.turkcell.library_cqrs.core.mediator.pipeline.RequestHandlerDelegate;

@Component
@Order(20)
public class LoggingBehavior implements PipelineBehavior {

    @Override
    public boolean supports(Object request) {
        return !(request instanceof NotLoggableRequest);
    }

    @Override
    public <R> R handle(Object request, RequestHandlerDelegate<R> next) {
        System.out.println("[LOG] Request başladı: " + request.getClass().getSimpleName());
        System.out.println("[LOG] Request içeriği: " + request);

        R response = next.invoke();

        System.out.println("[LOG] Response döndü: " + response);

        return response;
    }
}
