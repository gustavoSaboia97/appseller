package br.edu.infnet.appSales.model.repository;


import br.edu.infnet.appSales.model.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
