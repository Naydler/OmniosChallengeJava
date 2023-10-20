package com.naydler.omnioschallenge.mappers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.naydler.omnioschallenge.core.TextTranslator;
import com.doomedcat17.opentranslator.exception.TranslationException;
import com.naydler.omnioschallenge.core.CurrencyConverter;
import com.naydler.omnioschallenge.core.DeepAIManager;
import com.naydler.omnioschallenge.dtos.BookDto;
import com.naydler.omnioschallenge.entities.BookEntity;

import io.github.thibaultmeyer.cuid.CUID;

@Component
public class BookMapper {

    @Autowired
    private DeepAIManager deepAIManager;

    @Autowired
    private TextTranslator textTranslator;

    @Autowired
    private CurrencyConverter currencyConverter;

    public BookDto[] map(List<BookEntity> scrappedBooks) throws TranslationException {
        return scrappedBooks.parallelStream().map(scrappedBook -> {
            // TODO Obtain and transform data
            var id = CUID.randomCUID1();
            var text = deepAIManager.getText(scrappedBook.getTitle());
            var translation = textTranslator.getTranslation(text);
            var newPrice = currencyConverter.getConversion(scrappedBook.getPrice());
            System.out.println(newPrice);
            return new BookDto(id.toString(), text,translation.getSpanish(),translation.getGerman(), newPrice, scrappedBook.getTitle(),scrappedBook.getRating(),scrappedBook.getImageUrl());
        }).toArray(BookDto[]::new);     
    }
}
