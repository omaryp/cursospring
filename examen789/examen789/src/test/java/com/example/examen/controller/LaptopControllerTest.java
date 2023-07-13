package com.example.examen.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.net.URI;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import com.example.examen.model.Laptop;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:"+port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void testDeleteLaptop() {
        try {
            RequestEntity requestEntity = new RequestEntity<Laptop>(HttpMethod.DELETE, new URI("/api/laptops/1"));
            ResponseEntity<Laptop> rpta = testRestTemplate.exchange(requestEntity,Laptop.class);
            assertEquals( HttpStatus.NOT_FOUND,rpta.getStatusCode());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Test
    void testDeleteLaptops() {
        try {
            RequestEntity requestEntity = new RequestEntity<Laptop>(HttpMethod.DELETE, new URI("/api/laptops"));
            ResponseEntity<Laptop> rpta = testRestTemplate.exchange(requestEntity,Laptop.class);
            assertEquals(HttpStatus.NO_CONTENT,rpta.getStatusCode());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Test
    void testGetAll() {
        ResponseEntity<List> rpta = testRestTemplate.getForEntity("/api/laptops", List.class);
        assertEquals(HttpStatus.OK,rpta.getStatusCode());
        
    }

    @Test
    void testGetLaptop() {
        ResponseEntity<Laptop> rpta = testRestTemplate.getForEntity("/api/laptops/1", Laptop.class);
        assertEquals(HttpStatus.OK,rpta.getStatusCode());
    }

    @Test
    void testSaveLaptop() {
        Laptop laptop1 = new Laptop();
		laptop1.setMarca("Lenovo");
		laptop1.setModelo("XP512");
		laptop1.setProcesador("I7 11 generacion");
		laptop1.setRam("16 GB");
		laptop1.setTieneTarjetaVideo(true);
		laptop1.setDiscoDuro("SSD 512 GB");
        ResponseEntity<Laptop> rpta = testRestTemplate.postForEntity("/api/laptops",laptop1,Laptop.class);
        assertEquals(HttpStatus.OK,rpta.getStatusCode());
        assertNotEquals(rpta.getBody().getId(), 0);
    }

    @Test
    void testUpdateLaptop() {
        try {
            Laptop laptop1 = new Laptop();
            laptop1.setId(1L);
            laptop1.setMarca("Lenovo");
            laptop1.setModelo("XP512");
            laptop1.setProcesador("I7 11 generacion");
            laptop1.setRam("16 GB");
            laptop1.setTieneTarjetaVideo(true);
            laptop1.setDiscoDuro("SSD 512 GB");
            RequestEntity requestEntity = new RequestEntity<Laptop>(laptop1,HttpMethod.PUT, new URI("/api/laptops"));
            ResponseEntity<Laptop> rpta = testRestTemplate.exchange(requestEntity,Laptop.class);
            assertEquals(rpta.getStatusCode(), HttpStatus.NOT_FOUND);
            assertNotEquals(rpta.getBody().getId(), 0);
        } catch (Exception e) {
        }
    }
}
