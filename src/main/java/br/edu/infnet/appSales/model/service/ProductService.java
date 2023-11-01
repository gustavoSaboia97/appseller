package br.edu.infnet.appSales.model.service;

import br.edu.infnet.appSales.model.domain.Product;
import br.edu.infnet.appSales.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Product product){
        this.productRepository.save(product);
    }

    public Collection<Product> getProducts(){
        return (Collection<Product>) this.productRepository.findAll();
    }

    public Long getTotal() {
        return productRepository.count();
    }
}
