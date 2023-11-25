package ua.goit.task2;

import ua.goit.task2.parseutil.CommentWriter;
import ua.goit.task2.parseutil.LastPostFinder;

public class App {

    private static final String URL = "https://jsonplaceholder.typicode.com/users/1/posts";

    public static void main(String[] args) {

        int userId = LastPostFinder.getUserId(URL);
        int lastPostId = LastPostFinder.find(URL);
        System.out.println("userId = " + userId);
        System.out.println("lastPostId = " + lastPostId);
        CommentWriter.write(userId, lastPostId);


    }
}
