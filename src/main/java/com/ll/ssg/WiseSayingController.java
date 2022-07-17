package com.ll.ssg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    Scanner sc;

    WiseSayingRepository wiseSayingRepository;
    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        wiseSayingRepository = new WiseSayingRepository();

    }

    public void write() {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        wiseSayingRepository.write(content, author);
    }

    public void list(){
        if(wiseSayingRepository.isEmpty()){
            System.out.println("등록 된 글이 없습니다.");
            return;
        }
        wiseSayingRepository.list();

    }

    public void remove(){

        if(wiseSayingRepository.isEmpty()){
            System.out.println("등록된 글이 없습니다.");
            return;
        }

        System.out.println("삭제할 번호를 입력 해 주세요");
        int removeid = Integer.parseInt(sc.nextLine());

        wiseSayingRepository.remove(removeid);
    }

    public void modify(){
        if(wiseSayingRepository.isEmpty()){
            System.out.println("등록된 글이 없습니다.");
            return;
        }

        System.out.println("수정 할 번호를 입력 해 주세요");
        int modifyid = Integer.parseInt(sc.nextLine());

        wiseSayingRepository.modify(modifyid, sc);

    }

    public void build(){
        wiseSayingRepository.build();
    }


}
