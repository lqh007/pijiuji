package com.pijiuji.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FatExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FatExample() {
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

        public Criteria andFatIdIsNull() {
            addCriterion("fat_id is null");
            return (Criteria) this;
        }

        public Criteria andFatIdIsNotNull() {
            addCriterion("fat_id is not null");
            return (Criteria) this;
        }

        public Criteria andFatIdEqualTo(String value) {
            addCriterion("fat_id =", value, "fatId");
            return (Criteria) this;
        }

        public Criteria andFatIdNotEqualTo(String value) {
            addCriterion("fat_id <>", value, "fatId");
            return (Criteria) this;
        }

        public Criteria andFatIdGreaterThan(String value) {
            addCriterion("fat_id >", value, "fatId");
            return (Criteria) this;
        }

        public Criteria andFatIdGreaterThanOrEqualTo(String value) {
            addCriterion("fat_id >=", value, "fatId");
            return (Criteria) this;
        }

        public Criteria andFatIdLessThan(String value) {
            addCriterion("fat_id <", value, "fatId");
            return (Criteria) this;
        }

        public Criteria andFatIdLessThanOrEqualTo(String value) {
            addCriterion("fat_id <=", value, "fatId");
            return (Criteria) this;
        }

        public Criteria andFatIdLike(String value) {
            addCriterion("fat_id like", value, "fatId");
            return (Criteria) this;
        }

        public Criteria andFatIdNotLike(String value) {
            addCriterion("fat_id not like", value, "fatId");
            return (Criteria) this;
        }

        public Criteria andFatIdIn(List<String> values) {
            addCriterion("fat_id in", values, "fatId");
            return (Criteria) this;
        }

        public Criteria andFatIdNotIn(List<String> values) {
            addCriterion("fat_id not in", values, "fatId");
            return (Criteria) this;
        }

        public Criteria andFatIdBetween(String value1, String value2) {
            addCriterion("fat_id between", value1, value2, "fatId");
            return (Criteria) this;
        }

        public Criteria andFatIdNotBetween(String value1, String value2) {
            addCriterion("fat_id not between", value1, value2, "fatId");
            return (Criteria) this;
        }

        public Criteria andFatProductIdIsNull() {
            addCriterion("fat_product_id is null");
            return (Criteria) this;
        }

        public Criteria andFatProductIdIsNotNull() {
            addCriterion("fat_product_id is not null");
            return (Criteria) this;
        }

        public Criteria andFatProductIdEqualTo(String value) {
            addCriterion("fat_product_id =", value, "fatProductId");
            return (Criteria) this;
        }

        public Criteria andFatProductIdNotEqualTo(String value) {
            addCriterion("fat_product_id <>", value, "fatProductId");
            return (Criteria) this;
        }

        public Criteria andFatProductIdGreaterThan(String value) {
            addCriterion("fat_product_id >", value, "fatProductId");
            return (Criteria) this;
        }

        public Criteria andFatProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("fat_product_id >=", value, "fatProductId");
            return (Criteria) this;
        }

        public Criteria andFatProductIdLessThan(String value) {
            addCriterion("fat_product_id <", value, "fatProductId");
            return (Criteria) this;
        }

        public Criteria andFatProductIdLessThanOrEqualTo(String value) {
            addCriterion("fat_product_id <=", value, "fatProductId");
            return (Criteria) this;
        }

        public Criteria andFatProductIdLike(String value) {
            addCriterion("fat_product_id like", value, "fatProductId");
            return (Criteria) this;
        }

        public Criteria andFatProductIdNotLike(String value) {
            addCriterion("fat_product_id not like", value, "fatProductId");
            return (Criteria) this;
        }

        public Criteria andFatProductIdIn(List<String> values) {
            addCriterion("fat_product_id in", values, "fatProductId");
            return (Criteria) this;
        }

        public Criteria andFatProductIdNotIn(List<String> values) {
            addCriterion("fat_product_id not in", values, "fatProductId");
            return (Criteria) this;
        }

        public Criteria andFatProductIdBetween(String value1, String value2) {
            addCriterion("fat_product_id between", value1, value2, "fatProductId");
            return (Criteria) this;
        }

        public Criteria andFatProductIdNotBetween(String value1, String value2) {
            addCriterion("fat_product_id not between", value1, value2, "fatProductId");
            return (Criteria) this;
        }

        public Criteria andFatStatusIsNull() {
            addCriterion("fat_status is null");
            return (Criteria) this;
        }

        public Criteria andFatStatusIsNotNull() {
            addCriterion("fat_status is not null");
            return (Criteria) this;
        }

        public Criteria andFatStatusEqualTo(String value) {
            addCriterion("fat_status =", value, "fatStatus");
            return (Criteria) this;
        }

        public Criteria andFatStatusNotEqualTo(String value) {
            addCriterion("fat_status <>", value, "fatStatus");
            return (Criteria) this;
        }

        public Criteria andFatStatusGreaterThan(String value) {
            addCriterion("fat_status >", value, "fatStatus");
            return (Criteria) this;
        }

        public Criteria andFatStatusGreaterThanOrEqualTo(String value) {
            addCriterion("fat_status >=", value, "fatStatus");
            return (Criteria) this;
        }

        public Criteria andFatStatusLessThan(String value) {
            addCriterion("fat_status <", value, "fatStatus");
            return (Criteria) this;
        }

        public Criteria andFatStatusLessThanOrEqualTo(String value) {
            addCriterion("fat_status <=", value, "fatStatus");
            return (Criteria) this;
        }

        public Criteria andFatStatusLike(String value) {
            addCriterion("fat_status like", value, "fatStatus");
            return (Criteria) this;
        }

        public Criteria andFatStatusNotLike(String value) {
            addCriterion("fat_status not like", value, "fatStatus");
            return (Criteria) this;
        }

        public Criteria andFatStatusIn(List<String> values) {
            addCriterion("fat_status in", values, "fatStatus");
            return (Criteria) this;
        }

        public Criteria andFatStatusNotIn(List<String> values) {
            addCriterion("fat_status not in", values, "fatStatus");
            return (Criteria) this;
        }

        public Criteria andFatStatusBetween(String value1, String value2) {
            addCriterion("fat_status between", value1, value2, "fatStatus");
            return (Criteria) this;
        }

        public Criteria andFatStatusNotBetween(String value1, String value2) {
            addCriterion("fat_status not between", value1, value2, "fatStatus");
            return (Criteria) this;
        }

        public Criteria andFatNumIsNull() {
            addCriterion("fat_num is null");
            return (Criteria) this;
        }

        public Criteria andFatNumIsNotNull() {
            addCriterion("fat_num is not null");
            return (Criteria) this;
        }

        public Criteria andFatNumEqualTo(String value) {
            addCriterion("fat_num =", value, "fatNum");
            return (Criteria) this;
        }

        public Criteria andFatNumNotEqualTo(String value) {
            addCriterion("fat_num <>", value, "fatNum");
            return (Criteria) this;
        }

        public Criteria andFatNumGreaterThan(String value) {
            addCriterion("fat_num >", value, "fatNum");
            return (Criteria) this;
        }

        public Criteria andFatNumGreaterThanOrEqualTo(String value) {
            addCriterion("fat_num >=", value, "fatNum");
            return (Criteria) this;
        }

        public Criteria andFatNumLessThan(String value) {
            addCriterion("fat_num <", value, "fatNum");
            return (Criteria) this;
        }

        public Criteria andFatNumLessThanOrEqualTo(String value) {
            addCriterion("fat_num <=", value, "fatNum");
            return (Criteria) this;
        }

        public Criteria andFatNumLike(String value) {
            addCriterion("fat_num like", value, "fatNum");
            return (Criteria) this;
        }

        public Criteria andFatNumNotLike(String value) {
            addCriterion("fat_num not like", value, "fatNum");
            return (Criteria) this;
        }

        public Criteria andFatNumIn(List<String> values) {
            addCriterion("fat_num in", values, "fatNum");
            return (Criteria) this;
        }

        public Criteria andFatNumNotIn(List<String> values) {
            addCriterion("fat_num not in", values, "fatNum");
            return (Criteria) this;
        }

        public Criteria andFatNumBetween(String value1, String value2) {
            addCriterion("fat_num between", value1, value2, "fatNum");
            return (Criteria) this;
        }

        public Criteria andFatNumNotBetween(String value1, String value2) {
            addCriterion("fat_num not between", value1, value2, "fatNum");
            return (Criteria) this;
        }

        public Criteria andFatTimeIsNull() {
            addCriterion("fat_time is null");
            return (Criteria) this;
        }

        public Criteria andFatTimeIsNotNull() {
            addCriterion("fat_time is not null");
            return (Criteria) this;
        }

        public Criteria andFatTimeEqualTo(Date value) {
            addCriterion("fat_time =", value, "fatTime");
            return (Criteria) this;
        }

        public Criteria andFatTimeNotEqualTo(Date value) {
            addCriterion("fat_time <>", value, "fatTime");
            return (Criteria) this;
        }

        public Criteria andFatTimeGreaterThan(Date value) {
            addCriterion("fat_time >", value, "fatTime");
            return (Criteria) this;
        }

        public Criteria andFatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fat_time >=", value, "fatTime");
            return (Criteria) this;
        }

        public Criteria andFatTimeLessThan(Date value) {
            addCriterion("fat_time <", value, "fatTime");
            return (Criteria) this;
        }

        public Criteria andFatTimeLessThanOrEqualTo(Date value) {
            addCriterion("fat_time <=", value, "fatTime");
            return (Criteria) this;
        }

        public Criteria andFatTimeIn(List<Date> values) {
            addCriterion("fat_time in", values, "fatTime");
            return (Criteria) this;
        }

        public Criteria andFatTimeNotIn(List<Date> values) {
            addCriterion("fat_time not in", values, "fatTime");
            return (Criteria) this;
        }

        public Criteria andFatTimeBetween(Date value1, Date value2) {
            addCriterion("fat_time between", value1, value2, "fatTime");
            return (Criteria) this;
        }

        public Criteria andFatTimeNotBetween(Date value1, Date value2) {
            addCriterion("fat_time not between", value1, value2, "fatTime");
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