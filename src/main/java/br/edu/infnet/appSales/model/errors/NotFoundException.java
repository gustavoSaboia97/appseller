package br.edu.infnet.appSales.model.errors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class NotFoundException extends BaseAPIException {

    public NotFoundException(String entity){
        super(NOT_FOUND, entity + " Not Found");
    }
}
