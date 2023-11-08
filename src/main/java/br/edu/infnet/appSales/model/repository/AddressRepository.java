package br.edu.infnet.appSales.model.repository;


import br.edu.infnet.appSales.model.domain.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

    @Query("FROM Address a WHERE a.zipCode = :zipCode")
    Address findByZipCode(String zipCode);
}
