package com.music.manager.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhoubin 
 * @create 2020-05-12
 * @since 1.0.0
 */
public class Album implements Serializable {
    /**
     * 序号
     */
    private Integer albumid;

    /**
     * 专辑名称
     */
    private String albumname;

    /**
     * 发布时间
     */
    private Date issuedate;

    /**
     * 歌手编号
     */
    private Integer singerid;

    /**
     * 语言编号
     */
    private Integer languageid;

    /**
     * 分类编号
     */
    private Integer classifyid;

    /**
     * 专辑简介
     */
    private String albumintro;

    /**
     * album
     */
    private static final long serialVersionUID = 1L;

    public Integer getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Integer albumid) {
        this.albumid = albumid;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname == null ? null : albumname.trim();
    }

    public Date getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(Date issuedate) {
        this.issuedate = issuedate;
    }

    public Integer getSingerid() {
        return singerid;
    }

    public void setSingerid(Integer singerid) {
        this.singerid = singerid;
    }

    public Integer getLanguageid() {
        return languageid;
    }

    public void setLanguageid(Integer languageid) {
        this.languageid = languageid;
    }

    public Integer getClassifyid() {
        return classifyid;
    }

    public void setClassifyid(Integer classifyid) {
        this.classifyid = classifyid;
    }

    public String getAlbumintro() {
        return albumintro;
    }

    public void setAlbumintro(String albumintro) {
        this.albumintro = albumintro == null ? null : albumintro.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", albumid=").append(albumid);
        sb.append(", albumname=").append(albumname);
        sb.append(", issuedate=").append(issuedate);
        sb.append(", singerid=").append(singerid);
        sb.append(", languageid=").append(languageid);
        sb.append(", classifyid=").append(classifyid);
        sb.append(", albumintro=").append(albumintro);
        sb.append("]");
        return sb.toString();
    }
}