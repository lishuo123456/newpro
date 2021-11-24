package com.spring.entity;

import java.io.Serializable;

public class Medicine implements Serializable {

    private String ypcode;

    private String pm;

    private String gg;

    private String dw;

    private String counts;

    private String dj;

    private String jx;

    public String getYpcode() {
        return ypcode;
    }

    public void setYpcode(String ypcode) {
        this.ypcode = ypcode;
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    public String getGg() {
        return gg;
    }

    public void setGg(String gg) {
        this.gg = gg;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public String getCounts() {
        return counts;
    }

    public void setCounts(String counts) {
        this.counts = counts;
    }

    public String getDj() {
        return dj;
    }

    public void setDj(String dj) {
        this.dj = dj;
    }

    public String getJx() {
        return jx;
    }

    public void setJx(String jx) {
        this.jx = jx;
    }

    public Medicine(String ypcode, String pm, String gg, String dw, String counts, String dj, String jx) {
        this.ypcode = ypcode;
        this.pm = pm;
        this.gg = gg;
        this.dw = dw;
        this.counts = counts;
        this.dj = dj;
        this.jx = jx;
    }

    public Medicine() {
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "ypcode='" + ypcode + '\'' +
                ", pm='" + pm + '\'' +
                ", gg='" + gg + '\'' +
                ", dw='" + dw + '\'' +
                ", counts='" + counts + '\'' +
                ", dj='" + dj + '\'' +
                ", jx='" + jx + '\'' +
                '}';
    }
}
