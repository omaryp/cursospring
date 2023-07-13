package com.example.obrestdatajpa.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.example.obrestdatajpa.models.Book;

public class BookPriceCalculatorTest {
    @Test
    void testCalculatePrice() {

        //Configuramos la prueba
        Book book1 = new Book();
		book1.setTitle("El señor de los anillos");
		book1.setAutor("Gabriel García Marquez");
		book1.setPrice(19.99);	
		book1.setPages(150);
		book1.setReleasDate(LocalDate.of(1987, 01, 30));
		book1.setOnline(true);
        BookPriceCalculator calculator = new BookPriceCalculator();

        //Ejecutamos la prueba
        double price = calculator.calculatePrice(book1);

        System.out.println(price);
        //Comprobaciones aserciones
        assertTrue(price > 0);
        assertEquals(22.979999999999997, price);
    }
}
