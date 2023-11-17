package br.edu.infnet.appSales.model.errors;

import static org.springframework.http.HttpStatus.CONFLICT;

public class SellerHasProductsException extends BaseAPIException {

    public SellerHasProductsException(){
        super(CONFLICT, "Seller cannot be deleted");
    }
}
