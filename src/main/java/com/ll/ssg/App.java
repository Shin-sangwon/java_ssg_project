package com.ll.ssg;

import java.util.Scanner;

public class App {

    Scanner sc;
    void run(){
        System.out.println("== 명언 SSG ==");

        sc = new Scanner(System.in);

        int idx = 1;

        Loop1:
        while(true){
            System.out.println("명령을 입력하세요");
            System.out.print("명령) : ");
            String cmd = sc.nextLine();
            switch(cmd){
                case "종료" : break Loop1;
                case "등록" :
                    System.out.print("명언 : ");
                    String content = sc.nextLine();
                    System.out.print("작가 : ");
                    String author = sc.nextLine();
                    System.out.printf("%d번 명언이 등록되었습니다.\n", idx++);
                    break;
            }
        }


    }
}
