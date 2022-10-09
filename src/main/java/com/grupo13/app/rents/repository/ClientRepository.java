package com.grupo13.app.rents.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo13.app.rents.entities.Client;
import com.grupo13.app.rents.interfaces.IClientRepository;

@Repository
public class ClientRepository {
    
    @Autowired
    IClientRepository repository;

    public Iterable<Client> getAll(){
        return repository.findAll();
    }
    
    public Optional<Client> findById(Integer id){
        Optional<Client> response= repository.findById(id);
        return response;
    }
    
    public Boolean existsById(Integer id){
        return repository.existsById(id);
    }
    
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
    
    public Client save(Client client){
        return repository.save(client);
    }
  
}