package br.edu.infnet.appSales.model.controller;

import br.edu.infnet.appSales.model.domain.*;
import br.edu.infnet.appSales.model.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;


@Controller
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @RequestMapping(value = "/sellers")
    public ModelAndView showSellers() {
        ModelAndView sellersMV = new ModelAndView("sellers");
        Collection<Seller> sellers = sellerService.getSellers();
        sellersMV.addObject("sellers", sellers);
        return sellersMV;
    }
}
