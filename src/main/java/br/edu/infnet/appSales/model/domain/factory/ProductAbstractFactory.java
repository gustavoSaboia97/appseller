package br.edu.infnet.appSales.model.domain.factory;

import br.edu.infnet.appSales.model.domain.Product;
import br.edu.infnet.appSales.model.domain.Game;
import br.edu.infnet.appSales.model.domain.Book;
import br.edu.infnet.appSales.model.domain.ProductType;

import java.math.BigDecimal;

public class ProductAbstractFactory {
    public Product createProductWithTypeAndValues(ProductType productType, String[] values) throws Exception {
        return switch (productType){
            case ProductType.BOOK -> createBookWithValues(values);
            case ProductType.GAME -> createGameWithValues(values);
            default -> throw new Exception("Unsupported Product");
        };
    }

    public Product createBookWithValues(String[] values){
        return new Book.BookBuilder()
            .setId(Integer.parseInt(values[0]))
            .setTitle(values[2])
            .setDescription(values[3])
            .setPrice(new BigDecimal(values[4]))
            .setQuantity(Integer.parseInt(values[5]))
            .setAuthorName(values[7])
            .setPublisherName(values[8])
            .setNumberOfPages(Integer.parseInt(values[9]))
            .build();
    }

    public Product createGameWithValues(String[] values){
        return new Game.GameBuilder()
            .setId(Integer.parseInt(values[0]))
            .setTitle(values[2])
            .setDescription(values[3])
            .setPrice(new BigDecimal(values[4]))
            .setQuantity(Integer.parseInt(values[5]))
            .setPlatformName(values[7])
            .setStudioName(values[8])
            .build();
    }
}