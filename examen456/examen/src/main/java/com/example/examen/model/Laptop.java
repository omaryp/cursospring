package com.example.examen.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "laptops")
public class Laptop {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private String procesador;
    private String ram;
    private String discoDuro;
    private Boolean tieneTarjetaVideo;

    public Laptop() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(String discoDuro) {
        this.discoDuro = discoDuro;
    }

    public Boolean getTieneTarjetaVideo() {
        return tieneTarjetaVideo;
    }

    public void setTieneTarjetaVideo(Boolean tieneTarjetaVideo) {
        this.tieneTarjetaVideo = tieneTarjetaVideo;
    }

    @Override
    public String toString() {
        return "Laptop [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", procesador=" + procesador + ", ram="
                + ram + ", discoDuro=" + discoDuro + ", tieneTarjetaVideo=" + tieneTarjetaVideo + "]";
    }

}
