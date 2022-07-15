package com.ll.ssg;

import java.util.ArrayList;

public class WiseSayingRepository {
    int idx;
    ArrayList<WiseSaying> al;

    WiseSayingRepository(){
        idx = 1;
        al = new ArrayList<>();
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
