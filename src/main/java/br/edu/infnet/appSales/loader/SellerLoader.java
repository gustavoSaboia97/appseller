package br.edu.infnet.appSales.loader;

import br.edu.infnet.appSales.model.service.SellerService;
import br.edu.infnet.appSales.model.domain.Seller;
import br.edu.infnet.appSales.model.domain.Seller.SellerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;


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

            int sellerId = Integer.parseInt(values[0]);

            Seller seller = new SellerBuilder()
                .setId(sellerId)
                .setName(values[1])
                .setCpf(values[2]).setEmail(values[3])
                .setNickname(values[4])
                .setActive(Boolean.parseBoolean(values[5]))
                .setProducts()
                .build();

            sellerService.addSeller(seller);
        }
        reader.close();

        sellerService.getSellers().forEach(System.out::println);
    }
}
