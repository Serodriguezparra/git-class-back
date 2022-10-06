package com.grupo13.app.rents.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.grupo13.app.rents.entities.Client;

public interface IClientRepository extends CrudRepository <Client, Integer> {
    
}
