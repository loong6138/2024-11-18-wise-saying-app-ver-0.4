package com.ll.wiseSaying.service;

import com.ll.wiseSaying.domain.wiseSaying;
import com.ll.wiseSaying.repository.wiseSayingRepository;

public class wiseSayingService {

    wiseSayingRepository repository = new wiseSayingRepository();

    public wiseSayingService() {
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

    public wiseSaying findById(int id) {
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
