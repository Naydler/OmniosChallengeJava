package com.naydler.omnioschallenge.dtos;

import io.github.thibaultmeyer.cuid.CUID;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {
    private CUID id;
    private String text;
    private String translation;
    private String newPrice;
    private String title;
    private String rating;
    private String imageUrl;
}
