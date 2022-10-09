package com.grupo13.app.rents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.grupo13.app.rents.entities.Score;
import com.grupo13.app.rents.service.ScoreService;
import org.springframework.http.HttpStatus;

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
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Score request){
      
       service.create(request);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody Score request){
 
       service.update(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){
 
       service.delete(id);
    }


}
