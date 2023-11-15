package br.edu.infnet.appSales.model.service;

import br.edu.infnet.appSales.model.domain.Game;
import br.edu.infnet.appSales.model.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public void upsert(Game game){
        this.gameRepository.save(game);
    }

    public Collection<Game> getAll(){
        return (Collection<Game>) this.gameRepository.findAll(Sort.by(Sort.Direction.ASC, "platformName"));
    }

    public Long getTotal() {
        return gameRepository.count();
    }

    public void delete(Integer gameId){
        gameRepository.deleteById(gameId);
    }
}
