package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
public class Estate {
    // this code with auth feature
    //second auth code
    @Id
    @GeneratedValue
    Integer id;
    String number;
    String space;
    String type;
    String addressdetails;
    String description;
}
