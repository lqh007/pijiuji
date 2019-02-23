package com.pijiuji.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PjjExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PjjExample() {
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

        public Criteria andPjjIdIsNull() {
            addCriterion("pjj_id is null");
            return (Criteria) this;
        }

        public Criteria andPjjIdIsNotNull() {
            addCriterion("pjj_id is not null");
            return (Criteria) this;
        }

        public Criteria andPjjIdEqualTo(Integer value) {
            addCriterion("pjj_id =", value, "pjjId");
            return (Criteria) this;
        }

        public Criteria andPjjIdNotEqualTo(Integer value) {
            addCriterion("pjj_id <>", value, "pjjId");
            return (Criteria) this;
        }

        public Criteria andPjjIdGreaterThan(Integer value) {
            addCriterion("pjj_id >", value, "pjjId");
            return (Criteria) this;
        }

        public Criteria andPjjIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pjj_id >=", value, "pjjId");
            return (Criteria) this;
        }

        public Criteria andPjjIdLessThan(Integer value) {
            addCriterion("pjj_id <", value, "pjjId");
            return (Criteria) this;
        }

        public Criteria andPjjIdLessThanOrEqualTo(Integer value) {
            addCriterion("pjj_id <=", value, "pjjId");
            return (Criteria) this;
        }

        public Criteria andPjjIdIn(List<Integer> values) {
            addCriterion("pjj_id in", values, "pjjId");
            return (Criteria) this;
        }

        public Criteria andPjjIdNotIn(List<Integer> values) {
            addCriterion("pjj_id not in", values, "pjjId");
            return (Criteria) this;
        }

        public Criteria andPjjIdBetween(Integer value1, Integer value2) {
            addCriterion("pjj_id between", value1, value2, "pjjId");
            return (Criteria) this;
        }

        public Criteria andPjjIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pjj_id not between", value1, value2, "pjjId");
            return (Criteria) this;
        }

        public Criteria andPjjAddressIsNull() {
            addCriterion("pjj_address is null");
            return (Criteria) this;
        }

        public Criteria andPjjAddressIsNotNull() {
            addCriterion("pjj_address is not null");
            return (Criteria) this;
        }

        public Criteria andPjjAddressEqualTo(String value) {
            addCriterion("pjj_address =", value, "pjjAddress");
            return (Criteria) this;
        }

        public Criteria andPjjAddressNotEqualTo(String value) {
            addCriterion("pjj_address <>", value, "pjjAddress");
            return (Criteria) this;
        }

        public Criteria andPjjAddressGreaterThan(String value) {
            addCriterion("pjj_address >", value, "pjjAddress");
            return (Criteria) this;
        }

        public Criteria andPjjAddressGreaterThanOrEqualTo(String value) {
            addCriterion("pjj_address >=", value, "pjjAddress");
            return (Criteria) this;
        }

        public Criteria andPjjAddressLessThan(String value) {
            addCriterion("pjj_address <", value, "pjjAddress");
            return (Criteria) this;
        }

        public Criteria andPjjAddressLessThanOrEqualTo(String value) {
            addCriterion("pjj_address <=", value, "pjjAddress");
            return (Criteria) this;
        }

        public Criteria andPjjAddressLike(String value) {
            addCriterion("pjj_address like", value, "pjjAddress");
            return (Criteria) this;
        }

        public Criteria andPjjAddressNotLike(String value) {
            addCriterion("pjj_address not like", value, "pjjAddress");
            return (Criteria) this;
        }

        public Criteria andPjjAddressIn(List<String> values) {
            addCriterion("pjj_address in", values, "pjjAddress");
            return (Criteria) this;
        }

        public Criteria andPjjAddressNotIn(List<String> values) {
            addCriterion("pjj_address not in", values, "pjjAddress");
            return (Criteria) this;
        }

        public Criteria andPjjAddressBetween(String value1, String value2) {
            addCriterion("pjj_address between", value1, value2, "pjjAddress");
            return (Criteria) this;
        }

        public Criteria andPjjAddressNotBetween(String value1, String value2) {
            addCriterion("pjj_address not between", value1, value2, "pjjAddress");
            return (Criteria) this;
        }

        public Criteria andPjjStatusIsNull() {
            addCriterion("pjj_status is null");
            return (Criteria) this;
        }

        public Criteria andPjjStatusIsNotNull() {
            addCriterion("pjj_status is not null");
            return (Criteria) this;
        }

        public Criteria andPjjStatusEqualTo(String value) {
            addCriterion("pjj_status =", value, "pjjStatus");
            return (Criteria) this;
        }

        public Criteria andPjjStatusNotEqualTo(String value) {
            addCriterion("pjj_status <>", value, "pjjStatus");
            return (Criteria) this;
        }

        public Criteria andPjjStatusGreaterThan(String value) {
            addCriterion("pjj_status >", value, "pjjStatus");
            return (Criteria) this;
        }

        public Criteria andPjjStatusGreaterThanOrEqualTo(String value) {
            addCriterion("pjj_status >=", value, "pjjStatus");
            return (Criteria) this;
        }

        public Criteria andPjjStatusLessThan(String value) {
            addCriterion("pjj_status <", value, "pjjStatus");
            return (Criteria) this;
        }

        public Criteria andPjjStatusLessThanOrEqualTo(String value) {
            addCriterion("pjj_status <=", value, "pjjStatus");
            return (Criteria) this;
        }

        public Criteria andPjjStatusLike(String value) {
            addCriterion("pjj_status like", value, "pjjStatus");
            return (Criteria) this;
        }

        public Criteria andPjjStatusNotLike(String value) {
            addCriterion("pjj_status not like", value, "pjjStatus");
            return (Criteria) this;
        }

        public Criteria andPjjStatusIn(List<String> values) {
            addCriterion("pjj_status in", values, "pjjStatus");
            return (Criteria) this;
        }

        public Criteria andPjjStatusNotIn(List<String> values) {
            addCriterion("pjj_status not in", values, "pjjStatus");
            return (Criteria) this;
        }

        public Criteria andPjjStatusBetween(String value1, String value2) {
            addCriterion("pjj_status between", value1, value2, "pjjStatus");
            return (Criteria) this;
        }

        public Criteria andPjjStatusNotBetween(String value1, String value2) {
            addCriterion("pjj_status not between", value1, value2, "pjjStatus");
            return (Criteria) this;
        }

        public Criteria andPjjUserIdIsNull() {
            addCriterion("pjj_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPjjUserIdIsNotNull() {
            addCriterion("pjj_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPjjUserIdEqualTo(String value) {
            addCriterion("pjj_user_id =", value, "pjjUserId");
            return (Criteria) this;
        }

        public Criteria andPjjUserIdNotEqualTo(String value) {
            addCriterion("pjj_user_id <>", value, "pjjUserId");
            return (Criteria) this;
        }

        public Criteria andPjjUserIdGreaterThan(String value) {
            addCriterion("pjj_user_id >", value, "pjjUserId");
            return (Criteria) this;
        }

        public Criteria andPjjUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("pjj_user_id >=", value, "pjjUserId");
            return (Criteria) this;
        }

        public Criteria andPjjUserIdLessThan(String value) {
            addCriterion("pjj_user_id <", value, "pjjUserId");
            return (Criteria) this;
        }

        public Criteria andPjjUserIdLessThanOrEqualTo(String value) {
            addCriterion("pjj_user_id <=", value, "pjjUserId");
            return (Criteria) this;
        }

        public Criteria andPjjUserIdLike(String value) {
            addCriterion("pjj_user_id like", value, "pjjUserId");
            return (Criteria) this;
        }

        public Criteria andPjjUserIdNotLike(String value) {
            addCriterion("pjj_user_id not like", value, "pjjUserId");
            return (Criteria) this;
        }

        public Criteria andPjjUserIdIn(List<String> values) {
            addCriterion("pjj_user_id in", values, "pjjUserId");
            return (Criteria) this;
        }

        public Criteria andPjjUserIdNotIn(List<String> values) {
            addCriterion("pjj_user_id not in", values, "pjjUserId");
            return (Criteria) this;
        }

        public Criteria andPjjUserIdBetween(String value1, String value2) {
            addCriterion("pjj_user_id between", value1, value2, "pjjUserId");
            return (Criteria) this;
        }

        public Criteria andPjjUserIdNotBetween(String value1, String value2) {
            addCriterion("pjj_user_id not between", value1, value2, "pjjUserId");
            return (Criteria) this;
        }

        public Criteria andPjjTimeIsNull() {
            addCriterion("pjj_time is null");
            return (Criteria) this;
        }

        public Criteria andPjjTimeIsNotNull() {
            addCriterion("pjj_time is not null");
            return (Criteria) this;
        }

        public Criteria andPjjTimeEqualTo(Date value) {
            addCriterion("pjj_time =", value, "pjjTime");
            return (Criteria) this;
        }

        public Criteria andPjjTimeNotEqualTo(Date value) {
            addCriterion("pjj_time <>", value, "pjjTime");
            return (Criteria) this;
        }

        public Criteria andPjjTimeGreaterThan(Date value) {
            addCriterion("pjj_time >", value, "pjjTime");
            return (Criteria) this;
        }

        public Criteria andPjjTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pjj_time >=", value, "pjjTime");
            return (Criteria) this;
        }

        public Criteria andPjjTimeLessThan(Date value) {
            addCriterion("pjj_time <", value, "pjjTime");
            return (Criteria) this;
        }

        public Criteria andPjjTimeLessThanOrEqualTo(Date value) {
            addCriterion("pjj_time <=", value, "pjjTime");
            return (Criteria) this;
        }

        public Criteria andPjjTimeIn(List<Date> values) {
            addCriterion("pjj_time in", values, "pjjTime");
            return (Criteria) this;
        }

        public Criteria andPjjTimeNotIn(List<Date> values) {
            addCriterion("pjj_time not in", values, "pjjTime");
            return (Criteria) this;
        }

        public Criteria andPjjTimeBetween(Date value1, Date value2) {
            addCriterion("pjj_time between", value1, value2, "pjjTime");
            return (Criteria) this;
        }

        public Criteria andPjjTimeNotBetween(Date value1, Date value2) {
            addCriterion("pjj_time not between", value1, value2, "pjjTime");
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