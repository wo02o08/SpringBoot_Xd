package com.example.demoproject.domain;

import java.util.List;

public class Chapter {
    private Integer id;

    private String videoId;

    private String title;

    public Chapter(Integer id, String videoId, String title) {
        this.id = id;
        this.videoId = videoId;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", videoId='" + videoId + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
