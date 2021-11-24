package com.spring.entity;

public class Inbase {

    private String zyxh;

    private String ryrq;

    private String ysmc;

    private String yjjlj;

    private String zje;

    public String getZyxh() {
        return zyxh;
    }

    public void setZyxh(String zyxh) {
        this.zyxh = zyxh;
    }

    public String getRyrq() {
        return ryrq;
    }

    public void setRyrq(String ryrq) {
        this.ryrq = ryrq;
    }

    public String getYsmc() {
        return ysmc;
    }

    public void setYsmc(String ysmc) {
        this.ysmc = ysmc;
    }

    public String getYjjlj() {
        return yjjlj;
    }

    public void setYjjlj(String yjjlj) {
        this.yjjlj = yjjlj;
    }

    public String getZje() {
        return zje;
    }

    public void setZje(String zje) {
        this.zje = zje;
    }

    public Inbase(String zyxh, String ryrq, String ysmc, String yjjlj, String zje) {
        this.zyxh = zyxh;
        this.ryrq = ryrq;
        this.ysmc = ysmc;
        this.yjjlj = yjjlj;
        this.zje = zje;
    }


    public Inbase() {
    }

    @Override
    public String toString() {
        return "Inbase{" +
                "zyxh='" + zyxh + '\'' +
                ", ryrq='" + ryrq + '\'' +
                ", ysmc='" + ysmc + '\'' +
                ", yjjlj='" + yjjlj + '\'' +
                ", zje='" + zje + '\'' +
                '}';
    }
}
