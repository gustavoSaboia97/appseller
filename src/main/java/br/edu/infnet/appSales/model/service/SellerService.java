package br.edu.infnet.appSales.model.service;

import br.edu.infnet.appSales.model.domain.Address;
import br.edu.infnet.appSales.model.domain.Seller;
import br.edu.infnet.appSales.model.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private AddressService addressService;

    public void add(Seller seller){
        addressService.addByZipCode(seller.getAddress().getZipCode());
        Address address = addressService.getByZipCode(seller.getAddress().getZipCode());

        seller.setAddress(address);

        sellerRepository.save(seller);
    }

    public Collection<Seller> getAll(){
        return (Collection<Seller>) sellerRepository.findAll();
    }

    public Long getTotal() {
        return sellerRepository.count();
    }

    public void delete(Integer id){
        sellerRepository.deleteById(id);
    }
}
