package br.edu.infnet.appSales.model.errors;

import org.springframework.http.HttpStatus;

public class BaseAPIException extends RuntimeException {

    private final HttpStatus httpStatus;

    public BaseAPIException(HttpStatus httpStatus, String message){
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}