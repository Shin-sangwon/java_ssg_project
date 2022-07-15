package com.ll.ssg;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    Scanner sc;
    void run(){
        System.out.println("== 명언 SSG ==");

        sc = new Scanner(System.in);
        ArrayList<WiseSaying> al = new ArrayList<WiseSaying>();
        int idx = 1;
        WiseSaying wiseSaying;
        Loop1:
        while(true){
            System.out.println("명령을 입력하세요");
            System.out.print("명령) : ");
            String cmd = sc.nextLine();
            switch(cmd){
                case "종료" : break Loop1;
                case "등록" :
                    wiseSaying = new WiseSaying();
                    System.out.print("명언 : ");
                    wiseSaying.content = sc.nextLine();
                    System.out.print("작가 : ");
                    wiseSaying.author = sc.nextLine();
                    System.out.printf("%d번 명언이 등록되었습니다.\n", idx);
                    wiseSaying.idx = idx++;
                    al.add(wiseSaying);
                    break;
                case "목록" :
                    for(int i = al.size()-1; i>=0; i--){
                        System.out.printf("%d / %s / %s\n", al.get(i).idx, al.get(i).author, al.get(i).content);
                    }
                    break;

            }
        }


    }
}
