package com.spring.result;

public class DoctorByKsResult {

    private String ysdm;

    private String ysmc;

    private String yszc;

    private String ysjs;

    private String zjbj;

    public String getYsdm() {
        return ysdm;
    }

    public void setYsdm(String ysdm) {
        this.ysdm = ysdm;
    }

    public String getYsmc() {
        return ysmc;
    }

    public void setYsmc(String ysmc) {
        this.ysmc = ysmc;
    }

    public String getYszc() {
        return yszc;
    }

    public void setYszc(String yszc) {
        this.yszc = yszc;
    }

    public String getYsjs() {
        return ysjs;
    }

    public void setYsjs(String ysjs) {
        this.ysjs = ysjs;
    }

    public String getZjbj() {
        return zjbj;
    }

    public void setZjbj(String zjbj) {
        this.zjbj = zjbj;
    }

    public DoctorByKsResult(String ysdm, String ysmc, String yszc, String ysjs, String zjbj) {
        this.ysdm = ysdm;
        this.ysmc = ysmc;
        this.yszc = yszc;
        this.ysjs = ysjs;
        this.zjbj = zjbj;
    }

    public DoctorByKsResult() {
    }

    @Override
    public String toString() {
        return "DoctorByKsResult{" +
                "ysdm='" + ysdm + '\'' +
                ", ysmc='" + ysmc + '\'' +
                ", yszc='" + yszc + '\'' +
                ", ysjs='" + ysjs + '\'' +
                ", zjbj='" + zjbj + '\'' +
                '}';
    }
}

