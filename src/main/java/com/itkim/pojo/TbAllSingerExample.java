package com.itkim.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbAllSingerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbAllSingerExample() {
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
            addCriterion("singerId is null");
            return (Criteria) this;
        }

        public Criteria andSingeridIsNotNull() {
            addCriterion("singerId is not null");
            return (Criteria) this;
        }

        public Criteria andSingeridEqualTo(Long value) {
            addCriterion("singerId =", value, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridNotEqualTo(Long value) {
            addCriterion("singerId <>", value, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridGreaterThan(Long value) {
            addCriterion("singerId >", value, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridGreaterThanOrEqualTo(Long value) {
            addCriterion("singerId >=", value, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridLessThan(Long value) {
            addCriterion("singerId <", value, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridLessThanOrEqualTo(Long value) {
            addCriterion("singerId <=", value, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridIn(List<Long> values) {
            addCriterion("singerId in", values, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridNotIn(List<Long> values) {
            addCriterion("singerId not in", values, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridBetween(Long value1, Long value2) {
            addCriterion("singerId between", value1, value2, "singerid");
            return (Criteria) this;
        }

        public Criteria andSingeridNotBetween(Long value1, Long value2) {
            addCriterion("singerId not between", value1, value2, "singerid");
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

        public Criteria andSingerhrefIsNull() {
            addCriterion("singerHref is null");
            return (Criteria) this;
        }

        public Criteria andSingerhrefIsNotNull() {
            addCriterion("singerHref is not null");
            return (Criteria) this;
        }

        public Criteria andSingerhrefEqualTo(String value) {
            addCriterion("singerHref =", value, "singerhref");
            return (Criteria) this;
        }

        public Criteria andSingerhrefNotEqualTo(String value) {
            addCriterion("singerHref <>", value, "singerhref");
            return (Criteria) this;
        }

        public Criteria andSingerhrefGreaterThan(String value) {
            addCriterion("singerHref >", value, "singerhref");
            return (Criteria) this;
        }

        public Criteria andSingerhrefGreaterThanOrEqualTo(String value) {
            addCriterion("singerHref >=", value, "singerhref");
            return (Criteria) this;
        }

        public Criteria andSingerhrefLessThan(String value) {
            addCriterion("singerHref <", value, "singerhref");
            return (Criteria) this;
        }

        public Criteria andSingerhrefLessThanOrEqualTo(String value) {
            addCriterion("singerHref <=", value, "singerhref");
            return (Criteria) this;
        }

        public Criteria andSingerhrefLike(String value) {
            addCriterion("singerHref like", value, "singerhref");
            return (Criteria) this;
        }

        public Criteria andSingerhrefNotLike(String value) {
            addCriterion("singerHref not like", value, "singerhref");
            return (Criteria) this;
        }

        public Criteria andSingerhrefIn(List<String> values) {
            addCriterion("singerHref in", values, "singerhref");
            return (Criteria) this;
        }

        public Criteria andSingerhrefNotIn(List<String> values) {
            addCriterion("singerHref not in", values, "singerhref");
            return (Criteria) this;
        }

        public Criteria andSingerhrefBetween(String value1, String value2) {
            addCriterion("singerHref between", value1, value2, "singerhref");
            return (Criteria) this;
        }

        public Criteria andSingerhrefNotBetween(String value1, String value2) {
            addCriterion("singerHref not between", value1, value2, "singerhref");
            return (Criteria) this;
        }

        public Criteria andSingerdescIsNull() {
            addCriterion("singerDesc is null");
            return (Criteria) this;
        }

        public Criteria andSingerdescIsNotNull() {
            addCriterion("singerDesc is not null");
            return (Criteria) this;
        }

        public Criteria andSingerdescEqualTo(String value) {
            addCriterion("singerDesc =", value, "singerdesc");
            return (Criteria) this;
        }

        public Criteria andSingerdescNotEqualTo(String value) {
            addCriterion("singerDesc <>", value, "singerdesc");
            return (Criteria) this;
        }

        public Criteria andSingerdescGreaterThan(String value) {
            addCriterion("singerDesc >", value, "singerdesc");
            return (Criteria) this;
        }

        public Criteria andSingerdescGreaterThanOrEqualTo(String value) {
            addCriterion("singerDesc >=", value, "singerdesc");
            return (Criteria) this;
        }

        public Criteria andSingerdescLessThan(String value) {
            addCriterion("singerDesc <", value, "singerdesc");
            return (Criteria) this;
        }

        public Criteria andSingerdescLessThanOrEqualTo(String value) {
            addCriterion("singerDesc <=", value, "singerdesc");
            return (Criteria) this;
        }

        public Criteria andSingerdescLike(String value) {
            addCriterion("singerDesc like", value, "singerdesc");
            return (Criteria) this;
        }

        public Criteria andSingerdescNotLike(String value) {
            addCriterion("singerDesc not like", value, "singerdesc");
            return (Criteria) this;
        }

        public Criteria andSingerdescIn(List<String> values) {
            addCriterion("singerDesc in", values, "singerdesc");
            return (Criteria) this;
        }

        public Criteria andSingerdescNotIn(List<String> values) {
            addCriterion("singerDesc not in", values, "singerdesc");
            return (Criteria) this;
        }

        public Criteria andSingerdescBetween(String value1, String value2) {
            addCriterion("singerDesc between", value1, value2, "singerdesc");
            return (Criteria) this;
        }

        public Criteria andSingerdescNotBetween(String value1, String value2) {
            addCriterion("singerDesc not between", value1, value2, "singerdesc");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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