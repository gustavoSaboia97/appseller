package br.edu.infnet.appSales.clients;

import br.edu.infnet.appSales.model.domain.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "AddressClient", url = "https://viacep.com.br/ws")
public interface IAddressClient {

    @GetMapping(value = "/{zipCode}/json")
    Address findByZipCode(@PathVariable String zipCode);
}
