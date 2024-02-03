package com.example.checkbookservice.producer;

import com.example.checkbookservice.model.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookProducer {
    private static final String OUTPUT_TOPIC = "checked-books-topic";

    private KafkaTemplate<String, String> kafkaTemplate;
    private ObjectMapper objectMapper;
    public void sendCheckedBook(Book book){
        try {
            kafkaTemplate.send(OUTPUT_TOPIC,book.getId().toString(),
                    objectMapper.writeValueAsString(book));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
