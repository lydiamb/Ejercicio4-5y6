package com.example.ejercicio45y6.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${app.message}")
    String message;

    @GetMapping("/api/saludar")
    public String saludar(){
        System.out.println(message);
        return "Hola mundo bonito";
    }
}
