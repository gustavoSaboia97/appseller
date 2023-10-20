package br.edu.infnet.appSales.model.service;

import br.edu.infnet.appSales.model.domain.Seller;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SellerService {

    private final Map<Integer, Seller> sellerMap = new HashMap<>();

    public void addSeller(Seller seller){
        sellerMap.put(seller.getId(), seller);
    }

    public Collection<Seller> getSellers(){
        return sellerMap.values();
    }
}
