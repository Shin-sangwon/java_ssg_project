package com.ll.ssg;

import java.util.ArrayList;
import java.util.Scanner;

public class WiseSayingRepository {
    private int id;
    private ArrayList<WiseSaying> wiseSayings;
    private WiseSayingTable wiseSayingTable;

    WiseSayingRepository(){
        id = 1;
        wiseSayings = new ArrayList<>();
    }



    public void list() {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("==================");
        for(int i = wiseSayings.size()-1; i>=0; i--){
            System.out.printf("%d / %s / %s\n", wiseSayings.get(i).id, wiseSayings.get(i).author, wiseSayings.get(i).content);
        }
    }

    public void remove(int removeid) {
        WiseSaying removeWiseSaying = findById(removeid);
        if(removeWiseSaying == null){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", removeid);
            return;
        }

        wiseSayings.remove(removeWiseSaying);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", removeid);
    }

    public void modify(int modifyid, Scanner sc) {
        sc = new Scanner(System.in);
        WiseSaying modifyWiseSaying = findById(modifyid);

        if(modifyWiseSaying == null){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", modifyid);
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
        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
        WiseSaying wiseSaying = new WiseSaying(id++, content, author);
        wiseSayings.add(wiseSaying);
    }

    public void build(){
        WiseSayingTable wiseSayingTable = new WiseSayingTable();
        wiseSayingTable.dumpToJson();

    }

    public WiseSaying findById(int paramId){
        for(WiseSaying wiseSaying : wiseSayings){
            if(wiseSaying.id == paramId){
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
