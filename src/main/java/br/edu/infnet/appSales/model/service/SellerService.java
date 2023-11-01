package br.edu.infnet.appSales.model.service;

import br.edu.infnet.appSales.model.domain.Seller;
import br.edu.infnet.appSales.model.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public void addSeller(Seller seller){
        sellerRepository.save(seller);
    }

    public Collection<Seller> getSellers(){
        return (Collection<Seller>) sellerRepository.findAll();
    }

    public Long getTotal() {
        return sellerRepository.count();
    }
}
