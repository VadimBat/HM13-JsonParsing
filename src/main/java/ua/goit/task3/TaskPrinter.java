package ua.goit.task3;

import org.jsoup.Jsoup;

import java.io.IOException;

public class TaskPrinter {

    private static final String URL = "https://jsonplaceholder.typicode.com/users";
    private static boolean completed;

    public static void print(int userId, String url) {

        if (url != null && url.equals(URL)) {
            completed = false;
            String json = null;
            try {
                json = Jsoup.connect(url + "/" + userId + "/todos")
                        .ignoreContentType(true)
                        .get()
                        .body()
                        .text();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(json);
        } else {
            System.out.println("There are no active tasks or data error");
            ;
        }
    }
}
