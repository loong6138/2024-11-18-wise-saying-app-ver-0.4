package com.ll.wiseSaying.controller;

import com.ll.wiseSaying.domain.WiseSaying;
import com.ll.wiseSaying.service.WiseSayingService;

import java.util.Scanner;

public class WiseSayingController {

    WiseSayingService service = new WiseSayingService();

    public void register(Scanner scanner) {
        System.out.print("명언 : ");
        String message = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();
        int newId = service.register(message, author);
        System.out.println(newId + "번 명언이 등록되었습니다.");
    }

    public void findAll() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        service.findAll();
    }


    public void deleteById(String input) {
        boolean delete = service.deleteById(Integer.parseInt(input.substring(6)));
        if (delete) {
            System.out.println(Integer.parseInt(input.substring(6)) + "번 명언이 삭제되었습니다.");
        }
    }

    public void update(String input, Scanner scanner) {
        int id = Integer.parseInt(input.substring(6));
        WiseSaying existingValue = service.findById(id);
        if (existingValue != null) {
            System.out.println("명언(기존) : " + existingValue.getMessage());
            System.out.print("명언 : ");
            String message = scanner.nextLine();
            System.out.println("작가(기존) : " + existingValue.getAuthor());
            System.out.print("작가 : ");
            String author = scanner.nextLine();
            service.updateById(id, message, author);
        }
    }

    public void build() {
        service.build();
        System.out.println("data.json 파일의 내용이 갱신되었습니다.");
    }
}



