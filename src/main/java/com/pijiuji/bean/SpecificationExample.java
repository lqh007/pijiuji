package com.pijiuji.bean;

import java.util.ArrayList;
import java.util.List;

public class SpecificationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpecificationExample() {
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

        public Criteria andSpeIdIsNull() {
            addCriterion("spe_id is null");
            return (Criteria) this;
        }

        public Criteria andSpeIdIsNotNull() {
            addCriterion("spe_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpeIdEqualTo(String value) {
            addCriterion("spe_id =", value, "speId");
            return (Criteria) this;
        }

        public Criteria andSpeIdNotEqualTo(String value) {
            addCriterion("spe_id <>", value, "speId");
            return (Criteria) this;
        }

        public Criteria andSpeIdGreaterThan(String value) {
            addCriterion("spe_id >", value, "speId");
            return (Criteria) this;
        }

        public Criteria andSpeIdGreaterThanOrEqualTo(String value) {
            addCriterion("spe_id >=", value, "speId");
            return (Criteria) this;
        }

        public Criteria andSpeIdLessThan(String value) {
            addCriterion("spe_id <", value, "speId");
            return (Criteria) this;
        }

        public Criteria andSpeIdLessThanOrEqualTo(String value) {
            addCriterion("spe_id <=", value, "speId");
            return (Criteria) this;
        }

        public Criteria andSpeIdLike(String value) {
            addCriterion("spe_id like", value, "speId");
            return (Criteria) this;
        }

        public Criteria andSpeIdNotLike(String value) {
            addCriterion("spe_id not like", value, "speId");
            return (Criteria) this;
        }

        public Criteria andSpeIdIn(List<String> values) {
            addCriterion("spe_id in", values, "speId");
            return (Criteria) this;
        }

        public Criteria andSpeIdNotIn(List<String> values) {
            addCriterion("spe_id not in", values, "speId");
            return (Criteria) this;
        }

        public Criteria andSpeIdBetween(String value1, String value2) {
            addCriterion("spe_id between", value1, value2, "speId");
            return (Criteria) this;
        }

        public Criteria andSpeIdNotBetween(String value1, String value2) {
            addCriterion("spe_id not between", value1, value2, "speId");
            return (Criteria) this;
        }

        public Criteria andSpeSizeIsNull() {
            addCriterion("spe_size is null");
            return (Criteria) this;
        }

        public Criteria andSpeSizeIsNotNull() {
            addCriterion("spe_size is not null");
            return (Criteria) this;
        }

        public Criteria andSpeSizeEqualTo(String value) {
            addCriterion("spe_size =", value, "speSize");
            return (Criteria) this;
        }

        public Criteria andSpeSizeNotEqualTo(String value) {
            addCriterion("spe_size <>", value, "speSize");
            return (Criteria) this;
        }

        public Criteria andSpeSizeGreaterThan(String value) {
            addCriterion("spe_size >", value, "speSize");
            return (Criteria) this;
        }

        public Criteria andSpeSizeGreaterThanOrEqualTo(String value) {
            addCriterion("spe_size >=", value, "speSize");
            return (Criteria) this;
        }

        public Criteria andSpeSizeLessThan(String value) {
            addCriterion("spe_size <", value, "speSize");
            return (Criteria) this;
        }

        public Criteria andSpeSizeLessThanOrEqualTo(String value) {
            addCriterion("spe_size <=", value, "speSize");
            return (Criteria) this;
        }

        public Criteria andSpeSizeLike(String value) {
            addCriterion("spe_size like", value, "speSize");
            return (Criteria) this;
        }

        public Criteria andSpeSizeNotLike(String value) {
            addCriterion("spe_size not like", value, "speSize");
            return (Criteria) this;
        }

        public Criteria andSpeSizeIn(List<String> values) {
            addCriterion("spe_size in", values, "speSize");
            return (Criteria) this;
        }

        public Criteria andSpeSizeNotIn(List<String> values) {
            addCriterion("spe_size not in", values, "speSize");
            return (Criteria) this;
        }

        public Criteria andSpeSizeBetween(String value1, String value2) {
            addCriterion("spe_size between", value1, value2, "speSize");
            return (Criteria) this;
        }

        public Criteria andSpeSizeNotBetween(String value1, String value2) {
            addCriterion("spe_size not between", value1, value2, "speSize");
            return (Criteria) this;
        }

        public Criteria andSpePriceIsNull() {
            addCriterion("spe_price is null");
            return (Criteria) this;
        }

        public Criteria andSpePriceIsNotNull() {
            addCriterion("spe_price is not null");
            return (Criteria) this;
        }

        public Criteria andSpePriceEqualTo(String value) {
            addCriterion("spe_price =", value, "spePrice");
            return (Criteria) this;
        }

        public Criteria andSpePriceNotEqualTo(String value) {
            addCriterion("spe_price <>", value, "spePrice");
            return (Criteria) this;
        }

        public Criteria andSpePriceGreaterThan(String value) {
            addCriterion("spe_price >", value, "spePrice");
            return (Criteria) this;
        }

        public Criteria andSpePriceGreaterThanOrEqualTo(String value) {
            addCriterion("spe_price >=", value, "spePrice");
            return (Criteria) this;
        }

        public Criteria andSpePriceLessThan(String value) {
            addCriterion("spe_price <", value, "spePrice");
            return (Criteria) this;
        }

        public Criteria andSpePriceLessThanOrEqualTo(String value) {
            addCriterion("spe_price <=", value, "spePrice");
            return (Criteria) this;
        }

        public Criteria andSpePriceLike(String value) {
            addCriterion("spe_price like", value, "spePrice");
            return (Criteria) this;
        }

        public Criteria andSpePriceNotLike(String value) {
            addCriterion("spe_price not like", value, "spePrice");
            return (Criteria) this;
        }

        public Criteria andSpePriceIn(List<String> values) {
            addCriterion("spe_price in", values, "spePrice");
            return (Criteria) this;
        }

        public Criteria andSpePriceNotIn(List<String> values) {
            addCriterion("spe_price not in", values, "spePrice");
            return (Criteria) this;
        }

        public Criteria andSpePriceBetween(String value1, String value2) {
            addCriterion("spe_price between", value1, value2, "spePrice");
            return (Criteria) this;
        }

        public Criteria andSpePriceNotBetween(String value1, String value2) {
            addCriterion("spe_price not between", value1, value2, "spePrice");
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