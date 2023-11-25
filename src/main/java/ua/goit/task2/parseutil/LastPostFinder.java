package ua.goit.task2.parseutil;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;
import ua.goit.task2.pojo.Post;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LastPostFinder {

    public static int find(String url) {
        return lastPostFind(readJson(url));
    }

    public static int getUserId(String url) {
        Type typeToken = TypeToken
                .getParameterized(List.class, Post.class)
                .getType();

        List<Post> posts = new Gson().fromJson(readJson(url), typeToken);
        return posts.get(0).getUserId();
    }

    public static String readJson(String url) {
        String json = null;
        try {
            json = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .get()
                    .body()
                    .text();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return json;
    }

    private static int lastPostFind(String json) {
        Type typeToken = TypeToken
                .getParameterized(List.class, Post.class)
                .getType();

        List<Post> posts = new Gson().fromJson(json, typeToken);
        List<Integer> id = new ArrayList<>();

        for (Post post : posts) {
            id.add(post.getId());
        }
        Integer maxId = id.stream()
                .max(Integer::compareTo)
                .get();
        return maxId;
    }
}
