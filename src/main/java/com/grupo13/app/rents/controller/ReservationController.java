package com.grupo13.app.rents.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.grupo13.app.rents.entities.Reservation;
import com.grupo13.app.rents.service.ReservationService;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    
    @Autowired
    ReservationService service;

    @GetMapping("/all")
    public Iterable<Reservation> getReservations(){

        /*Iterable<Quadbike> response = repository.findAll();

        return response;*/
        return service.get();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Reservation request){
      
       service.create(request);
    }

   /* @Autowired
    IReservationRepository repository;
    
    @GetMapping("/all")
    public Iterable<Reservation> get(){
        Iterable<Reservation> response = repository.findAll();
        
        return response;
    }
    
    @PostMapping("/save")
    public String create(@RequestBody Reservation request){
        
        repository.save(request);
        
        return "crated....";
    }*/
}
