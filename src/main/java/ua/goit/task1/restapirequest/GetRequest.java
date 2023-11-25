package ua.goit.task1.restapirequest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetRequest {

    public void sendGet(String url) {
        try {
            HttpRequest getRequest = HttpRequest
                    .newBuilder()
                    .uri(new URI(url))
                    .header("Content-type", "application/json")
                    .GET()
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();

            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println("getResponse.body() = " + getResponse.body());
            System.out.println("getResponse.statusCode() = " + getResponse.statusCode());

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendGetById(String url, int id) {
        try {
            HttpRequest getByIdRequest = HttpRequest
                    .newBuilder()
                    .uri(new URI(url + "/" + id))
                    .header("Content-type", "application/json")
                    .GET()
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();

            HttpResponse<String> getByIdResponse = httpClient.send(getByIdRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println("getByIdResponse.body() = " + getByIdResponse.body());
            System.out.println("getByIdResponse.statusCode() = " + getByIdResponse.statusCode());

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendGetByUsername(String url, String username) {
        try {
            HttpRequest getByUsernameRequest = HttpRequest
                    .newBuilder()
                    .uri(new URI(url + "?" + username + "=" + username + ""))
                    .header("Content-type", "application/json")
                    .GET()
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();

            HttpResponse<String> getByUsernameResponse = httpClient.send(getByUsernameRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println("getByUsernameResponse.body() = " + getByUsernameResponse.body());
            System.out.println("getByUsernameResponse.statusCode() = " + getByUsernameResponse.statusCode());

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
