package com.ll.wiseSaying.service;

import com.ll.wiseSaying.entity.WiseSaying;
import com.ll.wiseSaying.repository.WiseSayingRepository;

public class WiseSayingService {

    WiseSayingRepository repository = new WiseSayingRepository();

    public WiseSayingService() {
        repository.loadQuote();
        repository.loadLastId();
    }

    public int register(String message, String author) {
        return repository.register(message, author);
    }

    public boolean deleteById(int id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            repository.exceptionHandler(e);
            return false;
        }
    }

    public void updateById(int id, String message, String author) {
        repository.updateById(id, message, author);
    }

    public WiseSaying findById(int id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            repository.exceptionHandler(e);
            return null;
        }
    }

    public void findAll() {
        repository.findAll();
    }

    public void build() {
        repository.build();
    }
}
