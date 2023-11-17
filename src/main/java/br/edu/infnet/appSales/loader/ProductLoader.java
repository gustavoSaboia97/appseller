package br.edu.infnet.appSales.loader;

import br.edu.infnet.appSales.model.service.ProductService;
import br.edu.infnet.appSales.model.domain.Product;
import br.edu.infnet.appSales.model.domain.ProductType;
import br.edu.infnet.appSales.model.domain.factory.ProductAbstractFactory;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Slf4j
@Order(2)
@Component
public class ProductLoader implements ApplicationRunner {

    @Autowired
    private ProductService productService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/products.txt");
        BufferedReader reader = new BufferedReader(file);

        while(reader.ready()){
            String line = reader.readLine();
            String[] values = line.split(";");

            ProductAbstractFactory factory = new ProductAbstractFactory();
            ProductType productType = ProductType.valueOf(values[6]);

            Product product = factory.createProductWithTypeAndValues(productType, values);

            try {
                this.productService.upsert(product);
            }
            catch (ConstraintViolationException exception) {
                log.error("Could not add the product. err={}", exception.getMessage());
            }
        }

        reader.close();
    }
}
