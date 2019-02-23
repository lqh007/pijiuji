package com.pijiuji.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserLotteryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserLotteryExample() {
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

        public Criteria andUlIdIsNull() {
            addCriterion("ul_id is null");
            return (Criteria) this;
        }

        public Criteria andUlIdIsNotNull() {
            addCriterion("ul_id is not null");
            return (Criteria) this;
        }

        public Criteria andUlIdEqualTo(String value) {
            addCriterion("ul_id =", value, "ulId");
            return (Criteria) this;
        }

        public Criteria andUlIdNotEqualTo(String value) {
            addCriterion("ul_id <>", value, "ulId");
            return (Criteria) this;
        }

        public Criteria andUlIdGreaterThan(String value) {
            addCriterion("ul_id >", value, "ulId");
            return (Criteria) this;
        }

        public Criteria andUlIdGreaterThanOrEqualTo(String value) {
            addCriterion("ul_id >=", value, "ulId");
            return (Criteria) this;
        }

        public Criteria andUlIdLessThan(String value) {
            addCriterion("ul_id <", value, "ulId");
            return (Criteria) this;
        }

        public Criteria andUlIdLessThanOrEqualTo(String value) {
            addCriterion("ul_id <=", value, "ulId");
            return (Criteria) this;
        }

        public Criteria andUlIdLike(String value) {
            addCriterion("ul_id like", value, "ulId");
            return (Criteria) this;
        }

        public Criteria andUlIdNotLike(String value) {
            addCriterion("ul_id not like", value, "ulId");
            return (Criteria) this;
        }

        public Criteria andUlIdIn(List<String> values) {
            addCriterion("ul_id in", values, "ulId");
            return (Criteria) this;
        }

        public Criteria andUlIdNotIn(List<String> values) {
            addCriterion("ul_id not in", values, "ulId");
            return (Criteria) this;
        }

        public Criteria andUlIdBetween(String value1, String value2) {
            addCriterion("ul_id between", value1, value2, "ulId");
            return (Criteria) this;
        }

        public Criteria andUlIdNotBetween(String value1, String value2) {
            addCriterion("ul_id not between", value1, value2, "ulId");
            return (Criteria) this;
        }

        public Criteria andUlUserOpenidIsNull() {
            addCriterion("ul_user_openid is null");
            return (Criteria) this;
        }

        public Criteria andUlUserOpenidIsNotNull() {
            addCriterion("ul_user_openid is not null");
            return (Criteria) this;
        }

        public Criteria andUlUserOpenidEqualTo(String value) {
            addCriterion("ul_user_openid =", value, "ulUserOpenid");
            return (Criteria) this;
        }

        public Criteria andUlUserOpenidNotEqualTo(String value) {
            addCriterion("ul_user_openid <>", value, "ulUserOpenid");
            return (Criteria) this;
        }

        public Criteria andUlUserOpenidGreaterThan(String value) {
            addCriterion("ul_user_openid >", value, "ulUserOpenid");
            return (Criteria) this;
        }

        public Criteria andUlUserOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("ul_user_openid >=", value, "ulUserOpenid");
            return (Criteria) this;
        }

        public Criteria andUlUserOpenidLessThan(String value) {
            addCriterion("ul_user_openid <", value, "ulUserOpenid");
            return (Criteria) this;
        }

        public Criteria andUlUserOpenidLessThanOrEqualTo(String value) {
            addCriterion("ul_user_openid <=", value, "ulUserOpenid");
            return (Criteria) this;
        }

        public Criteria andUlUserOpenidLike(String value) {
            addCriterion("ul_user_openid like", value, "ulUserOpenid");
            return (Criteria) this;
        }

        public Criteria andUlUserOpenidNotLike(String value) {
            addCriterion("ul_user_openid not like", value, "ulUserOpenid");
            return (Criteria) this;
        }

        public Criteria andUlUserOpenidIn(List<String> values) {
            addCriterion("ul_user_openid in", values, "ulUserOpenid");
            return (Criteria) this;
        }

        public Criteria andUlUserOpenidNotIn(List<String> values) {
            addCriterion("ul_user_openid not in", values, "ulUserOpenid");
            return (Criteria) this;
        }

        public Criteria andUlUserOpenidBetween(String value1, String value2) {
            addCriterion("ul_user_openid between", value1, value2, "ulUserOpenid");
            return (Criteria) this;
        }

        public Criteria andUlUserOpenidNotBetween(String value1, String value2) {
            addCriterion("ul_user_openid not between", value1, value2, "ulUserOpenid");
            return (Criteria) this;
        }

        public Criteria andUlLotteryNameIsNull() {
            addCriterion("ul_lottery_name is null");
            return (Criteria) this;
        }

        public Criteria andUlLotteryNameIsNotNull() {
            addCriterion("ul_lottery_name is not null");
            return (Criteria) this;
        }

        public Criteria andUlLotteryNameEqualTo(String value) {
            addCriterion("ul_lottery_name =", value, "ulLotteryName");
            return (Criteria) this;
        }

        public Criteria andUlLotteryNameNotEqualTo(String value) {
            addCriterion("ul_lottery_name <>", value, "ulLotteryName");
            return (Criteria) this;
        }

        public Criteria andUlLotteryNameGreaterThan(String value) {
            addCriterion("ul_lottery_name >", value, "ulLotteryName");
            return (Criteria) this;
        }

        public Criteria andUlLotteryNameGreaterThanOrEqualTo(String value) {
            addCriterion("ul_lottery_name >=", value, "ulLotteryName");
            return (Criteria) this;
        }

        public Criteria andUlLotteryNameLessThan(String value) {
            addCriterion("ul_lottery_name <", value, "ulLotteryName");
            return (Criteria) this;
        }

        public Criteria andUlLotteryNameLessThanOrEqualTo(String value) {
            addCriterion("ul_lottery_name <=", value, "ulLotteryName");
            return (Criteria) this;
        }

        public Criteria andUlLotteryNameLike(String value) {
            addCriterion("ul_lottery_name like", value, "ulLotteryName");
            return (Criteria) this;
        }

        public Criteria andUlLotteryNameNotLike(String value) {
            addCriterion("ul_lottery_name not like", value, "ulLotteryName");
            return (Criteria) this;
        }

        public Criteria andUlLotteryNameIn(List<String> values) {
            addCriterion("ul_lottery_name in", values, "ulLotteryName");
            return (Criteria) this;
        }

        public Criteria andUlLotteryNameNotIn(List<String> values) {
            addCriterion("ul_lottery_name not in", values, "ulLotteryName");
            return (Criteria) this;
        }

        public Criteria andUlLotteryNameBetween(String value1, String value2) {
            addCriterion("ul_lottery_name between", value1, value2, "ulLotteryName");
            return (Criteria) this;
        }

        public Criteria andUlLotteryNameNotBetween(String value1, String value2) {
            addCriterion("ul_lottery_name not between", value1, value2, "ulLotteryName");
            return (Criteria) this;
        }

        public Criteria andUlLotteryImgIsNull() {
            addCriterion("ul_lottery_img is null");
            return (Criteria) this;
        }

        public Criteria andUlLotteryImgIsNotNull() {
            addCriterion("ul_lottery_img is not null");
            return (Criteria) this;
        }

        public Criteria andUlLotteryImgEqualTo(String value) {
            addCriterion("ul_lottery_img =", value, "ulLotteryImg");
            return (Criteria) this;
        }

        public Criteria andUlLotteryImgNotEqualTo(String value) {
            addCriterion("ul_lottery_img <>", value, "ulLotteryImg");
            return (Criteria) this;
        }

        public Criteria andUlLotteryImgGreaterThan(String value) {
            addCriterion("ul_lottery_img >", value, "ulLotteryImg");
            return (Criteria) this;
        }

        public Criteria andUlLotteryImgGreaterThanOrEqualTo(String value) {
            addCriterion("ul_lottery_img >=", value, "ulLotteryImg");
            return (Criteria) this;
        }

        public Criteria andUlLotteryImgLessThan(String value) {
            addCriterion("ul_lottery_img <", value, "ulLotteryImg");
            return (Criteria) this;
        }

        public Criteria andUlLotteryImgLessThanOrEqualTo(String value) {
            addCriterion("ul_lottery_img <=", value, "ulLotteryImg");
            return (Criteria) this;
        }

        public Criteria andUlLotteryImgLike(String value) {
            addCriterion("ul_lottery_img like", value, "ulLotteryImg");
            return (Criteria) this;
        }

        public Criteria andUlLotteryImgNotLike(String value) {
            addCriterion("ul_lottery_img not like", value, "ulLotteryImg");
            return (Criteria) this;
        }

        public Criteria andUlLotteryImgIn(List<String> values) {
            addCriterion("ul_lottery_img in", values, "ulLotteryImg");
            return (Criteria) this;
        }

        public Criteria andUlLotteryImgNotIn(List<String> values) {
            addCriterion("ul_lottery_img not in", values, "ulLotteryImg");
            return (Criteria) this;
        }

        public Criteria andUlLotteryImgBetween(String value1, String value2) {
            addCriterion("ul_lottery_img between", value1, value2, "ulLotteryImg");
            return (Criteria) this;
        }

        public Criteria andUlLotteryImgNotBetween(String value1, String value2) {
            addCriterion("ul_lottery_img not between", value1, value2, "ulLotteryImg");
            return (Criteria) this;
        }

        public Criteria andUlLotteryTypeIsNull() {
            addCriterion("ul_lottery_type is null");
            return (Criteria) this;
        }

        public Criteria andUlLotteryTypeIsNotNull() {
            addCriterion("ul_lottery_type is not null");
            return (Criteria) this;
        }

        public Criteria andUlLotteryTypeEqualTo(String value) {
            addCriterion("ul_lottery_type =", value, "ulLotteryType");
            return (Criteria) this;
        }

        public Criteria andUlLotteryTypeNotEqualTo(String value) {
            addCriterion("ul_lottery_type <>", value, "ulLotteryType");
            return (Criteria) this;
        }

        public Criteria andUlLotteryTypeGreaterThan(String value) {
            addCriterion("ul_lottery_type >", value, "ulLotteryType");
            return (Criteria) this;
        }

        public Criteria andUlLotteryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ul_lottery_type >=", value, "ulLotteryType");
            return (Criteria) this;
        }

        public Criteria andUlLotteryTypeLessThan(String value) {
            addCriterion("ul_lottery_type <", value, "ulLotteryType");
            return (Criteria) this;
        }

        public Criteria andUlLotteryTypeLessThanOrEqualTo(String value) {
            addCriterion("ul_lottery_type <=", value, "ulLotteryType");
            return (Criteria) this;
        }

        public Criteria andUlLotteryTypeLike(String value) {
            addCriterion("ul_lottery_type like", value, "ulLotteryType");
            return (Criteria) this;
        }

        public Criteria andUlLotteryTypeNotLike(String value) {
            addCriterion("ul_lottery_type not like", value, "ulLotteryType");
            return (Criteria) this;
        }

        public Criteria andUlLotteryTypeIn(List<String> values) {
            addCriterion("ul_lottery_type in", values, "ulLotteryType");
            return (Criteria) this;
        }

        public Criteria andUlLotteryTypeNotIn(List<String> values) {
            addCriterion("ul_lottery_type not in", values, "ulLotteryType");
            return (Criteria) this;
        }

        public Criteria andUlLotteryTypeBetween(String value1, String value2) {
            addCriterion("ul_lottery_type between", value1, value2, "ulLotteryType");
            return (Criteria) this;
        }

        public Criteria andUlLotteryTypeNotBetween(String value1, String value2) {
            addCriterion("ul_lottery_type not between", value1, value2, "ulLotteryType");
            return (Criteria) this;
        }

        public Criteria andUlLotteryDetailIsNull() {
            addCriterion("ul_lottery_detail is null");
            return (Criteria) this;
        }

        public Criteria andUlLotteryDetailIsNotNull() {
            addCriterion("ul_lottery_detail is not null");
            return (Criteria) this;
        }

        public Criteria andUlLotteryDetailEqualTo(String value) {
            addCriterion("ul_lottery_detail =", value, "ulLotteryDetail");
            return (Criteria) this;
        }

        public Criteria andUlLotteryDetailNotEqualTo(String value) {
            addCriterion("ul_lottery_detail <>", value, "ulLotteryDetail");
            return (Criteria) this;
        }

        public Criteria andUlLotteryDetailGreaterThan(String value) {
            addCriterion("ul_lottery_detail >", value, "ulLotteryDetail");
            return (Criteria) this;
        }

        public Criteria andUlLotteryDetailGreaterThanOrEqualTo(String value) {
            addCriterion("ul_lottery_detail >=", value, "ulLotteryDetail");
            return (Criteria) this;
        }

        public Criteria andUlLotteryDetailLessThan(String value) {
            addCriterion("ul_lottery_detail <", value, "ulLotteryDetail");
            return (Criteria) this;
        }

        public Criteria andUlLotteryDetailLessThanOrEqualTo(String value) {
            addCriterion("ul_lottery_detail <=", value, "ulLotteryDetail");
            return (Criteria) this;
        }

        public Criteria andUlLotteryDetailLike(String value) {
            addCriterion("ul_lottery_detail like", value, "ulLotteryDetail");
            return (Criteria) this;
        }

        public Criteria andUlLotteryDetailNotLike(String value) {
            addCriterion("ul_lottery_detail not like", value, "ulLotteryDetail");
            return (Criteria) this;
        }

        public Criteria andUlLotteryDetailIn(List<String> values) {
            addCriterion("ul_lottery_detail in", values, "ulLotteryDetail");
            return (Criteria) this;
        }

        public Criteria andUlLotteryDetailNotIn(List<String> values) {
            addCriterion("ul_lottery_detail not in", values, "ulLotteryDetail");
            return (Criteria) this;
        }

        public Criteria andUlLotteryDetailBetween(String value1, String value2) {
            addCriterion("ul_lottery_detail between", value1, value2, "ulLotteryDetail");
            return (Criteria) this;
        }

        public Criteria andUlLotteryDetailNotBetween(String value1, String value2) {
            addCriterion("ul_lottery_detail not between", value1, value2, "ulLotteryDetail");
            return (Criteria) this;
        }

        public Criteria andUlTimeIsNull() {
            addCriterion("ul_time is null");
            return (Criteria) this;
        }

        public Criteria andUlTimeIsNotNull() {
            addCriterion("ul_time is not null");
            return (Criteria) this;
        }

        public Criteria andUlTimeEqualTo(Date value) {
            addCriterion("ul_time =", value, "ulTime");
            return (Criteria) this;
        }

        public Criteria andUlTimeNotEqualTo(Date value) {
            addCriterion("ul_time <>", value, "ulTime");
            return (Criteria) this;
        }

        public Criteria andUlTimeGreaterThan(Date value) {
            addCriterion("ul_time >", value, "ulTime");
            return (Criteria) this;
        }

        public Criteria andUlTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ul_time >=", value, "ulTime");
            return (Criteria) this;
        }

        public Criteria andUlTimeLessThan(Date value) {
            addCriterion("ul_time <", value, "ulTime");
            return (Criteria) this;
        }

        public Criteria andUlTimeLessThanOrEqualTo(Date value) {
            addCriterion("ul_time <=", value, "ulTime");
            return (Criteria) this;
        }

        public Criteria andUlTimeIn(List<Date> values) {
            addCriterion("ul_time in", values, "ulTime");
            return (Criteria) this;
        }

        public Criteria andUlTimeNotIn(List<Date> values) {
            addCriterion("ul_time not in", values, "ulTime");
            return (Criteria) this;
        }

        public Criteria andUlTimeBetween(Date value1, Date value2) {
            addCriterion("ul_time between", value1, value2, "ulTime");
            return (Criteria) this;
        }

        public Criteria andUlTimeNotBetween(Date value1, Date value2) {
            addCriterion("ul_time not between", value1, value2, "ulTime");
            return (Criteria) this;
        }

        public Criteria andUlCdkeyIsNull() {
            addCriterion("ul_cdkey is null");
            return (Criteria) this;
        }

        public Criteria andUlCdkeyIsNotNull() {
            addCriterion("ul_cdkey is not null");
            return (Criteria) this;
        }

        public Criteria andUlCdkeyEqualTo(String value) {
            addCriterion("ul_cdkey =", value, "ulCdkey");
            return (Criteria) this;
        }

        public Criteria andUlCdkeyNotEqualTo(String value) {
            addCriterion("ul_cdkey <>", value, "ulCdkey");
            return (Criteria) this;
        }

        public Criteria andUlCdkeyGreaterThan(String value) {
            addCriterion("ul_cdkey >", value, "ulCdkey");
            return (Criteria) this;
        }

        public Criteria andUlCdkeyGreaterThanOrEqualTo(String value) {
            addCriterion("ul_cdkey >=", value, "ulCdkey");
            return (Criteria) this;
        }

        public Criteria andUlCdkeyLessThan(String value) {
            addCriterion("ul_cdkey <", value, "ulCdkey");
            return (Criteria) this;
        }

        public Criteria andUlCdkeyLessThanOrEqualTo(String value) {
            addCriterion("ul_cdkey <=", value, "ulCdkey");
            return (Criteria) this;
        }

        public Criteria andUlCdkeyLike(String value) {
            addCriterion("ul_cdkey like", value, "ulCdkey");
            return (Criteria) this;
        }

        public Criteria andUlCdkeyNotLike(String value) {
            addCriterion("ul_cdkey not like", value, "ulCdkey");
            return (Criteria) this;
        }

        public Criteria andUlCdkeyIn(List<String> values) {
            addCriterion("ul_cdkey in", values, "ulCdkey");
            return (Criteria) this;
        }

        public Criteria andUlCdkeyNotIn(List<String> values) {
            addCriterion("ul_cdkey not in", values, "ulCdkey");
            return (Criteria) this;
        }

        public Criteria andUlCdkeyBetween(String value1, String value2) {
            addCriterion("ul_cdkey between", value1, value2, "ulCdkey");
            return (Criteria) this;
        }

        public Criteria andUlCdkeyNotBetween(String value1, String value2) {
            addCriterion("ul_cdkey not between", value1, value2, "ulCdkey");
            return (Criteria) this;
        }

        public Criteria andUlStatusIsNull() {
            addCriterion("ul_status is null");
            return (Criteria) this;
        }

        public Criteria andUlStatusIsNotNull() {
            addCriterion("ul_status is not null");
            return (Criteria) this;
        }

        public Criteria andUlStatusEqualTo(String value) {
            addCriterion("ul_status =", value, "ulStatus");
            return (Criteria) this;
        }

        public Criteria andUlStatusNotEqualTo(String value) {
            addCriterion("ul_status <>", value, "ulStatus");
            return (Criteria) this;
        }

        public Criteria andUlStatusGreaterThan(String value) {
            addCriterion("ul_status >", value, "ulStatus");
            return (Criteria) this;
        }

        public Criteria andUlStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ul_status >=", value, "ulStatus");
            return (Criteria) this;
        }

        public Criteria andUlStatusLessThan(String value) {
            addCriterion("ul_status <", value, "ulStatus");
            return (Criteria) this;
        }

        public Criteria andUlStatusLessThanOrEqualTo(String value) {
            addCriterion("ul_status <=", value, "ulStatus");
            return (Criteria) this;
        }

        public Criteria andUlStatusLike(String value) {
            addCriterion("ul_status like", value, "ulStatus");
            return (Criteria) this;
        }

        public Criteria andUlStatusNotLike(String value) {
            addCriterion("ul_status not like", value, "ulStatus");
            return (Criteria) this;
        }

        public Criteria andUlStatusIn(List<String> values) {
            addCriterion("ul_status in", values, "ulStatus");
            return (Criteria) this;
        }

        public Criteria andUlStatusNotIn(List<String> values) {
            addCriterion("ul_status not in", values, "ulStatus");
            return (Criteria) this;
        }

        public Criteria andUlStatusBetween(String value1, String value2) {
            addCriterion("ul_status between", value1, value2, "ulStatus");
            return (Criteria) this;
        }

        public Criteria andUlStatusNotBetween(String value1, String value2) {
            addCriterion("ul_status not between", value1, value2, "ulStatus");
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