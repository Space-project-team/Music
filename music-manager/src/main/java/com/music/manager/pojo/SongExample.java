package com.music.manager.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SongExample {
    /**
     * song
     */
    protected String orderByClause;

    /**
     * song
     */
    protected boolean distinct;

    /**
     * song
     */
    protected List<Criteria> oredCriteria;

    public SongExample() {
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
     * @create 2020-05-15
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

        public Criteria andSongidIsNull() {
            addCriterion("songID is null");
            return (Criteria) this;
        }

        public Criteria andSongidIsNotNull() {
            addCriterion("songID is not null");
            return (Criteria) this;
        }

        public Criteria andSongidEqualTo(String value) {
            addCriterion("songID =", value, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidNotEqualTo(String value) {
            addCriterion("songID <>", value, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidGreaterThan(String value) {
            addCriterion("songID >", value, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidGreaterThanOrEqualTo(String value) {
            addCriterion("songID >=", value, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidLessThan(String value) {
            addCriterion("songID <", value, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidLessThanOrEqualTo(String value) {
            addCriterion("songID <=", value, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidLike(String value) {
            addCriterion("songID like", value, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidNotLike(String value) {
            addCriterion("songID not like", value, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidIn(List<String> values) {
            addCriterion("songID in", values, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidNotIn(List<String> values) {
            addCriterion("songID not in", values, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidBetween(String value1, String value2) {
            addCriterion("songID between", value1, value2, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidNotBetween(String value1, String value2) {
            addCriterion("songID not between", value1, value2, "songid");
            return (Criteria) this;
        }

        public Criteria andSongnameIsNull() {
            addCriterion("songName is null");
            return (Criteria) this;
        }

        public Criteria andSongnameIsNotNull() {
            addCriterion("songName is not null");
            return (Criteria) this;
        }

        public Criteria andSongnameEqualTo(String value) {
            addCriterion("songName =", value, "songname");
            return (Criteria) this;
        }

        public Criteria andSongnameNotEqualTo(String value) {
            addCriterion("songName <>", value, "songname");
            return (Criteria) this;
        }

        public Criteria andSongnameGreaterThan(String value) {
            addCriterion("songName >", value, "songname");
            return (Criteria) this;
        }

        public Criteria andSongnameGreaterThanOrEqualTo(String value) {
            addCriterion("songName >=", value, "songname");
            return (Criteria) this;
        }

        public Criteria andSongnameLessThan(String value) {
            addCriterion("songName <", value, "songname");
            return (Criteria) this;
        }

        public Criteria andSongnameLessThanOrEqualTo(String value) {
            addCriterion("songName <=", value, "songname");
            return (Criteria) this;
        }

        public Criteria andSongnameLike(String value) {
            addCriterion("songName like", value, "songname");
            return (Criteria) this;
        }

        public Criteria andSongnameNotLike(String value) {
            addCriterion("songName not like", value, "songname");
            return (Criteria) this;
        }

        public Criteria andSongnameIn(List<String> values) {
            addCriterion("songName in", values, "songname");
            return (Criteria) this;
        }

        public Criteria andSongnameNotIn(List<String> values) {
            addCriterion("songName not in", values, "songname");
            return (Criteria) this;
        }

        public Criteria andSongnameBetween(String value1, String value2) {
            addCriterion("songName between", value1, value2, "songname");
            return (Criteria) this;
        }

        public Criteria andSongnameNotBetween(String value1, String value2) {
            addCriterion("songName not between", value1, value2, "songname");
            return (Criteria) this;
        }

        public Criteria andSingeridIsNull() {
            addCriterion("singerID is null");
            return (Criteria) this;
        }

        public Criteria andSingeridIsNotNull() {
            addCriterion("singerID is not null");
            return (Criteria) this;
        }

        public Criteria andSingeridEqualTo(String value) {
            addCriterion("singerID =", value, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridNotEqualTo(String value) {
            addCriterion("singerID <>", value, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridGreaterThan(String value) {
            addCriterion("singerID >", value, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridGreaterThanOrEqualTo(String value) {
            addCriterion("singerID >=", value, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridLessThan(String value) {
            addCriterion("singerID <", value, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridLessThanOrEqualTo(String value) {
            addCriterion("singerID <=", value, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridLike(String value) {
            addCriterion("singerID like", value, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridNotLike(String value) {
            addCriterion("singerID not like", value, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridIn(List<String> values) {
            addCriterion("singerID in", values, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridNotIn(List<String> values) {
            addCriterion("singerID not in", values, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridBetween(String value1, String value2) {
            addCriterion("singerID between", value1, value2, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridNotBetween(String value1, String value2) {
            addCriterion("singerID not between", value1, value2, "singerid");
            return (Criteria) this;
        }

        public Criteria andVotesIsNull() {
            addCriterion("votes is null");
            return (Criteria) this;
        }

        public Criteria andVotesIsNotNull() {
            addCriterion("votes is not null");
            return (Criteria) this;
        }

        public Criteria andVotesEqualTo(String value) {
            addCriterion("votes =", value, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesNotEqualTo(String value) {
            addCriterion("votes <>", value, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesGreaterThan(String value) {
            addCriterion("votes >", value, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesGreaterThanOrEqualTo(String value) {
            addCriterion("votes >=", value, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesLessThan(String value) {
            addCriterion("votes <", value, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesLessThanOrEqualTo(String value) {
            addCriterion("votes <=", value, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesLike(String value) {
            addCriterion("votes like", value, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesNotLike(String value) {
            addCriterion("votes not like", value, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesIn(List<String> values) {
            addCriterion("votes in", values, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesNotIn(List<String> values) {
            addCriterion("votes not in", values, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesBetween(String value1, String value2) {
            addCriterion("votes between", value1, value2, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesNotBetween(String value1, String value2) {
            addCriterion("votes not between", value1, value2, "votes");
            return (Criteria) this;
        }

        public Criteria andSongfileIsNull() {
            addCriterion("songFile is null");
            return (Criteria) this;
        }

        public Criteria andSongfileIsNotNull() {
            addCriterion("songFile is not null");
            return (Criteria) this;
        }

        public Criteria andSongfileEqualTo(String value) {
            addCriterion("songFile =", value, "songfile");
            return (Criteria) this;
        }

        public Criteria andSongfileNotEqualTo(String value) {
            addCriterion("songFile <>", value, "songfile");
            return (Criteria) this;
        }

        public Criteria andSongfileGreaterThan(String value) {
            addCriterion("songFile >", value, "songfile");
            return (Criteria) this;
        }

        public Criteria andSongfileGreaterThanOrEqualTo(String value) {
            addCriterion("songFile >=", value, "songfile");
            return (Criteria) this;
        }

        public Criteria andSongfileLessThan(String value) {
            addCriterion("songFile <", value, "songfile");
            return (Criteria) this;
        }

        public Criteria andSongfileLessThanOrEqualTo(String value) {
            addCriterion("songFile <=", value, "songfile");
            return (Criteria) this;
        }

        public Criteria andSongfileLike(String value) {
            addCriterion("songFile like", value, "songfile");
            return (Criteria) this;
        }

        public Criteria andSongfileNotLike(String value) {
            addCriterion("songFile not like", value, "songfile");
            return (Criteria) this;
        }

        public Criteria andSongfileIn(List<String> values) {
            addCriterion("songFile in", values, "songfile");
            return (Criteria) this;
        }

        public Criteria andSongfileNotIn(List<String> values) {
            addCriterion("songFile not in", values, "songfile");
            return (Criteria) this;
        }

        public Criteria andSongfileBetween(String value1, String value2) {
            addCriterion("songFile between", value1, value2, "songfile");
            return (Criteria) this;
        }

        public Criteria andSongfileNotBetween(String value1, String value2) {
            addCriterion("songFile not between", value1, value2, "songfile");
            return (Criteria) this;
        }

        public Criteria andPhotoimageIsNull() {
            addCriterion("photoImage is null");
            return (Criteria) this;
        }

        public Criteria andPhotoimageIsNotNull() {
            addCriterion("photoImage is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoimageEqualTo(String value) {
            addCriterion("photoImage =", value, "photoimage");
            return (Criteria) this;
        }

        public Criteria andPhotoimageNotEqualTo(String value) {
            addCriterion("photoImage <>", value, "photoimage");
            return (Criteria) this;
        }

        public Criteria andPhotoimageGreaterThan(String value) {
            addCriterion("photoImage >", value, "photoimage");
            return (Criteria) this;
        }

        public Criteria andPhotoimageGreaterThanOrEqualTo(String value) {
            addCriterion("photoImage >=", value, "photoimage");
            return (Criteria) this;
        }

        public Criteria andPhotoimageLessThan(String value) {
            addCriterion("photoImage <", value, "photoimage");
            return (Criteria) this;
        }

        public Criteria andPhotoimageLessThanOrEqualTo(String value) {
            addCriterion("photoImage <=", value, "photoimage");
            return (Criteria) this;
        }

        public Criteria andPhotoimageLike(String value) {
            addCriterion("photoImage like", value, "photoimage");
            return (Criteria) this;
        }

        public Criteria andPhotoimageNotLike(String value) {
            addCriterion("photoImage not like", value, "photoimage");
            return (Criteria) this;
        }

        public Criteria andPhotoimageIn(List<String> values) {
            addCriterion("photoImage in", values, "photoimage");
            return (Criteria) this;
        }

        public Criteria andPhotoimageNotIn(List<String> values) {
            addCriterion("photoImage not in", values, "photoimage");
            return (Criteria) this;
        }

        public Criteria andPhotoimageBetween(String value1, String value2) {
            addCriterion("photoImage between", value1, value2, "photoimage");
            return (Criteria) this;
        }

        public Criteria andPhotoimageNotBetween(String value1, String value2) {
            addCriterion("photoImage not between", value1, value2, "photoimage");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNull() {
            addCriterion("TypeID is null");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNotNull() {
            addCriterion("TypeID is not null");
            return (Criteria) this;
        }

        public Criteria andTypeidEqualTo(String value) {
            addCriterion("TypeID =", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotEqualTo(String value) {
            addCriterion("TypeID <>", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThan(String value) {
            addCriterion("TypeID >", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThanOrEqualTo(String value) {
            addCriterion("TypeID >=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThan(String value) {
            addCriterion("TypeID <", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThanOrEqualTo(String value) {
            addCriterion("TypeID <=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLike(String value) {
            addCriterion("TypeID like", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotLike(String value) {
            addCriterion("TypeID not like", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidIn(List<String> values) {
            addCriterion("TypeID in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotIn(List<String> values) {
            addCriterion("TypeID not in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidBetween(String value1, String value2) {
            addCriterion("TypeID between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotBetween(String value1, String value2) {
            addCriterion("TypeID not between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    /**
    /* 
     * @author zhoubin 
     * @create 2020-05-15
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
     * @create 2020-05-15
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