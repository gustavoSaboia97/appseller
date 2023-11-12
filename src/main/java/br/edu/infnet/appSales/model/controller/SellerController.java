package br.edu.infnet.appSales.model.controller;

import br.edu.infnet.appSales.model.domain.*;
import br.edu.infnet.appSales.model.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;


@Controller
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

    @DeleteMapping(value = "/api/seller/{id}")
    public void delete(@PathVariable Integer id){
        sellerService.delete(id);
    }
}
