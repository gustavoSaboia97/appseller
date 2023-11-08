package br.edu.infnet.appSales.model.domain.factory;

import br.edu.infnet.appSales.model.domain.*;

import java.math.BigDecimal;

public class ProductAbstractFactory {
    public Product createProductWithTypeAndValues(ProductType productType, String[] values) throws Exception {
        Seller seller = Seller.builder()
            .id(Integer.parseInt(values[1]))
            .build();

        return switch (productType){
            case ProductType.BOOK -> createBookWithValuesAndSeller(values, seller);
            case ProductType.GAME -> createGameWithValues(values, seller);
        };
    }

    public Product createBookWithValuesAndSeller(String[] values, Seller seller){
        return Book.builder()
            .id(Integer.parseInt(values[0]))
            .title(values[2])
            .description(values[3])
            .price(new BigDecimal(values[4]))
            .quantity(Integer.parseInt(values[5]))
            .type(ProductType.valueOf(values[6]))
            .seller(seller)
            .authorName(values[7])
            .publisherName(values[8])
            .numberOfPages(Integer.parseInt(values[9]))
            .build();
    }

    public Product createGameWithValues(String[] values, Seller seller){
        return Game.builder()
            .id(Integer.parseInt(values[0]))
            .title(values[2])
            .description(values[3])
            .price(new BigDecimal(values[4]))
            .quantity(Integer.parseInt(values[5]))
            .type(ProductType.valueOf(values[6]))
            .seller(seller)
            .platformName(values[7])
            .studioName(values[8])
            .build();
    }
}
