package com.example.obrestdatajpa.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
    
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String autor;
    private Integer pages;
    private Double price;
    private LocalDate releasDate;
    private Boolean online;
    
    
    //constructores

    public Book() {
    }

    public Book(Long id, String title, String autor, Integer pages, Double price, LocalDate releasDate,
            Boolean online) {
        this.id = id;
        this.title = title;
        this.autor = autor;
        this.pages = pages;
        this.price = price;
        this.releasDate = releasDate;
        this.online = online;
    }

    //getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getReleasDate() {
        return releasDate;
    }

    public void setReleasDate(LocalDate releasDate) {
        this.releasDate = releasDate;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    //toString

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", autor=" + autor + ", pages=" + pages + ", price=" + price
                + ", releasDate=" + releasDate + ", online=" + online + "]";
    }

}
