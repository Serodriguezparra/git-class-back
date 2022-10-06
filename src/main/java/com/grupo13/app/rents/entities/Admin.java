package com.grupo13.app.rents.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tb_admin")
@Getter @Setter
@AllArgsConstructor
public class Admin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Integer idClient;
    @Column
    private String name; 
    @Column
    private String email;
    @Column
    private String password;
   

}
