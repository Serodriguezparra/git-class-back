package com.grupo13.app.rents.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.grupo13.app.rents.entities.Reservation;

public interface IReservationRepository extends CrudRepository <Reservation, Integer> {
    
}
