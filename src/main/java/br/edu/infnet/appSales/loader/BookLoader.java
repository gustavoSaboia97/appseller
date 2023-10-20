package br.edu.infnet.appSales.loader;

import br.edu.infnet.appSales.model.domain.Book;
import br.edu.infnet.appSales.model.domain.Product;
import br.edu.infnet.appSales.model.domain.ProductType;
import br.edu.infnet.appSales.model.domain.factory.ProductAbstractFactory;
import br.edu.infnet.appSales.model.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(3)
@Component
public class BookLoader implements ApplicationRunner {

    @Autowired
    private BookService bookService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/books.txt");
        BufferedReader reader = new BufferedReader(file);

        while(reader.ready()){
            String line = reader.readLine();
            String[] values = line.split(";");

            ProductAbstractFactory factory = new ProductAbstractFactory();
            ProductType productType = ProductType.valueOf(values[6]);

            Book book = (Book) factory.createProductWithTypeAndValues(productType, values);
            this.bookService.addBook(book);
        }

        reader.close();

        this.bookService.getBooks().forEach(System.out::println);
    }
}
