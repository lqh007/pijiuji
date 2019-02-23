package com.pijiuji.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LevelUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LevelUserExample() {
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

        public Criteria andLevelUserIdIsNull() {
            addCriterion("level_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLevelUserIdIsNotNull() {
            addCriterion("level_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLevelUserIdEqualTo(String value) {
            addCriterion("level_user_id =", value, "levelUserId");
            return (Criteria) this;
        }

        public Criteria andLevelUserIdNotEqualTo(String value) {
            addCriterion("level_user_id <>", value, "levelUserId");
            return (Criteria) this;
        }

        public Criteria andLevelUserIdGreaterThan(String value) {
            addCriterion("level_user_id >", value, "levelUserId");
            return (Criteria) this;
        }

        public Criteria andLevelUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("level_user_id >=", value, "levelUserId");
            return (Criteria) this;
        }

        public Criteria andLevelUserIdLessThan(String value) {
            addCriterion("level_user_id <", value, "levelUserId");
            return (Criteria) this;
        }

        public Criteria andLevelUserIdLessThanOrEqualTo(String value) {
            addCriterion("level_user_id <=", value, "levelUserId");
            return (Criteria) this;
        }

        public Criteria andLevelUserIdLike(String value) {
            addCriterion("level_user_id like", value, "levelUserId");
            return (Criteria) this;
        }

        public Criteria andLevelUserIdNotLike(String value) {
            addCriterion("level_user_id not like", value, "levelUserId");
            return (Criteria) this;
        }

        public Criteria andLevelUserIdIn(List<String> values) {
            addCriterion("level_user_id in", values, "levelUserId");
            return (Criteria) this;
        }

        public Criteria andLevelUserIdNotIn(List<String> values) {
            addCriterion("level_user_id not in", values, "levelUserId");
            return (Criteria) this;
        }

        public Criteria andLevelUserIdBetween(String value1, String value2) {
            addCriterion("level_user_id between", value1, value2, "levelUserId");
            return (Criteria) this;
        }

        public Criteria andLevelUserIdNotBetween(String value1, String value2) {
            addCriterion("level_user_id not between", value1, value2, "levelUserId");
            return (Criteria) this;
        }

        public Criteria andLevelUserHeadimgIsNull() {
            addCriterion("level_user_headimg is null");
            return (Criteria) this;
        }

        public Criteria andLevelUserHeadimgIsNotNull() {
            addCriterion("level_user_headimg is not null");
            return (Criteria) this;
        }

        public Criteria andLevelUserHeadimgEqualTo(String value) {
            addCriterion("level_user_headimg =", value, "levelUserHeadimg");
            return (Criteria) this;
        }

        public Criteria andLevelUserHeadimgNotEqualTo(String value) {
            addCriterion("level_user_headimg <>", value, "levelUserHeadimg");
            return (Criteria) this;
        }

        public Criteria andLevelUserHeadimgGreaterThan(String value) {
            addCriterion("level_user_headimg >", value, "levelUserHeadimg");
            return (Criteria) this;
        }

        public Criteria andLevelUserHeadimgGreaterThanOrEqualTo(String value) {
            addCriterion("level_user_headimg >=", value, "levelUserHeadimg");
            return (Criteria) this;
        }

        public Criteria andLevelUserHeadimgLessThan(String value) {
            addCriterion("level_user_headimg <", value, "levelUserHeadimg");
            return (Criteria) this;
        }

        public Criteria andLevelUserHeadimgLessThanOrEqualTo(String value) {
            addCriterion("level_user_headimg <=", value, "levelUserHeadimg");
            return (Criteria) this;
        }

        public Criteria andLevelUserHeadimgLike(String value) {
            addCriterion("level_user_headimg like", value, "levelUserHeadimg");
            return (Criteria) this;
        }

        public Criteria andLevelUserHeadimgNotLike(String value) {
            addCriterion("level_user_headimg not like", value, "levelUserHeadimg");
            return (Criteria) this;
        }

        public Criteria andLevelUserHeadimgIn(List<String> values) {
            addCriterion("level_user_headimg in", values, "levelUserHeadimg");
            return (Criteria) this;
        }

        public Criteria andLevelUserHeadimgNotIn(List<String> values) {
            addCriterion("level_user_headimg not in", values, "levelUserHeadimg");
            return (Criteria) this;
        }

        public Criteria andLevelUserHeadimgBetween(String value1, String value2) {
            addCriterion("level_user_headimg between", value1, value2, "levelUserHeadimg");
            return (Criteria) this;
        }

        public Criteria andLevelUserHeadimgNotBetween(String value1, String value2) {
            addCriterion("level_user_headimg not between", value1, value2, "levelUserHeadimg");
            return (Criteria) this;
        }

        public Criteria andLevelUserNameIsNull() {
            addCriterion("level_user_name is null");
            return (Criteria) this;
        }

        public Criteria andLevelUserNameIsNotNull() {
            addCriterion("level_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andLevelUserNameEqualTo(String value) {
            addCriterion("level_user_name =", value, "levelUserName");
            return (Criteria) this;
        }

        public Criteria andLevelUserNameNotEqualTo(String value) {
            addCriterion("level_user_name <>", value, "levelUserName");
            return (Criteria) this;
        }

        public Criteria andLevelUserNameGreaterThan(String value) {
            addCriterion("level_user_name >", value, "levelUserName");
            return (Criteria) this;
        }

        public Criteria andLevelUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("level_user_name >=", value, "levelUserName");
            return (Criteria) this;
        }

        public Criteria andLevelUserNameLessThan(String value) {
            addCriterion("level_user_name <", value, "levelUserName");
            return (Criteria) this;
        }

        public Criteria andLevelUserNameLessThanOrEqualTo(String value) {
            addCriterion("level_user_name <=", value, "levelUserName");
            return (Criteria) this;
        }

        public Criteria andLevelUserNameLike(String value) {
            addCriterion("level_user_name like", value, "levelUserName");
            return (Criteria) this;
        }

        public Criteria andLevelUserNameNotLike(String value) {
            addCriterion("level_user_name not like", value, "levelUserName");
            return (Criteria) this;
        }

        public Criteria andLevelUserNameIn(List<String> values) {
            addCriterion("level_user_name in", values, "levelUserName");
            return (Criteria) this;
        }

        public Criteria andLevelUserNameNotIn(List<String> values) {
            addCriterion("level_user_name not in", values, "levelUserName");
            return (Criteria) this;
        }

        public Criteria andLevelUserNameBetween(String value1, String value2) {
            addCriterion("level_user_name between", value1, value2, "levelUserName");
            return (Criteria) this;
        }

        public Criteria andLevelUserNameNotBetween(String value1, String value2) {
            addCriterion("level_user_name not between", value1, value2, "levelUserName");
            return (Criteria) this;
        }

        public Criteria andLevelUserAddressIsNull() {
            addCriterion("level_user_address is null");
            return (Criteria) this;
        }

        public Criteria andLevelUserAddressIsNotNull() {
            addCriterion("level_user_address is not null");
            return (Criteria) this;
        }

        public Criteria andLevelUserAddressEqualTo(String value) {
            addCriterion("level_user_address =", value, "levelUserAddress");
            return (Criteria) this;
        }

        public Criteria andLevelUserAddressNotEqualTo(String value) {
            addCriterion("level_user_address <>", value, "levelUserAddress");
            return (Criteria) this;
        }

        public Criteria andLevelUserAddressGreaterThan(String value) {
            addCriterion("level_user_address >", value, "levelUserAddress");
            return (Criteria) this;
        }

        public Criteria andLevelUserAddressGreaterThanOrEqualTo(String value) {
            addCriterion("level_user_address >=", value, "levelUserAddress");
            return (Criteria) this;
        }

        public Criteria andLevelUserAddressLessThan(String value) {
            addCriterion("level_user_address <", value, "levelUserAddress");
            return (Criteria) this;
        }

        public Criteria andLevelUserAddressLessThanOrEqualTo(String value) {
            addCriterion("level_user_address <=", value, "levelUserAddress");
            return (Criteria) this;
        }

        public Criteria andLevelUserAddressLike(String value) {
            addCriterion("level_user_address like", value, "levelUserAddress");
            return (Criteria) this;
        }

        public Criteria andLevelUserAddressNotLike(String value) {
            addCriterion("level_user_address not like", value, "levelUserAddress");
            return (Criteria) this;
        }

        public Criteria andLevelUserAddressIn(List<String> values) {
            addCriterion("level_user_address in", values, "levelUserAddress");
            return (Criteria) this;
        }

        public Criteria andLevelUserAddressNotIn(List<String> values) {
            addCriterion("level_user_address not in", values, "levelUserAddress");
            return (Criteria) this;
        }

        public Criteria andLevelUserAddressBetween(String value1, String value2) {
            addCriterion("level_user_address between", value1, value2, "levelUserAddress");
            return (Criteria) this;
        }

        public Criteria andLevelUserAddressNotBetween(String value1, String value2) {
            addCriterion("level_user_address not between", value1, value2, "levelUserAddress");
            return (Criteria) this;
        }

        public Criteria andLevelUserPhoneIsNull() {
            addCriterion("level_user_phone is null");
            return (Criteria) this;
        }

        public Criteria andLevelUserPhoneIsNotNull() {
            addCriterion("level_user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andLevelUserPhoneEqualTo(String value) {
            addCriterion("level_user_phone =", value, "levelUserPhone");
            return (Criteria) this;
        }

        public Criteria andLevelUserPhoneNotEqualTo(String value) {
            addCriterion("level_user_phone <>", value, "levelUserPhone");
            return (Criteria) this;
        }

        public Criteria andLevelUserPhoneGreaterThan(String value) {
            addCriterion("level_user_phone >", value, "levelUserPhone");
            return (Criteria) this;
        }

        public Criteria andLevelUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("level_user_phone >=", value, "levelUserPhone");
            return (Criteria) this;
        }

        public Criteria andLevelUserPhoneLessThan(String value) {
            addCriterion("level_user_phone <", value, "levelUserPhone");
            return (Criteria) this;
        }

        public Criteria andLevelUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("level_user_phone <=", value, "levelUserPhone");
            return (Criteria) this;
        }

        public Criteria andLevelUserPhoneLike(String value) {
            addCriterion("level_user_phone like", value, "levelUserPhone");
            return (Criteria) this;
        }

        public Criteria andLevelUserPhoneNotLike(String value) {
            addCriterion("level_user_phone not like", value, "levelUserPhone");
            return (Criteria) this;
        }

        public Criteria andLevelUserPhoneIn(List<String> values) {
            addCriterion("level_user_phone in", values, "levelUserPhone");
            return (Criteria) this;
        }

        public Criteria andLevelUserPhoneNotIn(List<String> values) {
            addCriterion("level_user_phone not in", values, "levelUserPhone");
            return (Criteria) this;
        }

        public Criteria andLevelUserPhoneBetween(String value1, String value2) {
            addCriterion("level_user_phone between", value1, value2, "levelUserPhone");
            return (Criteria) this;
        }

        public Criteria andLevelUserPhoneNotBetween(String value1, String value2) {
            addCriterion("level_user_phone not between", value1, value2, "levelUserPhone");
            return (Criteria) this;
        }

        public Criteria andLevelUserPasswordIsNull() {
            addCriterion("level_user_password is null");
            return (Criteria) this;
        }

        public Criteria andLevelUserPasswordIsNotNull() {
            addCriterion("level_user_password is not null");
            return (Criteria) this;
        }

        public Criteria andLevelUserPasswordEqualTo(String value) {
            addCriterion("level_user_password =", value, "levelUserPassword");
            return (Criteria) this;
        }

        public Criteria andLevelUserPasswordNotEqualTo(String value) {
            addCriterion("level_user_password <>", value, "levelUserPassword");
            return (Criteria) this;
        }

        public Criteria andLevelUserPasswordGreaterThan(String value) {
            addCriterion("level_user_password >", value, "levelUserPassword");
            return (Criteria) this;
        }

        public Criteria andLevelUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("level_user_password >=", value, "levelUserPassword");
            return (Criteria) this;
        }

        public Criteria andLevelUserPasswordLessThan(String value) {
            addCriterion("level_user_password <", value, "levelUserPassword");
            return (Criteria) this;
        }

        public Criteria andLevelUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("level_user_password <=", value, "levelUserPassword");
            return (Criteria) this;
        }

        public Criteria andLevelUserPasswordLike(String value) {
            addCriterion("level_user_password like", value, "levelUserPassword");
            return (Criteria) this;
        }

        public Criteria andLevelUserPasswordNotLike(String value) {
            addCriterion("level_user_password not like", value, "levelUserPassword");
            return (Criteria) this;
        }

        public Criteria andLevelUserPasswordIn(List<String> values) {
            addCriterion("level_user_password in", values, "levelUserPassword");
            return (Criteria) this;
        }

        public Criteria andLevelUserPasswordNotIn(List<String> values) {
            addCriterion("level_user_password not in", values, "levelUserPassword");
            return (Criteria) this;
        }

        public Criteria andLevelUserPasswordBetween(String value1, String value2) {
            addCriterion("level_user_password between", value1, value2, "levelUserPassword");
            return (Criteria) this;
        }

        public Criteria andLevelUserPasswordNotBetween(String value1, String value2) {
            addCriterion("level_user_password not between", value1, value2, "levelUserPassword");
            return (Criteria) this;
        }

        public Criteria andLevelUserStatusIsNull() {
            addCriterion("level_user_status is null");
            return (Criteria) this;
        }

        public Criteria andLevelUserStatusIsNotNull() {
            addCriterion("level_user_status is not null");
            return (Criteria) this;
        }

        public Criteria andLevelUserStatusEqualTo(String value) {
            addCriterion("level_user_status =", value, "levelUserStatus");
            return (Criteria) this;
        }

        public Criteria andLevelUserStatusNotEqualTo(String value) {
            addCriterion("level_user_status <>", value, "levelUserStatus");
            return (Criteria) this;
        }

        public Criteria andLevelUserStatusGreaterThan(String value) {
            addCriterion("level_user_status >", value, "levelUserStatus");
            return (Criteria) this;
        }

        public Criteria andLevelUserStatusGreaterThanOrEqualTo(String value) {
            addCriterion("level_user_status >=", value, "levelUserStatus");
            return (Criteria) this;
        }

        public Criteria andLevelUserStatusLessThan(String value) {
            addCriterion("level_user_status <", value, "levelUserStatus");
            return (Criteria) this;
        }

        public Criteria andLevelUserStatusLessThanOrEqualTo(String value) {
            addCriterion("level_user_status <=", value, "levelUserStatus");
            return (Criteria) this;
        }

        public Criteria andLevelUserStatusLike(String value) {
            addCriterion("level_user_status like", value, "levelUserStatus");
            return (Criteria) this;
        }

        public Criteria andLevelUserStatusNotLike(String value) {
            addCriterion("level_user_status not like", value, "levelUserStatus");
            return (Criteria) this;
        }

        public Criteria andLevelUserStatusIn(List<String> values) {
            addCriterion("level_user_status in", values, "levelUserStatus");
            return (Criteria) this;
        }

        public Criteria andLevelUserStatusNotIn(List<String> values) {
            addCriterion("level_user_status not in", values, "levelUserStatus");
            return (Criteria) this;
        }

        public Criteria andLevelUserStatusBetween(String value1, String value2) {
            addCriterion("level_user_status between", value1, value2, "levelUserStatus");
            return (Criteria) this;
        }

        public Criteria andLevelUserStatusNotBetween(String value1, String value2) {
            addCriterion("level_user_status not between", value1, value2, "levelUserStatus");
            return (Criteria) this;
        }

        public Criteria andLevelUserApplyStatusIsNull() {
            addCriterion("level_user_apply_status is null");
            return (Criteria) this;
        }

        public Criteria andLevelUserApplyStatusIsNotNull() {
            addCriterion("level_user_apply_status is not null");
            return (Criteria) this;
        }

        public Criteria andLevelUserApplyStatusEqualTo(String value) {
            addCriterion("level_user_apply_status =", value, "levelUserApplyStatus");
            return (Criteria) this;
        }

        public Criteria andLevelUserApplyStatusNotEqualTo(String value) {
            addCriterion("level_user_apply_status <>", value, "levelUserApplyStatus");
            return (Criteria) this;
        }

        public Criteria andLevelUserApplyStatusGreaterThan(String value) {
            addCriterion("level_user_apply_status >", value, "levelUserApplyStatus");
            return (Criteria) this;
        }

        public Criteria andLevelUserApplyStatusGreaterThanOrEqualTo(String value) {
            addCriterion("level_user_apply_status >=", value, "levelUserApplyStatus");
            return (Criteria) this;
        }

        public Criteria andLevelUserApplyStatusLessThan(String value) {
            addCriterion("level_user_apply_status <", value, "levelUserApplyStatus");
            return (Criteria) this;
        }

        public Criteria andLevelUserApplyStatusLessThanOrEqualTo(String value) {
            addCriterion("level_user_apply_status <=", value, "levelUserApplyStatus");
            return (Criteria) this;
        }

        public Criteria andLevelUserApplyStatusLike(String value) {
            addCriterion("level_user_apply_status like", value, "levelUserApplyStatus");
            return (Criteria) this;
        }

        public Criteria andLevelUserApplyStatusNotLike(String value) {
            addCriterion("level_user_apply_status not like", value, "levelUserApplyStatus");
            return (Criteria) this;
        }

        public Criteria andLevelUserApplyStatusIn(List<String> values) {
            addCriterion("level_user_apply_status in", values, "levelUserApplyStatus");
            return (Criteria) this;
        }

        public Criteria andLevelUserApplyStatusNotIn(List<String> values) {
            addCriterion("level_user_apply_status not in", values, "levelUserApplyStatus");
            return (Criteria) this;
        }

        public Criteria andLevelUserApplyStatusBetween(String value1, String value2) {
            addCriterion("level_user_apply_status between", value1, value2, "levelUserApplyStatus");
            return (Criteria) this;
        }

        public Criteria andLevelUserApplyStatusNotBetween(String value1, String value2) {
            addCriterion("level_user_apply_status not between", value1, value2, "levelUserApplyStatus");
            return (Criteria) this;
        }

        public Criteria andLevelUserTimeIsNull() {
            addCriterion("level_user_time is null");
            return (Criteria) this;
        }

        public Criteria andLevelUserTimeIsNotNull() {
            addCriterion("level_user_time is not null");
            return (Criteria) this;
        }

        public Criteria andLevelUserTimeEqualTo(Date value) {
            addCriterion("level_user_time =", value, "levelUserTime");
            return (Criteria) this;
        }

        public Criteria andLevelUserTimeNotEqualTo(Date value) {
            addCriterion("level_user_time <>", value, "levelUserTime");
            return (Criteria) this;
        }

        public Criteria andLevelUserTimeGreaterThan(Date value) {
            addCriterion("level_user_time >", value, "levelUserTime");
            return (Criteria) this;
        }

        public Criteria andLevelUserTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("level_user_time >=", value, "levelUserTime");
            return (Criteria) this;
        }

        public Criteria andLevelUserTimeLessThan(Date value) {
            addCriterion("level_user_time <", value, "levelUserTime");
            return (Criteria) this;
        }

        public Criteria andLevelUserTimeLessThanOrEqualTo(Date value) {
            addCriterion("level_user_time <=", value, "levelUserTime");
            return (Criteria) this;
        }

        public Criteria andLevelUserTimeIn(List<Date> values) {
            addCriterion("level_user_time in", values, "levelUserTime");
            return (Criteria) this;
        }

        public Criteria andLevelUserTimeNotIn(List<Date> values) {
            addCriterion("level_user_time not in", values, "levelUserTime");
            return (Criteria) this;
        }

        public Criteria andLevelUserTimeBetween(Date value1, Date value2) {
            addCriterion("level_user_time between", value1, value2, "levelUserTime");
            return (Criteria) this;
        }

        public Criteria andLevelUserTimeNotBetween(Date value1, Date value2) {
            addCriterion("level_user_time not between", value1, value2, "levelUserTime");
            return (Criteria) this;
        }

        public Criteria andLevelUserParentOpenidIsNull() {
            addCriterion("level_user_parent_openid is null");
            return (Criteria) this;
        }

        public Criteria andLevelUserParentOpenidIsNotNull() {
            addCriterion("level_user_parent_openid is not null");
            return (Criteria) this;
        }

        public Criteria andLevelUserParentOpenidEqualTo(String value) {
            addCriterion("level_user_parent_openid =", value, "levelUserParentOpenid");
            return (Criteria) this;
        }

        public Criteria andLevelUserParentOpenidNotEqualTo(String value) {
            addCriterion("level_user_parent_openid <>", value, "levelUserParentOpenid");
            return (Criteria) this;
        }

        public Criteria andLevelUserParentOpenidGreaterThan(String value) {
            addCriterion("level_user_parent_openid >", value, "levelUserParentOpenid");
            return (Criteria) this;
        }

        public Criteria andLevelUserParentOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("level_user_parent_openid >=", value, "levelUserParentOpenid");
            return (Criteria) this;
        }

        public Criteria andLevelUserParentOpenidLessThan(String value) {
            addCriterion("level_user_parent_openid <", value, "levelUserParentOpenid");
            return (Criteria) this;
        }

        public Criteria andLevelUserParentOpenidLessThanOrEqualTo(String value) {
            addCriterion("level_user_parent_openid <=", value, "levelUserParentOpenid");
            return (Criteria) this;
        }

        public Criteria andLevelUserParentOpenidLike(String value) {
            addCriterion("level_user_parent_openid like", value, "levelUserParentOpenid");
            return (Criteria) this;
        }

        public Criteria andLevelUserParentOpenidNotLike(String value) {
            addCriterion("level_user_parent_openid not like", value, "levelUserParentOpenid");
            return (Criteria) this;
        }

        public Criteria andLevelUserParentOpenidIn(List<String> values) {
            addCriterion("level_user_parent_openid in", values, "levelUserParentOpenid");
            return (Criteria) this;
        }

        public Criteria andLevelUserParentOpenidNotIn(List<String> values) {
            addCriterion("level_user_parent_openid not in", values, "levelUserParentOpenid");
            return (Criteria) this;
        }

        public Criteria andLevelUserParentOpenidBetween(String value1, String value2) {
            addCriterion("level_user_parent_openid between", value1, value2, "levelUserParentOpenid");
            return (Criteria) this;
        }

        public Criteria andLevelUserParentOpenidNotBetween(String value1, String value2) {
            addCriterion("level_user_parent_openid not between", value1, value2, "levelUserParentOpenid");
            return (Criteria) this;
        }

        public Criteria andLevelUserLevelIsNull() {
            addCriterion("level_user_level is null");
            return (Criteria) this;
        }

        public Criteria andLevelUserLevelIsNotNull() {
            addCriterion("level_user_level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelUserLevelEqualTo(String value) {
            addCriterion("level_user_level =", value, "levelUserLevel");
            return (Criteria) this;
        }

        public Criteria andLevelUserLevelNotEqualTo(String value) {
            addCriterion("level_user_level <>", value, "levelUserLevel");
            return (Criteria) this;
        }

        public Criteria andLevelUserLevelGreaterThan(String value) {
            addCriterion("level_user_level >", value, "levelUserLevel");
            return (Criteria) this;
        }

        public Criteria andLevelUserLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level_user_level >=", value, "levelUserLevel");
            return (Criteria) this;
        }

        public Criteria andLevelUserLevelLessThan(String value) {
            addCriterion("level_user_level <", value, "levelUserLevel");
            return (Criteria) this;
        }

        public Criteria andLevelUserLevelLessThanOrEqualTo(String value) {
            addCriterion("level_user_level <=", value, "levelUserLevel");
            return (Criteria) this;
        }

        public Criteria andLevelUserLevelLike(String value) {
            addCriterion("level_user_level like", value, "levelUserLevel");
            return (Criteria) this;
        }

        public Criteria andLevelUserLevelNotLike(String value) {
            addCriterion("level_user_level not like", value, "levelUserLevel");
            return (Criteria) this;
        }

        public Criteria andLevelUserLevelIn(List<String> values) {
            addCriterion("level_user_level in", values, "levelUserLevel");
            return (Criteria) this;
        }

        public Criteria andLevelUserLevelNotIn(List<String> values) {
            addCriterion("level_user_level not in", values, "levelUserLevel");
            return (Criteria) this;
        }

        public Criteria andLevelUserLevelBetween(String value1, String value2) {
            addCriterion("level_user_level between", value1, value2, "levelUserLevel");
            return (Criteria) this;
        }

        public Criteria andLevelUserLevelNotBetween(String value1, String value2) {
            addCriterion("level_user_level not between", value1, value2, "levelUserLevel");
            return (Criteria) this;
        }

        public Criteria andLevelUserWxOpenidIsNull() {
            addCriterion("level_user_wx_openid is null");
            return (Criteria) this;
        }

        public Criteria andLevelUserWxOpenidIsNotNull() {
            addCriterion("level_user_wx_openid is not null");
            return (Criteria) this;
        }

        public Criteria andLevelUserWxOpenidEqualTo(String value) {
            addCriterion("level_user_wx_openid =", value, "levelUserWxOpenid");
            return (Criteria) this;
        }

        public Criteria andLevelUserWxOpenidNotEqualTo(String value) {
            addCriterion("level_user_wx_openid <>", value, "levelUserWxOpenid");
            return (Criteria) this;
        }

        public Criteria andLevelUserWxOpenidGreaterThan(String value) {
            addCriterion("level_user_wx_openid >", value, "levelUserWxOpenid");
            return (Criteria) this;
        }

        public Criteria andLevelUserWxOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("level_user_wx_openid >=", value, "levelUserWxOpenid");
            return (Criteria) this;
        }

        public Criteria andLevelUserWxOpenidLessThan(String value) {
            addCriterion("level_user_wx_openid <", value, "levelUserWxOpenid");
            return (Criteria) this;
        }

        public Criteria andLevelUserWxOpenidLessThanOrEqualTo(String value) {
            addCriterion("level_user_wx_openid <=", value, "levelUserWxOpenid");
            return (Criteria) this;
        }

        public Criteria andLevelUserWxOpenidLike(String value) {
            addCriterion("level_user_wx_openid like", value, "levelUserWxOpenid");
            return (Criteria) this;
        }

        public Criteria andLevelUserWxOpenidNotLike(String value) {
            addCriterion("level_user_wx_openid not like", value, "levelUserWxOpenid");
            return (Criteria) this;
        }

        public Criteria andLevelUserWxOpenidIn(List<String> values) {
            addCriterion("level_user_wx_openid in", values, "levelUserWxOpenid");
            return (Criteria) this;
        }

        public Criteria andLevelUserWxOpenidNotIn(List<String> values) {
            addCriterion("level_user_wx_openid not in", values, "levelUserWxOpenid");
            return (Criteria) this;
        }

        public Criteria andLevelUserWxOpenidBetween(String value1, String value2) {
            addCriterion("level_user_wx_openid between", value1, value2, "levelUserWxOpenid");
            return (Criteria) this;
        }

        public Criteria andLevelUserWxOpenidNotBetween(String value1, String value2) {
            addCriterion("level_user_wx_openid not between", value1, value2, "levelUserWxOpenid");
            return (Criteria) this;
        }

        public Criteria andLevelUserMoneyIsNull() {
            addCriterion("level_user_money is null");
            return (Criteria) this;
        }

        public Criteria andLevelUserMoneyIsNotNull() {
            addCriterion("level_user_money is not null");
            return (Criteria) this;
        }

        public Criteria andLevelUserMoneyEqualTo(String value) {
            addCriterion("level_user_money =", value, "levelUserMoney");
            return (Criteria) this;
        }

        public Criteria andLevelUserMoneyNotEqualTo(String value) {
            addCriterion("level_user_money <>", value, "levelUserMoney");
            return (Criteria) this;
        }

        public Criteria andLevelUserMoneyGreaterThan(String value) {
            addCriterion("level_user_money >", value, "levelUserMoney");
            return (Criteria) this;
        }

        public Criteria andLevelUserMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("level_user_money >=", value, "levelUserMoney");
            return (Criteria) this;
        }

        public Criteria andLevelUserMoneyLessThan(String value) {
            addCriterion("level_user_money <", value, "levelUserMoney");
            return (Criteria) this;
        }

        public Criteria andLevelUserMoneyLessThanOrEqualTo(String value) {
            addCriterion("level_user_money <=", value, "levelUserMoney");
            return (Criteria) this;
        }

        public Criteria andLevelUserMoneyLike(String value) {
            addCriterion("level_user_money like", value, "levelUserMoney");
            return (Criteria) this;
        }

        public Criteria andLevelUserMoneyNotLike(String value) {
            addCriterion("level_user_money not like", value, "levelUserMoney");
            return (Criteria) this;
        }

        public Criteria andLevelUserMoneyIn(List<String> values) {
            addCriterion("level_user_money in", values, "levelUserMoney");
            return (Criteria) this;
        }

        public Criteria andLevelUserMoneyNotIn(List<String> values) {
            addCriterion("level_user_money not in", values, "levelUserMoney");
            return (Criteria) this;
        }

        public Criteria andLevelUserMoneyBetween(String value1, String value2) {
            addCriterion("level_user_money between", value1, value2, "levelUserMoney");
            return (Criteria) this;
        }

        public Criteria andLevelUserMoneyNotBetween(String value1, String value2) {
            addCriterion("level_user_money not between", value1, value2, "levelUserMoney");
            return (Criteria) this;
        }

        public Criteria andLevelRoleIdIsNull() {
            addCriterion("level_role_id is null");
            return (Criteria) this;
        }

        public Criteria andLevelRoleIdIsNotNull() {
            addCriterion("level_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andLevelRoleIdEqualTo(Integer value) {
            addCriterion("level_role_id =", value, "levelRoleId");
            return (Criteria) this;
        }

        public Criteria andLevelRoleIdNotEqualTo(Integer value) {
            addCriterion("level_role_id <>", value, "levelRoleId");
            return (Criteria) this;
        }

        public Criteria andLevelRoleIdGreaterThan(Integer value) {
            addCriterion("level_role_id >", value, "levelRoleId");
            return (Criteria) this;
        }

        public Criteria andLevelRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("level_role_id >=", value, "levelRoleId");
            return (Criteria) this;
        }

        public Criteria andLevelRoleIdLessThan(Integer value) {
            addCriterion("level_role_id <", value, "levelRoleId");
            return (Criteria) this;
        }

        public Criteria andLevelRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("level_role_id <=", value, "levelRoleId");
            return (Criteria) this;
        }

        public Criteria andLevelRoleIdIn(List<Integer> values) {
            addCriterion("level_role_id in", values, "levelRoleId");
            return (Criteria) this;
        }

        public Criteria andLevelRoleIdNotIn(List<Integer> values) {
            addCriterion("level_role_id not in", values, "levelRoleId");
            return (Criteria) this;
        }

        public Criteria andLevelRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("level_role_id between", value1, value2, "levelRoleId");
            return (Criteria) this;
        }

        public Criteria andLevelRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("level_role_id not between", value1, value2, "levelRoleId");
            return (Criteria) this;
        }

        public Criteria andLevelUserReasonIsNull() {
            addCriterion("level_user_reason is null");
            return (Criteria) this;
        }

        public Criteria andLevelUserReasonIsNotNull() {
            addCriterion("level_user_reason is not null");
            return (Criteria) this;
        }

        public Criteria andLevelUserReasonEqualTo(String value) {
            addCriterion("level_user_reason =", value, "levelUserReason");
            return (Criteria) this;
        }

        public Criteria andLevelUserReasonNotEqualTo(String value) {
            addCriterion("level_user_reason <>", value, "levelUserReason");
            return (Criteria) this;
        }

        public Criteria andLevelUserReasonGreaterThan(String value) {
            addCriterion("level_user_reason >", value, "levelUserReason");
            return (Criteria) this;
        }

        public Criteria andLevelUserReasonGreaterThanOrEqualTo(String value) {
            addCriterion("level_user_reason >=", value, "levelUserReason");
            return (Criteria) this;
        }

        public Criteria andLevelUserReasonLessThan(String value) {
            addCriterion("level_user_reason <", value, "levelUserReason");
            return (Criteria) this;
        }

        public Criteria andLevelUserReasonLessThanOrEqualTo(String value) {
            addCriterion("level_user_reason <=", value, "levelUserReason");
            return (Criteria) this;
        }

        public Criteria andLevelUserReasonLike(String value) {
            addCriterion("level_user_reason like", value, "levelUserReason");
            return (Criteria) this;
        }

        public Criteria andLevelUserReasonNotLike(String value) {
            addCriterion("level_user_reason not like", value, "levelUserReason");
            return (Criteria) this;
        }

        public Criteria andLevelUserReasonIn(List<String> values) {
            addCriterion("level_user_reason in", values, "levelUserReason");
            return (Criteria) this;
        }

        public Criteria andLevelUserReasonNotIn(List<String> values) {
            addCriterion("level_user_reason not in", values, "levelUserReason");
            return (Criteria) this;
        }

        public Criteria andLevelUserReasonBetween(String value1, String value2) {
            addCriterion("level_user_reason between", value1, value2, "levelUserReason");
            return (Criteria) this;
        }

        public Criteria andLevelUserReasonNotBetween(String value1, String value2) {
            addCriterion("level_user_reason not between", value1, value2, "levelUserReason");
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