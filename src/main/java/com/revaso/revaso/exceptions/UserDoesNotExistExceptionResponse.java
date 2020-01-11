package com.revaso.revaso.exceptions;

public class UserDoesNotExistExceptionResponse {

    private String response;

    public UserDoesNotExistExceptionResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
