package ua.goit.task1;

import ua.goit.task1.restapirequest.DeleteRequest;
import ua.goit.task1.restapirequest.GetRequest;
import ua.goit.task1.restapirequest.PostRequest;
import com.google.gson.Gson;
import ua.goit.task1.restapirequest.PutRequest;
import ua.goit.task1.pojo.UserBuilder;

import java.io.IOException;

public class App {
        private static final String URL = "https://jsonplaceholder.typicode.com/users";
        private static final String URL_ID = "https://jsonplaceholder.typicode.com/users/7";
    public static void main(String[] args) throws IOException {


        Gson gson = new Gson();

        String jsonUser = gson.toJson(UserBuilder.build("John Wong"));
        String jsonUser1 = gson.toJson(UserBuilder.build("Jack Lam"));

        new PostRequest().sendPost(URL, jsonUser);
        new PutRequest().sendPut(URL_ID, jsonUser1);
        new DeleteRequest().sendDelete(URL_ID);
        new GetRequest().sendGet(URL);
        new GetRequest().sendGetById(URL, 9);
        new GetRequest().sendGetByUsername(URL, "Delphine");
    }
}
