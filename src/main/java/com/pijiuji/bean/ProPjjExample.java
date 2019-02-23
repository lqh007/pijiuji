package com.pijiuji.bean;

import java.util.ArrayList;
import java.util.List;

public class ProPjjExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProPjjExample() {
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

        public Criteria andPropjjIdIsNull() {
            addCriterion("propjj_id is null");
            return (Criteria) this;
        }

        public Criteria andPropjjIdIsNotNull() {
            addCriterion("propjj_id is not null");
            return (Criteria) this;
        }

        public Criteria andPropjjIdEqualTo(String value) {
            addCriterion("propjj_id =", value, "propjjId");
            return (Criteria) this;
        }

        public Criteria andPropjjIdNotEqualTo(String value) {
            addCriterion("propjj_id <>", value, "propjjId");
            return (Criteria) this;
        }

        public Criteria andPropjjIdGreaterThan(String value) {
            addCriterion("propjj_id >", value, "propjjId");
            return (Criteria) this;
        }

        public Criteria andPropjjIdGreaterThanOrEqualTo(String value) {
            addCriterion("propjj_id >=", value, "propjjId");
            return (Criteria) this;
        }

        public Criteria andPropjjIdLessThan(String value) {
            addCriterion("propjj_id <", value, "propjjId");
            return (Criteria) this;
        }

        public Criteria andPropjjIdLessThanOrEqualTo(String value) {
            addCriterion("propjj_id <=", value, "propjjId");
            return (Criteria) this;
        }

        public Criteria andPropjjIdLike(String value) {
            addCriterion("propjj_id like", value, "propjjId");
            return (Criteria) this;
        }

        public Criteria andPropjjIdNotLike(String value) {
            addCriterion("propjj_id not like", value, "propjjId");
            return (Criteria) this;
        }

        public Criteria andPropjjIdIn(List<String> values) {
            addCriterion("propjj_id in", values, "propjjId");
            return (Criteria) this;
        }

        public Criteria andPropjjIdNotIn(List<String> values) {
            addCriterion("propjj_id not in", values, "propjjId");
            return (Criteria) this;
        }

        public Criteria andPropjjIdBetween(String value1, String value2) {
            addCriterion("propjj_id between", value1, value2, "propjjId");
            return (Criteria) this;
        }

        public Criteria andPropjjIdNotBetween(String value1, String value2) {
            addCriterion("propjj_id not between", value1, value2, "propjjId");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjCodeIsNull() {
            addCriterion("propjj_pjj_code is null");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjCodeIsNotNull() {
            addCriterion("propjj_pjj_code is not null");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjCodeEqualTo(String value) {
            addCriterion("propjj_pjj_code =", value, "propjjPjjCode");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjCodeNotEqualTo(String value) {
            addCriterion("propjj_pjj_code <>", value, "propjjPjjCode");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjCodeGreaterThan(String value) {
            addCriterion("propjj_pjj_code >", value, "propjjPjjCode");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjCodeGreaterThanOrEqualTo(String value) {
            addCriterion("propjj_pjj_code >=", value, "propjjPjjCode");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjCodeLessThan(String value) {
            addCriterion("propjj_pjj_code <", value, "propjjPjjCode");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjCodeLessThanOrEqualTo(String value) {
            addCriterion("propjj_pjj_code <=", value, "propjjPjjCode");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjCodeLike(String value) {
            addCriterion("propjj_pjj_code like", value, "propjjPjjCode");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjCodeNotLike(String value) {
            addCriterion("propjj_pjj_code not like", value, "propjjPjjCode");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjCodeIn(List<String> values) {
            addCriterion("propjj_pjj_code in", values, "propjjPjjCode");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjCodeNotIn(List<String> values) {
            addCriterion("propjj_pjj_code not in", values, "propjjPjjCode");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjCodeBetween(String value1, String value2) {
            addCriterion("propjj_pjj_code between", value1, value2, "propjjPjjCode");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjCodeNotBetween(String value1, String value2) {
            addCriterion("propjj_pjj_code not between", value1, value2, "propjjPjjCode");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjProidIsNull() {
            addCriterion("propjj_pjj_proid is null");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjProidIsNotNull() {
            addCriterion("propjj_pjj_proid is not null");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjProidEqualTo(String value) {
            addCriterion("propjj_pjj_proid =", value, "propjjPjjProid");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjProidNotEqualTo(String value) {
            addCriterion("propjj_pjj_proid <>", value, "propjjPjjProid");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjProidGreaterThan(String value) {
            addCriterion("propjj_pjj_proid >", value, "propjjPjjProid");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjProidGreaterThanOrEqualTo(String value) {
            addCriterion("propjj_pjj_proid >=", value, "propjjPjjProid");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjProidLessThan(String value) {
            addCriterion("propjj_pjj_proid <", value, "propjjPjjProid");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjProidLessThanOrEqualTo(String value) {
            addCriterion("propjj_pjj_proid <=", value, "propjjPjjProid");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjProidLike(String value) {
            addCriterion("propjj_pjj_proid like", value, "propjjPjjProid");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjProidNotLike(String value) {
            addCriterion("propjj_pjj_proid not like", value, "propjjPjjProid");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjProidIn(List<String> values) {
            addCriterion("propjj_pjj_proid in", values, "propjjPjjProid");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjProidNotIn(List<String> values) {
            addCriterion("propjj_pjj_proid not in", values, "propjjPjjProid");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjProidBetween(String value1, String value2) {
            addCriterion("propjj_pjj_proid between", value1, value2, "propjjPjjProid");
            return (Criteria) this;
        }

        public Criteria andPropjjPjjProidNotBetween(String value1, String value2) {
            addCriterion("propjj_pjj_proid not between", value1, value2, "propjjPjjProid");
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