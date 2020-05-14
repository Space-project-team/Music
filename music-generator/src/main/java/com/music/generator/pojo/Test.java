package com.music.generator.pojo;

import java.io.Serializable;

/**
 * @author zhoubin 
 * @create 2020-05-10
 * @since 1.0.0
 */
public class Test implements Serializable {
    /**
     * 
     */
    private Integer testId;

    /**
     * 
     */
    private String testName;

    /**
     * 
     */
    private String info;

    /**
     * 
     */
    private String other;

    /**
     * m_test
     */
    private static final long serialVersionUID = 1L;

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName == null ? null : testName.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", testId=").append(testId);
        sb.append(", testName=").append(testName);
        sb.append(", info=").append(info);
        sb.append(", other=").append(other);
        sb.append("]");
        return sb.toString();
    }
}