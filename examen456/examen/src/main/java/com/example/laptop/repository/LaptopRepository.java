package com.example.laptop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.laptop.model.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop,Long>{
    
}
