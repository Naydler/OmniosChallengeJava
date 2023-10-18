package com.naydler.omnioschallenge.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookEntity {
    private String title;
    private String price;
    private String rating;
    private String imageUrl;
}
