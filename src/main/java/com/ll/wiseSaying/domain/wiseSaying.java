package com.ll.wiseSaying.domain;

public class wiseSaying {

    private int id;
    private String message;
    private String author;

    public wiseSaying(int id, String message, String author) {
        this.id = id;
        this.message = message;
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + " / " + author + " / " + message;
    }
}
