package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.Estate;
import com.example.demo.exception.EstateException;
import com.example.demo.model.ErrorMessage;
import com.example.demo.service.EstateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(value="/api/v1/estate")
public class EstateController {

    @Autowired
    EstateService estateService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Estate>> allEstates() {
        return ResponseEntity.status(HttpStatus.OK).body(estateService.getAllEstates());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Object> addEstate(@RequestBody Estate estate) throws EstateException{
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(estateService.addEstate(estate));   
        } catch (EstateException e) {
            ErrorMessage error = new ErrorMessage().withMessage(e.getMessage()).withHashcode("34g5j2k3l45g250248t5g24k3j").withType("SAVE_PRODUCT");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteEstate(@PathVariable(name = "id") Integer eid) {
        estateService.deleteEstate(eid);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Estate> updateEstate(@RequestBody Estate estate) {
        return ResponseEntity.status(HttpStatus.OK).body(estateService.updateestate(estate));
    }


}
