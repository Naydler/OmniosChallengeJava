package com.naydler.omnioschallenge.core;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

public class JsonFileWriter {
    @Autowired
    private JsonConverter jsonConverter;

    public void write(Object content, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(jsonConverter.getJson(content));
        writer.close();
    }
}
