package br.edu.infnet.appSales.loader;

import br.edu.infnet.appSales.model.domain.Address;
import br.edu.infnet.appSales.model.service.SellerService;
import br.edu.infnet.appSales.model.domain.Seller;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

@Slf4j
@Order(1)
@Component
public class SellerLoader implements ApplicationRunner {

    @Autowired
    private SellerService sellerService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/sellers.txt");
        BufferedReader reader = new BufferedReader(file);

        while(reader.ready()){
            String line = reader.readLine();
            String[] values = line.split(";");

            Integer sellerId = Integer.parseInt(values[0]);

            Address address = Address.builder()
                .zipCode(values[6])
                .build();

            Seller seller = Seller.builder()
                .id(sellerId)
                .name(values[1])
                .cpf(values[2])
                .email(values[3])
                .nickname(values[4])
                .isActive(Boolean.parseBoolean(values[5]))
                .products(new ArrayList<>())
                .address(address)
                .build();

            try {
                sellerService.upsert(seller);
            }
            catch (ConstraintViolationException exception) {
                log.error("Could not add the seller. err={}", exception.getMessage());
            }
        }
        reader.close();
    }
}
