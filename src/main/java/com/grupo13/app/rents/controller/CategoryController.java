package com.grupo13.app.rents.controller;

import com.grupo13.app.rents.entities.Category;
import com.grupo13.app.rents.interfaces.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/api/Category")
public class CategoryController {
    
    @Autowired
    ICategoryRepository repository;
    
    @GetMapping("/all")
    public Iterable<Category> get(){
        Iterable<Category> response = repository.findAll();
        
        return response;
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Category request){
        repository.save(request);
    }


    
    
}