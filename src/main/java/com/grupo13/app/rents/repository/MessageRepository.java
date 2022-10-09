package com.grupo13.app.rents.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo13.app.rents.entities.Message;
import com.grupo13.app.rents.interfaces.IMessageRepository;

@Repository
public class MessageRepository {
    
    @Autowired
    IMessageRepository repository;

    public Iterable<Message> getAll(){
        return repository.findAll();
    }
    
    public Optional<Message> findById(Integer id){
        Optional<Message> response= repository.findById(id);
        return response;
    }
    
    public Boolean existsById(Integer id){
        return repository.existsById(id);
    }
    
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
    
    public Message save(Message message){
        return repository.save(message);
    }


}