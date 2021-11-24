package com.spring.entity;

public class DoctorGhDetail {
    private String dctcode;

    private String dctname;

    private String dctks;

    private String amount;

    public String getDctcode() {
        return dctcode;
    }

    public void setDctcode(String dctcode) {
        this.dctcode = dctcode;
    }

    public String getDctname() {
        return dctname;
    }

    public void setDctname(String dctname) {
        this.dctname = dctname;
    }

    public String getDctks() {
        return dctks;
    }

    public void setDctks(String dctks) {
        this.dctks = dctks;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public DoctorGhDetail(String dctcode, String dctname, String dctks, String amount) {
        this.dctcode = dctcode;
        this.dctname = dctname;
        this.dctks = dctks;
        this.amount = amount;
    }

    public DoctorGhDetail() {
    }

    @Override
    public String toString() {
        return "DoctorGhDetail{" +
                "dctcode='" + dctcode + '\'' +
                ", dctname='" + dctname + '\'' +
                ", dctks='" + dctks + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
