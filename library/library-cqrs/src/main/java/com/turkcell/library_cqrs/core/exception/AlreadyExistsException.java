package com.turkcell.library_cqrs.core.exception;

public class AlreadyExistsException extends BusinessException {
    public AlreadyExistsException(String message) {
        super(message);
    }
}
