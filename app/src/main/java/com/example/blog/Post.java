package com.example.blog;

import java.text.SimpleDateFormat;

public class Post {
    private String title;
    private String inhoud;
    private SimpleDateFormat datum;

    public Post() {
        //is nodig...
    }

    public Post(String title, String inhoud, SimpleDateFormat datum) {
        this.title = title;
        this.inhoud = inhoud;
        this.datum = datum;
    }

    public SimpleDateFormat getDatum() {
        return datum;
    }

    public String getTitle() {
        return title;
    }

    public String getInhoud() {
        return inhoud;
    }
}
