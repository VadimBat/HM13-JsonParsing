package ua.goit.task1.restapirequest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PutRequest {
    public void sendPut(String url, String jsonUser) {
        try {
            HttpRequest putRequest = HttpRequest
                    .newBuilder()
                    .uri(new URI(url))
                    .header("Content-type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(jsonUser))
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();

            HttpResponse<String> putResponse = httpClient.send(putRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println("putResponse.body() = " + putResponse.body());
            System.out.println("putResponse.statusCode() = " + putResponse.statusCode());

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
