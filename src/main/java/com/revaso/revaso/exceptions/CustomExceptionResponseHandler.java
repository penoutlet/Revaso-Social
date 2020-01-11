package com.revaso.revaso.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomExceptionResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleUserExistsException(UserExistsException exc, WebRequest req){
        UserExistsExceptionResponse exceptionResponse = new UserExistsExceptionResponse(exc.getMessage());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleUserDoesNotExistException(UserDoesNotExistException exc, WebRequest request) {
        UserDoesNotExistExceptionResponse userDoesNotExistExceptionResponse = new UserDoesNotExistExceptionResponse((exc.getMessage()));

        return new ResponseEntity<>(userDoesNotExistExceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
