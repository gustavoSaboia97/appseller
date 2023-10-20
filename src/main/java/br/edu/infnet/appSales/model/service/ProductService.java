package br.edu.infnet.appSales.model.service;

import br.edu.infnet.appSales.model.domain.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {

    private final Map<Integer, Product> productMap = new HashMap<>();

    public void addProduct(Product product){
        this.productMap.put(product.getId(), product);
    }

    public Collection<Product> getProducts(){
        return this.productMap.values();
    }
}
