package com.spring.entity;

public class WJ {

    private String ypcode;

    private String pm;

    private String dw;

    private String lbdj;

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

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public String getLbdj() {
        return lbdj;
    }

    public void setLbdj(String lbdj) {
        this.lbdj = lbdj;
    }

    public WJ(String ypcode, String pm, String dw, String lbdj) {
        this.ypcode = ypcode;
        this.pm = pm;
        this.dw = dw;
        this.lbdj = lbdj;
    }

    public WJ() {
    }


    @Override
    public String toString() {
        return "WJ{" +
                "ypcode='" + ypcode + '\'' +
                ", pm='" + pm + '\'' +
                ", dw='" + dw + '\'' +
                ", lbdj='" + lbdj + '\'' +
                '}';
    }
}
