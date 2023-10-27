package br.edu.infnet.appSales.model.repository;


import br.edu.infnet.appSales.model.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Query("FROM Product p WHERE p.seller.id = :sellerId")
    Collection<Product> getProducts(Integer sellerId);
}
