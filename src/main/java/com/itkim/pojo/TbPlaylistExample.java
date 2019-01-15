package com.itkim.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbPlaylistExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPlaylistExample() {
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

        public Criteria andPlaylistidIsNull() {
            addCriterion("playlistId is null");
            return (Criteria) this;
        }

        public Criteria andPlaylistidIsNotNull() {
            addCriterion("playlistId is not null");
            return (Criteria) this;
        }

        public Criteria andPlaylistidEqualTo(Long value) {
            addCriterion("playlistId =", value, "playlistid");
            return (Criteria) this;
        }

        public Criteria andPlaylistidNotEqualTo(Long value) {
            addCriterion("playlistId <>", value, "playlistid");
            return (Criteria) this;
        }

        public Criteria andPlaylistidGreaterThan(Long value) {
            addCriterion("playlistId >", value, "playlistid");
            return (Criteria) this;
        }

        public Criteria andPlaylistidGreaterThanOrEqualTo(Long value) {
            addCriterion("playlistId >=", value, "playlistid");
            return (Criteria) this;
        }

        public Criteria andPlaylistidLessThan(Long value) {
            addCriterion("playlistId <", value, "playlistid");
            return (Criteria) this;
        }

        public Criteria andPlaylistidLessThanOrEqualTo(Long value) {
            addCriterion("playlistId <=", value, "playlistid");
            return (Criteria) this;
        }

        public Criteria andPlaylistidIn(List<Long> values) {
            addCriterion("playlistId in", values, "playlistid");
            return (Criteria) this;
        }

        public Criteria andPlaylistidNotIn(List<Long> values) {
            addCriterion("playlistId not in", values, "playlistid");
            return (Criteria) this;
        }

        public Criteria andPlaylistidBetween(Long value1, Long value2) {
            addCriterion("playlistId between", value1, value2, "playlistid");
            return (Criteria) this;
        }

        public Criteria andPlaylistidNotBetween(Long value1, Long value2) {
            addCriterion("playlistId not between", value1, value2, "playlistid");
            return (Criteria) this;
        }

        public Criteria andListtitleIsNull() {
            addCriterion("listTitle is null");
            return (Criteria) this;
        }

        public Criteria andListtitleIsNotNull() {
            addCriterion("listTitle is not null");
            return (Criteria) this;
        }

        public Criteria andListtitleEqualTo(String value) {
            addCriterion("listTitle =", value, "listtitle");
            return (Criteria) this;
        }

        public Criteria andListtitleNotEqualTo(String value) {
            addCriterion("listTitle <>", value, "listtitle");
            return (Criteria) this;
        }

        public Criteria andListtitleGreaterThan(String value) {
            addCriterion("listTitle >", value, "listtitle");
            return (Criteria) this;
        }

        public Criteria andListtitleGreaterThanOrEqualTo(String value) {
            addCriterion("listTitle >=", value, "listtitle");
            return (Criteria) this;
        }

        public Criteria andListtitleLessThan(String value) {
            addCriterion("listTitle <", value, "listtitle");
            return (Criteria) this;
        }

        public Criteria andListtitleLessThanOrEqualTo(String value) {
            addCriterion("listTitle <=", value, "listtitle");
            return (Criteria) this;
        }

        public Criteria andListtitleLike(String value) {
            addCriterion("listTitle like", value, "listtitle");
            return (Criteria) this;
        }

        public Criteria andListtitleNotLike(String value) {
            addCriterion("listTitle not like", value, "listtitle");
            return (Criteria) this;
        }

        public Criteria andListtitleIn(List<String> values) {
            addCriterion("listTitle in", values, "listtitle");
            return (Criteria) this;
        }

        public Criteria andListtitleNotIn(List<String> values) {
            addCriterion("listTitle not in", values, "listtitle");
            return (Criteria) this;
        }

        public Criteria andListtitleBetween(String value1, String value2) {
            addCriterion("listTitle between", value1, value2, "listtitle");
            return (Criteria) this;
        }

        public Criteria andListtitleNotBetween(String value1, String value2) {
            addCriterion("listTitle not between", value1, value2, "listtitle");
            return (Criteria) this;
        }

        public Criteria andListhrefIsNull() {
            addCriterion("listHref is null");
            return (Criteria) this;
        }

        public Criteria andListhrefIsNotNull() {
            addCriterion("listHref is not null");
            return (Criteria) this;
        }

        public Criteria andListhrefEqualTo(String value) {
            addCriterion("listHref =", value, "listhref");
            return (Criteria) this;
        }

        public Criteria andListhrefNotEqualTo(String value) {
            addCriterion("listHref <>", value, "listhref");
            return (Criteria) this;
        }

        public Criteria andListhrefGreaterThan(String value) {
            addCriterion("listHref >", value, "listhref");
            return (Criteria) this;
        }

        public Criteria andListhrefGreaterThanOrEqualTo(String value) {
            addCriterion("listHref >=", value, "listhref");
            return (Criteria) this;
        }

        public Criteria andListhrefLessThan(String value) {
            addCriterion("listHref <", value, "listhref");
            return (Criteria) this;
        }

        public Criteria andListhrefLessThanOrEqualTo(String value) {
            addCriterion("listHref <=", value, "listhref");
            return (Criteria) this;
        }

        public Criteria andListhrefLike(String value) {
            addCriterion("listHref like", value, "listhref");
            return (Criteria) this;
        }

        public Criteria andListhrefNotLike(String value) {
            addCriterion("listHref not like", value, "listhref");
            return (Criteria) this;
        }

        public Criteria andListhrefIn(List<String> values) {
            addCriterion("listHref in", values, "listhref");
            return (Criteria) this;
        }

        public Criteria andListhrefNotIn(List<String> values) {
            addCriterion("listHref not in", values, "listhref");
            return (Criteria) this;
        }

        public Criteria andListhrefBetween(String value1, String value2) {
            addCriterion("listHref between", value1, value2, "listhref");
            return (Criteria) this;
        }

        public Criteria andListhrefNotBetween(String value1, String value2) {
            addCriterion("listHref not between", value1, value2, "listhref");
            return (Criteria) this;
        }

        public Criteria andPhotohrefIsNull() {
            addCriterion("photoHref is null");
            return (Criteria) this;
        }

        public Criteria andPhotohrefIsNotNull() {
            addCriterion("photoHref is not null");
            return (Criteria) this;
        }

        public Criteria andPhotohrefEqualTo(String value) {
            addCriterion("photoHref =", value, "photohref");
            return (Criteria) this;
        }

        public Criteria andPhotohrefNotEqualTo(String value) {
            addCriterion("photoHref <>", value, "photohref");
            return (Criteria) this;
        }

        public Criteria andPhotohrefGreaterThan(String value) {
            addCriterion("photoHref >", value, "photohref");
            return (Criteria) this;
        }

        public Criteria andPhotohrefGreaterThanOrEqualTo(String value) {
            addCriterion("photoHref >=", value, "photohref");
            return (Criteria) this;
        }

        public Criteria andPhotohrefLessThan(String value) {
            addCriterion("photoHref <", value, "photohref");
            return (Criteria) this;
        }

        public Criteria andPhotohrefLessThanOrEqualTo(String value) {
            addCriterion("photoHref <=", value, "photohref");
            return (Criteria) this;
        }

        public Criteria andPhotohrefLike(String value) {
            addCriterion("photoHref like", value, "photohref");
            return (Criteria) this;
        }

        public Criteria andPhotohrefNotLike(String value) {
            addCriterion("photoHref not like", value, "photohref");
            return (Criteria) this;
        }

        public Criteria andPhotohrefIn(List<String> values) {
            addCriterion("photoHref in", values, "photohref");
            return (Criteria) this;
        }

        public Criteria andPhotohrefNotIn(List<String> values) {
            addCriterion("photoHref not in", values, "photohref");
            return (Criteria) this;
        }

        public Criteria andPhotohrefBetween(String value1, String value2) {
            addCriterion("photoHref between", value1, value2, "photohref");
            return (Criteria) this;
        }

        public Criteria andPhotohrefNotBetween(String value1, String value2) {
            addCriterion("photoHref not between", value1, value2, "photohref");
            return (Criteria) this;
        }

        public Criteria andIshotIsNull() {
            addCriterion("isHot is null");
            return (Criteria) this;
        }

        public Criteria andIshotIsNotNull() {
            addCriterion("isHot is not null");
            return (Criteria) this;
        }

        public Criteria andIshotEqualTo(Integer value) {
            addCriterion("isHot =", value, "ishot");
            return (Criteria) this;
        }

        public Criteria andIshotNotEqualTo(Integer value) {
            addCriterion("isHot <>", value, "ishot");
            return (Criteria) this;
        }

        public Criteria andIshotGreaterThan(Integer value) {
            addCriterion("isHot >", value, "ishot");
            return (Criteria) this;
        }

        public Criteria andIshotGreaterThanOrEqualTo(Integer value) {
            addCriterion("isHot >=", value, "ishot");
            return (Criteria) this;
        }

        public Criteria andIshotLessThan(Integer value) {
            addCriterion("isHot <", value, "ishot");
            return (Criteria) this;
        }

        public Criteria andIshotLessThanOrEqualTo(Integer value) {
            addCriterion("isHot <=", value, "ishot");
            return (Criteria) this;
        }

        public Criteria andIshotIn(List<Integer> values) {
            addCriterion("isHot in", values, "ishot");
            return (Criteria) this;
        }

        public Criteria andIshotNotIn(List<Integer> values) {
            addCriterion("isHot not in", values, "ishot");
            return (Criteria) this;
        }

        public Criteria andIshotBetween(Integer value1, Integer value2) {
            addCriterion("isHot between", value1, value2, "ishot");
            return (Criteria) this;
        }

        public Criteria andIshotNotBetween(Integer value1, Integer value2) {
            addCriterion("isHot not between", value1, value2, "ishot");
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