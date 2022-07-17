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
        System.out.println("등록이 완료되었습니다.");
    }

    public void list(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("==================");
        List<WiseSaying> printList = wiseSayingRepository.list();
        for(int i = printList.size() - 1; i >= 0; i--){
            WiseSaying wiseSaying = printList.get(i);

            System.out.printf("%d / %s / %s\n", wiseSaying.id, wiseSaying.author, wiseSaying.content);
        }

    }

    public void remove(){

        System.out.println("삭제할 번호를 입력 해 주세요");
        int removeid = Integer.parseInt(sc.nextLine());

        wiseSayingRepository.remove(removeid);
    }

    public void modify(){

        System.out.println("수정 할 번호를 입력 해 주세요");
        int modifyid = Integer.parseInt(sc.nextLine());

        wiseSayingRepository.modify(modifyid, sc);

    }

    public void build(){
        wiseSayingRepository.build();
    }


}
