package br.edu.infnet.appSales.model.errors;

import static org.springframework.http.HttpStatus.CONFLICT;

public class AlreadyExistsException extends BaseAPIException {

    public AlreadyExistsException(String entity){
        super(CONFLICT, entity + " Already Exists");
    }
}
