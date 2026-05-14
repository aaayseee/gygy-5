package com.turkcell.library_cqrs.core.security.authorization;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs.core.exception.UnauthenticatedException;
import com.turkcell.library_cqrs.core.exception.UnauthorizedException;
import com.turkcell.library_cqrs.core.mediator.pipeline.PipelineBehavior;
import com.turkcell.library_cqrs.core.mediator.pipeline.RequestHandlerDelegate;
import com.turkcell.library_cqrs.core.security.context.UserContext;

@Component
@Order(5)
public class AuthorizationBehavior implements PipelineBehavior {
    private final UserContext userContext;

    public AuthorizationBehavior(UserContext userContext) {
        this.userContext = userContext;
    }

    @Override
    public boolean supports(Object request) {
        return request instanceof AuthorizableRequest;
    }

    @Override
    public <R> R handle(Object request, RequestHandlerDelegate<R> next) {
        if (!userContext.isAuthenticated())
            throw new UnauthenticatedException();

        AuthorizableRequest authRequest = (AuthorizableRequest) request;

        if (!authRequest.requiredRoles().isEmpty()) {
            boolean hasRole = authRequest.requiredRoles()
                    .stream()
                    .anyMatch(role -> userContext.getRoles().contains(role));
            if (!hasRole)
                throw new UnauthorizedException();
        }

        return next.invoke();
    }
}
