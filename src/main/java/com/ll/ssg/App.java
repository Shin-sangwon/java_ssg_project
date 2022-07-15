package com.ll.ssg;

import java.util.Scanner;

public class App {

    Scanner sc;
    void run(){
        System.out.println("== 명언 SSG ==");
        sc = new Scanner(System.in);
        String cmd = sc.nextLine();

        Loop1:
        while(true){
            switch(cmd){
                case "종료" : break Loop1;
            }
        }


    }
}
