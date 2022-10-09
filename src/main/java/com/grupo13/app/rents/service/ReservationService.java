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

    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= repository.findById(reservation.getIdReservation());
            if(!e.isEmpty()){
                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                if(reservation.getQuadbike()!=null){
                    e.get().setQuadbike(reservation.getQuadbike());
                }
                if(reservation.getClient()!=null){
                    e.get().setClient(reservation.getClient());
                }
                repository.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    /*public Reservation update(Reservation reservation){
        Reservation reservationToUpdate = new Reservation();
        if(repository.existsById(reservation.getIdReservation())){ // si existe
            reservationToUpdate = reservation;
            repository.save(reservationToUpdate);
        }
        return reservationToUpdate;
    }*/

    public Boolean delete(Integer id){
        repository.deleteById(id);
        Boolean delete = true;
        return delete;
    }

}
