package com.api.parkingcontrol.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class ValidationConflictException extends RuntimeException {

    @Getter
    private final String message;

    public ValidationConflictException(String message) {
        super(message);
        this.message = message;
    }
}
