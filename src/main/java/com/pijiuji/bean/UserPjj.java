package com.pijiuji.bean;

import java.util.Date;

public class UserPjj {
    private String pjjId;

    private String pjjUserId;

    private String pjjDetailAddress;

    private String pjjStatus;

    private Date pjjTime;

    private String pjjJiuCode;

    private String pjjJiuCodes;

    private String pjjQiNum;

    public String getPjjId() {
        return pjjId;
    }

    public void setPjjId(String pjjId) {
        this.pjjId = pjjId == null ? null : pjjId.trim();
    }

    public String getPjjUserId() {
        return pjjUserId;
    }

    public void setPjjUserId(String pjjUserId) {
        this.pjjUserId = pjjUserId == null ? null : pjjUserId.trim();
    }

    public String getPjjDetailAddress() {
        return pjjDetailAddress;
    }

    public void setPjjDetailAddress(String pjjDetailAddress) {
        this.pjjDetailAddress = pjjDetailAddress == null ? null : pjjDetailAddress.trim();
    }

    public String getPjjStatus() {
        return pjjStatus;
    }

    public void setPjjStatus(String pjjStatus) {
        this.pjjStatus = pjjStatus == null ? null : pjjStatus.trim();
    }

    public Date getPjjTime() {
        return pjjTime;
    }

    public void setPjjTime(Date pjjTime) {
        this.pjjTime = pjjTime;
    }

    public String getPjjJiuCode() {
        return pjjJiuCode;
    }

    public void setPjjJiuCode(String pjjJiuCode) {
        this.pjjJiuCode = pjjJiuCode == null ? null : pjjJiuCode.trim();
    }

    public String getPjjJiuCodes() {
        return pjjJiuCodes;
    }

    public void setPjjJiuCodes(String pjjJiuCodes) {
        this.pjjJiuCodes = pjjJiuCodes == null ? null : pjjJiuCodes.trim();
    }

    public String getPjjQiNum() {
        return pjjQiNum;
    }

    public void setPjjQiNum(String pjjQiNum) {
        this.pjjQiNum = pjjQiNum == null ? null : pjjQiNum.trim();
    }
}