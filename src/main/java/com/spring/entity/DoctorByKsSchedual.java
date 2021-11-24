package com.spring.entity;

public class DoctorByKsSchedual {

    private String dctcode;

    private String dctname;

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

    public DoctorByKsSchedual(String dctcode, String dctname) {
        this.dctcode = dctcode;
        this.dctname = dctname;
    }

    public DoctorByKsSchedual() {
    }

    @Override
    public String toString() {
        return "DoctorByKsSchedual{" +
                "dctcode='" + dctcode + '\'' +
                ", dctname='" + dctname + '\'' +
                '}';
    }
}
