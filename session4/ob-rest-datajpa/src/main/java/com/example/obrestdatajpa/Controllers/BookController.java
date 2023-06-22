package com.example.obrestdatajpa.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.obrestdatajpa.models.Book;
import com.example.obrestdatajpa.repositorys.BookRepository;

@RestController
@RequestMapping("/api/books")
public class BookController {
    
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @GetMapping()
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    /*public Book getBook(@PathVariable Long id){
        Optional<Book> optBook = bookRepository.findById(id);
        return optBook.orElse(null);
    }*/
    public ResponseEntity<Book> getBook(@PathVariable Long id){
        Optional<Book> optBook = bookRepository.findById(id);
        return optBook.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Book createBook(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers);
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public long deleteBook(@PathVariable Long id){
        return 0;
    }

}
