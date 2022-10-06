package com.grupo13.app.rents.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.grupo13.app.rents.entities.Client;
import com.grupo13.app.rents.service.ClientService;


@RestController
@RequestMapping("/api/Client")
public class ClientController {
    
    @Autowired
    ClientService service;
    
    @GetMapping("/all")
    public Iterable<Client> get(){
        Iterable<Client> response = service.get();
        
        return response;
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Client request){
        service.create(request);
    }

}
