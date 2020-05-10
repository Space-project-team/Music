package com.music.manager.pojo;

import java.io.Serializable;

/**
 * @author zhoubin 
 * @create 2020-05-10
 * @since 1.0.0
 */
public class MusicLink implements Serializable {
    /**
     * 
     */
    private Integer mlId;

    /**
     * 
     */
    private String mlSongname;

    /**
     * 
     */
    private String mlSinger;

    /**
     * 
     */
    private String mlSonglink;

    /**
     * 
     */
    private String mlLyriclink;

    /**
     * 
     */
    private String mlPhotolink;

    /**
     * musiclink
     */
    private static final long serialVersionUID = 1L;

    public Integer getMlId() {
        return mlId;
    }

    public void setMlId(Integer mlId) {
        this.mlId = mlId;
    }

    public String getMlSongname() {
        return mlSongname;
    }

    public void setMlSongname(String mlSongname) {
        this.mlSongname = mlSongname == null ? null : mlSongname.trim();
    }

    public String getMlSinger() {
        return mlSinger;
    }

    public void setMlSinger(String mlSinger) {
        this.mlSinger = mlSinger == null ? null : mlSinger.trim();
    }

    public String getMlSonglink() {
        return mlSonglink;
    }

    public void setMlSonglink(String mlSonglink) {
        this.mlSonglink = mlSonglink == null ? null : mlSonglink.trim();
    }

    public String getMlLyriclink() {
        return mlLyriclink;
    }

    public void setMlLyriclink(String mlLyriclink) {
        this.mlLyriclink = mlLyriclink == null ? null : mlLyriclink.trim();
    }

    public String getMlPhotolink() {
        return mlPhotolink;
    }

    public void setMlPhotolink(String mlPhotolink) {
        this.mlPhotolink = mlPhotolink == null ? null : mlPhotolink.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mlId=").append(mlId);
        sb.append(", mlSongname=").append(mlSongname);
        sb.append(", mlSinger=").append(mlSinger);
        sb.append(", mlSonglink=").append(mlSonglink);
        sb.append(", mlLyriclink=").append(mlLyriclink);
        sb.append(", mlPhotolink=").append(mlPhotolink);
        sb.append("]");
        return sb.toString();
    }
}