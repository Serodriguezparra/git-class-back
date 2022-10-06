package com.grupo13.app.rents.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo13.app.rents.entities.Client;
import com.grupo13.app.rents.entities.Message;
import com.grupo13.app.rents.entities.Quadbike;
import com.grupo13.app.rents.interfaces.IClientRepository;
import com.grupo13.app.rents.interfaces.IMessageRepository;
import com.grupo13.app.rents.interfaces.IQuadbikeRepository;

@Service
public class MessageService {
    @Autowired
    IMessageRepository messageRepository;

    @Autowired
    IClientRepository clientRepository;

    @Autowired
    IQuadbikeRepository quadbikeRepository;

    public Iterable<Message> get(){

        Iterable<Message> response = messageRepository.findAll();

        return response;
    }

    public String create(Message request){
        Optional<Client> cl = clientRepository.findById(request.getClient().getIdClient());
        Optional<Quadbike> qua = quadbikeRepository.findById(request.getQuadbike().getId());
        if(!qua.isEmpty()){
            request.setQuadbike(qua.get());
        }
        if(!cl.isEmpty()){
            request.setClient(cl.get());
        }
        if(request.getMessageText()!=null){
           messageRepository.save(request);
            return "Created ...";
            
        }else{
            return "Falta el nombre";
        }
        
    }

     /*   @PostMapping("/save")
    public String createMessage(@RequestBody Message request){
        
        repository.save(request);
        
        return "crated....";
    } */

 /*    public String create(Quadbike request){
        Optional<Category> cat = categoryRepository.findById(request.getCategory().getId());
        if(!cat.isEmpty()){
            request.setCategory(cat.get());
        }
        if(request.getName()!=null){
            repository.save(request);
            return "Created ...";
            
        }else{
            return "Falta el nombre";
              /*repository.save(request);
      
       return "Created ...";
        }
     
        
    }*/

}
