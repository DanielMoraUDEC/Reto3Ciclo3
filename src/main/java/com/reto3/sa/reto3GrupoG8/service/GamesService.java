/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.sa.reto3GrupoG8.service;

import com.reto3.sa.reto3GrupoG8.entity.Games;
import com.reto3.sa.reto3GrupoG8.repository.GamesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author danie
 */
@Service
public class GamesService {
    @Autowired
    private GamesRepository repository;
    //listar
    public List<Games> getGamesAll(){
        return repository.findAll();
    }
    //crear
    public Games saveGames(Games games){
        return repository.save(games);
    }
    //actualizar
    public Games updateGames(Games games){
        
        Games existeProducto = repository.findById(games.getId()).orElse(null);
        existeProducto.setDeveloper(games.getDeveloper());
        existeProducto.setMinage(games.getMinage());
        existeProducto.setCategory_id(games.getCategory_id());
        existeProducto.setName(games.getName());
        
        return repository.save(existeProducto);
    }
    //eliminar
    public String deleteGames(int idGame){
        Games existeProducto = repository.findById(idGame).orElse(null);
        if(existeProducto != null){
            repository.deleteById(idGame);
        return "Game deleted";
        }else{
            return "Error";
        }  
    }
    
    public Games getGameById(Games games){
        return repository.findById(games.getId()).orElse(null);
    }
    
}
