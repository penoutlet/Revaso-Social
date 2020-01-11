package com.revaso.revaso.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserDoesNotExistException extends RuntimeException {

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public UserDoesNotExistException(String message) {
        super(message);
    }
}
