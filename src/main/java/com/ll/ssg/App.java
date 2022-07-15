package com.ll.ssg;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    Scanner sc;
    int idx;
    ArrayList<WiseSaying> al;

    public App(){
        sc = new Scanner(System.in);
        al = new ArrayList<>();
        idx = 1;
    }
    void run(){
        System.out.println("== 명언 SSG ==");

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
                    write();
                    break;
                case "목록" :
                    list();
                    break;
                case "삭제" :
                    remove(rq);
                    break;
                case "수정" :
                    modify(rq);
                    break;
            }
        }
        sc.close();
    }
    public void write() {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();
        System.out.printf("%d번 명언이 등록되었습니다.\n", idx);
        WiseSaying wiseSaying = new WiseSaying(idx++, content, author);
        al.add(wiseSaying);
    }

    public void list(){
        if(al.size() == 0){
            System.out.println("등록 된 글이 없습니다.");
            return;
        }

        System.out.println("번호 / 작가 / 명언");
        System.out.println("==================");
        for(int i = al.size()-1; i>=0; i--){
            System.out.printf("%d / %s / %s\n", al.get(i).idx, al.get(i).author, al.get(i).content);
        }
    }

    public void remove(Rq rq){



        if(al.size() == 0){
            System.out.println("삭제 할 글이 없습니다.");
            return;
        }

        System.out.println("삭제할 번호를 입력 해 주세요");
        int removeIdx = Integer.parseInt(sc.nextLine());
        WiseSaying removeWiseSaying = findById(removeIdx);
        if(removeWiseSaying == null){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", removeIdx);
            return;
        }

        al.remove(removeWiseSaying);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", removeIdx);
    }

    public void modify(Rq rq){
        if(al.size() == 0){
            System.out.println("수정 할 글이 없습니다.");
            return;
        }

        System.out.println("수정 할 번호를 입력 해 주세요");
        int modifyIdx = Integer.parseInt(sc.nextLine());

        WiseSaying modifyWiseSaying = findById(modifyIdx);

        if(modifyWiseSaying == null){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", modifyIdx);
            return;
        }

        System.out.printf("명언(기존) : %s \n", modifyWiseSaying.content);
        System.out.print("명언 : ");
        modifyWiseSaying.content = sc.nextLine();
        System.out.printf("작가(기존) : %s \n", modifyWiseSaying.author);
        System.out.print("작가 : ");
        modifyWiseSaying.author = sc.nextLine();

        System.out.printf("%d번 명언이 수정되었습니다.", modifyIdx);

    }

    public WiseSaying findById(int paramId){
        for(WiseSaying wiseSaying : al){
            if(wiseSaying.idx == paramId){
                return wiseSaying;
            }
        }
        return null;
    }

}
