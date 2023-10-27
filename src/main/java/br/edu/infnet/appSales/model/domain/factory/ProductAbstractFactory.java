package br.edu.infnet.appSales.model.domain.factory;

import br.edu.infnet.appSales.model.domain.*;

import java.math.BigDecimal;

public class ProductAbstractFactory {
    public Product createProductWithTypeAndValues(ProductType productType, String[] values) throws Exception {
        Seller seller = new Seller.SellerBuilder()
            .setId(Integer.parseInt(values[1]))
            .build();

        return switch (productType){
            case ProductType.BOOK -> createBookWithValuesAndSeller(values, seller);
            case ProductType.GAME -> createGameWithValues(values, seller);
        };
    }

    public Product createBookWithValuesAndSeller(String[] values, Seller seller){
        return new Book.BookBuilder()
            .setId(Integer.parseInt(values[0]))
            .setTitle(values[2])
            .setDescription(values[3])
            .setPrice(new BigDecimal(values[4]))
            .setQuantity(Integer.parseInt(values[5]))
            .setType(ProductType.valueOf(values[6]))
            .setSeller(seller)
            .setAuthorName(values[7])
            .setPublisherName(values[8])
            .setNumberOfPages(Integer.parseInt(values[9]))
            .build();
    }

    public Product createGameWithValues(String[] values, Seller seller){
        return new Game.GameBuilder()
            .setId(Integer.parseInt(values[0]))
            .setTitle(values[2])
            .setDescription(values[3])
            .setPrice(new BigDecimal(values[4]))
            .setQuantity(Integer.parseInt(values[5]))
            .setType(ProductType.valueOf(values[6]))
            .setSeller(seller)
            .setPlatformName(values[7])
            .setStudioName(values[8])
            .build();
    }
}
