package com.ll.wiseSaying;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class wiseSayingRepository {

    LinkedHashMap<Integer, wiseSaying> map = new LinkedHashMap<>();
    private int lastId;

    int register(String message, String author) {
        ++lastId;
        wiseSaying wiseSaying = new wiseSaying(this.lastId, message, author);
        map.put(this.lastId, wiseSaying);
        return lastId;
    }

    void deleteById(int number) {
        if (map.get(number) == null) {
            throw new NullPointerException(number + "");
        } else {
            map.remove(number);
        }
    }

    void updateById(int id, String message, String author) {
        wiseSaying update = new wiseSaying(id, message, author);
        map.replace(id, update);
    }

    wiseSaying findById(int id) {
        wiseSaying findById = map.get(id);
        if (findById == null) {
            throw new NullPointerException(id + "");
        } else {
            return map.get(id);
        }
    }

    void findAll() {
        // 키 내림차순 정렬
        List<Integer> ids = new ArrayList<>(map.keySet());
        ids.sort(Collections.reverseOrder());

        // 정렬된 키 순서로 출력
        for (Integer number : ids) {
            System.out.println(map.get(number));
        }
    }

    void exceptionHandler(Exception e) {
        // 예외 종류에 따른 구분
        if (e instanceof NullPointerException) {
            System.out.println(e.getMessage() + "번 명언은 존재하지 않습니다.");
        }
    }
}
