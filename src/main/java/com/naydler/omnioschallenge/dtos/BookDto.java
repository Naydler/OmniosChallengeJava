package com.naydler.omnioschallenge.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {
    private String id;
    private String text;
    private String spanishText;
    private String germanText;
    private Double price;
    private String title;
    private String rating;
    private String imageUrl;
}
