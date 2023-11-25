package ua.goit.task2.parseutil;

import java.io.FileWriter;
import java.io.IOException;

public class CommentWriter {

    private static final String URL_POSTS = "https://jsonplaceholder.typicode.com/posts";

    public static void write(int userId, int lastPostId) {
        String json = LastPostFinder.readJson(URL_POSTS + "/" + lastPostId + "/comments");
        System.out.println(json);
        try {
            FileWriter fileWriter = new FileWriter("user-" + userId + "-post-" + lastPostId + "-comments.json");
            fileWriter.write(json);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
