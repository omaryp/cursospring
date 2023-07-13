package com.example.obrestdatajpa.services;

import com.example.obrestdatajpa.models.Book;

public class BookPriceCalculator {
    
    public double calculatePrice(Book book){
        double price = book.getPrice();
        if(book.getPages() > 300){
            price += 5;
        }

        //envío
        price += 2.99;
        return price;
    }
}
