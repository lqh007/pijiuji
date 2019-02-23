package com.pijiuji.bean;

import java.util.Date;

public class Fat {
    private String fatId;

    private String fatProductId;

    private String fatStatus;

    private String fatNum;

    private Date fatTime;

    public String getFatId() {
        return fatId;
    }

    public void setFatId(String fatId) {
        this.fatId = fatId == null ? null : fatId.trim();
    }

    public String getFatProductId() {
        return fatProductId;
    }

    public void setFatProductId(String fatProductId) {
        this.fatProductId = fatProductId == null ? null : fatProductId.trim();
    }

    public String getFatStatus() {
        return fatStatus;
    }

    public void setFatStatus(String fatStatus) {
        this.fatStatus = fatStatus == null ? null : fatStatus.trim();
    }

    public String getFatNum() {
        return fatNum;
    }

    public void setFatNum(String fatNum) {
        this.fatNum = fatNum == null ? null : fatNum.trim();
    }

    public Date getFatTime() {
        return fatTime;
    }

    public void setFatTime(Date fatTime) {
        this.fatTime = fatTime;
    }
}