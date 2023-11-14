package br.edu.infnet.appSales.model.controller;

import br.edu.infnet.appSales.model.domain.*;
import br.edu.infnet.appSales.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;


@RestController
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

    @GetMapping(value = "/api/product")
    public Collection<Product> getSellerByCpf(@Param(value = "sellerId") Integer sellerId) {
        if (sellerId != null){
            return productService.getBySellerId(sellerId);
        }
        return productService.getAll();
    }

    @GetMapping(value = "/api/product/{id}")
    public Product getById(@PathVariable Integer id){
        return productService.getById(id);
    }

    @DeleteMapping(value = "/api/product/{id}")
    public void delete(@PathVariable Integer id){
        productService.delete(id);
    }
}
