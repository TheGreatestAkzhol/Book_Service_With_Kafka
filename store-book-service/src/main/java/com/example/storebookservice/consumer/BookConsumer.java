package com.example.storebookservice.consumer;

import com.example.storebookservice.model.Book;
import com.example.storebookservice.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookConsumer {
    private BookService bookService;
    private ObjectMapper objectMapper;
    @KafkaListener(topics = "checked-books-topic",groupId = "store-checked-book-group")
    public void getBook(ConsumerRecord<String, String> record){
        Book book = null;
        try {
            book = objectMapper.readValue(record.value(), Book.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        bookService.createBook(book);
    }

}
