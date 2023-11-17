package br.edu.infnet.appSales.model.controller;

import br.edu.infnet.appSales.model.domain.SalesInfo;
import br.edu.infnet.appSales.model.service.BookService;
import br.edu.infnet.appSales.model.service.GameService;
import br.edu.infnet.appSales.model.service.ProductService;
import br.edu.infnet.appSales.model.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SalesController {

    @Autowired
    private ProductService productService;

    @Autowired
    private GameService gameService;

    @Autowired
    private BookService bookService;

    @Autowired
    private SellerService sellerService;

    @GetMapping(value = "/api/sales-info")
    public SalesInfo getBasicInfo() {
        return SalesInfo.builder()
                .totalOfSellers(sellerService.getTotal())
                .totalOfProducts(productService.getTotal())
                .totalOfGames(gameService.getTotal())
                .totalOfBooks(bookService.getTotal())
                .build();
    }
}
