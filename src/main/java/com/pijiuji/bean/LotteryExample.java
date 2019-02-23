package com.pijiuji.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LotteryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LotteryExample() {
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

        public Criteria andLotteryIdIsNull() {
            addCriterion("lottery_id is null");
            return (Criteria) this;
        }

        public Criteria andLotteryIdIsNotNull() {
            addCriterion("lottery_id is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryIdEqualTo(Integer value) {
            addCriterion("lottery_id =", value, "lotteryId");
            return (Criteria) this;
        }

        public Criteria andLotteryIdNotEqualTo(Integer value) {
            addCriterion("lottery_id <>", value, "lotteryId");
            return (Criteria) this;
        }

        public Criteria andLotteryIdGreaterThan(Integer value) {
            addCriterion("lottery_id >", value, "lotteryId");
            return (Criteria) this;
        }

        public Criteria andLotteryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("lottery_id >=", value, "lotteryId");
            return (Criteria) this;
        }

        public Criteria andLotteryIdLessThan(Integer value) {
            addCriterion("lottery_id <", value, "lotteryId");
            return (Criteria) this;
        }

        public Criteria andLotteryIdLessThanOrEqualTo(Integer value) {
            addCriterion("lottery_id <=", value, "lotteryId");
            return (Criteria) this;
        }

        public Criteria andLotteryIdIn(List<Integer> values) {
            addCriterion("lottery_id in", values, "lotteryId");
            return (Criteria) this;
        }

        public Criteria andLotteryIdNotIn(List<Integer> values) {
            addCriterion("lottery_id not in", values, "lotteryId");
            return (Criteria) this;
        }

        public Criteria andLotteryIdBetween(Integer value1, Integer value2) {
            addCriterion("lottery_id between", value1, value2, "lotteryId");
            return (Criteria) this;
        }

        public Criteria andLotteryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("lottery_id not between", value1, value2, "lotteryId");
            return (Criteria) this;
        }

        public Criteria andLotteryNameIsNull() {
            addCriterion("lottery_name is null");
            return (Criteria) this;
        }

        public Criteria andLotteryNameIsNotNull() {
            addCriterion("lottery_name is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryNameEqualTo(String value) {
            addCriterion("lottery_name =", value, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameNotEqualTo(String value) {
            addCriterion("lottery_name <>", value, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameGreaterThan(String value) {
            addCriterion("lottery_name >", value, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameGreaterThanOrEqualTo(String value) {
            addCriterion("lottery_name >=", value, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameLessThan(String value) {
            addCriterion("lottery_name <", value, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameLessThanOrEqualTo(String value) {
            addCriterion("lottery_name <=", value, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameLike(String value) {
            addCriterion("lottery_name like", value, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameNotLike(String value) {
            addCriterion("lottery_name not like", value, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameIn(List<String> values) {
            addCriterion("lottery_name in", values, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameNotIn(List<String> values) {
            addCriterion("lottery_name not in", values, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameBetween(String value1, String value2) {
            addCriterion("lottery_name between", value1, value2, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryNameNotBetween(String value1, String value2) {
            addCriterion("lottery_name not between", value1, value2, "lotteryName");
            return (Criteria) this;
        }

        public Criteria andLotteryGailvIsNull() {
            addCriterion("lottery_gailv is null");
            return (Criteria) this;
        }

        public Criteria andLotteryGailvIsNotNull() {
            addCriterion("lottery_gailv is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryGailvEqualTo(Integer value) {
            addCriterion("lottery_gailv =", value, "lotteryGailv");
            return (Criteria) this;
        }

        public Criteria andLotteryGailvNotEqualTo(Integer value) {
            addCriterion("lottery_gailv <>", value, "lotteryGailv");
            return (Criteria) this;
        }

        public Criteria andLotteryGailvGreaterThan(Integer value) {
            addCriterion("lottery_gailv >", value, "lotteryGailv");
            return (Criteria) this;
        }

        public Criteria andLotteryGailvGreaterThanOrEqualTo(Integer value) {
            addCriterion("lottery_gailv >=", value, "lotteryGailv");
            return (Criteria) this;
        }

        public Criteria andLotteryGailvLessThan(Integer value) {
            addCriterion("lottery_gailv <", value, "lotteryGailv");
            return (Criteria) this;
        }

        public Criteria andLotteryGailvLessThanOrEqualTo(Integer value) {
            addCriterion("lottery_gailv <=", value, "lotteryGailv");
            return (Criteria) this;
        }

        public Criteria andLotteryGailvIn(List<Integer> values) {
            addCriterion("lottery_gailv in", values, "lotteryGailv");
            return (Criteria) this;
        }

        public Criteria andLotteryGailvNotIn(List<Integer> values) {
            addCriterion("lottery_gailv not in", values, "lotteryGailv");
            return (Criteria) this;
        }

        public Criteria andLotteryGailvBetween(Integer value1, Integer value2) {
            addCriterion("lottery_gailv between", value1, value2, "lotteryGailv");
            return (Criteria) this;
        }

        public Criteria andLotteryGailvNotBetween(Integer value1, Integer value2) {
            addCriterion("lottery_gailv not between", value1, value2, "lotteryGailv");
            return (Criteria) this;
        }

        public Criteria andLotteryImgIsNull() {
            addCriterion("lottery_img is null");
            return (Criteria) this;
        }

        public Criteria andLotteryImgIsNotNull() {
            addCriterion("lottery_img is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryImgEqualTo(String value) {
            addCriterion("lottery_img =", value, "lotteryImg");
            return (Criteria) this;
        }

        public Criteria andLotteryImgNotEqualTo(String value) {
            addCriterion("lottery_img <>", value, "lotteryImg");
            return (Criteria) this;
        }

        public Criteria andLotteryImgGreaterThan(String value) {
            addCriterion("lottery_img >", value, "lotteryImg");
            return (Criteria) this;
        }

        public Criteria andLotteryImgGreaterThanOrEqualTo(String value) {
            addCriterion("lottery_img >=", value, "lotteryImg");
            return (Criteria) this;
        }

        public Criteria andLotteryImgLessThan(String value) {
            addCriterion("lottery_img <", value, "lotteryImg");
            return (Criteria) this;
        }

        public Criteria andLotteryImgLessThanOrEqualTo(String value) {
            addCriterion("lottery_img <=", value, "lotteryImg");
            return (Criteria) this;
        }

        public Criteria andLotteryImgLike(String value) {
            addCriterion("lottery_img like", value, "lotteryImg");
            return (Criteria) this;
        }

        public Criteria andLotteryImgNotLike(String value) {
            addCriterion("lottery_img not like", value, "lotteryImg");
            return (Criteria) this;
        }

        public Criteria andLotteryImgIn(List<String> values) {
            addCriterion("lottery_img in", values, "lotteryImg");
            return (Criteria) this;
        }

        public Criteria andLotteryImgNotIn(List<String> values) {
            addCriterion("lottery_img not in", values, "lotteryImg");
            return (Criteria) this;
        }

        public Criteria andLotteryImgBetween(String value1, String value2) {
            addCriterion("lottery_img between", value1, value2, "lotteryImg");
            return (Criteria) this;
        }

        public Criteria andLotteryImgNotBetween(String value1, String value2) {
            addCriterion("lottery_img not between", value1, value2, "lotteryImg");
            return (Criteria) this;
        }

        public Criteria andLotteryTimeIsNull() {
            addCriterion("lottery_time is null");
            return (Criteria) this;
        }

        public Criteria andLotteryTimeIsNotNull() {
            addCriterion("lottery_time is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryTimeEqualTo(Date value) {
            addCriterion("lottery_time =", value, "lotteryTime");
            return (Criteria) this;
        }

        public Criteria andLotteryTimeNotEqualTo(Date value) {
            addCriterion("lottery_time <>", value, "lotteryTime");
            return (Criteria) this;
        }

        public Criteria andLotteryTimeGreaterThan(Date value) {
            addCriterion("lottery_time >", value, "lotteryTime");
            return (Criteria) this;
        }

        public Criteria andLotteryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lottery_time >=", value, "lotteryTime");
            return (Criteria) this;
        }

        public Criteria andLotteryTimeLessThan(Date value) {
            addCriterion("lottery_time <", value, "lotteryTime");
            return (Criteria) this;
        }

        public Criteria andLotteryTimeLessThanOrEqualTo(Date value) {
            addCriterion("lottery_time <=", value, "lotteryTime");
            return (Criteria) this;
        }

        public Criteria andLotteryTimeIn(List<Date> values) {
            addCriterion("lottery_time in", values, "lotteryTime");
            return (Criteria) this;
        }

        public Criteria andLotteryTimeNotIn(List<Date> values) {
            addCriterion("lottery_time not in", values, "lotteryTime");
            return (Criteria) this;
        }

        public Criteria andLotteryTimeBetween(Date value1, Date value2) {
            addCriterion("lottery_time between", value1, value2, "lotteryTime");
            return (Criteria) this;
        }

        public Criteria andLotteryTimeNotBetween(Date value1, Date value2) {
            addCriterion("lottery_time not between", value1, value2, "lotteryTime");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIsNull() {
            addCriterion("lottery_type is null");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIsNotNull() {
            addCriterion("lottery_type is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeEqualTo(String value) {
            addCriterion("lottery_type =", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeNotEqualTo(String value) {
            addCriterion("lottery_type <>", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeGreaterThan(String value) {
            addCriterion("lottery_type >", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("lottery_type >=", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeLessThan(String value) {
            addCriterion("lottery_type <", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeLessThanOrEqualTo(String value) {
            addCriterion("lottery_type <=", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeLike(String value) {
            addCriterion("lottery_type like", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeNotLike(String value) {
            addCriterion("lottery_type not like", value, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeIn(List<String> values) {
            addCriterion("lottery_type in", values, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeNotIn(List<String> values) {
            addCriterion("lottery_type not in", values, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeBetween(String value1, String value2) {
            addCriterion("lottery_type between", value1, value2, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypeNotBetween(String value1, String value2) {
            addCriterion("lottery_type not between", value1, value2, "lotteryType");
            return (Criteria) this;
        }

        public Criteria andLotteryTypedetailIsNull() {
            addCriterion("lottery_typedetail is null");
            return (Criteria) this;
        }

        public Criteria andLotteryTypedetailIsNotNull() {
            addCriterion("lottery_typedetail is not null");
            return (Criteria) this;
        }

        public Criteria andLotteryTypedetailEqualTo(String value) {
            addCriterion("lottery_typedetail =", value, "lotteryTypedetail");
            return (Criteria) this;
        }

        public Criteria andLotteryTypedetailNotEqualTo(String value) {
            addCriterion("lottery_typedetail <>", value, "lotteryTypedetail");
            return (Criteria) this;
        }

        public Criteria andLotteryTypedetailGreaterThan(String value) {
            addCriterion("lottery_typedetail >", value, "lotteryTypedetail");
            return (Criteria) this;
        }

        public Criteria andLotteryTypedetailGreaterThanOrEqualTo(String value) {
            addCriterion("lottery_typedetail >=", value, "lotteryTypedetail");
            return (Criteria) this;
        }

        public Criteria andLotteryTypedetailLessThan(String value) {
            addCriterion("lottery_typedetail <", value, "lotteryTypedetail");
            return (Criteria) this;
        }

        public Criteria andLotteryTypedetailLessThanOrEqualTo(String value) {
            addCriterion("lottery_typedetail <=", value, "lotteryTypedetail");
            return (Criteria) this;
        }

        public Criteria andLotteryTypedetailLike(String value) {
            addCriterion("lottery_typedetail like", value, "lotteryTypedetail");
            return (Criteria) this;
        }

        public Criteria andLotteryTypedetailNotLike(String value) {
            addCriterion("lottery_typedetail not like", value, "lotteryTypedetail");
            return (Criteria) this;
        }

        public Criteria andLotteryTypedetailIn(List<String> values) {
            addCriterion("lottery_typedetail in", values, "lotteryTypedetail");
            return (Criteria) this;
        }

        public Criteria andLotteryTypedetailNotIn(List<String> values) {
            addCriterion("lottery_typedetail not in", values, "lotteryTypedetail");
            return (Criteria) this;
        }

        public Criteria andLotteryTypedetailBetween(String value1, String value2) {
            addCriterion("lottery_typedetail between", value1, value2, "lotteryTypedetail");
            return (Criteria) this;
        }

        public Criteria andLotteryTypedetailNotBetween(String value1, String value2) {
            addCriterion("lottery_typedetail not between", value1, value2, "lotteryTypedetail");
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