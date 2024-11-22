package com.ll.wiseSaying;

public class WiseSaying {

    private int number;
    private String message;
    private String author;

    public WiseSaying(int number, String message, String author) {
        this.number = number;
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
