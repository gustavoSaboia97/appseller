package br.edu.infnet.appSales.model.controller;

import br.edu.infnet.appSales.model.domain.APIError;
import br.edu.infnet.appSales.model.errors.BaseAPIException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.ResponseEntity.status;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;


@Slf4j
@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({BaseAPIException.class})
    public ResponseEntity<APIError> knownExceptionHandler(BaseAPIException ex) {
        log.error("Known error:  {}", ex.getMessage());

        APIError error = APIError.builder()
                .statusCode(ex.getHttpStatus().value())
                .message(ex.getMessage())
                .build();

        return status(ex.getHttpStatus()).body(error);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<APIError> parameterExceptionHandler(MethodArgumentNotValidException ex) {
        log.error("Known error:  {}", ex.getMessage());

        APIError error = APIError.builder()
                .message(ex.getMessage())
                .build();

        return status(BAD_REQUEST).body(error);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<APIError> genericExceptionHandler(Exception ex) {
        log.error("Unknown error {}: {}", ex.getClass(), ex.getMessage());

        APIError error = APIError.builder()
                .statusCode(INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage())
                .build();

        return status(INTERNAL_SERVER_ERROR).body(error);
    }
}
