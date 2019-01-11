package com.shile;

public class Song {
    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }
// com.shile.Song@1540e19d 代表对象的内存地址
    @Override
    public String toString() {
        // 这是一个快速输出对象内容的方式
        return this.title + ": " + this.duration;
    }
}
