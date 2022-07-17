package com.ll.ssg;

import java.util.ArrayList;
import java.util.Scanner;

public class WiseSayingRepository {
    private int idx;
    private ArrayList<WiseSaying> wiseSayings;

    WiseSayingRepository(){
        idx = 1;
        wiseSayings = new ArrayList<>();
    }



    public void list() {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("==================");
        for(int i = wiseSayings.size()-1; i>=0; i--){
            System.out.printf("%d / %s / %s\n", wiseSayings.get(i).idx, wiseSayings.get(i).author, wiseSayings.get(i).content);
        }
    }

    public void remove(int removeIdx) {
        WiseSaying removeWiseSaying = findById(removeIdx);
        if(removeWiseSaying == null){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", removeIdx);
            return;
        }

        wiseSayings.remove(removeWiseSaying);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", removeIdx);
    }

    public void modify(int modifyIdx, Scanner sc) {
        sc = new Scanner(System.in);
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

    }

    public void write(String content, String author) {
        System.out.printf("%d번 명언이 등록되었습니다.\n", idx);
        WiseSaying wiseSaying = new WiseSaying(idx++, content, author);
        wiseSayings.add(wiseSaying);
    }

    public WiseSaying findById(int paramId){
        for(WiseSaying wiseSaying : wiseSayings){
            if(wiseSaying.idx == paramId){
                return wiseSaying;
            }
        }
        return null;
    }

    public boolean isEmpty(){
        if(wiseSayings.size() == 0) return true;

        return false;
    }
}
