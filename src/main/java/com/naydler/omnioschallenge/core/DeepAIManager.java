package com.naydler.omnioschallenge.core;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import org.springframework.stereotype.Component;

@Component
public class DeepAIManager {
    public String getText(String title) {
        var client = HttpClient.newBuilder().build();
        var question = "{\"text\":\"The text of "+ title +" is:\"}";
        var request = HttpRequest.newBuilder().uri(URI.create("https://api.deepai.org/api/text-generator"))
                .header("api-key", "quickstart-QUdJIGlzIGNvbWluZy4uLi4K").POST(BodyPublishers.ofString(question)).build();
        HttpResponse<String> response;
        try {
            // Use question on the body handler
            response = client.send(request, BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        return "There was an error with the request";
    }
}
