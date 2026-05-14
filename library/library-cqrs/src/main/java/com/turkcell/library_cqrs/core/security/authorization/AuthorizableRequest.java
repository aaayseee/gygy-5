package com.turkcell.library_cqrs.core.security.authorization;

import java.util.List;

public interface AuthorizableRequest {
    default List<String> requiredRoles() {
        return List.of();
    }
}
