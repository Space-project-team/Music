package com.music.manager.pojo;

import java.util.ArrayList;
import java.util.List;

public class MusicLinkExample {
    /**
     * musiclink
     */
    protected String orderByClause;

    /**
     * musiclink
     */
    protected boolean distinct;

    /**
     * musiclink
     */
    protected List<Criteria> oredCriteria;

    public MusicLinkExample() {
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

        public Criteria andMlIdIsNull() {
            addCriterion("ml_id is null");
            return (Criteria) this;
        }

        public Criteria andMlIdIsNotNull() {
            addCriterion("ml_id is not null");
            return (Criteria) this;
        }

        public Criteria andMlIdEqualTo(Integer value) {
            addCriterion("ml_id =", value, "mlId");
            return (Criteria) this;
        }

        public Criteria andMlIdNotEqualTo(Integer value) {
            addCriterion("ml_id <>", value, "mlId");
            return (Criteria) this;
        }

        public Criteria andMlIdGreaterThan(Integer value) {
            addCriterion("ml_id >", value, "mlId");
            return (Criteria) this;
        }

        public Criteria andMlIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ml_id >=", value, "mlId");
            return (Criteria) this;
        }

        public Criteria andMlIdLessThan(Integer value) {
            addCriterion("ml_id <", value, "mlId");
            return (Criteria) this;
        }

        public Criteria andMlIdLessThanOrEqualTo(Integer value) {
            addCriterion("ml_id <=", value, "mlId");
            return (Criteria) this;
        }

        public Criteria andMlIdIn(List<Integer> values) {
            addCriterion("ml_id in", values, "mlId");
            return (Criteria) this;
        }

        public Criteria andMlIdNotIn(List<Integer> values) {
            addCriterion("ml_id not in", values, "mlId");
            return (Criteria) this;
        }

        public Criteria andMlIdBetween(Integer value1, Integer value2) {
            addCriterion("ml_id between", value1, value2, "mlId");
            return (Criteria) this;
        }

        public Criteria andMlIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ml_id not between", value1, value2, "mlId");
            return (Criteria) this;
        }

        public Criteria andMlSongnameIsNull() {
            addCriterion("ml_songName is null");
            return (Criteria) this;
        }

        public Criteria andMlSongnameIsNotNull() {
            addCriterion("ml_songName is not null");
            return (Criteria) this;
        }

        public Criteria andMlSongnameEqualTo(String value) {
            addCriterion("ml_songName =", value, "mlSongname");
            return (Criteria) this;
        }

        public Criteria andMlSongnameNotEqualTo(String value) {
            addCriterion("ml_songName <>", value, "mlSongname");
            return (Criteria) this;
        }

        public Criteria andMlSongnameGreaterThan(String value) {
            addCriterion("ml_songName >", value, "mlSongname");
            return (Criteria) this;
        }

        public Criteria andMlSongnameGreaterThanOrEqualTo(String value) {
            addCriterion("ml_songName >=", value, "mlSongname");
            return (Criteria) this;
        }

        public Criteria andMlSongnameLessThan(String value) {
            addCriterion("ml_songName <", value, "mlSongname");
            return (Criteria) this;
        }

        public Criteria andMlSongnameLessThanOrEqualTo(String value) {
            addCriterion("ml_songName <=", value, "mlSongname");
            return (Criteria) this;
        }

        public Criteria andMlSongnameLike(String value) {
            addCriterion("ml_songName like", value, "mlSongname");
            return (Criteria) this;
        }

        public Criteria andMlSongnameNotLike(String value) {
            addCriterion("ml_songName not like", value, "mlSongname");
            return (Criteria) this;
        }

        public Criteria andMlSongnameIn(List<String> values) {
            addCriterion("ml_songName in", values, "mlSongname");
            return (Criteria) this;
        }

        public Criteria andMlSongnameNotIn(List<String> values) {
            addCriterion("ml_songName not in", values, "mlSongname");
            return (Criteria) this;
        }

        public Criteria andMlSongnameBetween(String value1, String value2) {
            addCriterion("ml_songName between", value1, value2, "mlSongname");
            return (Criteria) this;
        }

        public Criteria andMlSongnameNotBetween(String value1, String value2) {
            addCriterion("ml_songName not between", value1, value2, "mlSongname");
            return (Criteria) this;
        }

        public Criteria andMlSingerIsNull() {
            addCriterion("ml_singer is null");
            return (Criteria) this;
        }

        public Criteria andMlSingerIsNotNull() {
            addCriterion("ml_singer is not null");
            return (Criteria) this;
        }

        public Criteria andMlSingerEqualTo(String value) {
            addCriterion("ml_singer =", value, "mlSinger");
            return (Criteria) this;
        }

        public Criteria andMlSingerNotEqualTo(String value) {
            addCriterion("ml_singer <>", value, "mlSinger");
            return (Criteria) this;
        }

        public Criteria andMlSingerGreaterThan(String value) {
            addCriterion("ml_singer >", value, "mlSinger");
            return (Criteria) this;
        }

        public Criteria andMlSingerGreaterThanOrEqualTo(String value) {
            addCriterion("ml_singer >=", value, "mlSinger");
            return (Criteria) this;
        }

        public Criteria andMlSingerLessThan(String value) {
            addCriterion("ml_singer <", value, "mlSinger");
            return (Criteria) this;
        }

        public Criteria andMlSingerLessThanOrEqualTo(String value) {
            addCriterion("ml_singer <=", value, "mlSinger");
            return (Criteria) this;
        }

        public Criteria andMlSingerLike(String value) {
            addCriterion("ml_singer like", value, "mlSinger");
            return (Criteria) this;
        }

        public Criteria andMlSingerNotLike(String value) {
            addCriterion("ml_singer not like", value, "mlSinger");
            return (Criteria) this;
        }

        public Criteria andMlSingerIn(List<String> values) {
            addCriterion("ml_singer in", values, "mlSinger");
            return (Criteria) this;
        }

        public Criteria andMlSingerNotIn(List<String> values) {
            addCriterion("ml_singer not in", values, "mlSinger");
            return (Criteria) this;
        }

        public Criteria andMlSingerBetween(String value1, String value2) {
            addCriterion("ml_singer between", value1, value2, "mlSinger");
            return (Criteria) this;
        }

        public Criteria andMlSingerNotBetween(String value1, String value2) {
            addCriterion("ml_singer not between", value1, value2, "mlSinger");
            return (Criteria) this;
        }

        public Criteria andMlSonglinkIsNull() {
            addCriterion("ml_songLink is null");
            return (Criteria) this;
        }

        public Criteria andMlSonglinkIsNotNull() {
            addCriterion("ml_songLink is not null");
            return (Criteria) this;
        }

        public Criteria andMlSonglinkEqualTo(String value) {
            addCriterion("ml_songLink =", value, "mlSonglink");
            return (Criteria) this;
        }

        public Criteria andMlSonglinkNotEqualTo(String value) {
            addCriterion("ml_songLink <>", value, "mlSonglink");
            return (Criteria) this;
        }

        public Criteria andMlSonglinkGreaterThan(String value) {
            addCriterion("ml_songLink >", value, "mlSonglink");
            return (Criteria) this;
        }

        public Criteria andMlSonglinkGreaterThanOrEqualTo(String value) {
            addCriterion("ml_songLink >=", value, "mlSonglink");
            return (Criteria) this;
        }

        public Criteria andMlSonglinkLessThan(String value) {
            addCriterion("ml_songLink <", value, "mlSonglink");
            return (Criteria) this;
        }

        public Criteria andMlSonglinkLessThanOrEqualTo(String value) {
            addCriterion("ml_songLink <=", value, "mlSonglink");
            return (Criteria) this;
        }

        public Criteria andMlSonglinkLike(String value) {
            addCriterion("ml_songLink like", value, "mlSonglink");
            return (Criteria) this;
        }

        public Criteria andMlSonglinkNotLike(String value) {
            addCriterion("ml_songLink not like", value, "mlSonglink");
            return (Criteria) this;
        }

        public Criteria andMlSonglinkIn(List<String> values) {
            addCriterion("ml_songLink in", values, "mlSonglink");
            return (Criteria) this;
        }

        public Criteria andMlSonglinkNotIn(List<String> values) {
            addCriterion("ml_songLink not in", values, "mlSonglink");
            return (Criteria) this;
        }

        public Criteria andMlSonglinkBetween(String value1, String value2) {
            addCriterion("ml_songLink between", value1, value2, "mlSonglink");
            return (Criteria) this;
        }

        public Criteria andMlSonglinkNotBetween(String value1, String value2) {
            addCriterion("ml_songLink not between", value1, value2, "mlSonglink");
            return (Criteria) this;
        }

        public Criteria andMlLyriclinkIsNull() {
            addCriterion("ml_lyricLink is null");
            return (Criteria) this;
        }

        public Criteria andMlLyriclinkIsNotNull() {
            addCriterion("ml_lyricLink is not null");
            return (Criteria) this;
        }

        public Criteria andMlLyriclinkEqualTo(String value) {
            addCriterion("ml_lyricLink =", value, "mlLyriclink");
            return (Criteria) this;
        }

        public Criteria andMlLyriclinkNotEqualTo(String value) {
            addCriterion("ml_lyricLink <>", value, "mlLyriclink");
            return (Criteria) this;
        }

        public Criteria andMlLyriclinkGreaterThan(String value) {
            addCriterion("ml_lyricLink >", value, "mlLyriclink");
            return (Criteria) this;
        }

        public Criteria andMlLyriclinkGreaterThanOrEqualTo(String value) {
            addCriterion("ml_lyricLink >=", value, "mlLyriclink");
            return (Criteria) this;
        }

        public Criteria andMlLyriclinkLessThan(String value) {
            addCriterion("ml_lyricLink <", value, "mlLyriclink");
            return (Criteria) this;
        }

        public Criteria andMlLyriclinkLessThanOrEqualTo(String value) {
            addCriterion("ml_lyricLink <=", value, "mlLyriclink");
            return (Criteria) this;
        }

        public Criteria andMlLyriclinkLike(String value) {
            addCriterion("ml_lyricLink like", value, "mlLyriclink");
            return (Criteria) this;
        }

        public Criteria andMlLyriclinkNotLike(String value) {
            addCriterion("ml_lyricLink not like", value, "mlLyriclink");
            return (Criteria) this;
        }

        public Criteria andMlLyriclinkIn(List<String> values) {
            addCriterion("ml_lyricLink in", values, "mlLyriclink");
            return (Criteria) this;
        }

        public Criteria andMlLyriclinkNotIn(List<String> values) {
            addCriterion("ml_lyricLink not in", values, "mlLyriclink");
            return (Criteria) this;
        }

        public Criteria andMlLyriclinkBetween(String value1, String value2) {
            addCriterion("ml_lyricLink between", value1, value2, "mlLyriclink");
            return (Criteria) this;
        }

        public Criteria andMlLyriclinkNotBetween(String value1, String value2) {
            addCriterion("ml_lyricLink not between", value1, value2, "mlLyriclink");
            return (Criteria) this;
        }

        public Criteria andMlPhotolinkIsNull() {
            addCriterion("ml_photoLink is null");
            return (Criteria) this;
        }

        public Criteria andMlPhotolinkIsNotNull() {
            addCriterion("ml_photoLink is not null");
            return (Criteria) this;
        }

        public Criteria andMlPhotolinkEqualTo(String value) {
            addCriterion("ml_photoLink =", value, "mlPhotolink");
            return (Criteria) this;
        }

        public Criteria andMlPhotolinkNotEqualTo(String value) {
            addCriterion("ml_photoLink <>", value, "mlPhotolink");
            return (Criteria) this;
        }

        public Criteria andMlPhotolinkGreaterThan(String value) {
            addCriterion("ml_photoLink >", value, "mlPhotolink");
            return (Criteria) this;
        }

        public Criteria andMlPhotolinkGreaterThanOrEqualTo(String value) {
            addCriterion("ml_photoLink >=", value, "mlPhotolink");
            return (Criteria) this;
        }

        public Criteria andMlPhotolinkLessThan(String value) {
            addCriterion("ml_photoLink <", value, "mlPhotolink");
            return (Criteria) this;
        }

        public Criteria andMlPhotolinkLessThanOrEqualTo(String value) {
            addCriterion("ml_photoLink <=", value, "mlPhotolink");
            return (Criteria) this;
        }

        public Criteria andMlPhotolinkLike(String value) {
            addCriterion("ml_photoLink like", value, "mlPhotolink");
            return (Criteria) this;
        }

        public Criteria andMlPhotolinkNotLike(String value) {
            addCriterion("ml_photoLink not like", value, "mlPhotolink");
            return (Criteria) this;
        }

        public Criteria andMlPhotolinkIn(List<String> values) {
            addCriterion("ml_photoLink in", values, "mlPhotolink");
            return (Criteria) this;
        }

        public Criteria andMlPhotolinkNotIn(List<String> values) {
            addCriterion("ml_photoLink not in", values, "mlPhotolink");
            return (Criteria) this;
        }

        public Criteria andMlPhotolinkBetween(String value1, String value2) {
            addCriterion("ml_photoLink between", value1, value2, "mlPhotolink");
            return (Criteria) this;
        }

        public Criteria andMlPhotolinkNotBetween(String value1, String value2) {
            addCriterion("ml_photoLink not between", value1, value2, "mlPhotolink");
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