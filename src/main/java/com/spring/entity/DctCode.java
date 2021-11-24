package com.spring.entity;

import java.io.Serializable;

public class DctCode implements Serializable {

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

    public DctCode(String dctcode, String dctname) {
        this.dctcode = dctcode;
        this.dctname = dctname;
    }

    public DctCode() {
    }

    @Override
    public String toString() {
        return "DctCode{" +
                "dctcode='" + dctcode + '\'' +
                ", dctname='" + dctname + '\'' +
                '}';
    }
}
