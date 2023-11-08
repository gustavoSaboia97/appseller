package br.edu.infnet.appSales.model.controller;

import br.edu.infnet.appSales.model.domain.*;
import br.edu.infnet.appSales.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;


@Controller
public class ProductsController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product")
    public ModelAndView showProducts() {
        ModelAndView productsMV = new ModelAndView("product");
        Collection<Product> products = productService.getAll();

        Collection<Game> games = products.stream()
                .filter(product -> product.getType() == ProductType.GAME)
                .map(product -> (Game) product)
                .toList();

        Collection<Book> books = products.stream()
                .filter(product -> product.getType() == ProductType.BOOK)
                .map(product -> (Book) product)
                .toList();

        productsMV.addObject("games", games);
        productsMV.addObject("books", books);

        return productsMV;
    }

    @DeleteMapping(value = "/product/{id}")
    public void delete(@PathVariable Integer id){
        productService.delete(id);
    }
}
