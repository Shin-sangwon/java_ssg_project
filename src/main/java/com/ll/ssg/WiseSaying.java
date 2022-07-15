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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WiseSaying)) return false;
        WiseSaying that = (WiseSaying) o;
        return idx == that.idx && Objects.equals(content, that.content) && Objects.equals(author, that.author);
    }


}
