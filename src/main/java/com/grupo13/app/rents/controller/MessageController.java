package com.grupo13.app.rents.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.grupo13.app.rents.entities.Message;
import com.grupo13.app.rents.service.MessageService;

@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    MessageService service;

    @GetMapping("/all")
    public Iterable<Message> getMesssages(){

        return service.get();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Message request){
        service.create(request);
    }

    
   /*  @Autowired
    IMessageRepository repository;
    
    @GetMapping("/all")
    public Iterable<Message> getMessages(){
        Iterable<Message> response = repository.findAll();
        
        return response;
    }*/
    
 /*   @PostMapping("/save")
    public String createMessage(@RequestBody Message request){
        
        repository.save(request);
        
        return "crated....";
    } */

}
