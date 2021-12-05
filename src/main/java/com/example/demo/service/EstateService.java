package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Estate;
import com.example.demo.exception.EstateException;
import com.example.demo.repo.EstateRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstateService {

    @Autowired
    EstateRepo estateRepo;
    
    public List<Estate> getAllEstates(){
        return estateRepo.findAll();
    }

    public Estate addEstate(Estate estate) throws EstateException{
       if(estate.getId() != null) throw new EstateException("can't add product with this id");
       return estateRepo.save(estate);
    }

    public void deleteEstate(Integer id){
        estateRepo.deleteById(id);
    }

    public Estate updateestate(Estate estate){ 
        return estateRepo.save(estate);
    }
}
