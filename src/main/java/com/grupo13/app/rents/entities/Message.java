package com.grupo13.app.rents.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_message")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Integer idMessage; 
    @Column
    private String messageText;

    //@ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name="quadbike_id")
    @JsonIgnoreProperties({"messages","reservations"})
    private Quadbike quadbike; 

    //@ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name="client_id")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client; 
}
