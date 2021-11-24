package com.spring.result;

public class KsCodeResult {
    private String ksdm;//科室代码

    private String ksmc;//科室名称

    private String ksjj;//科室简介

    private String py;//拼音

    private String wb;//五笔

    public String getKsdm() {
        return ksdm;
    }

    public void setKsdm(String ksdm) {
        this.ksdm = ksdm;
    }

    public String getKsmc() {
        return ksmc;
    }

    public void setKsmc(String ksmc) {
        this.ksmc = ksmc;
    }

    public String getKsjj() {
        return ksjj;
    }

    public void setKsjj(String ksjj) {
        this.ksjj = ksjj;
    }

    public String getPy() {
        return py;
    }

    public void setPy(String py) {
        this.py = py;
    }

    public String getWb() {
        return wb;
    }

    public void setWb(String wb) {
        this.wb = wb;
    }

    public KsCodeResult() {
    }

    public KsCodeResult(String ksdm, String ksmc, String ksjj, String py, String wb) {
        this.ksdm = ksdm;
        this.ksmc = ksmc;
        this.ksjj = ksjj;
        this.py = py;
        this.wb = wb;
    }

    @Override
    public String toString() {
        return "KsCodeResult{" +
                "ksdm='" + ksdm + '\'' +
                ", ksmc='" + ksmc + '\'' +
                ", ksjj='" + ksjj + '\'' +
                ", py='" + py + '\'' +
                ", wb='" + wb + '\'' +
                '}';
    }
}
