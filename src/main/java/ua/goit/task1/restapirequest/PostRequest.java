package ua.goit.task1.restapirequest;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PostRequest {

    public void sendPost(String url, String jsonUser) {
        try {
            HttpRequest postRequest = HttpRequest
                    .newBuilder()
                    .uri(new URI(url))
                    .header("Content-type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonUser))
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();

            HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println("postResponse.body() = " + postResponse.body());
            System.out.println("postResponse.statusCode() = " + postResponse.statusCode());

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
