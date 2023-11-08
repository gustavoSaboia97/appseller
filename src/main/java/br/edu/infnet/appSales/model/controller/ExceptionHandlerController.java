package br.edu.infnet.appSales.model.controller;

import br.edu.infnet.appSales.model.errors.BaseAPIException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.ResponseEntity.status;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.io.IOException;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({BaseAPIException.class})
    public ResponseEntity<Error> knownExceptionHandler(BaseAPIException ex) throws IOException {
        log.error("Known error:  {}", ex.getMessage());

        Error error = new Error(ex.getMessage());

        return status(ex.getHttpStatus()).body(error);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Error> parameterExceptionHandler(MethodArgumentNotValidException ex) throws IOException {
        log.error("Known error:  {}", ex.getMessage());

        Error error = new Error(ex.getMessage());

        return status(BAD_REQUEST).body(error);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Error> genericExceptionHandler(Exception ex) throws IOException {
        log.error("Unknown error: {}", ex.getMessage());

        Error error = new Error(ex.getMessage());

        return status(INTERNAL_SERVER_ERROR).body(error);
    }
}
