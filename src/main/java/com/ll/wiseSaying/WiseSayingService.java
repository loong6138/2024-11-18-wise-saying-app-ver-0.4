package com.ll.wiseSaying;

public class WiseSayingService {

    WiseSayingRepository repository = new WiseSayingRepository();

    int register(String message, String author) {
        return repository.register(message, author);
    }

    boolean deleteById(int number) {
        try {
            repository.deleteById(number);
            return true;
        } catch (Exception e) {
            repository.exceptionHandler(e);
            return false;
        }
    }

    void updateById(int number, String message, String author) {
        repository.updateById(number, message, author);
    }

    WiseSaying findById(int number) {
        try {
            return repository.findById(number);
        } catch (Exception e) {
            repository.exceptionHandler(e);
            return null;
        }
    }

    void findAll() {
        repository.findAll();
    }
}
