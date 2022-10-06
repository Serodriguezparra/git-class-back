package com.grupo13.app.rents.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_quadbike")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quadbike implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Integer id; 
    @Column
    private String name;
    @Column
    private String brand;
    @Column
    private Integer year;
    @Column
    private String description;
    
    @ManyToOne
    @JsonIgnoreProperties("quadbikes")
    @JoinColumn(name="category_id")
    private Category category;


    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="quadbike")
   // @OneToMany(cascade={CascadeType.PERSIST})
    @JsonIgnoreProperties({"quadbike","client"})
    private List<Message> messages;  

    
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="quadbike")
    @JsonIgnoreProperties({"quadbike","messages"})
    private List<Reservation> reservations;

}
