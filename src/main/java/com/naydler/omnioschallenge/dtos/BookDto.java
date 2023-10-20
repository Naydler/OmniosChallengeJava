package com.naydler.omnioschallenge.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {
    private String id;
    private String text;
    private String spanishText;
    private String germanText;
    private BigDecimal price;
    private String title;
    private String rating;
    private String imageUrl;
}
