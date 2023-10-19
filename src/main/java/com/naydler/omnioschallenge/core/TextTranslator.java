package com.naydler.omnioschallenge.core;

import org.springframework.stereotype.Component;

@Component
public class TextTranslator {
    public String getTranslation(String text) {
        // I didn't find a free api for this, so i'm just returning the same text
        return text;
    }
}