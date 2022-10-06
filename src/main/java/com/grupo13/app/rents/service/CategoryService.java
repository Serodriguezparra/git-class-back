package com.grupo13.app.rents.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo13.app.rents.entities.Category;
import com.grupo13.app.rents.entities.Quadbike;
import com.grupo13.app.rents.interfaces.ICategoryRepository;
import com.grupo13.app.rents.interfaces.IQuadbikeRepository;

@Service
public class CategoryService {
    @Autowired
    IQuadbikeRepository repository;
    @Autowired
    ICategoryRepository categoryRepository;
    
    public Iterable<Quadbike> get(){
        Iterable<Quadbike> response = repository.findAll();
        return response;
    }

    public Quadbike create(Quadbike request){
        Optional<Category> cat = categoryRepository.findById(request.getCategory().getId());
        if(!cat.isEmpty()){
            request.setCategory(cat.get());
        }
        
            return repository.save(request);
         
       /*repository.save(request);
      
       return "Created ...";*/
        
    }

}
