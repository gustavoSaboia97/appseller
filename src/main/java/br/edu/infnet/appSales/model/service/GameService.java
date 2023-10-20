package br.edu.infnet.appSales.model.service;

import br.edu.infnet.appSales.model.domain.Game;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class GameService {

    private final Map<Integer, Game> gameMap = new HashMap<>();

    public void addGame(Game Game){
        this.gameMap.put(Game.getId(), Game);
    }

    public Collection<Game> getGames(){
        return this.gameMap.values();
    }
}
