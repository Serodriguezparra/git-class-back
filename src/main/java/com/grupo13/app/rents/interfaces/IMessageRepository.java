package com.grupo13.app.rents.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.grupo13.app.rents.entities.Message;

public interface IMessageRepository extends CrudRepository <Message, Integer> {
    
}
