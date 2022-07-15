package com.ll.ssg;

import java.util.ArrayList;
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
        System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSayingRepository.idx);
        WiseSaying wiseSaying = new WiseSaying(wiseSayingRepository.idx++, content, author);
        wiseSayingRepository.al.add(wiseSaying);
    }

    public void list(){
        if(wiseSayingRepository.al.size() == 0){
            System.out.println("등록 된 글이 없습니다.");
            return;
        }

        System.out.println("번호 / 작가 / 명언");
        System.out.println("==================");
        for(int i = wiseSayingRepository.al.size()-1; i>=0; i--){
            System.out.printf("%d / %s / %s\n", wiseSayingRepository.al.get(i).idx, wiseSayingRepository.al.get(i).author, wiseSayingRepository.al.get(i).content);
        }
    }

    public void remove(Rq rq){

        if(wiseSayingRepository.al.size() == 0){
            System.out.println("등록된 글이 없습니다.");
            return;
        }

        System.out.println("삭제할 번호를 입력 해 주세요");
        int removeIdx = Integer.parseInt(sc.nextLine());
        WiseSaying removeWiseSaying = wiseSayingRepository.findById(removeIdx);
        if(removeWiseSaying == null){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", removeIdx);
            return;
        }

        wiseSayingRepository.al.remove(removeWiseSaying);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", removeIdx);
    }

    public void modify(Rq rq){
        if(wiseSayingRepository.al.size() == 0){
            System.out.println("등록된 글이 없습니다.");
            return;
        }

        System.out.println("수정 할 번호를 입력 해 주세요");
        int modifyIdx = Integer.parseInt(sc.nextLine());

        WiseSaying modifyWiseSaying = wiseSayingRepository.findById(modifyIdx);

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


}
