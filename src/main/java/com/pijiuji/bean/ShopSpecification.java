package com.pijiuji.bean;

public class ShopSpecification {
    private Integer id;

    private String specId;

    private String price;

    private Integer pjjId;

    private String updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId == null ? null : specId.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public Integer getPjjId() {
        return pjjId;
    }

    public void setPjjId(Integer pjjId) {
        this.pjjId = pjjId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}