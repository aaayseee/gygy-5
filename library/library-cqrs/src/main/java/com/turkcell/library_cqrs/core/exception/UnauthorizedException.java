package com.turkcell.library_cqrs.core.exception;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException() {
        super("Bu işlem için yetkiniz bulunmamaktadır.");
    }
}
