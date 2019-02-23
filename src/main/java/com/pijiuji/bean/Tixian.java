package com.pijiuji.bean;

import java.util.Date;

public class Tixian {
    private String txId;

    private String txUserid;

    private String txMoney;

    private Date txTime;

    private String txSuccessTime;

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getTxUserid() {
        return txUserid;
    }

    public void setTxUserid(String txUserid) {
        this.txUserid = txUserid == null ? null : txUserid.trim();
    }

    public String getTxMoney() {
        return txMoney;
    }

    public void setTxMoney(String txMoney) {
        this.txMoney = txMoney == null ? null : txMoney.trim();
    }

    public Date getTxTime() {
        return txTime;
    }

    public void setTxTime(Date txTime) {
        this.txTime = txTime;
    }

    public String getTxSuccessTime() {
        return txSuccessTime;
    }

    public void setTxSuccessTime(String txSuccessTime) {
        this.txSuccessTime = txSuccessTime == null ? null : txSuccessTime.trim();
    }
}