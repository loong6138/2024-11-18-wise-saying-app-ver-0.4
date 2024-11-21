package com.ll.wiseSaying;

import java.util.Scanner;

public class WiseSayingController {

    WiseSayingService service = new WiseSayingService();

    void run() {

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
                int number = service.register(message, author);
                System.out.println(number + "번 명언이 등록되었습니다.");

            } else if (input.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                service.findAll();

            } else if (input.contains("삭제?id=")) {
                boolean delete = service.deleteById(Integer.parseInt(input.substring(6)));
                if (delete) {
                    System.out.println(Integer.parseInt(input.substring(6)) + "번 명언이 삭제되었습니다.");
                }
            } else if (input.equals("종료")) {
                scanner.close();
                break;
            }
        }
    }

}
