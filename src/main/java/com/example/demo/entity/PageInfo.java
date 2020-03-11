package com.example.demo.entity;/*
 * @author p78o2
 * @date 2020/3/10
 */


import java.util.List;

public class PageInfo<T> {
    private int count;
    private List<T> list;

    @Override
    public String toString() {
        return "PageInfo{" +
                "count=" + count +
                ", list=" + list +
                '}';
    }

    public PageInfo() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public PageInfo(int count, List<T> list) {
        this.count = count;
        this.list = list;
    }
}
