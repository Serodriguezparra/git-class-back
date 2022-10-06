package com.grupo13.app.rents.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.grupo13.app.rents.entities.Category;

public interface ICategoryRepository extends CrudRepository <Category, Integer> {
    
}
