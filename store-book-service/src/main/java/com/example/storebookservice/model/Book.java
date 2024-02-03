package com.example.storebookservice.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Book {
    private Long id;
    private String title;
    private String description;
    private boolean status;
    private double price;
}
