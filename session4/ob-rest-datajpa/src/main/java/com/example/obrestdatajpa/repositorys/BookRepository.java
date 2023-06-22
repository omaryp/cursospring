package com.example.obrestdatajpa.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.obrestdatajpa.models.Book;

public interface BookRepository extends JpaRepository<Book,Long>{
    
}
