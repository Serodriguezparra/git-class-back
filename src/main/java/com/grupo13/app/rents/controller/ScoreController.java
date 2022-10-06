package com.grupo13.app.rents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.grupo13.app.rents.entities.Score;
import com.grupo13.app.rents.service.ScoreService;

@RestController
@RequestMapping("/api/Score")
public class ScoreController {
    
    @Autowired
    ScoreService service;

    @GetMapping("/all")
    public Iterable<Score> getScores(){

        /*Iterable<Quadbike> response = repository.findAll();

        return response;*/
        return service.get();
    }


    @PostMapping("/save")
    public String create(@RequestBody Score request){
      
       return service.create(request);
    }

}
