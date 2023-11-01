package br.edu.infnet.appSales.model.controller;

import br.edu.infnet.appSales.model.domain.Seller;
import br.edu.infnet.appSales.model.service.BookService;
import br.edu.infnet.appSales.model.service.GameService;
import br.edu.infnet.appSales.model.service.ProductService;
import br.edu.infnet.appSales.model.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;


@Controller
public class SalesController {

    @Autowired
    private ProductService productService;

    @Autowired
    private GameService gameService;

    @Autowired
    private BookService bookService;

    @Autowired
    private SellerService sellerService;

    @RequestMapping(value = {"/", "/index"})
    public ModelAndView showIndex() {
        ModelAndView indexMV = new ModelAndView("index");

        Long totalOfSellers = sellerService.getTotal();
        Long totalOfProducts = productService.getTotal();
        Long totalOfGames = gameService.getTotal();
        Long totalOfBooks = bookService.getTotal();

        indexMV.addObject("totalOfSellers", totalOfSellers);
        indexMV.addObject("totalOfProducts", totalOfProducts);
        indexMV.addObject("totalOfGames", totalOfGames);
        indexMV.addObject("totalOfBooks", totalOfBooks);

        return indexMV;
    }
}
