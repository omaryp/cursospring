package com.example.examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.examen.model.Laptop;
import com.example.examen.repository.LaptopRepository;

@SpringBootApplication
public class ExamenApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ExamenApplication.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop();
		laptop1.setMarca("Lenovo");
		laptop1.setModelo("XP512");
		laptop1.setProcesador("I7 11 generacion");
		laptop1.setRam("16 GB");
		laptop1.setTieneTarjetaVideo(true);
		laptop1.setDiscoDuro("SSD 512 GB");

		Laptop laptop2 = new Laptop();
		laptop2.setMarca("Asus");
		laptop2.setModelo("Gamer TD4565");
		laptop2.setProcesador("I9 11 generacion");
		laptop2.setRam("32 GB");
		laptop2.setTieneTarjetaVideo(true);
		laptop2.setDiscoDuro("SSD 1 TG");

		repository.save(laptop1);
		repository.save(laptop2);
	}

}
