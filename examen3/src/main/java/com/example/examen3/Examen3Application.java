package com.example.examen3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.examen3.model.Persona;
import com.example.examen3.repository.PersonaRepository;

@SpringBootApplication
public class Examen3Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Examen3Application.class, args);
		PersonaRepository user = (PersonaRepository) context.getBean("personaRepository");

		System.out.println("Cantidad personas : "+user.count());
		Persona per1 = new Persona(null, "Omar Antonio", "Yarlequé Peña", "01/12/1987", "Programador");
		Persona per2 = new Persona(null, "Manuel Antonio", "Yarlequé Castro", "03/12/2019", "Estudiante");
		Persona per3 = new Persona(null, "Oscar David", "Yarlequé Castro", "20/11/2015", "Estudiante");

		user.save(per1);
		user.save(per2);
		user.save(per3);

		System.out.println("Total ingresadas : "+user.count());

		System.out.println(user.findAll());

	}

}
