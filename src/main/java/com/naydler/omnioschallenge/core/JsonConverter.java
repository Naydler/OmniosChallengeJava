package com.naydler.omnioschallenge.core;

import org.springframework.stereotype.Component;
import com.google.gson.Gson;

@Component
public class JsonConverter {
    public String getJson(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }
}

