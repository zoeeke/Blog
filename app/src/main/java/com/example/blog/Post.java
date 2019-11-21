package com.example.blog;

public class Post {
    private String title;
    private String inhoud;
    private int datum;

    public Post() {
        //is nodig...
    }

    public Post(String title, String inhoud, int datum) {
        this.title = title;
        this.inhoud = inhoud;
        this.datum = datum;
    }

    public int getDatum() {
        return datum;
    }

    public String getTitle() {
        return title;
    }

    public String getInhoud() {
        return inhoud;
    }
}
