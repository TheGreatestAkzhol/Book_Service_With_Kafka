package com.example.storebookservice.service;

import com.example.storebookservice.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    List<Book> books = new ArrayList<>();
    public void createBook(Book book){
        System.out.println(book.toString());
        books.add(book);
    }
    public List<Book> showBooks(){
        return books;
    }
}
