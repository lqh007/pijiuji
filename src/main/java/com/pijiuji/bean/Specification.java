package com.pijiuji.bean;

public class Specification {
    private String speId;

    private String speSize;

    private String spePrice;

    private String speProId;

    public String getSpeId() {
        return speId;
    }

    public void setSpeId(String speId) {
        this.speId = speId == null ? null : speId.trim();
    }

    public String getSpeSize() {
        return speSize;
    }

    public void setSpeSize(String speSize) {
        this.speSize = speSize == null ? null : speSize.trim();
    }

    public String getSpePrice() {
        return spePrice;
    }

    public void setSpePrice(String spePrice) {
        this.spePrice = spePrice == null ? null : spePrice.trim();
    }

    public String getSpeProId() {
        return speProId;
    }

    public void setSpeProId(String speProId) {
        this.speProId = speProId;
    }
}