package br.edu.infnet.appSales.model.controller;

import br.edu.infnet.appSales.model.domain.*;
import br.edu.infnet.appSales.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
public class ProductsController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/api/seller/{sellerId}/product")
    public Product create(@PathVariable Integer sellerId, @RequestBody Product product) {
        Seller seller = Seller.builder()
                .id(sellerId)
                .build();

        product.setSeller(seller);

        return this.productService.create(product);
    }

    @PutMapping(value = "/api/seller/{sellerId}/product/{id}")
    public Product update(@PathVariable Integer sellerId, @PathVariable Integer id, @RequestBody Product product) {
        Seller seller = Seller.builder()
                .id(sellerId)
                .build();

        product.setId(id);
        product.setSeller(seller);

        return this.productService.create(product);
    }

    @GetMapping(value = "/api/product")
    public Collection<Product> getAll(@Param(value = "sellerId") Integer sellerId) {
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
