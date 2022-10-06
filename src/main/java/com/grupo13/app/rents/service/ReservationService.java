package com.grupo13.app.rents.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo13.app.rents.entities.Client;
import com.grupo13.app.rents.entities.Quadbike;
import com.grupo13.app.rents.entities.Reservation;
import com.grupo13.app.rents.interfaces.IClientRepository;
import com.grupo13.app.rents.interfaces.IQuadbikeRepository;
import com.grupo13.app.rents.interfaces.IReservationRepository;

@Service
public class ReservationService {
    @Autowired
    IReservationRepository repository;
    @Autowired
    IQuadbikeRepository quadbikeRepository;
    @Autowired
    IClientRepository clientRepository; 
    
    public Iterable<Reservation> get(){

        Iterable<Reservation> response = repository.findAll();

        return response;
    }

    public String create(Reservation request){
        Optional<Quadbike> qua = quadbikeRepository.findById(request.getQuadbike().getId());
        Optional<Client> cl = clientRepository.findById(request.getClient().getIdClient());
        if(!qua.isEmpty()){
            request.setQuadbike(qua.get());
        }
        if(!cl.isEmpty()){
            request.setClient(cl.get());
        }
        if(request.getStartDate()!=null){
            repository.save(request);
            return "Created ...";
            
        }else{
            return "Falta el nombre";
        }
       /*repository.save(request);
      
       return "Created ...";*/
        
    }

}
