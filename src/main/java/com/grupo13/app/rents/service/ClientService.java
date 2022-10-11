package com.grupo13.app.rents.service;


import java.util.Optional;

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

    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> e= repository.findById(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getEmail()!=null){
                    e.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                repository.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    /*public Client update(Client client){
        Client clientToUpdate = new Client();
        if(repository.existsById(client.getIdClient())){ // si existe
            clientToUpdate = client;
            repository.save(clientToUpdate);
        }
        return clientToUpdate;
    }*/

    

    public Boolean delete(Integer id){
        repository.deleteById(id);
        Boolean delete = true;
        return delete;
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
