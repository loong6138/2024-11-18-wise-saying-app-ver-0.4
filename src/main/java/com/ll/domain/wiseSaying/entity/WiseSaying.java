package com.ll.domain.wiseSaying.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WiseSaying {

    private int id;
    private String message;
    private String author;

    public WiseSaying(int id, String message, String author) {
        this.id = id;
        this.message = message;
        this.author = author;
    }

    @Override
    public String toString() {
        return id + " / " + author + " / " + message;
    }
}
