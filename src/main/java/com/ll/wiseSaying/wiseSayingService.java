package com.ll.wiseSaying;

public class wiseSayingService {

    wiseSayingRepository repository = new wiseSayingRepository();

    int register(String message, String author) {
        return repository.register(message, author);
    }

    boolean deleteById(int id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            repository.exceptionHandler(e);
            return false;
        }
    }

    void updateById(int id, String message, String author) {
        repository.updateById(id, message, author);
    }

    wiseSaying findById(int id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            repository.exceptionHandler(e);
            return null;
        }
    }

    void findAll() {
        repository.findAll();
    }
}
