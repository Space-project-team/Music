package com.music.manager.pojo;

import java.io.Serializable;

/**
 * @author zhoubin 
 * @create 2020-05-12
 * @since 1.0.0
 */
public class Language implements Serializable {
    /**
     * 语言编号
     */
    private String languageid;

    /**
     * 语言名称
     */
    private String languagename;

    /**
     * 类型id
     */
    private Integer typeid;

    /**
     * language
     */
    private static final long serialVersionUID = 1L;

    public String getLanguageid() {
        return languageid;
    }

    public void setLanguageid(String languageid) {
        this.languageid = languageid == null ? null : languageid.trim();
    }

    public String getLanguagename() {
        return languagename;
    }

    public void setLanguagename(String languagename) {
        this.languagename = languagename == null ? null : languagename.trim();
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", languageid=").append(languageid);
        sb.append(", languagename=").append(languagename);
        sb.append(", typeid=").append(typeid);
        sb.append("]");
        return sb.toString();
    }
}