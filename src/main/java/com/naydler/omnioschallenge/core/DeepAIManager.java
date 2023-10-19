package com.naydler.omnioschallenge.core;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Component;

@Component
public class DeepAIManager {
    public String getText(String title) {
        var question = "{\"text\":\"The text of " + title + " is:\"}";

        HttpURLConnection connection;
        try {
            connection = (HttpURLConnection) new URL("https://api.deepai.org/api/text-generator").openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("api-key", "quickstart-QUdJIGlzIGNvbWluZy4uLi4K");
            connection.setDoOutput(true);

            OutputStream os = connection.getOutputStream();
            byte[] input = question.getBytes("utf-8");
            os.write(input, 0, input.length);

            return connection.getResponseCode() == HttpURLConnection.HTTP_OK 
                ? "Dummy data due to a successful request"
                : connection.getResponseMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return "There was an error with the request";
        }
    }
}
