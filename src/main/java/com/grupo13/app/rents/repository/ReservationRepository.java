package com.grupo13.app.rents.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo13.app.rents.entities.Reservation;
import com.grupo13.app.rents.interfaces.IReservationRepository;

@Repository
public class ReservationRepository {
    
    @Autowired
    IReservationRepository repository;

    public Iterable<Reservation> getAll(){
        return repository.findAll();
    }
    
    public Optional<Reservation> findById(Integer id){
        Optional<Reservation> response= repository.findById(id);
        return response;
    }
    
    public Boolean existsById(Integer id){
        return repository.existsById(id);
    }
    
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
    
    public Reservation save(Reservation reservation){
        return repository.save(reservation);
    }
     
}