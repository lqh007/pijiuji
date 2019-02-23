package com.pijiuji.bean;

import java.util.Date;

public class Pjj {
    private Integer pjjId;

    private String pjjCode;

    private String pjjAddress;

    private String pjjStatus;

    private String pjjUserId;

    private Date pjjTime;

    public Integer getPjjId() {
        return pjjId;
    }

    public void setPjjId(Integer pjjId) {
        this.pjjId = pjjId;
    }

    public String getPjjAddress() {
        return pjjAddress;
    }

    public void setPjjAddress(String pjjAddress) {
        this.pjjAddress = pjjAddress == null ? null : pjjAddress.trim();
    }

    public String getPjjStatus() {
        return pjjStatus;
    }

    public void setPjjStatus(String pjjStatus) {
        this.pjjStatus = pjjStatus == null ? null : pjjStatus.trim();
    }

    public String getPjjUserId() {
        return pjjUserId;
    }

    public void setPjjUserId(String pjjUserId) {
        this.pjjUserId = pjjUserId == null ? null : pjjUserId.trim();
    }

    public Date getPjjTime() {
        return pjjTime;
    }

    public void setPjjTime(Date pjjTime) {
        this.pjjTime = pjjTime;
    }

    public String getPjjCode() {
        return pjjCode;
    }

    public void setPjjCode(String pjjCode) {
        this.pjjCode = pjjCode;
    }
}