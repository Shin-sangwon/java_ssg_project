package com.ll.ssg;

import java.util.Scanner;
public class App {

    Scanner sc;

    private static String mode = "prod";

    public App(){
        sc = new Scanner(System.in);

    }

    public static String getDataBaseDir() {
        return mode + "_data";
    }

    void run(){
        System.out.println("== 명언 SSG ==");
        WiseSayingController wiseSayingController = new WiseSayingController(sc);

        Loop1:
        while(true){
            System.out.println("명령을 입력하세요");
            System.out.println("등록/목록/삭제/수정/종료");
            System.out.print("명령) : ");
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);
            switch(rq.getPath()){
                case "종료" :
                    break Loop1;
                case "등록" :
                    wiseSayingController.write();
                    break;
                case "목록" :
                    wiseSayingController.list();
                    break;
                case "삭제" :
                    wiseSayingController.remove();
                    break;
                case "수정" :
                    wiseSayingController.modify();
                    break;
                case "빌드" :
                    wiseSayingController.build();
            }
        }
        sc.close();
    }


}
