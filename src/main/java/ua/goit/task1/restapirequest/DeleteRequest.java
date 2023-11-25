package ua.goit.task1.restapirequest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DeleteRequest {

    public void sendDelete(String url) {
        try {
            HttpRequest deleteRequest = HttpRequest
                    .newBuilder()
                    .uri(new URI(url))
                    .header("Content-type", "application/json")
                    .DELETE()
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();

            HttpResponse<String> deleteResponse = httpClient.send(deleteRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println("deleteResponse.body() = " + deleteResponse.body());
            System.out.println("deleteResponse.statusCode() = " + deleteResponse.statusCode());

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
