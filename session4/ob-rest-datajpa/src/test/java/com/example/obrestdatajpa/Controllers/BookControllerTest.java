package com.example.obrestdatajpa.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.obrestdatajpa.models.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookControllerTest {

    private TestRestTemplate testRestTemplate;
    
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    //antes de cada test
    @BeforeEach //con esta anotación ejecutamos antes de cada test
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:"+port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void testCreateBook() {

        Book book1 = new Book();
		book1.setTitle("El señor de los cielos");
		book1.setAutor("Omar Yarleque");
		book1.setPrice(19.99);	
		book1.setPages(10);
		book1.setReleasDate(LocalDate.of(1987, 01, 30));
		book1.setOnline(true);
        ResponseEntity<Book> rpta = testRestTemplate.postForEntity("/api/books",book1,Book.class);
        assertEquals(rpta.getStatusCode(), HttpStatus.OK);
        assertNotEquals(rpta.getBody().getId(), 0);
    
    }

    @DisplayName("Testenado hola mundo para un controlador rest")
    @Test
    void hello() {
        ResponseEntity<String> rpta = testRestTemplate.getForEntity("/hola", String.class);
        assertEquals(rpta.getStatusCode(), HttpStatus.OK);
        assertEquals(rpta.getBody(), "Hola Mundo, claro que shiiiiii");
    }

    @Test
    void testFindAll() {
        ResponseEntity<List> rpta = testRestTemplate.getForEntity("/api/books", List.class);
         assertEquals(rpta.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void testGetBook() {
        ResponseEntity<Book> rpta = testRestTemplate.getForEntity("/api/books/1", Book.class);
        assertEquals(rpta.getStatusCode(), HttpStatus.NOT_FOUND);
    }

}
