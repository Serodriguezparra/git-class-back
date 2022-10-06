package com.grupo13.app.rents.interfaces;

import org.springframework.data.repository.CrudRepository;


import com.grupo13.app.rents.entities.Score;

public interface IScoreRepository extends CrudRepository <Score, Integer> {
    
}
