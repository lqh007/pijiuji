package com.pijiuji.bean;

import java.util.Date;

public class Lottery {
    private Integer lotteryId;

    private String lotteryName;

    private Integer lotteryGailv;

    private String lotteryImg;

    private Date lotteryTime;

    private String lotteryType;

    private String lotteryTypedetail;

    private String LotteryCode;

    public Integer getLotteryId() {
        return lotteryId;
    }

    public void setLotteryId(Integer lotteryId) {
        this.lotteryId = lotteryId;
    }

    public String getLotteryName() {
        return lotteryName;
    }

    public void setLotteryName(String lotteryName) {
        this.lotteryName = lotteryName == null ? null : lotteryName.trim();
    }

    public Integer getLotteryGailv() {
        return lotteryGailv;
    }

    public void setLotteryGailv(Integer lotteryGailv) {
        this.lotteryGailv = lotteryGailv;
    }

    public String getLotteryImg() {
        return lotteryImg;
    }

    public void setLotteryImg(String lotteryImg) {
        this.lotteryImg = lotteryImg == null ? null : lotteryImg.trim();
    }

    public Date getLotteryTime() {
        return lotteryTime;
    }

    public void setLotteryTime(Date lotteryTime) {
        this.lotteryTime = lotteryTime;
    }

    public String getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(String lotteryType) {
        this.lotteryType = lotteryType == null ? null : lotteryType.trim();
    }

    public String getLotteryTypedetail() {
        return lotteryTypedetail;
    }

    public void setLotteryTypedetail(String lotteryTypedetail) {
        this.lotteryTypedetail = lotteryTypedetail == null ? null : lotteryTypedetail.trim();
    }

    public String getLotteryCode() {
        return LotteryCode;
    }

    public void setLotteryCode(String lotteryCode) {
        LotteryCode = lotteryCode;
    }
}