package com.grupo13.app.rents.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.grupo13.app.rents.entities.Quadbike;

public interface IQuadbikeRepository extends CrudRepository <Quadbike, Integer> {
    
    @Query("SELECT c.year, COUNT(c.year) from Quadbike AS c group by c.year order by COUNT(c.year) DESC")
    public List<Object[]> countTotalQuadbikeByYear();
}
