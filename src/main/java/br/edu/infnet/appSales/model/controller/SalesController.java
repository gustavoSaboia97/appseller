package br.edu.infnet.appSales.model.controller;

import br.edu.infnet.appSales.model.domain.Product;
import br.edu.infnet.appSales.model.domain.Seller;
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
    private SellerService sellerService;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/index")
    public String showIndex() {
        return "index";
    }

    @RequestMapping(value = "/sellers")
    public ModelAndView showSellers() {
        ModelAndView sellersMV = new ModelAndView("sellers");
        Collection<Seller> sellers = sellerService.getSellers();
        sellersMV.addObject("sellers", sellers);
        return sellersMV;
    }

    @RequestMapping(value = "/products")
    public ModelAndView showProducts() {
        ModelAndView productsMV = new ModelAndView("products");
        Collection<Product> products = productService.getProducts();
        productsMV.addObject("products", products);
        return productsMV;
    }
}
