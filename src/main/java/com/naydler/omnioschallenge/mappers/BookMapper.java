package com.naydler.omnioschallenge.mappers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.naydler.omnioschallenge.core.DeepAIManager;
import com.naydler.omnioschallenge.dtos.BookDto;
import com.naydler.omnioschallenge.entities.BookEntity;

import io.github.thibaultmeyer.cuid.CUID;

@Component
public class BookMapper {

    @Autowired
    private DeepAIManager deepAIManager;

    public BookDto[] map(List<BookEntity> scrappedBooks) {
        return scrappedBooks.stream().map(scrappedBook -> {
            // TODO Obtain and transform data
            var id = CUID.randomCUID1();
            var text = deepAIManager.getText(scrappedBook.getTitle());
            return new BookDto();
        }).toArray(BookDto[]::new);
    }
}
