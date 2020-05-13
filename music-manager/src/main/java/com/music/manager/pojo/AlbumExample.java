package com.music.manager.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AlbumExample  implements Serializable {
    /**
     * album
     */
    protected String orderByClause;

    /**
     * album
     */
    protected boolean distinct;

    /**
     * album
     */
    protected List<Criteria> oredCriteria;

    public AlbumExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andAlbumidIsNull() {
            addCriterion("albumId is null");
            return (Criteria) this;
        }

        public Criteria andAlbumidIsNotNull() {
            addCriterion("albumId is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumidEqualTo(Integer value) {
            addCriterion("albumId =", value, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidNotEqualTo(Integer value) {
            addCriterion("albumId <>", value, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidGreaterThan(Integer value) {
            addCriterion("albumId >", value, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidGreaterThanOrEqualTo(Integer value) {
            addCriterion("albumId >=", value, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidLessThan(Integer value) {
            addCriterion("albumId <", value, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidLessThanOrEqualTo(Integer value) {
            addCriterion("albumId <=", value, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidIn(List<Integer> values) {
            addCriterion("albumId in", values, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidNotIn(List<Integer> values) {
            addCriterion("albumId not in", values, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidBetween(Integer value1, Integer value2) {
            addCriterion("albumId between", value1, value2, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumidNotBetween(Integer value1, Integer value2) {
            addCriterion("albumId not between", value1, value2, "albumid");
            return (Criteria) this;
        }

        public Criteria andAlbumnameIsNull() {
            addCriterion("albumName is null");
            return (Criteria) this;
        }

        public Criteria andAlbumnameIsNotNull() {
            addCriterion("albumName is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumnameEqualTo(String value) {
            addCriterion("albumName =", value, "albumname");
            return (Criteria) this;
        }

        public Criteria andAlbumnameNotEqualTo(String value) {
            addCriterion("albumName <>", value, "albumname");
            return (Criteria) this;
        }

        public Criteria andAlbumnameGreaterThan(String value) {
            addCriterion("albumName >", value, "albumname");
            return (Criteria) this;
        }

        public Criteria andAlbumnameGreaterThanOrEqualTo(String value) {
            addCriterion("albumName >=", value, "albumname");
            return (Criteria) this;
        }

        public Criteria andAlbumnameLessThan(String value) {
            addCriterion("albumName <", value, "albumname");
            return (Criteria) this;
        }

        public Criteria andAlbumnameLessThanOrEqualTo(String value) {
            addCriterion("albumName <=", value, "albumname");
            return (Criteria) this;
        }

        public Criteria andAlbumnameLike(String value) {
            addCriterion("albumName like", value, "albumname");
            return (Criteria) this;
        }

        public Criteria andAlbumnameNotLike(String value) {
            addCriterion("albumName not like", value, "albumname");
            return (Criteria) this;
        }

        public Criteria andAlbumnameIn(List<String> values) {
            addCriterion("albumName in", values, "albumname");
            return (Criteria) this;
        }

        public Criteria andAlbumnameNotIn(List<String> values) {
            addCriterion("albumName not in", values, "albumname");
            return (Criteria) this;
        }

        public Criteria andAlbumnameBetween(String value1, String value2) {
            addCriterion("albumName between", value1, value2, "albumname");
            return (Criteria) this;
        }

        public Criteria andAlbumnameNotBetween(String value1, String value2) {
            addCriterion("albumName not between", value1, value2, "albumname");
            return (Criteria) this;
        }

        public Criteria andIssuedateIsNull() {
            addCriterion("issueDate is null");
            return (Criteria) this;
        }

        public Criteria andIssuedateIsNotNull() {
            addCriterion("issueDate is not null");
            return (Criteria) this;
        }

        public Criteria andIssuedateEqualTo(Date value) {
            addCriterionForJDBCDate("issueDate =", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("issueDate <>", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateGreaterThan(Date value) {
            addCriterionForJDBCDate("issueDate >", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("issueDate >=", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateLessThan(Date value) {
            addCriterionForJDBCDate("issueDate <", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("issueDate <=", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateIn(List<Date> values) {
            addCriterionForJDBCDate("issueDate in", values, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("issueDate not in", values, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("issueDate between", value1, value2, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("issueDate not between", value1, value2, "issuedate");
            return (Criteria) this;
        }

        public Criteria andSingeridIsNull() {
            addCriterion("singerId is null");
            return (Criteria) this;
        }

        public Criteria andSingeridIsNotNull() {
            addCriterion("singerId is not null");
            return (Criteria) this;
        }

        public Criteria andSingeridEqualTo(Integer value) {
            addCriterion("singerId =", value, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridNotEqualTo(Integer value) {
            addCriterion("singerId <>", value, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridGreaterThan(Integer value) {
            addCriterion("singerId >", value, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridGreaterThanOrEqualTo(Integer value) {
            addCriterion("singerId >=", value, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridLessThan(Integer value) {
            addCriterion("singerId <", value, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridLessThanOrEqualTo(Integer value) {
            addCriterion("singerId <=", value, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridIn(List<Integer> values) {
            addCriterion("singerId in", values, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridNotIn(List<Integer> values) {
            addCriterion("singerId not in", values, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridBetween(Integer value1, Integer value2) {
            addCriterion("singerId between", value1, value2, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridNotBetween(Integer value1, Integer value2) {
            addCriterion("singerId not between", value1, value2, "singerid");
            return (Criteria) this;
        }

        public Criteria andLanguageidIsNull() {
            addCriterion("languageId is null");
            return (Criteria) this;
        }

        public Criteria andLanguageidIsNotNull() {
            addCriterion("languageId is not null");
            return (Criteria) this;
        }

        public Criteria andLanguageidEqualTo(Integer value) {
            addCriterion("languageId =", value, "languageid");
            return (Criteria) this;
        }

        public Criteria andLanguageidNotEqualTo(Integer value) {
            addCriterion("languageId <>", value, "languageid");
            return (Criteria) this;
        }

        public Criteria andLanguageidGreaterThan(Integer value) {
            addCriterion("languageId >", value, "languageid");
            return (Criteria) this;
        }

        public Criteria andLanguageidGreaterThanOrEqualTo(Integer value) {
            addCriterion("languageId >=", value, "languageid");
            return (Criteria) this;
        }

        public Criteria andLanguageidLessThan(Integer value) {
            addCriterion("languageId <", value, "languageid");
            return (Criteria) this;
        }

        public Criteria andLanguageidLessThanOrEqualTo(Integer value) {
            addCriterion("languageId <=", value, "languageid");
            return (Criteria) this;
        }

        public Criteria andLanguageidIn(List<Integer> values) {
            addCriterion("languageId in", values, "languageid");
            return (Criteria) this;
        }

        public Criteria andLanguageidNotIn(List<Integer> values) {
            addCriterion("languageId not in", values, "languageid");
            return (Criteria) this;
        }

        public Criteria andLanguageidBetween(Integer value1, Integer value2) {
            addCriterion("languageId between", value1, value2, "languageid");
            return (Criteria) this;
        }

        public Criteria andLanguageidNotBetween(Integer value1, Integer value2) {
            addCriterion("languageId not between", value1, value2, "languageid");
            return (Criteria) this;
        }

        public Criteria andClassifyidIsNull() {
            addCriterion("classifyId is null");
            return (Criteria) this;
        }

        public Criteria andClassifyidIsNotNull() {
            addCriterion("classifyId is not null");
            return (Criteria) this;
        }

        public Criteria andClassifyidEqualTo(Integer value) {
            addCriterion("classifyId =", value, "classifyid");
            return (Criteria) this;
        }

        public Criteria andClassifyidNotEqualTo(Integer value) {
            addCriterion("classifyId <>", value, "classifyid");
            return (Criteria) this;
        }

        public Criteria andClassifyidGreaterThan(Integer value) {
            addCriterion("classifyId >", value, "classifyid");
            return (Criteria) this;
        }

        public Criteria andClassifyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("classifyId >=", value, "classifyid");
            return (Criteria) this;
        }

        public Criteria andClassifyidLessThan(Integer value) {
            addCriterion("classifyId <", value, "classifyid");
            return (Criteria) this;
        }

        public Criteria andClassifyidLessThanOrEqualTo(Integer value) {
            addCriterion("classifyId <=", value, "classifyid");
            return (Criteria) this;
        }

        public Criteria andClassifyidIn(List<Integer> values) {
            addCriterion("classifyId in", values, "classifyid");
            return (Criteria) this;
        }

        public Criteria andClassifyidNotIn(List<Integer> values) {
            addCriterion("classifyId not in", values, "classifyid");
            return (Criteria) this;
        }

        public Criteria andClassifyidBetween(Integer value1, Integer value2) {
            addCriterion("classifyId between", value1, value2, "classifyid");
            return (Criteria) this;
        }

        public Criteria andClassifyidNotBetween(Integer value1, Integer value2) {
            addCriterion("classifyId not between", value1, value2, "classifyid");
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