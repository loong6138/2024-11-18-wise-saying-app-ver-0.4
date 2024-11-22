package com.ll.wiseSaying.controller;

import com.ll.wiseSaying.domain.WiseSaying;
import com.ll.wiseSaying.service.WiseSayingService;

import java.util.Scanner;

public class WiseSayingController {

    WiseSayingService service = new WiseSayingService();

    public void run() {

        System.out.println("== 명언 앱 ==");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("명령) ");
            String input = scanner.nextLine();

            if (input.equals("등록")) {
                System.out.print("명언 : ");
                String message = scanner.nextLine();
                System.out.print("작가 : ");
                String author = scanner.nextLine();
                int newId = service.register(message, author);
                System.out.println(newId + "번 명언이 등록되었습니다.");

            } else if (input.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                service.findAll();

            } else if (input.startsWith("삭제?id=")) {
                boolean delete = service.deleteById(Integer.parseInt(input.substring(6)));
                if (delete) {
                    System.out.println(Integer.parseInt(input.substring(6)) + "번 명언이 삭제되었습니다.");
                }

            } else if (input.startsWith("수정?id=")) {
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

            } else if (input.equals("빌드")) {
                service.build();
                System.out.println("data.json 파일의 내용이 갱신되었습니다.");

            } else if (input.equals("종료")) {
                scanner.close();
                break;
            }
        }
    }

}
