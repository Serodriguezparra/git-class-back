package com.grupo13.app.rents.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_client")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Integer idClient; 
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private Integer age;
   
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties({"client"})
    private List<Message> messages;

    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties("client")
    private List<Reservation> reservations;

    

}
