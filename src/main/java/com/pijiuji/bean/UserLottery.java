package com.pijiuji.bean;

import java.util.Date;

public class UserLottery {
    private String ulId;

    private String ulUserOpenid;

    private String ulLotteryName;

    private String ulLotteryImg;

    private String ulLotteryType;

    private String ulLotteryDetail;

    private Date ulTime;

    private String ulCdkey;

    private String ulStatus;

    public String getUlId() {
        return ulId;
    }

    public void setUlId(String ulId) {
        this.ulId = ulId == null ? null : ulId.trim();
    }

    public String getUlUserOpenid() {
        return ulUserOpenid;
    }

    public void setUlUserOpenid(String ulUserOpenid) {
        this.ulUserOpenid = ulUserOpenid == null ? null : ulUserOpenid.trim();
    }

    public String getUlLotteryName() {
        return ulLotteryName;
    }

    public void setUlLotteryName(String ulLotteryName) {
        this.ulLotteryName = ulLotteryName == null ? null : ulLotteryName.trim();
    }

    public String getUlLotteryImg() {
        return ulLotteryImg;
    }

    public void setUlLotteryImg(String ulLotteryImg) {
        this.ulLotteryImg = ulLotteryImg == null ? null : ulLotteryImg.trim();
    }

    public String getUlLotteryType() {
        return ulLotteryType;
    }

    public void setUlLotteryType(String ulLotteryType) {
        this.ulLotteryType = ulLotteryType == null ? null : ulLotteryType.trim();
    }

    public String getUlLotteryDetail() {
        return ulLotteryDetail;
    }

    public void setUlLotteryDetail(String ulLotteryDetail) {
        this.ulLotteryDetail = ulLotteryDetail == null ? null : ulLotteryDetail.trim();
    }

    public Date getUlTime() {
        return ulTime;
    }

    public void setUlTime(Date ulTime) {
        this.ulTime = ulTime;
    }

    public String getUlCdkey() {
        return ulCdkey;
    }

    public void setUlCdkey(String ulCdkey) {
        this.ulCdkey = ulCdkey == null ? null : ulCdkey.trim();
    }

    public String getUlStatus() {
        return ulStatus;
    }

    public void setUlStatus(String ulStatus) {
        this.ulStatus = ulStatus == null ? null : ulStatus.trim();
    }
}