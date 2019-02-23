package com.pijiuji.bean;

import java.util.ArrayList;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdIsNull() {
            addCriterion("order_product_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdIsNotNull() {
            addCriterion("order_product_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdEqualTo(String value) {
            addCriterion("order_product_id =", value, "orderProductId");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdNotEqualTo(String value) {
            addCriterion("order_product_id <>", value, "orderProductId");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdGreaterThan(String value) {
            addCriterion("order_product_id >", value, "orderProductId");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_product_id >=", value, "orderProductId");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdLessThan(String value) {
            addCriterion("order_product_id <", value, "orderProductId");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdLessThanOrEqualTo(String value) {
            addCriterion("order_product_id <=", value, "orderProductId");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdLike(String value) {
            addCriterion("order_product_id like", value, "orderProductId");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdNotLike(String value) {
            addCriterion("order_product_id not like", value, "orderProductId");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdIn(List<String> values) {
            addCriterion("order_product_id in", values, "orderProductId");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdNotIn(List<String> values) {
            addCriterion("order_product_id not in", values, "orderProductId");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdBetween(String value1, String value2) {
            addCriterion("order_product_id between", value1, value2, "orderProductId");
            return (Criteria) this;
        }

        public Criteria andOrderProductIdNotBetween(String value1, String value2) {
            addCriterion("order_product_id not between", value1, value2, "orderProductId");
            return (Criteria) this;
        }

        public Criteria andOrderSizeIsNull() {
            addCriterion("order_size is null");
            return (Criteria) this;
        }

        public Criteria andOrderSizeIsNotNull() {
            addCriterion("order_size is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSizeEqualTo(String value) {
            addCriterion("order_size =", value, "orderSize");
            return (Criteria) this;
        }

        public Criteria andOrderSizeNotEqualTo(String value) {
            addCriterion("order_size <>", value, "orderSize");
            return (Criteria) this;
        }

        public Criteria andOrderSizeGreaterThan(String value) {
            addCriterion("order_size >", value, "orderSize");
            return (Criteria) this;
        }

        public Criteria andOrderSizeGreaterThanOrEqualTo(String value) {
            addCriterion("order_size >=", value, "orderSize");
            return (Criteria) this;
        }

        public Criteria andOrderSizeLessThan(String value) {
            addCriterion("order_size <", value, "orderSize");
            return (Criteria) this;
        }

        public Criteria andOrderSizeLessThanOrEqualTo(String value) {
            addCriterion("order_size <=", value, "orderSize");
            return (Criteria) this;
        }

        public Criteria andOrderSizeLike(String value) {
            addCriterion("order_size like", value, "orderSize");
            return (Criteria) this;
        }

        public Criteria andOrderSizeNotLike(String value) {
            addCriterion("order_size not like", value, "orderSize");
            return (Criteria) this;
        }

        public Criteria andOrderSizeIn(List<String> values) {
            addCriterion("order_size in", values, "orderSize");
            return (Criteria) this;
        }

        public Criteria andOrderSizeNotIn(List<String> values) {
            addCriterion("order_size not in", values, "orderSize");
            return (Criteria) this;
        }

        public Criteria andOrderSizeBetween(String value1, String value2) {
            addCriterion("order_size between", value1, value2, "orderSize");
            return (Criteria) this;
        }

        public Criteria andOrderSizeNotBetween(String value1, String value2) {
            addCriterion("order_size not between", value1, value2, "orderSize");
            return (Criteria) this;
        }

        public Criteria andOrderEmployeeIdIsNull() {
            addCriterion("order_employee_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderEmployeeIdIsNotNull() {
            addCriterion("order_employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEmployeeIdEqualTo(String value) {
            addCriterion("order_employee_id =", value, "orderEmployeeId");
            return (Criteria) this;
        }

        public Criteria andOrderEmployeeIdNotEqualTo(String value) {
            addCriterion("order_employee_id <>", value, "orderEmployeeId");
            return (Criteria) this;
        }

        public Criteria andOrderEmployeeIdGreaterThan(String value) {
            addCriterion("order_employee_id >", value, "orderEmployeeId");
            return (Criteria) this;
        }

        public Criteria andOrderEmployeeIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_employee_id >=", value, "orderEmployeeId");
            return (Criteria) this;
        }

        public Criteria andOrderEmployeeIdLessThan(String value) {
            addCriterion("order_employee_id <", value, "orderEmployeeId");
            return (Criteria) this;
        }

        public Criteria andOrderEmployeeIdLessThanOrEqualTo(String value) {
            addCriterion("order_employee_id <=", value, "orderEmployeeId");
            return (Criteria) this;
        }

        public Criteria andOrderEmployeeIdLike(String value) {
            addCriterion("order_employee_id like", value, "orderEmployeeId");
            return (Criteria) this;
        }

        public Criteria andOrderEmployeeIdNotLike(String value) {
            addCriterion("order_employee_id not like", value, "orderEmployeeId");
            return (Criteria) this;
        }

        public Criteria andOrderEmployeeIdIn(List<String> values) {
            addCriterion("order_employee_id in", values, "orderEmployeeId");
            return (Criteria) this;
        }

        public Criteria andOrderEmployeeIdNotIn(List<String> values) {
            addCriterion("order_employee_id not in", values, "orderEmployeeId");
            return (Criteria) this;
        }

        public Criteria andOrderEmployeeIdBetween(String value1, String value2) {
            addCriterion("order_employee_id between", value1, value2, "orderEmployeeId");
            return (Criteria) this;
        }

        public Criteria andOrderEmployeeIdNotBetween(String value1, String value2) {
            addCriterion("order_employee_id not between", value1, value2, "orderEmployeeId");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyIsNull() {
            addCriterion("order_money is null");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyIsNotNull() {
            addCriterion("order_money is not null");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyEqualTo(String value) {
            addCriterion("order_money =", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyNotEqualTo(String value) {
            addCriterion("order_money <>", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyGreaterThan(String value) {
            addCriterion("order_money >", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("order_money >=", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyLessThan(String value) {
            addCriterion("order_money <", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyLessThanOrEqualTo(String value) {
            addCriterion("order_money <=", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyLike(String value) {
            addCriterion("order_money like", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyNotLike(String value) {
            addCriterion("order_money not like", value, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyIn(List<String> values) {
            addCriterion("order_money in", values, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyNotIn(List<String> values) {
            addCriterion("order_money not in", values, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyBetween(String value1, String value2) {
            addCriterion("order_money between", value1, value2, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderMoneyNotBetween(String value1, String value2) {
            addCriterion("order_money not between", value1, value2, "orderMoney");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNull() {
            addCriterion("order_num is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNotNull() {
            addCriterion("order_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumEqualTo(String value) {
            addCriterion("order_num =", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotEqualTo(String value) {
            addCriterion("order_num <>", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThan(String value) {
            addCriterion("order_num >", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThanOrEqualTo(String value) {
            addCriterion("order_num >=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThan(String value) {
            addCriterion("order_num <", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThanOrEqualTo(String value) {
            addCriterion("order_num <=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLike(String value) {
            addCriterion("order_num like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotLike(String value) {
            addCriterion("order_num not like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumIn(List<String> values) {
            addCriterion("order_num in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotIn(List<String> values) {
            addCriterion("order_num not in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumBetween(String value1, String value2) {
            addCriterion("order_num between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotBetween(String value1, String value2) {
            addCriterion("order_num not between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderPointIsNull() {
            addCriterion("order_point is null");
            return (Criteria) this;
        }

        public Criteria andOrderPointIsNotNull() {
            addCriterion("order_point is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPointEqualTo(String value) {
            addCriterion("order_point =", value, "orderPoint");
            return (Criteria) this;
        }

        public Criteria andOrderPointNotEqualTo(String value) {
            addCriterion("order_point <>", value, "orderPoint");
            return (Criteria) this;
        }

        public Criteria andOrderPointGreaterThan(String value) {
            addCriterion("order_point >", value, "orderPoint");
            return (Criteria) this;
        }

        public Criteria andOrderPointGreaterThanOrEqualTo(String value) {
            addCriterion("order_point >=", value, "orderPoint");
            return (Criteria) this;
        }

        public Criteria andOrderPointLessThan(String value) {
            addCriterion("order_point <", value, "orderPoint");
            return (Criteria) this;
        }

        public Criteria andOrderPointLessThanOrEqualTo(String value) {
            addCriterion("order_point <=", value, "orderPoint");
            return (Criteria) this;
        }

        public Criteria andOrderPointLike(String value) {
            addCriterion("order_point like", value, "orderPoint");
            return (Criteria) this;
        }

        public Criteria andOrderPointNotLike(String value) {
            addCriterion("order_point not like", value, "orderPoint");
            return (Criteria) this;
        }

        public Criteria andOrderPointIn(List<String> values) {
            addCriterion("order_point in", values, "orderPoint");
            return (Criteria) this;
        }

        public Criteria andOrderPointNotIn(List<String> values) {
            addCriterion("order_point not in", values, "orderPoint");
            return (Criteria) this;
        }

        public Criteria andOrderPointBetween(String value1, String value2) {
            addCriterion("order_point between", value1, value2, "orderPoint");
            return (Criteria) this;
        }

        public Criteria andOrderPointNotBetween(String value1, String value2) {
            addCriterion("order_point not between", value1, value2, "orderPoint");
            return (Criteria) this;
        }

        public Criteria andOrderSpecIdIsNull() {
            addCriterion("order_spec_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderSpecIdIsNotNull() {
            addCriterion("order_spec_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSpecIdEqualTo(String value) {
            addCriterion("order_spec_id =", value, "orderSpecId");
            return (Criteria) this;
        }

        public Criteria andOrderSpecIdNotEqualTo(String value) {
            addCriterion("order_spec_id <>", value, "orderSpecId");
            return (Criteria) this;
        }

        public Criteria andOrderSpecIdGreaterThan(String value) {
            addCriterion("order_spec_id >", value, "orderSpecId");
            return (Criteria) this;
        }

        public Criteria andOrderSpecIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_spec_id >=", value, "orderSpecId");
            return (Criteria) this;
        }

        public Criteria andOrderSpecIdLessThan(String value) {
            addCriterion("order_spec_id <", value, "orderSpecId");
            return (Criteria) this;
        }

        public Criteria andOrderSpecIdLessThanOrEqualTo(String value) {
            addCriterion("order_spec_id <=", value, "orderSpecId");
            return (Criteria) this;
        }

        public Criteria andOrderSpecIdLike(String value) {
            addCriterion("order_spec_id like", value, "orderSpecId");
            return (Criteria) this;
        }

        public Criteria andOrderSpecIdNotLike(String value) {
            addCriterion("order_spec_id not like", value, "orderSpecId");
            return (Criteria) this;
        }

        public Criteria andOrderSpecIdIn(List<String> values) {
            addCriterion("order_spec_id in", values, "orderSpecId");
            return (Criteria) this;
        }

        public Criteria andOrderSpecIdNotIn(List<String> values) {
            addCriterion("order_spec_id not in", values, "orderSpecId");
            return (Criteria) this;
        }

        public Criteria andOrderSpecIdBetween(String value1, String value2) {
            addCriterion("order_spec_id between", value1, value2, "orderSpecId");
            return (Criteria) this;
        }

        public Criteria andOrderSpecIdNotBetween(String value1, String value2) {
            addCriterion("order_spec_id not between", value1, value2, "orderSpecId");
            return (Criteria) this;
        }

        public Criteria andOrderTransactionIdIsNull() {
            addCriterion("order_transaction_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderTransactionIdIsNotNull() {
            addCriterion("order_transaction_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTransactionIdEqualTo(String value) {
            addCriterion("order_transaction_id =", value, "orderTransactionId");
            return (Criteria) this;
        }

        public Criteria andOrderTransactionIdNotEqualTo(String value) {
            addCriterion("order_transaction_id <>", value, "orderTransactionId");
            return (Criteria) this;
        }

        public Criteria andOrderTransactionIdGreaterThan(String value) {
            addCriterion("order_transaction_id >", value, "orderTransactionId");
            return (Criteria) this;
        }

        public Criteria andOrderTransactionIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_transaction_id >=", value, "orderTransactionId");
            return (Criteria) this;
        }

        public Criteria andOrderTransactionIdLessThan(String value) {
            addCriterion("order_transaction_id <", value, "orderTransactionId");
            return (Criteria) this;
        }

        public Criteria andOrderTransactionIdLessThanOrEqualTo(String value) {
            addCriterion("order_transaction_id <=", value, "orderTransactionId");
            return (Criteria) this;
        }

        public Criteria andOrderTransactionIdLike(String value) {
            addCriterion("order_transaction_id like", value, "orderTransactionId");
            return (Criteria) this;
        }

        public Criteria andOrderTransactionIdNotLike(String value) {
            addCriterion("order_transaction_id not like", value, "orderTransactionId");
            return (Criteria) this;
        }

        public Criteria andOrderTransactionIdIn(List<String> values) {
            addCriterion("order_transaction_id in", values, "orderTransactionId");
            return (Criteria) this;
        }

        public Criteria andOrderTransactionIdNotIn(List<String> values) {
            addCriterion("order_transaction_id not in", values, "orderTransactionId");
            return (Criteria) this;
        }

        public Criteria andOrderTransactionIdBetween(String value1, String value2) {
            addCriterion("order_transaction_id between", value1, value2, "orderTransactionId");
            return (Criteria) this;
        }

        public Criteria andOrderTransactionIdNotBetween(String value1, String value2) {
            addCriterion("order_transaction_id not between", value1, value2, "orderTransactionId");
            return (Criteria) this;
        }

        public Criteria andOrderIsChujiuIsNull() {
            addCriterion("order_is_chujiu is null");
            return (Criteria) this;
        }

        public Criteria andOrderIsChujiuIsNotNull() {
            addCriterion("order_is_chujiu is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIsChujiuEqualTo(String value) {
            addCriterion("order_is_chujiu =", value, "orderIsChujiu");
            return (Criteria) this;
        }

        public Criteria andOrderIsChujiuNotEqualTo(String value) {
            addCriterion("order_is_chujiu <>", value, "orderIsChujiu");
            return (Criteria) this;
        }

        public Criteria andOrderIsChujiuGreaterThan(String value) {
            addCriterion("order_is_chujiu >", value, "orderIsChujiu");
            return (Criteria) this;
        }

        public Criteria andOrderIsChujiuGreaterThanOrEqualTo(String value) {
            addCriterion("order_is_chujiu >=", value, "orderIsChujiu");
            return (Criteria) this;
        }

        public Criteria andOrderIsChujiuLessThan(String value) {
            addCriterion("order_is_chujiu <", value, "orderIsChujiu");
            return (Criteria) this;
        }

        public Criteria andOrderIsChujiuLessThanOrEqualTo(String value) {
            addCriterion("order_is_chujiu <=", value, "orderIsChujiu");
            return (Criteria) this;
        }

        public Criteria andOrderIsChujiuLike(String value) {
            addCriterion("order_is_chujiu like", value, "orderIsChujiu");
            return (Criteria) this;
        }

        public Criteria andOrderIsChujiuNotLike(String value) {
            addCriterion("order_is_chujiu not like", value, "orderIsChujiu");
            return (Criteria) this;
        }

        public Criteria andOrderIsChujiuIn(List<String> values) {
            addCriterion("order_is_chujiu in", values, "orderIsChujiu");
            return (Criteria) this;
        }

        public Criteria andOrderIsChujiuNotIn(List<String> values) {
            addCriterion("order_is_chujiu not in", values, "orderIsChujiu");
            return (Criteria) this;
        }

        public Criteria andOrderIsChujiuBetween(String value1, String value2) {
            addCriterion("order_is_chujiu between", value1, value2, "orderIsChujiu");
            return (Criteria) this;
        }

        public Criteria andOrderIsChujiuNotBetween(String value1, String value2) {
            addCriterion("order_is_chujiu not between", value1, value2, "orderIsChujiu");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(String value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(String value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(String value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(String value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(String value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLike(String value) {
            addCriterion("order_status like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotLike(String value) {
            addCriterion("order_status not like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<String> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<String> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(String value1, String value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(String value1, String value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeIsNull() {
            addCriterion("order_createtime is null");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeIsNotNull() {
            addCriterion("order_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeEqualTo(String value) {
            addCriterion("order_createtime =", value, "orderCreatetime");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeNotEqualTo(String value) {
            addCriterion("order_createtime <>", value, "orderCreatetime");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeGreaterThan(String value) {
            addCriterion("order_createtime >", value, "orderCreatetime");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("order_createtime >=", value, "orderCreatetime");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeLessThan(String value) {
            addCriterion("order_createtime <", value, "orderCreatetime");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("order_createtime <=", value, "orderCreatetime");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeLike(String value) {
            addCriterion("order_createtime like", value, "orderCreatetime");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeNotLike(String value) {
            addCriterion("order_createtime not like", value, "orderCreatetime");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeIn(List<String> values) {
            addCriterion("order_createtime in", values, "orderCreatetime");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeNotIn(List<String> values) {
            addCriterion("order_createtime not in", values, "orderCreatetime");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeBetween(String value1, String value2) {
            addCriterion("order_createtime between", value1, value2, "orderCreatetime");
            return (Criteria) this;
        }

        public Criteria andOrderCreatetimeNotBetween(String value1, String value2) {
            addCriterion("order_createtime not between", value1, value2, "orderCreatetime");
            return (Criteria) this;
        }

        public Criteria andOrderPaytimeIsNull() {
            addCriterion("order_paytime is null");
            return (Criteria) this;
        }

        public Criteria andOrderPaytimeIsNotNull() {
            addCriterion("order_paytime is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPaytimeEqualTo(String value) {
            addCriterion("order_paytime =", value, "orderPaytime");
            return (Criteria) this;
        }

        public Criteria andOrderPaytimeNotEqualTo(String value) {
            addCriterion("order_paytime <>", value, "orderPaytime");
            return (Criteria) this;
        }

        public Criteria andOrderPaytimeGreaterThan(String value) {
            addCriterion("order_paytime >", value, "orderPaytime");
            return (Criteria) this;
        }

        public Criteria andOrderPaytimeGreaterThanOrEqualTo(String value) {
            addCriterion("order_paytime >=", value, "orderPaytime");
            return (Criteria) this;
        }

        public Criteria andOrderPaytimeLessThan(String value) {
            addCriterion("order_paytime <", value, "orderPaytime");
            return (Criteria) this;
        }

        public Criteria andOrderPaytimeLessThanOrEqualTo(String value) {
            addCriterion("order_paytime <=", value, "orderPaytime");
            return (Criteria) this;
        }

        public Criteria andOrderPaytimeLike(String value) {
            addCriterion("order_paytime like", value, "orderPaytime");
            return (Criteria) this;
        }

        public Criteria andOrderPaytimeNotLike(String value) {
            addCriterion("order_paytime not like", value, "orderPaytime");
            return (Criteria) this;
        }

        public Criteria andOrderPaytimeIn(List<String> values) {
            addCriterion("order_paytime in", values, "orderPaytime");
            return (Criteria) this;
        }

        public Criteria andOrderPaytimeNotIn(List<String> values) {
            addCriterion("order_paytime not in", values, "orderPaytime");
            return (Criteria) this;
        }

        public Criteria andOrderPaytimeBetween(String value1, String value2) {
            addCriterion("order_paytime between", value1, value2, "orderPaytime");
            return (Criteria) this;
        }

        public Criteria andOrderPaytimeNotBetween(String value1, String value2) {
            addCriterion("order_paytime not between", value1, value2, "orderPaytime");
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