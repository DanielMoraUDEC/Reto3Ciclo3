/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.sa.reto3GrupoG8.controller;

import com.reto3.sa.reto3GrupoG8.entity.Games;
import com.reto3.sa.reto3GrupoG8.service.GamesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author danie
 */
@RestController
@RequestMapping("/api/games/")
public class GamesController {
    @Autowired
    private GamesService service;
    
    @GetMapping("/all")
    public List<Games> findAllGames(){
        return service.getGamesAll();
    }
    
    @PostMapping("/save")
    public ResponseEntity addGame(@RequestBody Games games){
        service.saveGames(games);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateGame(@RequestBody Games games){
        service.updateGames(games);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity deleteGame(@RequestBody Games games){
        service.deleteGames(games.getId());
        return ResponseEntity.status(204).build();
    }
    
}
