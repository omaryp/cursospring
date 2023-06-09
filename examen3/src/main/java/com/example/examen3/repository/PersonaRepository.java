package com.example.examen3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examen3.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona,Long>{
    
}
