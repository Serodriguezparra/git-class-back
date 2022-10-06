package com.grupo13.app.rents.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo13.app.rents.entities.Client;
import com.grupo13.app.rents.interfaces.IClientRepository;
import com.grupo13.app.rents.interfaces.IMessageRepository;

@Service
public class ClientService {
    @Autowired
    IClientRepository repository;

    @Autowired
    IMessageRepository messageRepository;
    
    public Iterable<Client> get(){
        Iterable<Client> response = repository.findAll();
        return response;
    }

    public String create(Client request) {

        if (request.getName() != null) {
            repository.save(request);
            return "created....";
        } else {
            return "falta el nombre";
        }

    }

    /*   @Query("SELECT c.year, COUNT(c.year) from Quadbike AS c group by c.year order by COUNT(c.year) DESC")
    public List<Object[]> countTotalQuadbikeByYear();

    public Client create(Client request){
       /*  Optional<Client> cat = categoryRepository.findById(request.getCategory().getId());
        if(!cat.isEmpty()){
            request.setCategory(cat.get());
        }*/
        /*if(request.getName()!=null){
            repository.save(request);
            return "Created ...";
        }else{
            return "Falta el nombre";
        }*/
    //    return repository.save(request);
        
    //}*/ 

}
