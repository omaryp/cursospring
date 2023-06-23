package com.example.obrestdatajpa.Controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.obrestdatajpa.models.Book;
import com.example.obrestdatajpa.repositorys.BookRepository;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);
    
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

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        log.info("Actualizando book : {}",book);
        System.out.println(book); 
        if(book.getId().equals(null)){
            log.warn("No se puede actualizar elemento que no existe.");
            return ResponseEntity.badRequest().build();            
        }
        if(!bookRepository.existsById(book.getId())){
            log.warn("Libro no existe");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookRepository.save(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id){
        if(!bookRepository.existsById(id)){
            log.warn("Libro no existe");
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build(); // no content indica que el elemento se ha eliminado
    }

}
