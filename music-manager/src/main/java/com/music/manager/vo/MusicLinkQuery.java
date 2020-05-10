package com.music.manager.vo;

/**
 * 音乐播放列表
 */
public class MusicLinkQuery {
    private Integer pageNum=1;
    private Integer pageSize=30;
    private String tbStatus;
    private String order;
    private String desc;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getTbStatus() {
        return tbStatus;
    }

    public void setTbStatus(String tbStatus) {
        this.tbStatus = tbStatus;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
