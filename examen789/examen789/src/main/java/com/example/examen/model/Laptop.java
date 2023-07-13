package com.example.examen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "laptops")
@ApiModel("Modelo base para la creación de objetod del tipo Laptop")
public class Laptop {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Primary Key , de tipo Long. Se autogenera")
    private Long id;
    @ApiModelProperty("Campo identifica la marca del producto , de tipo String. Campo obligatorio")
    private String marca;
    @ApiModelProperty("Campo identifica el modelo del producto , de tipo String. Campo obligatorio")
    private String modelo;
    @ApiModelProperty("Campo identifica capacidad y modelo del procesador del producto , de tipo String. Campo obligatorio")
    private String procesador;
    @ApiModelProperty("Campo identifica capacidad y tipo de memoria ram del producto , de tipo String. Campo obligatorio")
    private String ram;
    @ApiModelProperty("Campo identifica capacidad, tipo, modelo y marca de la unidad de almacenamiento del producto , de tipo String. Campo obligatorio")
    private String discoDuro;
    @ApiModelProperty("Campo da a conocer si el producto cuenta con tarjeta de vide , de tipo Boolean. Campo obligatorio")
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
