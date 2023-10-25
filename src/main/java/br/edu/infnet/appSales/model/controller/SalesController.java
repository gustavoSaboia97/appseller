package br.edu.infnet.appSales.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class SalesController {

    @RequestMapping(value = "/index")
    public String showIndex() {
        return "index";
    }
}
