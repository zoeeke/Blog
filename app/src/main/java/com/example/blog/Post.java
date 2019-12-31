package com.example.blog;

public class Post {
    private String title;
    private String inhoud;
    private int prio;

    public Post() {
        //is nodig...
    }

    public Post(String title, String inhoud, int prio) {
        this.title = title;
        this.inhoud = inhoud;
        this.prio = prio;
    }

    public int getPrio() {
        return prio;
    }

    public String getTitle() {
        return title;
    }

    public String getInhoud() {
        return inhoud;
    }
}
