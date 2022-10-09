package com.grupo13.app.rents.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo13.app.rents.entities.Category;
import com.grupo13.app.rents.interfaces.ICategoryRepository;

@Service
public class CategoryService {
   /*  @Autowired
    IQuadbikeRepository repository;

    @Autowired
    ICategoryRepository categoryRepository;*/
    @Autowired
    ICategoryRepository repository;
    
    public Iterable<Category> get(){
        Iterable<Category> response = repository.findAll();
        return response;
    }

    public String create(Category request){
        //Optional<Category> cat = repository.findById(request.getCategory().getId());
       /*  if(!cat.isEmpty()){
            request.setCategory(cat.get());
        }
        
            return repository.save(request);*/

        if(request.getName() != null){
            repository.save(request);
            return "created...";
        }else{
            return "falta el nombre";
        }
         
       /*repository.save(request);
      
       return "Created ...";*/
        
    }


   /*  public Category update(Category category){
        Category categoryToUpdate = new Category();
        if(repository.existsById(category.getId())){ // si existe
            categoryToUpdate = category;
            repository.save(categoryToUpdate);
        }
        return categoryToUpdate;
    }*/

    //pegar category y probar que pasa cuando no se envia un cmapo
    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category> e= repository.findById(category.getId());
            if(!e.isEmpty()){
                if(category.getName()!=null){
                    e.get().setName(category.getName());
                }
                if(category.getDescription()!=null){
                    e.get().setDescription(category.getDescription());
                }
                repository.save(e.get());
                return e.get();
            }else{
                return category;
            }
        }else{
            return category;
        }
    }

    public Boolean delete(Integer id){
        repository.deleteById(id);
        Boolean delete = true;
        return delete;
    }

}
