package com.itkim.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbAllMusicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbAllMusicExample() {
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

        public Criteria andSongidIsNull() {
            addCriterion("songId is null");
            return (Criteria) this;
        }

        public Criteria andSongidIsNotNull() {
            addCriterion("songId is not null");
            return (Criteria) this;
        }

        public Criteria andSongidEqualTo(Long value) {
            addCriterion("songId =", value, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidNotEqualTo(Long value) {
            addCriterion("songId <>", value, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidGreaterThan(Long value) {
            addCriterion("songId >", value, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidGreaterThanOrEqualTo(Long value) {
            addCriterion("songId >=", value, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidLessThan(Long value) {
            addCriterion("songId <", value, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidLessThanOrEqualTo(Long value) {
            addCriterion("songId <=", value, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidIn(List<Long> values) {
            addCriterion("songId in", values, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidNotIn(List<Long> values) {
            addCriterion("songId not in", values, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidBetween(Long value1, Long value2) {
            addCriterion("songId between", value1, value2, "songid");
            return (Criteria) this;
        }

        public Criteria andSongidNotBetween(Long value1, Long value2) {
            addCriterion("songId not between", value1, value2, "songid");
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

        public Criteria andSongsingerIsNull() {
            addCriterion("songSinger is null");
            return (Criteria) this;
        }

        public Criteria andSongsingerIsNotNull() {
            addCriterion("songSinger is not null");
            return (Criteria) this;
        }

        public Criteria andSongsingerEqualTo(String value) {
            addCriterion("songSinger =", value, "songsinger");
            return (Criteria) this;
        }

        public Criteria andSongsingerNotEqualTo(String value) {
            addCriterion("songSinger <>", value, "songsinger");
            return (Criteria) this;
        }

        public Criteria andSongsingerGreaterThan(String value) {
            addCriterion("songSinger >", value, "songsinger");
            return (Criteria) this;
        }

        public Criteria andSongsingerGreaterThanOrEqualTo(String value) {
            addCriterion("songSinger >=", value, "songsinger");
            return (Criteria) this;
        }

        public Criteria andSongsingerLessThan(String value) {
            addCriterion("songSinger <", value, "songsinger");
            return (Criteria) this;
        }

        public Criteria andSongsingerLessThanOrEqualTo(String value) {
            addCriterion("songSinger <=", value, "songsinger");
            return (Criteria) this;
        }

        public Criteria andSongsingerLike(String value) {
            addCriterion("songSinger like", value, "songsinger");
            return (Criteria) this;
        }

        public Criteria andSongsingerNotLike(String value) {
            addCriterion("songSinger not like", value, "songsinger");
            return (Criteria) this;
        }

        public Criteria andSongsingerIn(List<String> values) {
            addCriterion("songSinger in", values, "songsinger");
            return (Criteria) this;
        }

        public Criteria andSongsingerNotIn(List<String> values) {
            addCriterion("songSinger not in", values, "songsinger");
            return (Criteria) this;
        }

        public Criteria andSongsingerBetween(String value1, String value2) {
            addCriterion("songSinger between", value1, value2, "songsinger");
            return (Criteria) this;
        }

        public Criteria andSongsingerNotBetween(String value1, String value2) {
            addCriterion("songSinger not between", value1, value2, "songsinger");
            return (Criteria) this;
        }

        public Criteria andSongurlIsNull() {
            addCriterion("songUrl is null");
            return (Criteria) this;
        }

        public Criteria andSongurlIsNotNull() {
            addCriterion("songUrl is not null");
            return (Criteria) this;
        }

        public Criteria andSongurlEqualTo(String value) {
            addCriterion("songUrl =", value, "songurl");
            return (Criteria) this;
        }

        public Criteria andSongurlNotEqualTo(String value) {
            addCriterion("songUrl <>", value, "songurl");
            return (Criteria) this;
        }

        public Criteria andSongurlGreaterThan(String value) {
            addCriterion("songUrl >", value, "songurl");
            return (Criteria) this;
        }

        public Criteria andSongurlGreaterThanOrEqualTo(String value) {
            addCriterion("songUrl >=", value, "songurl");
            return (Criteria) this;
        }

        public Criteria andSongurlLessThan(String value) {
            addCriterion("songUrl <", value, "songurl");
            return (Criteria) this;
        }

        public Criteria andSongurlLessThanOrEqualTo(String value) {
            addCriterion("songUrl <=", value, "songurl");
            return (Criteria) this;
        }

        public Criteria andSongurlLike(String value) {
            addCriterion("songUrl like", value, "songurl");
            return (Criteria) this;
        }

        public Criteria andSongurlNotLike(String value) {
            addCriterion("songUrl not like", value, "songurl");
            return (Criteria) this;
        }

        public Criteria andSongurlIn(List<String> values) {
            addCriterion("songUrl in", values, "songurl");
            return (Criteria) this;
        }

        public Criteria andSongurlNotIn(List<String> values) {
            addCriterion("songUrl not in", values, "songurl");
            return (Criteria) this;
        }

        public Criteria andSongurlBetween(String value1, String value2) {
            addCriterion("songUrl between", value1, value2, "songurl");
            return (Criteria) this;
        }

        public Criteria andSongurlNotBetween(String value1, String value2) {
            addCriterion("songUrl not between", value1, value2, "songurl");
            return (Criteria) this;
        }

        public Criteria andOuterurlIsNull() {
            addCriterion("outerUrl is null");
            return (Criteria) this;
        }

        public Criteria andOuterurlIsNotNull() {
            addCriterion("outerUrl is not null");
            return (Criteria) this;
        }

        public Criteria andOuterurlEqualTo(String value) {
            addCriterion("outerUrl =", value, "outerurl");
            return (Criteria) this;
        }

        public Criteria andOuterurlNotEqualTo(String value) {
            addCriterion("outerUrl <>", value, "outerurl");
            return (Criteria) this;
        }

        public Criteria andOuterurlGreaterThan(String value) {
            addCriterion("outerUrl >", value, "outerurl");
            return (Criteria) this;
        }

        public Criteria andOuterurlGreaterThanOrEqualTo(String value) {
            addCriterion("outerUrl >=", value, "outerurl");
            return (Criteria) this;
        }

        public Criteria andOuterurlLessThan(String value) {
            addCriterion("outerUrl <", value, "outerurl");
            return (Criteria) this;
        }

        public Criteria andOuterurlLessThanOrEqualTo(String value) {
            addCriterion("outerUrl <=", value, "outerurl");
            return (Criteria) this;
        }

        public Criteria andOuterurlLike(String value) {
            addCriterion("outerUrl like", value, "outerurl");
            return (Criteria) this;
        }

        public Criteria andOuterurlNotLike(String value) {
            addCriterion("outerUrl not like", value, "outerurl");
            return (Criteria) this;
        }

        public Criteria andOuterurlIn(List<String> values) {
            addCriterion("outerUrl in", values, "outerurl");
            return (Criteria) this;
        }

        public Criteria andOuterurlNotIn(List<String> values) {
            addCriterion("outerUrl not in", values, "outerurl");
            return (Criteria) this;
        }

        public Criteria andOuterurlBetween(String value1, String value2) {
            addCriterion("outerUrl between", value1, value2, "outerurl");
            return (Criteria) this;
        }

        public Criteria andOuterurlNotBetween(String value1, String value2) {
            addCriterion("outerUrl not between", value1, value2, "outerurl");
            return (Criteria) this;
        }

        public Criteria andLyricIsNull() {
            addCriterion("lyric is null");
            return (Criteria) this;
        }

        public Criteria andLyricIsNotNull() {
            addCriterion("lyric is not null");
            return (Criteria) this;
        }

        public Criteria andLyricEqualTo(String value) {
            addCriterion("lyric =", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricNotEqualTo(String value) {
            addCriterion("lyric <>", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricGreaterThan(String value) {
            addCriterion("lyric >", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricGreaterThanOrEqualTo(String value) {
            addCriterion("lyric >=", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricLessThan(String value) {
            addCriterion("lyric <", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricLessThanOrEqualTo(String value) {
            addCriterion("lyric <=", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricLike(String value) {
            addCriterion("lyric like", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricNotLike(String value) {
            addCriterion("lyric not like", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricIn(List<String> values) {
            addCriterion("lyric in", values, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricNotIn(List<String> values) {
            addCriterion("lyric not in", values, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricBetween(String value1, String value2) {
            addCriterion("lyric between", value1, value2, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricNotBetween(String value1, String value2) {
            addCriterion("lyric not between", value1, value2, "lyric");
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