package com.example.creationbookservice.controller;

import com.example.creationbookservice.producer.BookProducer;
import com.example.creationbookservice.util.BookGenerator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BooksController {
    private BookProducer bookProducer;
    private BookGenerator bookGenerator;
    @GetMapping
    public void createBook(){;
        bookProducer.sendBook(bookGenerator.generateBook());
    }
}
