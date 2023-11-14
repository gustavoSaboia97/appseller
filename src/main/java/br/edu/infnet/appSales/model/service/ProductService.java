package br.edu.infnet.appSales.model.service;

import br.edu.infnet.appSales.model.domain.Product;
import br.edu.infnet.appSales.model.domain.Seller;
import br.edu.infnet.appSales.model.errors.NotFoundException;
import br.edu.infnet.appSales.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SellerService sellerService;


    public void add(Product product){
        this.productRepository.save(product);
    }

    public Collection<Product> getAll(){
        return (Collection<Product>) this.productRepository.findAll(Sort.by(Sort.Direction.ASC, "title"));
    }

    public Product getById(Integer id){
        Optional<Product> optionalProduct = this.productRepository.findById(id);

        if (optionalProduct.isEmpty()){
            throw new NotFoundException("Product");
        }

        return optionalProduct.get();
    }

    public Collection<Product> getBySellerId(Integer sellerId) {
        Seller seller = this.sellerService.getById(sellerId);
        return (Collection<Product>) this.productRepository.findAllBySellerId(seller.getId());
    }

    public Long getTotal() {
        return this.productRepository.count();
    }

    public void delete(Integer productId) {
        this.productRepository.deleteById(productId);
    }
}
