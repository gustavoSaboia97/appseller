package br.edu.infnet.appSales.model.repository;


import br.edu.infnet.appSales.model.domain.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {
}
