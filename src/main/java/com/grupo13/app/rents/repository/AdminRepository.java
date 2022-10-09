package com.grupo13.app.rents.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo13.app.rents.entities.Admin;
import com.grupo13.app.rents.interfaces.IAdminRepository;

@Repository
public class AdminRepository {
    
    @Autowired
    IAdminRepository repository;

    public Iterable<Admin> getAll(){
        return repository.findAll();
    }
    
    public Optional<Admin> findById(Integer id){
        Optional<Admin> response= repository.findById(id);
        return response;
    }
    
    public Boolean existsById(Integer id){
        return repository.existsById(id);
    }
    
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
    
    public Admin save(Admin admin){
        return repository.save(admin);
    }


}