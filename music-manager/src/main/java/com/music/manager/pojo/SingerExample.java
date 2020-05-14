package com.music.manager.pojo;

import java.util.ArrayList;
import java.util.List;

public class SingerExample {
    /**
     * singer
     */
    protected String orderByClause;

    /**
     * singer
     */
    protected boolean distinct;

    /**
     * singer
     */
    protected List<Criteria> oredCriteria;

    public SingerExample() {
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
     * @create 2020-05-14
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

        public Criteria andSingernameIsNull() {
            addCriterion("singerName is null");
            return (Criteria) this;
        }

        public Criteria andSingernameIsNotNull() {
            addCriterion("singerName is not null");
            return (Criteria) this;
        }

        public Criteria andSingernameEqualTo(String value) {
            addCriterion("singerName =", value, "singername");
            return (Criteria) this;
        }

        public Criteria andSingernameNotEqualTo(String value) {
            addCriterion("singerName <>", value, "singername");
            return (Criteria) this;
        }

        public Criteria andSingernameGreaterThan(String value) {
            addCriterion("singerName >", value, "singername");
            return (Criteria) this;
        }

        public Criteria andSingernameGreaterThanOrEqualTo(String value) {
            addCriterion("singerName >=", value, "singername");
            return (Criteria) this;
        }

        public Criteria andSingernameLessThan(String value) {
            addCriterion("singerName <", value, "singername");
            return (Criteria) this;
        }

        public Criteria andSingernameLessThanOrEqualTo(String value) {
            addCriterion("singerName <=", value, "singername");
            return (Criteria) this;
        }

        public Criteria andSingernameLike(String value) {
            addCriterion("singerName like", value, "singername");
            return (Criteria) this;
        }

        public Criteria andSingernameNotLike(String value) {
            addCriterion("singerName not like", value, "singername");
            return (Criteria) this;
        }

        public Criteria andSingernameIn(List<String> values) {
            addCriterion("singerName in", values, "singername");
            return (Criteria) this;
        }

        public Criteria andSingernameNotIn(List<String> values) {
            addCriterion("singerName not in", values, "singername");
            return (Criteria) this;
        }

        public Criteria andSingernameBetween(String value1, String value2) {
            addCriterion("singerName between", value1, value2, "singername");
            return (Criteria) this;
        }

        public Criteria andSingernameNotBetween(String value1, String value2) {
            addCriterion("singerName not between", value1, value2, "singername");
            return (Criteria) this;
        }

        public Criteria andIsgroupIsNull() {
            addCriterion("isGroup is null");
            return (Criteria) this;
        }

        public Criteria andIsgroupIsNotNull() {
            addCriterion("isGroup is not null");
            return (Criteria) this;
        }

        public Criteria andIsgroupEqualTo(String value) {
            addCriterion("isGroup =", value, "isgroup");
            return (Criteria) this;
        }

        public Criteria andIsgroupNotEqualTo(String value) {
            addCriterion("isGroup <>", value, "isgroup");
            return (Criteria) this;
        }

        public Criteria andIsgroupGreaterThan(String value) {
            addCriterion("isGroup >", value, "isgroup");
            return (Criteria) this;
        }

        public Criteria andIsgroupGreaterThanOrEqualTo(String value) {
            addCriterion("isGroup >=", value, "isgroup");
            return (Criteria) this;
        }

        public Criteria andIsgroupLessThan(String value) {
            addCriterion("isGroup <", value, "isgroup");
            return (Criteria) this;
        }

        public Criteria andIsgroupLessThanOrEqualTo(String value) {
            addCriterion("isGroup <=", value, "isgroup");
            return (Criteria) this;
        }

        public Criteria andIsgroupLike(String value) {
            addCriterion("isGroup like", value, "isgroup");
            return (Criteria) this;
        }

        public Criteria andIsgroupNotLike(String value) {
            addCriterion("isGroup not like", value, "isgroup");
            return (Criteria) this;
        }

        public Criteria andIsgroupIn(List<String> values) {
            addCriterion("isGroup in", values, "isgroup");
            return (Criteria) this;
        }

        public Criteria andIsgroupNotIn(List<String> values) {
            addCriterion("isGroup not in", values, "isgroup");
            return (Criteria) this;
        }

        public Criteria andIsgroupBetween(String value1, String value2) {
            addCriterion("isGroup between", value1, value2, "isgroup");
            return (Criteria) this;
        }

        public Criteria andIsgroupNotBetween(String value1, String value2) {
            addCriterion("isGroup not between", value1, value2, "isgroup");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andFansIsNull() {
            addCriterion("fans is null");
            return (Criteria) this;
        }

        public Criteria andFansIsNotNull() {
            addCriterion("fans is not null");
            return (Criteria) this;
        }

        public Criteria andFansEqualTo(Integer value) {
            addCriterion("fans =", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansNotEqualTo(Integer value) {
            addCriterion("fans <>", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansGreaterThan(Integer value) {
            addCriterion("fans >", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansGreaterThanOrEqualTo(Integer value) {
            addCriterion("fans >=", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansLessThan(Integer value) {
            addCriterion("fans <", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansLessThanOrEqualTo(Integer value) {
            addCriterion("fans <=", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansIn(List<Integer> values) {
            addCriterion("fans in", values, "fans");
            return (Criteria) this;
        }

        public Criteria andFansNotIn(List<Integer> values) {
            addCriterion("fans not in", values, "fans");
            return (Criteria) this;
        }

        public Criteria andFansBetween(Integer value1, Integer value2) {
            addCriterion("fans between", value1, value2, "fans");
            return (Criteria) this;
        }

        public Criteria andFansNotBetween(Integer value1, Integer value2) {
            addCriterion("fans not between", value1, value2, "fans");
            return (Criteria) this;
        }

        public Criteria andHeadimageIsNull() {
            addCriterion("headImage is null");
            return (Criteria) this;
        }

        public Criteria andHeadimageIsNotNull() {
            addCriterion("headImage is not null");
            return (Criteria) this;
        }

        public Criteria andHeadimageEqualTo(String value) {
            addCriterion("headImage =", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageNotEqualTo(String value) {
            addCriterion("headImage <>", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageGreaterThan(String value) {
            addCriterion("headImage >", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageGreaterThanOrEqualTo(String value) {
            addCriterion("headImage >=", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageLessThan(String value) {
            addCriterion("headImage <", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageLessThanOrEqualTo(String value) {
            addCriterion("headImage <=", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageLike(String value) {
            addCriterion("headImage like", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageNotLike(String value) {
            addCriterion("headImage not like", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageIn(List<String> values) {
            addCriterion("headImage in", values, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageNotIn(List<String> values) {
            addCriterion("headImage not in", values, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageBetween(String value1, String value2) {
            addCriterion("headImage between", value1, value2, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageNotBetween(String value1, String value2) {
            addCriterion("headImage not between", value1, value2, "headimage");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andGroupsIsNull() {
            addCriterion("groups is null");
            return (Criteria) this;
        }

        public Criteria andGroupsIsNotNull() {
            addCriterion("groups is not null");
            return (Criteria) this;
        }

        public Criteria andGroupsEqualTo(String value) {
            addCriterion("groups =", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsNotEqualTo(String value) {
            addCriterion("groups <>", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsGreaterThan(String value) {
            addCriterion("groups >", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsGreaterThanOrEqualTo(String value) {
            addCriterion("groups >=", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsLessThan(String value) {
            addCriterion("groups <", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsLessThanOrEqualTo(String value) {
            addCriterion("groups <=", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsLike(String value) {
            addCriterion("groups like", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsNotLike(String value) {
            addCriterion("groups not like", value, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsIn(List<String> values) {
            addCriterion("groups in", values, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsNotIn(List<String> values) {
            addCriterion("groups not in", values, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsBetween(String value1, String value2) {
            addCriterion("groups between", value1, value2, "groups");
            return (Criteria) this;
        }

        public Criteria andGroupsNotBetween(String value1, String value2) {
            addCriterion("groups not between", value1, value2, "groups");
            return (Criteria) this;
        }
    }

    /**
    /* 
     * @author zhoubin 
     * @create 2020-05-14
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
     * @create 2020-05-14
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