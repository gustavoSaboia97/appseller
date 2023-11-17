package br.edu.infnet.appSales.model.repository;


import br.edu.infnet.appSales.model.domain.Seller;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface SellerRepository extends CrudRepository<Seller, Integer> {
    Optional<Seller> findByCpf(String cpf);
    Iterable<Seller> findAll(Sort sort);
}
