package com.ll.ssg;

import java.util.Objects;

public class WiseSaying {
    int idx;

    String content;
    String author;

    WiseSaying(int idx, String content, String author){
        this.idx = idx;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return "WiseSaying{" +
                "idx=" + idx +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }




}
