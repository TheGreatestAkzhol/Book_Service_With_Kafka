package com.example.storebookservice.controller;

import com.example.storebookservice.model.Book;
import com.example.storebookservice.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BookController {

    private BookService bookService;
    @GetMapping("/getBooks")
    public List<Book> getBook(){
        return bookService.showBooks();
    }
}
