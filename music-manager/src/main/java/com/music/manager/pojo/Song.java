package com.music.manager.pojo;

import java.io.Serializable;

/**
 * @author zhoubin 
 * @create 2020-05-12
 * @since 1.0.0
 */
public class Song implements Serializable {
    /**
     * 歌曲编号
     */
    private String songid;

    /**
     * 歌曲名称
     */
    private String songname;

    /**
     * 歌手编号
     */
    private String singerid;

    /**
     * 人气值
     */
    private String votes;

    /**
     * 歌曲文件
     */
    private String songfile;

    /**
     * 歌曲封面
     */
    private String photoimage;

    /**
     * song
     */
    private static final long serialVersionUID = 1L;

    public String getSongid() {
        return songid;
    }

    public void setSongid(String songid) {
        this.songid = songid == null ? null : songid.trim();
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname == null ? null : songname.trim();
    }

    public String getSingerid() {
        return singerid;
    }

    public void setSingerid(String singerid) {
        this.singerid = singerid == null ? null : singerid.trim();
    }

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes == null ? null : votes.trim();
    }

    public String getSongfile() {
        return songfile;
    }

    public void setSongfile(String songfile) {
        this.songfile = songfile == null ? null : songfile.trim();
    }

    public String getPhotoimage() {
        return photoimage;
    }

    public void setPhotoimage(String photoimage) {
        this.photoimage = photoimage == null ? null : photoimage.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", songid=").append(songid);
        sb.append(", songname=").append(songname);
        sb.append(", singerid=").append(singerid);
        sb.append(", votes=").append(votes);
        sb.append(", songfile=").append(songfile);
        sb.append(", photoimage=").append(photoimage);
        sb.append("]");
        return sb.toString();
    }
}