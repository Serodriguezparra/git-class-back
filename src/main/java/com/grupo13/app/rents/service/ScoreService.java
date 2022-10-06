package com.grupo13.app.rents.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo13.app.rents.entities.Score;
import com.grupo13.app.rents.interfaces.IReservationRepository;
import com.grupo13.app.rents.interfaces.IScoreRepository;

@Service
public class ScoreService {
    @Autowired
    IScoreRepository repository;
    @Autowired
    IReservationRepository reservationRepository;

    public Iterable<Score> get(){
        Iterable<Score> response = repository.findAll();

        return response;
    }

    public String create(Score request){
        if(request.getMessageText()!=null){
            repository.save(request);
            return "Created ...";
            
        }else{
            return "Falta el nombre";
        }
    }

}
