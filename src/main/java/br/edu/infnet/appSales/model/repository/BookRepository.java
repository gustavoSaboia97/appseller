package br.edu.infnet.appSales.model.repository;


import br.edu.infnet.appSales.model.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
}
