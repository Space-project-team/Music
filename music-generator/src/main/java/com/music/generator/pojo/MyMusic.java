package com.music.generator.pojo;

import java.io.Serializable;

/**
 * @author zhoubin 
 * @create 2020-05-10
 * @since 1.0.0
 */
public class MyMusic implements Serializable {
    /**
     * 
     */
    private Integer myId;

    /**
     * 
     */
    private String mySongname;

    /**
     * 
     */
    private String mySinger;

    /**
     * 
     */
    private String mySonglink;

    /**
     * 
     */
    private String myLyriclink;

    /**
     * 
     */
    private String myPhotolink;

    /**
     * 
     */
    private Integer userId;

    /**
     * mymusic
     */
    private static final long serialVersionUID = 1L;

    public Integer getMyId() {
        return myId;
    }

    public void setMyId(Integer myId) {
        this.myId = myId;
    }

    public String getMySongname() {
        return mySongname;
    }

    public void setMySongname(String mySongname) {
        this.mySongname = mySongname == null ? null : mySongname.trim();
    }

    public String getMySinger() {
        return mySinger;
    }

    public void setMySinger(String mySinger) {
        this.mySinger = mySinger == null ? null : mySinger.trim();
    }

    public String getMySonglink() {
        return mySonglink;
    }

    public void setMySonglink(String mySonglink) {
        this.mySonglink = mySonglink == null ? null : mySonglink.trim();
    }

    public String getMyLyriclink() {
        return myLyriclink;
    }

    public void setMyLyriclink(String myLyriclink) {
        this.myLyriclink = myLyriclink == null ? null : myLyriclink.trim();
    }

    public String getMyPhotolink() {
        return myPhotolink;
    }

    public void setMyPhotolink(String myPhotolink) {
        this.myPhotolink = myPhotolink == null ? null : myPhotolink.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", myId=").append(myId);
        sb.append(", mySongname=").append(mySongname);
        sb.append(", mySinger=").append(mySinger);
        sb.append(", mySonglink=").append(mySonglink);
        sb.append(", myLyriclink=").append(myLyriclink);
        sb.append(", myPhotolink=").append(myPhotolink);
        sb.append(", userId=").append(userId);
        sb.append("]");
        return sb.toString();
    }
}