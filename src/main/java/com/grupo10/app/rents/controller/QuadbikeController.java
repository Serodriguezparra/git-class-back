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

    @PostMapping("/save")
    public String createQuadbike(@RequestBody Quadbike request) {
        return service.create(request);
    }

}