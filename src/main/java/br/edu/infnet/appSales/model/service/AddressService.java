package br.edu.infnet.appSales.model.service;

import br.edu.infnet.appSales.clients.IAddressClient;
import br.edu.infnet.appSales.model.domain.Address;
import br.edu.infnet.appSales.model.domain.Seller;
import br.edu.infnet.appSales.model.repository.AddressRepository;
import br.edu.infnet.appSales.model.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private IAddressClient addressClient;

    public void addByZipCode(String zipCode) {
        Address existentAddress = getByZipCode(zipCode);

        if (existentAddress == null){
            Address address = addressClient.findByZipCode(zipCode);
            addressRepository.save(address);
        }
    }

    public Address getByZipCode(String zipCode) {
        return addressRepository.findByZipCode(zipCode);
    }
}
