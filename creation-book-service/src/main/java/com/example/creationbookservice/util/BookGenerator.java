package com.example.creationbookservice.util;

import com.example.creationbookservice.model.Book;
import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class BookGenerator {
    private final Random rnd = new Random();
    public Book generateBook(){
        Long randomBookId = (long) rnd.nextInt(10);
        String randomTitle = "Book title: " + randomBookId;
        String randomDescription = "Book description: " + randomBookId;
        boolean status  = false;
        double randomPrice = randomBookId++;
        return Book.builder()
                .id(randomBookId)
                .title(randomTitle)
                .description(randomDescription)
                .status(status)
                .price(randomPrice)
                .build();
    }
}
