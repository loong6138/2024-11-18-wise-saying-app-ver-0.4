package com.ll.wiseSaying;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class WiseSayingRepository {

    LinkedHashMap<Integer, WiseSaying> map = new LinkedHashMap<>();
    private int number;

    int register(String message, String author) {
        ++number;
        WiseSaying wiseSaying = new WiseSaying(this.number, message, author);
        map.put(this.number, wiseSaying);
        return number;
    }

    void deleteById(int number) {
        if (map.get(number) == null) {
            throw new NullPointerException(number + "");
        } else {
            map.remove(number);
        }
    }

    void updateById(int number, String message, String author) {
        WiseSaying update = new WiseSaying(number, message, author);
        map.replace(number, update);
    }

    WiseSaying findById(int number) {
        WiseSaying findById = map.get(number);
        if (findById == null) {
            throw new NullPointerException(number + "");
        } else {
            return map.get(number);
        }
    }

    void findAll() {
        // 키 내림차순 정렬
        List<Integer> numbers = new ArrayList<>(map.keySet());
        numbers.sort(Collections.reverseOrder());

        // 정렬된 키 순서로 출력
        for (Integer number : numbers) {
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
