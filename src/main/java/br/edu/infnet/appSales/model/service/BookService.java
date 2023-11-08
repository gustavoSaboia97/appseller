package br.edu.infnet.appSales.model.service;

import br.edu.infnet.appSales.model.domain.Book;
import br.edu.infnet.appSales.model.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void add(Book book){
        this.bookRepository.save(book);
    }

    public Collection<Book> getAll(){
        return (Collection<Book>) this.bookRepository.findAll();
    }

    public Long getTotal() {
        return bookRepository.count();
    }

    public void delete(Integer bookId){
        bookRepository.deleteById(bookId);
    }
}
