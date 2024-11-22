package com.ll.wiseSaying.app;

import com.ll.wiseSaying.controller.WiseSayingController;

import java.util.Scanner;

public class App {

    public void run() {

        WiseSayingController controller = new WiseSayingController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String input = scanner.nextLine();

            if (input.equals("등록")) {
                controller.register(scanner);
            } else if (input.equals("목록")) {
                controller.findAll();
            } else if (input.startsWith("삭제")) {
                controller.deleteById(input);
            } else if (input.startsWith("수정")) {
                controller.update(input, scanner);
            } else if (input.equals("빌드")) {
                controller.build();
            } else if (input.equals("종료")) {
                break;
            }
        }

    }
}
