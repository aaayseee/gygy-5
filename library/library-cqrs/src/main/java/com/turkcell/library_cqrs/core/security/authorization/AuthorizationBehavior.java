package com.turkcell.library_cqrs.core.security.authorization;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.core.mediator.pipeline.PipelineBehavior;
import com.turkcell.library_cqrs.core.mediator.pipeline.RequestHandlerDelegate;

@Component
@Order(5) // Performance(10) ve Logging(20)'dan önce çalışır
public class AuthorizationBehavior implements PipelineBehavior {
    @Override
    public <R> R handle(Object request, RequestHandlerDelegate<R> next) {
        System.out.println("[AUTH] Yetkilendirme kontrolü: " + request.getClass().getSimpleName());
        return next.invoke();
    }
}
