/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.app.rents.controller;

import com.grupo10.app.rents.entities.Quadbike;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.grupo10.app.rents.service.QuadbikeService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Andres
 */
@RestController
@RequestMapping("/api/Quadbike")
public class QuadbikeController {

    @Autowired
    QuadbikeService service;

    @GetMapping("/all")
    public Iterable<Quadbike> get() {
        return service.get();
    }
    
    @GetMapping("/{id}")
    public Optional<Quadbike> get(@PathVariable("id") Integer id) {
        return service.get(id);
    }
    
    @GetMapping("/reports/{id}")
    public List<Quadbike> getReport(@PathVariable("id") Integer id) {
        return service.getReport();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Quadbike request) {
        service.create(request);
    }
    
    @PutMapping("/update")
    public Quadbike update(@RequestBody Quadbike request) {
        return service.update(request);
    }
    
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return service.delete(id);
    }

}
