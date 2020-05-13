package com.music.manager.pojo;

import java.io.Serializable;

/**
 * @author zhoubin 
 * @create 2020-05-12
 * @since 1.0.0
 */
public class Singer implements Serializable {
    /**
     * 歌手编号
     */
    private String singerid;

    /**
     * 姓名
     */
    private String singername;

    /**
     * 是否组合(取值0或1)
     */
    private String isgroup;

    /**
     * 检查约束(男,女)
     */
    private String sex;

    /**
     * 粉丝
     */
    private Integer fans;

    /**
     * 头像
     */
    private String headimage;

    /**
     * singer
     */
    private static final long serialVersionUID = 1L;

    public String getSingerid() {
        return singerid;
    }

    public void setSingerid(String singerid) {
        this.singerid = singerid == null ? null : singerid.trim();
    }

    public String getSingername() {
        return singername;
    }

    public void setSingername(String singername) {
        this.singername = singername == null ? null : singername.trim();
    }

    public String getIsgroup() {
        return isgroup;
    }

    public void setIsgroup(String isgroup) {
        this.isgroup = isgroup == null ? null : isgroup.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }

    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage == null ? null : headimage.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", singerid=").append(singerid);
        sb.append(", singername=").append(singername);
        sb.append(", isgroup=").append(isgroup);
        sb.append(", sex=").append(sex);
        sb.append(", fans=").append(fans);
        sb.append(", headimage=").append(headimage);
        sb.append("]");
        return sb.toString();
    }
}