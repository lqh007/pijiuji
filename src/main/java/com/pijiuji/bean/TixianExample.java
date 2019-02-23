package com.pijiuji.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TixianExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TixianExample() {
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

        public Criteria andTxIdIsNull() {
            addCriterion("tx_id is null");
            return (Criteria) this;
        }

        public Criteria andTxIdIsNotNull() {
            addCriterion("tx_id is not null");
            return (Criteria) this;
        }

        public Criteria andTxIdEqualTo(Integer value) {
            addCriterion("tx_id =", value, "txId");
            return (Criteria) this;
        }

        public Criteria andTxIdNotEqualTo(Integer value) {
            addCriterion("tx_id <>", value, "txId");
            return (Criteria) this;
        }

        public Criteria andTxIdGreaterThan(Integer value) {
            addCriterion("tx_id >", value, "txId");
            return (Criteria) this;
        }

        public Criteria andTxIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tx_id >=", value, "txId");
            return (Criteria) this;
        }

        public Criteria andTxIdLessThan(Integer value) {
            addCriterion("tx_id <", value, "txId");
            return (Criteria) this;
        }

        public Criteria andTxIdLessThanOrEqualTo(Integer value) {
            addCriterion("tx_id <=", value, "txId");
            return (Criteria) this;
        }

        public Criteria andTxIdIn(List<Integer> values) {
            addCriterion("tx_id in", values, "txId");
            return (Criteria) this;
        }

        public Criteria andTxIdNotIn(List<Integer> values) {
            addCriterion("tx_id not in", values, "txId");
            return (Criteria) this;
        }

        public Criteria andTxIdBetween(Integer value1, Integer value2) {
            addCriterion("tx_id between", value1, value2, "txId");
            return (Criteria) this;
        }

        public Criteria andTxIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tx_id not between", value1, value2, "txId");
            return (Criteria) this;
        }

        public Criteria andTxUseridIsNull() {
            addCriterion("tx_userid is null");
            return (Criteria) this;
        }

        public Criteria andTxUseridIsNotNull() {
            addCriterion("tx_userid is not null");
            return (Criteria) this;
        }

        public Criteria andTxUseridEqualTo(String value) {
            addCriterion("tx_userid =", value, "txUserid");
            return (Criteria) this;
        }

        public Criteria andTxUseridNotEqualTo(String value) {
            addCriterion("tx_userid <>", value, "txUserid");
            return (Criteria) this;
        }

        public Criteria andTxUseridGreaterThan(String value) {
            addCriterion("tx_userid >", value, "txUserid");
            return (Criteria) this;
        }

        public Criteria andTxUseridGreaterThanOrEqualTo(String value) {
            addCriterion("tx_userid >=", value, "txUserid");
            return (Criteria) this;
        }

        public Criteria andTxUseridLessThan(String value) {
            addCriterion("tx_userid <", value, "txUserid");
            return (Criteria) this;
        }

        public Criteria andTxUseridLessThanOrEqualTo(String value) {
            addCriterion("tx_userid <=", value, "txUserid");
            return (Criteria) this;
        }

        public Criteria andTxUseridLike(String value) {
            addCriterion("tx_userid like", value, "txUserid");
            return (Criteria) this;
        }

        public Criteria andTxUseridNotLike(String value) {
            addCriterion("tx_userid not like", value, "txUserid");
            return (Criteria) this;
        }

        public Criteria andTxUseridIn(List<String> values) {
            addCriterion("tx_userid in", values, "txUserid");
            return (Criteria) this;
        }

        public Criteria andTxUseridNotIn(List<String> values) {
            addCriterion("tx_userid not in", values, "txUserid");
            return (Criteria) this;
        }

        public Criteria andTxUseridBetween(String value1, String value2) {
            addCriterion("tx_userid between", value1, value2, "txUserid");
            return (Criteria) this;
        }

        public Criteria andTxUseridNotBetween(String value1, String value2) {
            addCriterion("tx_userid not between", value1, value2, "txUserid");
            return (Criteria) this;
        }

        public Criteria andTxMoneyIsNull() {
            addCriterion("tx_money is null");
            return (Criteria) this;
        }

        public Criteria andTxMoneyIsNotNull() {
            addCriterion("tx_money is not null");
            return (Criteria) this;
        }

        public Criteria andTxMoneyEqualTo(String value) {
            addCriterion("tx_money =", value, "txMoney");
            return (Criteria) this;
        }

        public Criteria andTxMoneyNotEqualTo(String value) {
            addCriterion("tx_money <>", value, "txMoney");
            return (Criteria) this;
        }

        public Criteria andTxMoneyGreaterThan(String value) {
            addCriterion("tx_money >", value, "txMoney");
            return (Criteria) this;
        }

        public Criteria andTxMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("tx_money >=", value, "txMoney");
            return (Criteria) this;
        }

        public Criteria andTxMoneyLessThan(String value) {
            addCriterion("tx_money <", value, "txMoney");
            return (Criteria) this;
        }

        public Criteria andTxMoneyLessThanOrEqualTo(String value) {
            addCriterion("tx_money <=", value, "txMoney");
            return (Criteria) this;
        }

        public Criteria andTxMoneyLike(String value) {
            addCriterion("tx_money like", value, "txMoney");
            return (Criteria) this;
        }

        public Criteria andTxMoneyNotLike(String value) {
            addCriterion("tx_money not like", value, "txMoney");
            return (Criteria) this;
        }

        public Criteria andTxMoneyIn(List<String> values) {
            addCriterion("tx_money in", values, "txMoney");
            return (Criteria) this;
        }

        public Criteria andTxMoneyNotIn(List<String> values) {
            addCriterion("tx_money not in", values, "txMoney");
            return (Criteria) this;
        }

        public Criteria andTxMoneyBetween(String value1, String value2) {
            addCriterion("tx_money between", value1, value2, "txMoney");
            return (Criteria) this;
        }

        public Criteria andTxMoneyNotBetween(String value1, String value2) {
            addCriterion("tx_money not between", value1, value2, "txMoney");
            return (Criteria) this;
        }

        public Criteria andTxTimeIsNull() {
            addCriterion("tx_time is null");
            return (Criteria) this;
        }

        public Criteria andTxTimeIsNotNull() {
            addCriterion("tx_time is not null");
            return (Criteria) this;
        }

        public Criteria andTxTimeEqualTo(Date value) {
            addCriterion("tx_time =", value, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeNotEqualTo(Date value) {
            addCriterion("tx_time <>", value, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeGreaterThan(Date value) {
            addCriterion("tx_time >", value, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("tx_time >=", value, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeLessThan(Date value) {
            addCriterion("tx_time <", value, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeLessThanOrEqualTo(Date value) {
            addCriterion("tx_time <=", value, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeIn(List<Date> values) {
            addCriterion("tx_time in", values, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeNotIn(List<Date> values) {
            addCriterion("tx_time not in", values, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeBetween(Date value1, Date value2) {
            addCriterion("tx_time between", value1, value2, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeNotBetween(Date value1, Date value2) {
            addCriterion("tx_time not between", value1, value2, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxSuccessTimeIsNull() {
            addCriterion("tx_success_time is null");
            return (Criteria) this;
        }

        public Criteria andTxSuccessTimeIsNotNull() {
            addCriterion("tx_success_time is not null");
            return (Criteria) this;
        }

        public Criteria andTxSuccessTimeEqualTo(String value) {
            addCriterion("tx_success_time =", value, "txSuccessTime");
            return (Criteria) this;
        }

        public Criteria andTxSuccessTimeNotEqualTo(String value) {
            addCriterion("tx_success_time <>", value, "txSuccessTime");
            return (Criteria) this;
        }

        public Criteria andTxSuccessTimeGreaterThan(String value) {
            addCriterion("tx_success_time >", value, "txSuccessTime");
            return (Criteria) this;
        }

        public Criteria andTxSuccessTimeGreaterThanOrEqualTo(String value) {
            addCriterion("tx_success_time >=", value, "txSuccessTime");
            return (Criteria) this;
        }

        public Criteria andTxSuccessTimeLessThan(String value) {
            addCriterion("tx_success_time <", value, "txSuccessTime");
            return (Criteria) this;
        }

        public Criteria andTxSuccessTimeLessThanOrEqualTo(String value) {
            addCriterion("tx_success_time <=", value, "txSuccessTime");
            return (Criteria) this;
        }

        public Criteria andTxSuccessTimeLike(String value) {
            addCriterion("tx_success_time like", value, "txSuccessTime");
            return (Criteria) this;
        }

        public Criteria andTxSuccessTimeNotLike(String value) {
            addCriterion("tx_success_time not like", value, "txSuccessTime");
            return (Criteria) this;
        }

        public Criteria andTxSuccessTimeIn(List<String> values) {
            addCriterion("tx_success_time in", values, "txSuccessTime");
            return (Criteria) this;
        }

        public Criteria andTxSuccessTimeNotIn(List<String> values) {
            addCriterion("tx_success_time not in", values, "txSuccessTime");
            return (Criteria) this;
        }

        public Criteria andTxSuccessTimeBetween(String value1, String value2) {
            addCriterion("tx_success_time between", value1, value2, "txSuccessTime");
            return (Criteria) this;
        }

        public Criteria andTxSuccessTimeNotBetween(String value1, String value2) {
            addCriterion("tx_success_time not between", value1, value2, "txSuccessTime");
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