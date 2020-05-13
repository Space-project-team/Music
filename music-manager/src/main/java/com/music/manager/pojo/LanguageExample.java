package com.music.manager.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LanguageExample implements Serializable {
    /**
     * language
     */
    protected String orderByClause;

    /**
     * language
     */
    protected boolean distinct;

    /**
     * language
     */
    protected List<Criteria> oredCriteria;

    public LanguageExample() {
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
     * @create 2020-05-12
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

        public Criteria andLanguageidIsNull() {
            addCriterion("languageID is null");
            return (Criteria) this;
        }

        public Criteria andLanguageidIsNotNull() {
            addCriterion("languageID is not null");
            return (Criteria) this;
        }

        public Criteria andLanguageidEqualTo(String value) {
            addCriterion("languageID =", value, "languageid");
            return (Criteria) this;
        }

        public Criteria andLanguageidNotEqualTo(String value) {
            addCriterion("languageID <>", value, "languageid");
            return (Criteria) this;
        }

        public Criteria andLanguageidGreaterThan(String value) {
            addCriterion("languageID >", value, "languageid");
            return (Criteria) this;
        }

        public Criteria andLanguageidGreaterThanOrEqualTo(String value) {
            addCriterion("languageID >=", value, "languageid");
            return (Criteria) this;
        }

        public Criteria andLanguageidLessThan(String value) {
            addCriterion("languageID <", value, "languageid");
            return (Criteria) this;
        }

        public Criteria andLanguageidLessThanOrEqualTo(String value) {
            addCriterion("languageID <=", value, "languageid");
            return (Criteria) this;
        }

        public Criteria andLanguageidLike(String value) {
            addCriterion("languageID like", value, "languageid");
            return (Criteria) this;
        }

        public Criteria andLanguageidNotLike(String value) {
            addCriterion("languageID not like", value, "languageid");
            return (Criteria) this;
        }

        public Criteria andLanguageidIn(List<String> values) {
            addCriterion("languageID in", values, "languageid");
            return (Criteria) this;
        }

        public Criteria andLanguageidNotIn(List<String> values) {
            addCriterion("languageID not in", values, "languageid");
            return (Criteria) this;
        }

        public Criteria andLanguageidBetween(String value1, String value2) {
            addCriterion("languageID between", value1, value2, "languageid");
            return (Criteria) this;
        }

        public Criteria andLanguageidNotBetween(String value1, String value2) {
            addCriterion("languageID not between", value1, value2, "languageid");
            return (Criteria) this;
        }

        public Criteria andLanguagenameIsNull() {
            addCriterion("languageName is null");
            return (Criteria) this;
        }

        public Criteria andLanguagenameIsNotNull() {
            addCriterion("languageName is not null");
            return (Criteria) this;
        }

        public Criteria andLanguagenameEqualTo(String value) {
            addCriterion("languageName =", value, "languagename");
            return (Criteria) this;
        }

        public Criteria andLanguagenameNotEqualTo(String value) {
            addCriterion("languageName <>", value, "languagename");
            return (Criteria) this;
        }

        public Criteria andLanguagenameGreaterThan(String value) {
            addCriterion("languageName >", value, "languagename");
            return (Criteria) this;
        }

        public Criteria andLanguagenameGreaterThanOrEqualTo(String value) {
            addCriterion("languageName >=", value, "languagename");
            return (Criteria) this;
        }

        public Criteria andLanguagenameLessThan(String value) {
            addCriterion("languageName <", value, "languagename");
            return (Criteria) this;
        }

        public Criteria andLanguagenameLessThanOrEqualTo(String value) {
            addCriterion("languageName <=", value, "languagename");
            return (Criteria) this;
        }

        public Criteria andLanguagenameLike(String value) {
            addCriterion("languageName like", value, "languagename");
            return (Criteria) this;
        }

        public Criteria andLanguagenameNotLike(String value) {
            addCriterion("languageName not like", value, "languagename");
            return (Criteria) this;
        }

        public Criteria andLanguagenameIn(List<String> values) {
            addCriterion("languageName in", values, "languagename");
            return (Criteria) this;
        }

        public Criteria andLanguagenameNotIn(List<String> values) {
            addCriterion("languageName not in", values, "languagename");
            return (Criteria) this;
        }

        public Criteria andLanguagenameBetween(String value1, String value2) {
            addCriterion("languageName between", value1, value2, "languagename");
            return (Criteria) this;
        }

        public Criteria andLanguagenameNotBetween(String value1, String value2) {
            addCriterion("languageName not between", value1, value2, "languagename");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNull() {
            addCriterion("typeID is null");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNotNull() {
            addCriterion("typeID is not null");
            return (Criteria) this;
        }

        public Criteria andTypeidEqualTo(Integer value) {
            addCriterion("typeID =", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotEqualTo(Integer value) {
            addCriterion("typeID <>", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThan(Integer value) {
            addCriterion("typeID >", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("typeID >=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThan(Integer value) {
            addCriterion("typeID <", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThanOrEqualTo(Integer value) {
            addCriterion("typeID <=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidIn(List<Integer> values) {
            addCriterion("typeID in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotIn(List<Integer> values) {
            addCriterion("typeID not in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidBetween(Integer value1, Integer value2) {
            addCriterion("typeID between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("typeID not between", value1, value2, "typeid");
            return (Criteria) this;
        }
    }

    /**
    /* 
     * @author zhoubin 
     * @create 2020-05-12
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
     * @create 2020-05-12
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