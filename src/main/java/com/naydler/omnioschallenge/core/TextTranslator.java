package com.naydler.omnioschallenge.core;

import org.springframework.stereotype.Component;

import com.doomedcat17.opentranslator.exception.TranslationException;
import com.doomedcat17.opentranslator.language.Language;
import com.doomedcat17.opentranslator.translation.Translator;
import com.naydler.omnioschallenge.entities.TranslationEntity;

@Component
public class TextTranslator {
    public TranslationEntity getTranslation(String text) {
        Translator translator = new Translator();
        text = text.substring(0,Math.min(text.length(), 1000)); // Due to an API limitation
        try {
            var textSpanish = translator.translate(text, Language.ENGLISH, Language.SPANISH);
            var textGerman = translator.translate(text, Language.ENGLISH, Language.GERMAN);
            return new TranslationEntity(textSpanish.getTranslatedText(), textGerman.getTranslatedText());
        } catch (TranslationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
}