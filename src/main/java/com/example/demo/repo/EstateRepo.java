package com.example.demo.repo;

import com.example.demo.entity.Estate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface EstateRepo extends JpaRepository<Estate,Integer>{}