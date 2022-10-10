package com.example.ejercicio45y6.controllers;

import com.example.ejercicio45y6.entities.Laptop;
import com.example.ejercicio45y6.repositories.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class LaptopController {

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);
    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptops")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id) {
        Optional<Laptop> laptop = laptopRepository.findById(id);
        if(laptop.isPresent()) {
            return ResponseEntity.ok(laptop.get());
        }
        return ResponseEntity.notFound().build(); //404 not found
    }

    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));
        if(laptop.getId() != null){
            log.warn("Laptop already exists: " + laptop.getId());
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getId() == null){
            log.warn("Trying to update a non existent laptop");
            return ResponseEntity.badRequest().build();
        }

        if(!laptopRepository.existsById(laptop.getId())){
            log.warn("Trying to a non existent laptop");
            ResponseEntity.notFound().build();
        }

        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if(!laptopRepository.existsById(id)){
            log.warn("Trying to delete a non existent laptop");
            ResponseEntity.notFound().build();
        }

        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        log.info("Executing method DELETEALL");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
