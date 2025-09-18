package com.souparnikar.gameclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souparnikar.gameclub.exceptions.BusinessException;
import com.souparnikar.gameclub.exceptions.IdNotPresentException;
import com.souparnikar.gameclub.modal.Game;
import com.souparnikar.gameclub.repository.GameRepository;

@Service
public class GameService {
    
    @Autowired
    private GameRepository repo;

    public Game create(Game game){
        game.setId(null);
        Game savedGame = repo.save(game);
        return savedGame;
    }
    public List<Game> findAll(){
        List<Game> games = repo.findAll();
        return games;
    }
    public Game findById(String Id) throws IdNotPresentException{
        Optional<Game> optionalGame = repo.findById(Id);
        if(optionalGame.isEmpty()){
            throw new IdNotPresentException("Product not found: " + Id);
        }

        return optionalGame.get();
    }
    public Game update(String Id, Game game) throws IdNotPresentException{
        Optional<Game> optionalGame = repo.findById(Id);
        if(optionalGame.isEmpty()){
            throw new IdNotPresentException("Game not found" + Id);
        }
        Game oldGame = optionalGame.get();
        oldGame.setName(game.getName());
        oldGame.setDescription(game.getDescription());  
        oldGame.setPrice(game.getPrice());

        Game updatedGame = repo.save(oldGame);
        return updatedGame;
    } 
    public boolean delete(String id) throws IdNotPresentException{
        Optional<Game> optionalGame = repo.findById(id);
        if(optionalGame.isEmpty()){
            throw new IdNotPresentException("Game not found: "+ id);
        }

        repo.deleteById(id);
        return true;
    }
}
