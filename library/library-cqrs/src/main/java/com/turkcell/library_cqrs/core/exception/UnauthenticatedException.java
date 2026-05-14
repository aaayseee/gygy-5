package com.turkcell.library_cqrs.core.exception;

public class UnauthenticatedException extends RuntimeException {
    public UnauthenticatedException() {
        super("Bu işlem için giriş yapmalısınız.");
    }
}
