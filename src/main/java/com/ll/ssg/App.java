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
        WiseSaying wiseSaying;

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
                    remove();
                    break;
                case "수정" :
                    modify();
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
        System.out.println("번호 / 작가 / 명언");
        System.out.println("==================");
        for(int i = al.size()-1; i>=0; i--){
            System.out.printf("%d / %s / %s\n", al.get(i).idx, al.get(i).author, al.get(i).content);
        }
    }

    public void remove(){
        if(al.size() == 0){
            System.out.println("삭제 할 글이 없습니다.");
            return;
        }

        System.out.println("삭제할 번호를 입력 해 주세요");
        int removeTmp = Integer.parseInt(sc.nextLine());
        if(removeTmp <= 0 || removeTmp > al.size()){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", removeTmp);
            return;
        }

        al.remove(removeTmp-1);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", removeTmp);
    }

    public void modify(){
        if(al.size() == 0){
            System.out.println("수정 할 글이 없습니다.");
            return;
        }

        System.out.println("수정 할 번호를 입력 해 주세요");
        int modifyTmp = Integer.parseInt(sc.nextLine());

        WiseSaying searchTmp = null;
        for(WiseSaying tmp : al){
            if(tmp.idx == modifyTmp) searchTmp = tmp;
        }

        if(searchTmp == null){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", modifyTmp);
            return;
        }



        System.out.printf("명언(기존) : %s \n", searchTmp.content);
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.printf("작가(기존) : %s \n", searchTmp.author);
        System.out.print("작가 : ");
        String author = sc.nextLine();
        searchTmp.content = content;
        searchTmp.author = author;
        int idx = searchTmp.idx;
        al.remove(idx-1);
        al.add(idx-1, searchTmp);

    }

}
