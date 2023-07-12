package com.example.obrestdatajpa;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.obrestdatajpa.models.Book;
import com.example.obrestdatajpa.repositorys.BookRepository;




@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);
		BookRepository repository = context.getBean(BookRepository.class);

		Book book1 = new Book();
		book1.setTitle("Cien años de soledad");
		book1.setAutor("Gabriel García Marquez");
		book1.setPrice(19.99);	
		book1.setPages(150);
		book1.setReleasDate(LocalDate.of(1987, 01, 30));
		book1.setOnline(true);
	
		Book book2 = new Book();
		book2.setTitle("Caballero Carmelo");
		book2.setAutor("Ricardo Palma");
		book2.setPrice(39.99);	
		book2.setPages(250);
		book2.setReleasDate(LocalDate.of(1967, 12, 07));
		book2.setOnline(true);

		repository.save(book1);
		repository.save(book2);

	}

}
