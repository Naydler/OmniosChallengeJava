package com.naydler.omnioschallenge.mappers;

import java.util.List;
import org.springframework.stereotype.Component;
import com.naydler.omnioschallenge.dtos.BookDto;
import com.naydler.omnioschallenge.entities.BookEntity;

@Component
public class BookMapper {

    public BookDto[] map(List<BookEntity> scrappedBooks) {
        return scrappedBooks.stream().map(scrappedBook -> {
            // TODO Obtain and transform data
            return new BookDto();
        }).toArray(BookDto[]::new);
    }
}
