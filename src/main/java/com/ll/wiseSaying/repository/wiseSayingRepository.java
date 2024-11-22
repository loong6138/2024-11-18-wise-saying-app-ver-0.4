package com.ll.wiseSaying.repository;

import com.ll.wiseSaying.domain.wiseSaying;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class wiseSayingRepository {

    LinkedHashMap<Integer, wiseSaying> map = new LinkedHashMap<>();
    private int lastId;
    private static final String QUOTE_FOLDER = System.getProperty("user.dir") + "/src/main/java/com/ll/wiseSaying/db/wiseSaying";
    private static final String LAST_ID_FILE = System.getProperty("user.dir") + "/src/main/java/com/ll/wiseSaying/db/wiseSaying/lastId.txt";

    public int register(String message, String author) {
        ++lastId;
        System.out.println(lastId);
        wiseSaying wiseSaying = new wiseSaying(lastId, message, author);
        map.put(lastId, wiseSaying);
        saveQuote(wiseSaying);
        saveLastId();
        return wiseSaying.getId();
    }

    public void deleteById(int number) {
        if (map.get(number) == null) {
            throw new NullPointerException(number + "");
        } else {
            map.remove(number);
        }
    }

    public void updateById(int id, String message, String author) {
        wiseSaying update = new wiseSaying(id, message, author);
        map.replace(id, update);
    }

    public wiseSaying findById(int id) {
        wiseSaying findById = map.get(id);
        if (findById == null) {
            throw new NullPointerException(id + "");
        } else {
            return map.get(id);
        }
    }

    public void findAll() {
        // 키 내림차순 정렬
        List<Integer> ids = new ArrayList<>(map.keySet());
        ids.sort(Collections.reverseOrder());

        // 정렬된 키 순서로 출력
        for (Integer id : ids) {
            System.out.println(map.get(id));
        }
    }

    private void saveQuote(wiseSaying wiseSaying) {
        File file = new File(QUOTE_FOLDER, lastId + ".json");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("{\n");
            writer.write("  \"id\": " + wiseSaying.getId() + ",\n");
            writer.write("  \"message\": \"" + wiseSaying.getMessage() + "\",\n");
            writer.write("  \"author\": \"" + wiseSaying.getAuthor() + "\"\n");
            writer.write("}");
        } catch (Exception e) {
            exceptionHandler(e);
        }
    }

    private void saveLastId() {
        File file = new File(LAST_ID_FILE);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(String.valueOf(lastId));
        } catch (IOException e) {
            exceptionHandler(e);
        }
    }

    public void exceptionHandler(Exception e) {
        // 예외 종류에 따른 구분
        if (e instanceof NullPointerException) {
            System.out.println(e.getMessage() + "번 명언은 존재하지 않습니다.");
        } else if (e instanceof IOException) {
            System.out.println("명언 작업 중 오류가 발생했습니다.");
        }
    }
}
