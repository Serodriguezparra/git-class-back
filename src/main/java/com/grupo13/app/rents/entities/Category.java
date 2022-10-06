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
@Table(name="tb_category")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Integer id;
    @Column
    private String name;
    @Column
    private String description;
    
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy = "category") //unca tegoria puede tener muchas cuatrimotos
    @JsonIgnoreProperties({"category","reservations"})

    private List<Quadbike> quadbikes;


  


    

}
