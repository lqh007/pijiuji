package com.pijiuji.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LevelFcExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LevelFcExample() {
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

        public Criteria andFcIdIsNull() {
            addCriterion("fc_id is null");
            return (Criteria) this;
        }

        public Criteria andFcIdIsNotNull() {
            addCriterion("fc_id is not null");
            return (Criteria) this;
        }

        public Criteria andFcIdEqualTo(Integer value) {
            addCriterion("fc_id =", value, "fcId");
            return (Criteria) this;
        }

        public Criteria andFcIdNotEqualTo(Integer value) {
            addCriterion("fc_id <>", value, "fcId");
            return (Criteria) this;
        }

        public Criteria andFcIdGreaterThan(Integer value) {
            addCriterion("fc_id >", value, "fcId");
            return (Criteria) this;
        }

        public Criteria andFcIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fc_id >=", value, "fcId");
            return (Criteria) this;
        }

        public Criteria andFcIdLessThan(Integer value) {
            addCriterion("fc_id <", value, "fcId");
            return (Criteria) this;
        }

        public Criteria andFcIdLessThanOrEqualTo(Integer value) {
            addCriterion("fc_id <=", value, "fcId");
            return (Criteria) this;
        }

        public Criteria andFcIdIn(List<Integer> values) {
            addCriterion("fc_id in", values, "fcId");
            return (Criteria) this;
        }

        public Criteria andFcIdNotIn(List<Integer> values) {
            addCriterion("fc_id not in", values, "fcId");
            return (Criteria) this;
        }

        public Criteria andFcIdBetween(Integer value1, Integer value2) {
            addCriterion("fc_id between", value1, value2, "fcId");
            return (Criteria) this;
        }

        public Criteria andFcIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fc_id not between", value1, value2, "fcId");
            return (Criteria) this;
        }

        public Criteria andFcLevelIdIsNull() {
            addCriterion("fc_level_id is null");
            return (Criteria) this;
        }

        public Criteria andFcLevelIdIsNotNull() {
            addCriterion("fc_level_id is not null");
            return (Criteria) this;
        }

        public Criteria andFcLevelIdEqualTo(String value) {
            addCriterion("fc_level_id =", value, "fcLevelId");
            return (Criteria) this;
        }

        public Criteria andFcLevelIdNotEqualTo(String value) {
            addCriterion("fc_level_id <>", value, "fcLevelId");
            return (Criteria) this;
        }

        public Criteria andFcLevelIdGreaterThan(String value) {
            addCriterion("fc_level_id >", value, "fcLevelId");
            return (Criteria) this;
        }

        public Criteria andFcLevelIdGreaterThanOrEqualTo(String value) {
            addCriterion("fc_level_id >=", value, "fcLevelId");
            return (Criteria) this;
        }

        public Criteria andFcLevelIdLessThan(String value) {
            addCriterion("fc_level_id <", value, "fcLevelId");
            return (Criteria) this;
        }

        public Criteria andFcLevelIdLessThanOrEqualTo(String value) {
            addCriterion("fc_level_id <=", value, "fcLevelId");
            return (Criteria) this;
        }

        public Criteria andFcLevelIdLike(String value) {
            addCriterion("fc_level_id like", value, "fcLevelId");
            return (Criteria) this;
        }

        public Criteria andFcLevelIdNotLike(String value) {
            addCriterion("fc_level_id not like", value, "fcLevelId");
            return (Criteria) this;
        }

        public Criteria andFcLevelIdIn(List<String> values) {
            addCriterion("fc_level_id in", values, "fcLevelId");
            return (Criteria) this;
        }

        public Criteria andFcLevelIdNotIn(List<String> values) {
            addCriterion("fc_level_id not in", values, "fcLevelId");
            return (Criteria) this;
        }

        public Criteria andFcLevelIdBetween(String value1, String value2) {
            addCriterion("fc_level_id between", value1, value2, "fcLevelId");
            return (Criteria) this;
        }

        public Criteria andFcLevelIdNotBetween(String value1, String value2) {
            addCriterion("fc_level_id not between", value1, value2, "fcLevelId");
            return (Criteria) this;
        }

        public Criteria andFcLevelNameIsNull() {
            addCriterion("fc_level_name is null");
            return (Criteria) this;
        }

        public Criteria andFcLevelNameIsNotNull() {
            addCriterion("fc_level_name is not null");
            return (Criteria) this;
        }

        public Criteria andFcLevelNameEqualTo(String value) {
            addCriterion("fc_level_name =", value, "fcLevelName");
            return (Criteria) this;
        }

        public Criteria andFcLevelNameNotEqualTo(String value) {
            addCriterion("fc_level_name <>", value, "fcLevelName");
            return (Criteria) this;
        }

        public Criteria andFcLevelNameGreaterThan(String value) {
            addCriterion("fc_level_name >", value, "fcLevelName");
            return (Criteria) this;
        }

        public Criteria andFcLevelNameGreaterThanOrEqualTo(String value) {
            addCriterion("fc_level_name >=", value, "fcLevelName");
            return (Criteria) this;
        }

        public Criteria andFcLevelNameLessThan(String value) {
            addCriterion("fc_level_name <", value, "fcLevelName");
            return (Criteria) this;
        }

        public Criteria andFcLevelNameLessThanOrEqualTo(String value) {
            addCriterion("fc_level_name <=", value, "fcLevelName");
            return (Criteria) this;
        }

        public Criteria andFcLevelNameLike(String value) {
            addCriterion("fc_level_name like", value, "fcLevelName");
            return (Criteria) this;
        }

        public Criteria andFcLevelNameNotLike(String value) {
            addCriterion("fc_level_name not like", value, "fcLevelName");
            return (Criteria) this;
        }

        public Criteria andFcLevelNameIn(List<String> values) {
            addCriterion("fc_level_name in", values, "fcLevelName");
            return (Criteria) this;
        }

        public Criteria andFcLevelNameNotIn(List<String> values) {
            addCriterion("fc_level_name not in", values, "fcLevelName");
            return (Criteria) this;
        }

        public Criteria andFcLevelNameBetween(String value1, String value2) {
            addCriterion("fc_level_name between", value1, value2, "fcLevelName");
            return (Criteria) this;
        }

        public Criteria andFcLevelNameNotBetween(String value1, String value2) {
            addCriterion("fc_level_name not between", value1, value2, "fcLevelName");
            return (Criteria) this;
        }

        public Criteria andFcBiliIsNull() {
            addCriterion("fc_bili is null");
            return (Criteria) this;
        }

        public Criteria andFcBiliIsNotNull() {
            addCriterion("fc_bili is not null");
            return (Criteria) this;
        }

        public Criteria andFcBiliEqualTo(String value) {
            addCriterion("fc_bili =", value, "fcBili");
            return (Criteria) this;
        }

        public Criteria andFcBiliNotEqualTo(String value) {
            addCriterion("fc_bili <>", value, "fcBili");
            return (Criteria) this;
        }

        public Criteria andFcBiliGreaterThan(String value) {
            addCriterion("fc_bili >", value, "fcBili");
            return (Criteria) this;
        }

        public Criteria andFcBiliGreaterThanOrEqualTo(String value) {
            addCriterion("fc_bili >=", value, "fcBili");
            return (Criteria) this;
        }

        public Criteria andFcBiliLessThan(String value) {
            addCriterion("fc_bili <", value, "fcBili");
            return (Criteria) this;
        }

        public Criteria andFcBiliLessThanOrEqualTo(String value) {
            addCriterion("fc_bili <=", value, "fcBili");
            return (Criteria) this;
        }

        public Criteria andFcBiliLike(String value) {
            addCriterion("fc_bili like", value, "fcBili");
            return (Criteria) this;
        }

        public Criteria andFcBiliNotLike(String value) {
            addCriterion("fc_bili not like", value, "fcBili");
            return (Criteria) this;
        }

        public Criteria andFcBiliIn(List<String> values) {
            addCriterion("fc_bili in", values, "fcBili");
            return (Criteria) this;
        }

        public Criteria andFcBiliNotIn(List<String> values) {
            addCriterion("fc_bili not in", values, "fcBili");
            return (Criteria) this;
        }

        public Criteria andFcBiliBetween(String value1, String value2) {
            addCriterion("fc_bili between", value1, value2, "fcBili");
            return (Criteria) this;
        }

        public Criteria andFcBiliNotBetween(String value1, String value2) {
            addCriterion("fc_bili not between", value1, value2, "fcBili");
            return (Criteria) this;
        }

        public Criteria andFcTimeIsNull() {
            addCriterion("fc_time is null");
            return (Criteria) this;
        }

        public Criteria andFcTimeIsNotNull() {
            addCriterion("fc_time is not null");
            return (Criteria) this;
        }

        public Criteria andFcTimeEqualTo(Date value) {
            addCriterion("fc_time =", value, "fcTime");
            return (Criteria) this;
        }

        public Criteria andFcTimeNotEqualTo(Date value) {
            addCriterion("fc_time <>", value, "fcTime");
            return (Criteria) this;
        }

        public Criteria andFcTimeGreaterThan(Date value) {
            addCriterion("fc_time >", value, "fcTime");
            return (Criteria) this;
        }

        public Criteria andFcTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fc_time >=", value, "fcTime");
            return (Criteria) this;
        }

        public Criteria andFcTimeLessThan(Date value) {
            addCriterion("fc_time <", value, "fcTime");
            return (Criteria) this;
        }

        public Criteria andFcTimeLessThanOrEqualTo(Date value) {
            addCriterion("fc_time <=", value, "fcTime");
            return (Criteria) this;
        }

        public Criteria andFcTimeIn(List<Date> values) {
            addCriterion("fc_time in", values, "fcTime");
            return (Criteria) this;
        }

        public Criteria andFcTimeNotIn(List<Date> values) {
            addCriterion("fc_time not in", values, "fcTime");
            return (Criteria) this;
        }

        public Criteria andFcTimeBetween(Date value1, Date value2) {
            addCriterion("fc_time between", value1, value2, "fcTime");
            return (Criteria) this;
        }

        public Criteria andFcTimeNotBetween(Date value1, Date value2) {
            addCriterion("fc_time not between", value1, value2, "fcTime");
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