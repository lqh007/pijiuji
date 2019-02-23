package com.pijiuji.bean;

import java.util.Date;

public class LevelUser {
    /** 用户标识*/
    private String levelUserId;

    /** 头像*/
    private String levelUserHeadimg;

    /** 用户姓名*/
    private String levelUserName;

    /** 联系地址*/
    private String levelUserAddress;

    /** 联系方式(也是账号)*/
    private String levelUserPhone;

    /** 密码*/
    private String levelUserPassword;

    /** 状态(0正常  1禁用)*/
    private String levelUserStatus;

    /** 申请状态(0审核中  1通过  2失败)*/
    private String levelUserApplyStatus;

    /** 添加时间*/
    private Date levelUserTime;

    /** 上级标识*/
    private String levelUserParentOpenid;

    /** 用户级别(0城市创始人  1城市合作伙伴 2终端店  3服务推广员)*/
    private String levelUserLevel;

    /** 微信的openid*/
    private String levelUserWxOpenid;

    /** 余额*/
    private String levelUserMoney;

    /** 角色id*/
    private Integer levelRoleId;

    /** 审核原因*/
    private String levelUserReason;

    public String getLevelUserId() {
        return levelUserId;
    }

    public void setLevelUserId(String levelUserId) {
        this.levelUserId = levelUserId == null ? null : levelUserId.trim();
    }

    public String getLevelUserHeadimg() {
        return levelUserHeadimg;
    }

    public void setLevelUserHeadimg(String levelUserHeadimg) {
        this.levelUserHeadimg = levelUserHeadimg == null ? null : levelUserHeadimg.trim();
    }

    public String getLevelUserName() {
        return levelUserName;
    }

    public void setLevelUserName(String levelUserName) {
        this.levelUserName = levelUserName == null ? null : levelUserName.trim();
    }

    public String getLevelUserAddress() {
        return levelUserAddress;
    }

    public void setLevelUserAddress(String levelUserAddress) {
        this.levelUserAddress = levelUserAddress == null ? null : levelUserAddress.trim();
    }

    public String getLevelUserPhone() {
        return levelUserPhone;
    }

    public void setLevelUserPhone(String levelUserPhone) {
        this.levelUserPhone = levelUserPhone == null ? null : levelUserPhone.trim();
    }

    public String getLevelUserPassword() {
        return levelUserPassword;
    }

    public void setLevelUserPassword(String levelUserPassword) {
        this.levelUserPassword = levelUserPassword == null ? null : levelUserPassword.trim();
    }

    public String getLevelUserStatus() {
        return levelUserStatus;
    }

    public void setLevelUserStatus(String levelUserStatus) {
        this.levelUserStatus = levelUserStatus == null ? null : levelUserStatus.trim();
    }

    public String getLevelUserApplyStatus() {
        return levelUserApplyStatus;
    }

    public void setLevelUserApplyStatus(String levelUserApplyStatus) {
        this.levelUserApplyStatus = levelUserApplyStatus == null ? null : levelUserApplyStatus.trim();
    }

    public Date getLevelUserTime() {
        return levelUserTime;
    }

    public void setLevelUserTime(Date levelUserTime) {
        this.levelUserTime = levelUserTime;
    }

    public String getLevelUserParentOpenid() {
        return levelUserParentOpenid;
    }

    public void setLevelUserParentOpenid(String levelUserParentOpenid) {
        this.levelUserParentOpenid = levelUserParentOpenid == null ? null : levelUserParentOpenid.trim();
    }

    public String getLevelUserLevel() {
        return levelUserLevel;
    }

    public void setLevelUserLevel(String levelUserLevel) {
        this.levelUserLevel = levelUserLevel == null ? null : levelUserLevel.trim();
    }

    public String getLevelUserWxOpenid() {
        return levelUserWxOpenid;
    }

    public void setLevelUserWxOpenid(String levelUserWxOpenid) {
        this.levelUserWxOpenid = levelUserWxOpenid == null ? null : levelUserWxOpenid.trim();
    }

    public String getLevelUserMoney() {
        return levelUserMoney;
    }

    public void setLevelUserMoney(String levelUserMoney) {
        this.levelUserMoney = levelUserMoney == null ? null : levelUserMoney.trim();
    }

    public Integer getLevelRoleId() {
        return levelRoleId;
    }

    public void setLevelRoleId(Integer levelRoleId) {
        this.levelRoleId = levelRoleId;
    }

    public String getLevelUserReason() {
        return levelUserReason;
    }

    public void setLevelUserReason(String levelUserReason) {
        this.levelUserReason = levelUserReason == null ? null : levelUserReason.trim();
    }
}