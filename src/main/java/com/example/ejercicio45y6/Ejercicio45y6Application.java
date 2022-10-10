package com.example.ejercicio45y6;

import com.example.ejercicio45y6.entities.Laptop;
import com.example.ejercicio45y6.repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio45y6Application {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Ejercicio45y6Application.class, args);
        LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);

        Laptop laptop1 = new Laptop(null,"Acer","Predator Helios 300","16MG","1TB");
        Laptop laptop2 = new Laptop(null,"Toshiba","Turbo","8MG","500MG");
        Laptop laptop3 = new Laptop(null,"Mountain","300","24MG","2TB");

        laptopRepository.save(laptop1);
        laptopRepository.save(laptop2);
        laptopRepository.save(laptop3);

    }

}
