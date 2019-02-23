package com.pijiuji.bean;

public class Order {
    private String orderId;

    private String orderProductId;

    private String orderSize;

    private String orderEmployeeId;

    private String orderMoney;

    private String orderNum;

    private String orderChuNum;

    private String orderPoint;

    private String orderSpecId;

    private String orderTransactionId;

    private String orderIsChujiu;

    private String orderStatus;

    private String orderCreatetime;

    private String orderPaytime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(String orderProductId) {
        this.orderProductId = orderProductId == null ? null : orderProductId.trim();
    }

    public String getOrderSize() {
        return orderSize;
    }

    public void setOrderSize(String orderSize) {
        this.orderSize = orderSize == null ? null : orderSize.trim();
    }

    public String getOrderEmployeeId() {
        return orderEmployeeId;
    }

    public void setOrderEmployeeId(String orderEmployeeId) {
        this.orderEmployeeId = orderEmployeeId == null ? null : orderEmployeeId.trim();
    }

    public String getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(String orderMoney) {
        this.orderMoney = orderMoney == null ? null : orderMoney.trim();
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public String getOrderPoint() {
        return orderPoint;
    }

    public void setOrderPoint(String orderPoint) {
        this.orderPoint = orderPoint == null ? null : orderPoint.trim();
    }

    public String getOrderSpecId() {
        return orderSpecId;
    }

    public void setOrderSpecId(String orderSpecId) {
        this.orderSpecId = orderSpecId == null ? null : orderSpecId.trim();
    }

    public String getOrderTransactionId() {
        return orderTransactionId;
    }

    public void setOrderTransactionId(String orderTransactionId) {
        this.orderTransactionId = orderTransactionId == null ? null : orderTransactionId.trim();
    }

    public String getOrderIsChujiu() {
        return orderIsChujiu;
    }

    public void setOrderIsChujiu(String orderIsChujiu) {
        this.orderIsChujiu = orderIsChujiu == null ? null : orderIsChujiu.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getOrderCreatetime() {
        return orderCreatetime;
    }

    public void setOrderCreatetime(String orderCreatetime) {
        this.orderCreatetime = orderCreatetime == null ? null : orderCreatetime.trim();
    }

    public String getOrderPaytime() {
        return orderPaytime;
    }

    public void setOrderPaytime(String orderPaytime) {
        this.orderPaytime = orderPaytime == null ? null : orderPaytime.trim();
    }

    public String getOrderChuNum() {
        return orderChuNum;
    }

    public void setOrderChuNum(String orderChuNum) {
        this.orderChuNum = orderChuNum;
    }
}