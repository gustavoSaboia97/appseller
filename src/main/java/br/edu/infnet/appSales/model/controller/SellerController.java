package br.edu.infnet.appSales.model.controller;

import br.edu.infnet.appSales.model.domain.*;
import br.edu.infnet.appSales.model.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;


@RestController
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping(value = "/api/seller")
    public Seller create(@RequestBody Seller seller) {
        return sellerService.create(seller);
    }

    @PutMapping(value = "/api/seller/{id}")
    public Seller update(@PathVariable Integer id, @RequestBody Seller seller) {
        seller.setId(id);
        return sellerService.update(seller);
    }

    @GetMapping(value = "/api/seller")
    public Collection<Seller> getAll() {
        return sellerService.getAll();
    }

    @GetMapping(value = "/api/seller/{id}")
    public Seller getByCpf(@PathVariable Integer id) {
        return sellerService.getById(id);
    }

    @GetMapping(value = "/api/seller/cpf")
    public Seller getByCpf(@Param(value = "cpf") String cpf) {
        return sellerService.getByCpf(cpf);
    }

    @DeleteMapping(value = "/api/seller/{id}")
    public void delete(@PathVariable Integer id){
        sellerService.delete(id);
    }
}
