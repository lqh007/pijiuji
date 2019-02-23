package com.pijiuji.bean;

public class ProPjj {
    private String propjjId;

    private String propjjPjjCode;

    private String propjjPjjProid;

    public String getPropjjId() {
        return propjjId;
    }

    public void setPropjjId(String propjjId) {
        this.propjjId = propjjId == null ? null : propjjId.trim();
    }

    public String getPropjjPjjCode() {
        return propjjPjjCode;
    }

    public void setPropjjPjjCode(String propjjPjjCode) {
        this.propjjPjjCode = propjjPjjCode == null ? null : propjjPjjCode.trim();
    }

    public String getPropjjPjjProid() {
        return propjjPjjProid;
    }

    public void setPropjjPjjProid(String propjjPjjProid) {
        this.propjjPjjProid = propjjPjjProid == null ? null : propjjPjjProid.trim();
    }
}