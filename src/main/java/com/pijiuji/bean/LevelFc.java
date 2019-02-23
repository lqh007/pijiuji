package com.pijiuji.bean;

import java.util.Date;

public class LevelFc {
    private Integer fcId;

    private String fcLevelId;

    private String fcLevelName;

    private String fcBili;

    private Date fcTime;

    public Integer getFcId() {
        return fcId;
    }

    public void setFcId(Integer fcId) {
        this.fcId = fcId;
    }

    public String getFcLevelId() {
        return fcLevelId;
    }

    public void setFcLevelId(String fcLevelId) {
        this.fcLevelId = fcLevelId == null ? null : fcLevelId.trim();
    }

    public String getFcLevelName() {
        return fcLevelName;
    }

    public void setFcLevelName(String fcLevelName) {
        this.fcLevelName = fcLevelName == null ? null : fcLevelName.trim();
    }

    public String getFcBili() {
        return fcBili;
    }

    public void setFcBili(String fcBili) {
        this.fcBili = fcBili == null ? null : fcBili.trim();
    }

    public Date getFcTime() {
        return fcTime;
    }

    public void setFcTime(Date fcTime) {
        this.fcTime = fcTime;
    }
}