package com.jokes;
import com.jokes.JokesUtils;

public class JokesGenerator {

    public static String generateRandomJokes()
    {
        int maxSize = JokesUtils.jokes.length;
        int element = (int)  Math.floor(Math.random()*maxSize);

        return JokesUtils.jokes[element];
    }
}
