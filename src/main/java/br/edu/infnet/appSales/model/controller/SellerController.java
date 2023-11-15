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

    @RequestMapping(value = "/seller")
    public ModelAndView showSellers() {
        ModelAndView sellersMV = new ModelAndView("seller");
        Collection<Seller> sellers = sellerService.getAll();
        sellersMV.addObject("sellers", sellers);
        return sellersMV;
    }

    @PostMapping(value = "/api/seller")
    public Seller createSeller(@RequestBody Seller seller) {
        return sellerService.createSeller(seller);
    }

    @PutMapping(value = "/api/seller/{id}")
    public Seller updateSeller(@PathVariable Integer id, @RequestBody Seller seller) {
        seller.setId(id);
        return sellerService.updateSeller(seller);
    }

    @GetMapping(value = "/api/seller")
    public Collection<Seller> getSellers() {
        return sellerService.getAll();
    }

    @GetMapping(value = "/api/seller/{id}")
    public Seller getSellerByCpf(@PathVariable Integer id) {
        return sellerService.getById(id);
    }

    @GetMapping(value = "/api/seller/cpf")
    public Seller getSellerByCpf(@Param(value = "cpf") String cpf) {
        return sellerService.getByCpf(cpf);
    }

    @DeleteMapping(value = "/api/seller/{id}")
    public void delete(@PathVariable Integer id){
        sellerService.delete(id);
    }
}
