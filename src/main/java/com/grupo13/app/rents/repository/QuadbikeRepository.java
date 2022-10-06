package com.grupo13.app.rents.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo13.app.rents.entities.Quadbike;
import com.grupo13.app.rents.interfaces.IQuadbikeRepository;

@Repository
public class QuadbikeRepository {
    
    @Autowired
    IQuadbikeRepository repository;

    public Iterable<Quadbike> getAll(){
        return repository.findAll();
    }
    
    public Optional<Quadbike> findById(Integer id){
        Optional<Quadbike> response= repository.findById(id);
        return response;
    }
    
    public Boolean existsById(Integer id){
        return repository.existsById(id);
    }
    
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
    
    public Quadbike save(Quadbike quadbike){
        return repository.save(quadbike);
    }
     
    public List<Object[]> getReport(){
        return repository.countTotalQuadbikeByYear();
    }

}