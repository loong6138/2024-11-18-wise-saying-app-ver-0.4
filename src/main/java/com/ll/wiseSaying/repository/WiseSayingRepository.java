package com.ll.wiseSaying.repository;

import com.ll.wiseSaying.entity.WiseSaying;

import java.io.*;
import java.util.*;

public class WiseSayingRepository {

    LinkedHashMap<Integer, WiseSaying> map = new LinkedHashMap<>();
    private int lastId;
    private static final String QUOTE_FOLDER = System.getProperty("user.dir") + "/src/main/java/com/ll/wiseSaying/db/wiseSaying";
    private static final String LAST_ID_FILE = System.getProperty("user.dir") + "/src/main/java/com/ll/wiseSaying/db/wiseSaying/lastId.txt";
    private static final String DATA_FILE = System.getProperty("user.dir") + "/src/main/java/com/ll/wiseSaying/db/wiseSaying/data.json";

    public int register(String message, String author) {
        ++lastId;
        WiseSaying wiseSaying = new WiseSaying(lastId, message, author);
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
        WiseSaying update = new WiseSaying(id, message, author);
        map.replace(id, update);
    }

    public WiseSaying findById(int id) {
        WiseSaying findById = map.get(id);
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

    private void saveQuote(WiseSaying wiseSaying) {
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

    public void saveLastId() {
        File file = new File(LAST_ID_FILE);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(String.valueOf(lastId));
        } catch (IOException e) {
            exceptionHandler(e);
        }
    }

    public void loadQuote() {
        File folder = new File(QUOTE_FOLDER);
        if (!folder.exists()) return;

        File[] files = folder.listFiles((dir, name) -> name.endsWith(".json"));
        if (files == null) return;

        for (File file : files) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }

                String json = content.toString();
                int id = Integer.parseInt(json.split("\"id\": ")[1].split(",")[0]);
                String message = json.split("\"message\": \"")[1].split("\",")[0];
                String author = json.split("\"author\": \"")[1].split("\"")[0];

                map.put(id, new WiseSaying(id, message, author));
                lastId = Math.max(lastId, id);
            } catch (Exception e) {
                exceptionHandler(e);
            }
        }
    }

    public void loadLastId() {
        File file = new File(LAST_ID_FILE);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String lastIdStr = reader.readLine();
                if (lastIdStr != null && !lastIdStr.isEmpty()) {
                    lastId = Integer.parseInt(lastIdStr);
                }
            } catch (IOException e) {
                exceptionHandler(e);
            }
        } else {
            lastId = 0; // 파일이 없으면 0
        }
    }

    public void build() {
        File file = new File(DATA_FILE);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("[\n");
            int size = map.size();
            int index = 0;
            for (Map.Entry<Integer, WiseSaying> entry : map.entrySet()) {
                WiseSaying wiseSaying = entry.getValue();
                writer.write("   {\n");
                writer.write("    \"id\": " + wiseSaying.getId() + ",\n");
                writer.write("    \"content\": \"" + wiseSaying.getMessage() + "\",\n");
                writer.write("    \"author\": \"" + wiseSaying.getAuthor() + "\"\n");
                writer.write("  }");
                index++;
                if (index < size) {
                    writer.write(",");
                }
                writer.write("\n");
            }
            writer.write("]");
        } catch (Exception e) {
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
