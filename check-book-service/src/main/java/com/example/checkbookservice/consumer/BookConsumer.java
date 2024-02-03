package com.example.checkbookservice.consumer;

import com.example.checkbookservice.model.Book;
import com.example.checkbookservice.producer.BookProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookConsumer {
    private BookProducer bookProducer;
    private ObjectMapper objectMapper;
    @KafkaListener(topics = "unchecked-books-topic",groupId = "check-book-group")
    public void consumeBook(ConsumerRecord<String, String> record){
        Book book = null;
        try {
            book = objectMapper.readValue(record.value(), Book.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(book.toString());
        book.setStatus(!book.isStatus());
        bookProducer.sendCheckedBook(book);
    }
}
