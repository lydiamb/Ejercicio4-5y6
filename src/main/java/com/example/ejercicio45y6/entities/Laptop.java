package com.example.ejercicio45y6.entities;

import javax.persistence.*;

@Entity
@Table(name = "laptop")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String marca;
    private String modelo;
    private String memoriaRAM;
    private String memoriaAlmacenamiento;

    public Laptop() {
    }

    public Laptop(Long id, String marca, String modelo, String memoriaRAM, String memoriaAlmacenamiento) {
        Id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.memoriaRAM = memoriaRAM;
        this.memoriaAlmacenamiento = memoriaAlmacenamiento;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMemoriaRAM() {
        return memoriaRAM;
    }

    public void setMemoriaRAM(String memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }

    public String getMemoriaAlmacenamiento() {
        return memoriaAlmacenamiento;
    }

    public void setMemoriaAlmacenamiento(String memoriaAlmacenamiento) {
        this.memoriaAlmacenamiento = memoriaAlmacenamiento;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "Id=" + Id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", memoriaRAM='" + memoriaRAM + '\'' +
                ", memoriaAlmacenamiento='" + memoriaAlmacenamiento + '\'' +
                '}';
    }
}
