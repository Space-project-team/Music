package com.music.common.result;

/**
 * 定义了一个基本的查询条件，就是一个vo，而且是分页查询必带的条件
 */
public class BaseQuery {
    private Integer page=1;
    private Integer rows=10;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
