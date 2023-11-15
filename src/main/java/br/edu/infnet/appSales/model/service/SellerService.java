package br.edu.infnet.appSales.model.service;

import br.edu.infnet.appSales.model.domain.Address;
import br.edu.infnet.appSales.model.domain.Seller;
import br.edu.infnet.appSales.model.errors.AlreadyExistsException;
import br.edu.infnet.appSales.model.errors.NotFoundException;
import br.edu.infnet.appSales.model.repository.SellerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private AddressService addressService;

    public void upsert(Seller seller){
        Seller sellerWithAddress = this.createSellerAddress(seller);
        sellerRepository.save(sellerWithAddress);
    }

    public Seller createSeller(Seller seller){
        Optional<Seller> optionalSeller = sellerRepository.findByCpf(seller.getCpf());

        if (optionalSeller.isPresent()){
            throw new AlreadyExistsException("Seller");
        }

        Seller sellerWithAddress = this.createSellerAddress(seller);
        sellerWithAddress.setId(null);

        return sellerRepository.save(sellerWithAddress);
    }

    public Seller updateSeller(Seller seller){
        log.error("Updating seller with id {}", seller.getId());
        Optional<Seller> optionalSeller = sellerRepository.findById(seller.getId());

        if (optionalSeller.isEmpty()){
            throw new NotFoundException("Seller");
        }

        Seller sellerWithAddress = this.createSellerAddress(seller);

        return sellerRepository.save(sellerWithAddress);
    }

    public Collection<Seller> getAll(){
        return (Collection<Seller>) sellerRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public Seller getByCpf(String cpf) throws NotFoundException {
        Optional<Seller> optionalSeller = sellerRepository.findByCpf(cpf);

        if (optionalSeller.isEmpty()) {
            throw new NotFoundException("Seller");
        }

        return optionalSeller.get();
    }

    public Seller getById(Integer id) {
        Optional<Seller> optionalSeller = sellerRepository.findById(id);

        if (optionalSeller.isEmpty()) {
            throw new NotFoundException("Seller");
        }

        return optionalSeller.get();
    }

    public Long getTotal() {
        return sellerRepository.count();
    }

    public void delete(Integer id){
        sellerRepository.deleteById(id);
    }

    private Seller createSellerAddress(Seller seller){
        addressService.addByZipCode(seller.getAddress().getZipCode());
        Address address = addressService.getByZipCode(seller.getAddress().getZipCode());

        seller.setAddress(address);

        return seller;
    }
}
