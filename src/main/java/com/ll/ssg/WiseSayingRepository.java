package com.ll.ssg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingRepository {

    private WiseSayingTable wiseSayingTable;

    WiseSayingRepository(){
        wiseSayingTable = new WiseSayingTable();
    }


    public void remove(int removeid) {
        WiseSaying removeWiseSaying = findById(removeid);
        if(removeWiseSaying == null){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", removeid);
            return;
        }

        wiseSayingTable.removeById(removeid);
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

        wiseSayingTable.save(modifyid, modifyWiseSaying.content, modifyWiseSaying.author);

    }

    public List<WiseSaying> list(){
        return wiseSayingTable.findAll();
    }

    public void write(String content, String author) {
        wiseSayingTable.save(content, author);
    }

    public void build(){
        WiseSayingTable wiseSayingTable = new WiseSayingTable();
        wiseSayingTable.dumpToJson();

    }

    public WiseSaying findById(int id){
        return wiseSayingTable.findById(id);
    }

    public boolean isEmpty(int id){
        if(wiseSayingTable.findById(id) == null) return false;

        return true;
    }
}
