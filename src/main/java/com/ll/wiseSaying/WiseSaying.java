package com.ll.wiseSaying;

public class WiseSaying {

    private String message;
    private String author;
    private int number;

    public WiseSaying(String message, String author, int number) {
        this.message = message;
        this.author = author;
        this.number = number;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return number + " / " + author + " / " + message;
    }
}
