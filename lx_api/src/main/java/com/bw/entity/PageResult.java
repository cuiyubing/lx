package com.bw.entity;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {

    private List<T> content;//数据集合
    private Long total;//总条数
    private int pages;//总页数
    private Integer pageNum;
    private Integer pageSize;

    public PageResult() {
    }

    public PageResult(List<T> content, Long total, int pages, Integer pageNum, Integer pageSize) {
        this.content = content;
        this.total = total;
        this.pages = pages;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
