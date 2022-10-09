package com.grupo13.app.rents.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo13.app.rents.entities.Category;
import com.grupo13.app.rents.interfaces.ICategoryRepository;

@Repository
public class CategoryRepository {
    
    @Autowired
    ICategoryRepository repository;

    public Iterable<Category> getAll(){
        return repository.findAll();
    }
    
    public Optional<Category> findById(Integer id){
        Optional<Category> response= repository.findById(id);
        return response;
    }
    
    public Boolean existsById(Integer id){
        return repository.existsById(id);
    }
    
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
    
    public Category save(Category category){
        return repository.save(category);
    }
     
}