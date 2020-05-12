package com.music.manager.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MyMusicExample  implements Serializable {
    /**
     * mymusic
     */
    protected String orderByClause;

    /**
     * mymusic
     */
    protected boolean distinct;

    /**
     * mymusic
     */
    protected List<Criteria> oredCriteria;

    public MyMusicExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
    /* 
     * @author zhoubin 
     * @create 2020-05-10
     * @since 1.0.0
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMyIdIsNull() {
            addCriterion("my_id is null");
            return (Criteria) this;
        }

        public Criteria andMyIdIsNotNull() {
            addCriterion("my_id is not null");
            return (Criteria) this;
        }

        public Criteria andMyIdEqualTo(Integer value) {
            addCriterion("my_id =", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdNotEqualTo(Integer value) {
            addCriterion("my_id <>", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdGreaterThan(Integer value) {
            addCriterion("my_id >", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("my_id >=", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdLessThan(Integer value) {
            addCriterion("my_id <", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdLessThanOrEqualTo(Integer value) {
            addCriterion("my_id <=", value, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdIn(List<Integer> values) {
            addCriterion("my_id in", values, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdNotIn(List<Integer> values) {
            addCriterion("my_id not in", values, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdBetween(Integer value1, Integer value2) {
            addCriterion("my_id between", value1, value2, "myId");
            return (Criteria) this;
        }

        public Criteria andMyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("my_id not between", value1, value2, "myId");
            return (Criteria) this;
        }

        public Criteria andMySongnameIsNull() {
            addCriterion("my_songName is null");
            return (Criteria) this;
        }

        public Criteria andMySongnameIsNotNull() {
            addCriterion("my_songName is not null");
            return (Criteria) this;
        }

        public Criteria andMySongnameEqualTo(String value) {
            addCriterion("my_songName =", value, "mySongname");
            return (Criteria) this;
        }

        public Criteria andMySongnameNotEqualTo(String value) {
            addCriterion("my_songName <>", value, "mySongname");
            return (Criteria) this;
        }

        public Criteria andMySongnameGreaterThan(String value) {
            addCriterion("my_songName >", value, "mySongname");
            return (Criteria) this;
        }

        public Criteria andMySongnameGreaterThanOrEqualTo(String value) {
            addCriterion("my_songName >=", value, "mySongname");
            return (Criteria) this;
        }

        public Criteria andMySongnameLessThan(String value) {
            addCriterion("my_songName <", value, "mySongname");
            return (Criteria) this;
        }

        public Criteria andMySongnameLessThanOrEqualTo(String value) {
            addCriterion("my_songName <=", value, "mySongname");
            return (Criteria) this;
        }

        public Criteria andMySongnameLike(String value) {
            addCriterion("my_songName like", value, "mySongname");
            return (Criteria) this;
        }

        public Criteria andMySongnameNotLike(String value) {
            addCriterion("my_songName not like", value, "mySongname");
            return (Criteria) this;
        }

        public Criteria andMySongnameIn(List<String> values) {
            addCriterion("my_songName in", values, "mySongname");
            return (Criteria) this;
        }

        public Criteria andMySongnameNotIn(List<String> values) {
            addCriterion("my_songName not in", values, "mySongname");
            return (Criteria) this;
        }

        public Criteria andMySongnameBetween(String value1, String value2) {
            addCriterion("my_songName between", value1, value2, "mySongname");
            return (Criteria) this;
        }

        public Criteria andMySongnameNotBetween(String value1, String value2) {
            addCriterion("my_songName not between", value1, value2, "mySongname");
            return (Criteria) this;
        }

        public Criteria andMySingerIsNull() {
            addCriterion("my_singer is null");
            return (Criteria) this;
        }

        public Criteria andMySingerIsNotNull() {
            addCriterion("my_singer is not null");
            return (Criteria) this;
        }

        public Criteria andMySingerEqualTo(String value) {
            addCriterion("my_singer =", value, "mySinger");
            return (Criteria) this;
        }

        public Criteria andMySingerNotEqualTo(String value) {
            addCriterion("my_singer <>", value, "mySinger");
            return (Criteria) this;
        }

        public Criteria andMySingerGreaterThan(String value) {
            addCriterion("my_singer >", value, "mySinger");
            return (Criteria) this;
        }

        public Criteria andMySingerGreaterThanOrEqualTo(String value) {
            addCriterion("my_singer >=", value, "mySinger");
            return (Criteria) this;
        }

        public Criteria andMySingerLessThan(String value) {
            addCriterion("my_singer <", value, "mySinger");
            return (Criteria) this;
        }

        public Criteria andMySingerLessThanOrEqualTo(String value) {
            addCriterion("my_singer <=", value, "mySinger");
            return (Criteria) this;
        }

        public Criteria andMySingerLike(String value) {
            addCriterion("my_singer like", value, "mySinger");
            return (Criteria) this;
        }

        public Criteria andMySingerNotLike(String value) {
            addCriterion("my_singer not like", value, "mySinger");
            return (Criteria) this;
        }

        public Criteria andMySingerIn(List<String> values) {
            addCriterion("my_singer in", values, "mySinger");
            return (Criteria) this;
        }

        public Criteria andMySingerNotIn(List<String> values) {
            addCriterion("my_singer not in", values, "mySinger");
            return (Criteria) this;
        }

        public Criteria andMySingerBetween(String value1, String value2) {
            addCriterion("my_singer between", value1, value2, "mySinger");
            return (Criteria) this;
        }

        public Criteria andMySingerNotBetween(String value1, String value2) {
            addCriterion("my_singer not between", value1, value2, "mySinger");
            return (Criteria) this;
        }

        public Criteria andMySonglinkIsNull() {
            addCriterion("my_songLink is null");
            return (Criteria) this;
        }

        public Criteria andMySonglinkIsNotNull() {
            addCriterion("my_songLink is not null");
            return (Criteria) this;
        }

        public Criteria andMySonglinkEqualTo(String value) {
            addCriterion("my_songLink =", value, "mySonglink");
            return (Criteria) this;
        }

        public Criteria andMySonglinkNotEqualTo(String value) {
            addCriterion("my_songLink <>", value, "mySonglink");
            return (Criteria) this;
        }

        public Criteria andMySonglinkGreaterThan(String value) {
            addCriterion("my_songLink >", value, "mySonglink");
            return (Criteria) this;
        }

        public Criteria andMySonglinkGreaterThanOrEqualTo(String value) {
            addCriterion("my_songLink >=", value, "mySonglink");
            return (Criteria) this;
        }

        public Criteria andMySonglinkLessThan(String value) {
            addCriterion("my_songLink <", value, "mySonglink");
            return (Criteria) this;
        }

        public Criteria andMySonglinkLessThanOrEqualTo(String value) {
            addCriterion("my_songLink <=", value, "mySonglink");
            return (Criteria) this;
        }

        public Criteria andMySonglinkLike(String value) {
            addCriterion("my_songLink like", value, "mySonglink");
            return (Criteria) this;
        }

        public Criteria andMySonglinkNotLike(String value) {
            addCriterion("my_songLink not like", value, "mySonglink");
            return (Criteria) this;
        }

        public Criteria andMySonglinkIn(List<String> values) {
            addCriterion("my_songLink in", values, "mySonglink");
            return (Criteria) this;
        }

        public Criteria andMySonglinkNotIn(List<String> values) {
            addCriterion("my_songLink not in", values, "mySonglink");
            return (Criteria) this;
        }

        public Criteria andMySonglinkBetween(String value1, String value2) {
            addCriterion("my_songLink between", value1, value2, "mySonglink");
            return (Criteria) this;
        }

        public Criteria andMySonglinkNotBetween(String value1, String value2) {
            addCriterion("my_songLink not between", value1, value2, "mySonglink");
            return (Criteria) this;
        }

        public Criteria andMyLyriclinkIsNull() {
            addCriterion("my_lyricLink is null");
            return (Criteria) this;
        }

        public Criteria andMyLyriclinkIsNotNull() {
            addCriterion("my_lyricLink is not null");
            return (Criteria) this;
        }

        public Criteria andMyLyriclinkEqualTo(String value) {
            addCriterion("my_lyricLink =", value, "myLyriclink");
            return (Criteria) this;
        }

        public Criteria andMyLyriclinkNotEqualTo(String value) {
            addCriterion("my_lyricLink <>", value, "myLyriclink");
            return (Criteria) this;
        }

        public Criteria andMyLyriclinkGreaterThan(String value) {
            addCriterion("my_lyricLink >", value, "myLyriclink");
            return (Criteria) this;
        }

        public Criteria andMyLyriclinkGreaterThanOrEqualTo(String value) {
            addCriterion("my_lyricLink >=", value, "myLyriclink");
            return (Criteria) this;
        }

        public Criteria andMyLyriclinkLessThan(String value) {
            addCriterion("my_lyricLink <", value, "myLyriclink");
            return (Criteria) this;
        }

        public Criteria andMyLyriclinkLessThanOrEqualTo(String value) {
            addCriterion("my_lyricLink <=", value, "myLyriclink");
            return (Criteria) this;
        }

        public Criteria andMyLyriclinkLike(String value) {
            addCriterion("my_lyricLink like", value, "myLyriclink");
            return (Criteria) this;
        }

        public Criteria andMyLyriclinkNotLike(String value) {
            addCriterion("my_lyricLink not like", value, "myLyriclink");
            return (Criteria) this;
        }

        public Criteria andMyLyriclinkIn(List<String> values) {
            addCriterion("my_lyricLink in", values, "myLyriclink");
            return (Criteria) this;
        }

        public Criteria andMyLyriclinkNotIn(List<String> values) {
            addCriterion("my_lyricLink not in", values, "myLyriclink");
            return (Criteria) this;
        }

        public Criteria andMyLyriclinkBetween(String value1, String value2) {
            addCriterion("my_lyricLink between", value1, value2, "myLyriclink");
            return (Criteria) this;
        }

        public Criteria andMyLyriclinkNotBetween(String value1, String value2) {
            addCriterion("my_lyricLink not between", value1, value2, "myLyriclink");
            return (Criteria) this;
        }

        public Criteria andMyPhotolinkIsNull() {
            addCriterion("my_photoLink is null");
            return (Criteria) this;
        }

        public Criteria andMyPhotolinkIsNotNull() {
            addCriterion("my_photoLink is not null");
            return (Criteria) this;
        }

        public Criteria andMyPhotolinkEqualTo(String value) {
            addCriterion("my_photoLink =", value, "myPhotolink");
            return (Criteria) this;
        }

        public Criteria andMyPhotolinkNotEqualTo(String value) {
            addCriterion("my_photoLink <>", value, "myPhotolink");
            return (Criteria) this;
        }

        public Criteria andMyPhotolinkGreaterThan(String value) {
            addCriterion("my_photoLink >", value, "myPhotolink");
            return (Criteria) this;
        }

        public Criteria andMyPhotolinkGreaterThanOrEqualTo(String value) {
            addCriterion("my_photoLink >=", value, "myPhotolink");
            return (Criteria) this;
        }

        public Criteria andMyPhotolinkLessThan(String value) {
            addCriterion("my_photoLink <", value, "myPhotolink");
            return (Criteria) this;
        }

        public Criteria andMyPhotolinkLessThanOrEqualTo(String value) {
            addCriterion("my_photoLink <=", value, "myPhotolink");
            return (Criteria) this;
        }

        public Criteria andMyPhotolinkLike(String value) {
            addCriterion("my_photoLink like", value, "myPhotolink");
            return (Criteria) this;
        }

        public Criteria andMyPhotolinkNotLike(String value) {
            addCriterion("my_photoLink not like", value, "myPhotolink");
            return (Criteria) this;
        }

        public Criteria andMyPhotolinkIn(List<String> values) {
            addCriterion("my_photoLink in", values, "myPhotolink");
            return (Criteria) this;
        }

        public Criteria andMyPhotolinkNotIn(List<String> values) {
            addCriterion("my_photoLink not in", values, "myPhotolink");
            return (Criteria) this;
        }

        public Criteria andMyPhotolinkBetween(String value1, String value2) {
            addCriterion("my_photoLink between", value1, value2, "myPhotolink");
            return (Criteria) this;
        }

        public Criteria andMyPhotolinkNotBetween(String value1, String value2) {
            addCriterion("my_photoLink not between", value1, value2, "myPhotolink");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }
    }

    /**
    /* 
     * @author zhoubin 
     * @create 2020-05-10
     * @since 1.0.0
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
    /* 
     * @author zhoubin 
     * @create 2020-05-10
     * @since 1.0.0
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}