package com.grupo13.app.rents.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo13.app.rents.entities.Score;
import com.grupo13.app.rents.interfaces.IScoreRepository;

@Repository
public class ScoreRepository {
    
    @Autowired
    IScoreRepository repository;

    public Iterable<Score> getAll(){
        return repository.findAll();
    }
    
    public Optional<Score> findById(Integer id){
        Optional<Score> response= repository.findById(id);
        return response;
    }
    
    public Boolean existsById(Integer id){
        return repository.existsById(id);
    }
    
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
    
    public Score save(Score score){
        return repository.save(score);
    }


}