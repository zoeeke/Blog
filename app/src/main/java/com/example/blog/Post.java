package com.example.blog;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {
    private String title;
    private String inhoud;
    private Date datum;

    public Post() {
        //is nodig...
    }

    public Post(String title, String inhoud, Date datum) {
        this.title = title;
        this.inhoud = inhoud;
        this.datum = datum;
    }

    public Date getDatum() {
        return datum;
    }

    public String getTitle() {
        return title;
    }

    public String getInhoud() {
        return inhoud;
    }
}
