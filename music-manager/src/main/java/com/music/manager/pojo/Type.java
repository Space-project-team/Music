package com.music.manager.pojo;

import java.io.Serializable;

/**
 * @author zhoubin 
 * @create 2020-05-12
 * @since 1.0.0
 */
public class Type implements Serializable {
    /**
     * 类型id
     */
    private Integer id;

    /**
     * 类型
     */
    private String typename;

    /**
     * type
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", typename=").append(typename);
        sb.append("]");
        return sb.toString();
    }
}