package br.edu.infnet.appSales.model.service;

import br.edu.infnet.appSales.model.domain.Book;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class BookService {

    private final Map<Integer, Book> bookMap = new HashMap<>();

    public void addBook(Book Book){
        this.bookMap.put(Book.getId(), Book);
    }

    public Collection<Book> getBooks(){
        return this.bookMap.values();
    }
}
