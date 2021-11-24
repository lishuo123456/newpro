package com.spring.result;

public class MedicineResult {

    private String ypbm;

    private String ypmc;

    private String jx;

    private String gg;

    private String jldw;

    private String ypdj;

    private String sfdj;

    private String sflb;

    private String sccj;

    private String bz;

    public String getYpbm() {
        return ypbm;
    }

    public void setYpbm(String ypbm) {
        this.ypbm = ypbm;
    }

    public String getYpmc() {
        return ypmc;
    }

    public void setYpmc(String ypmc) {
        this.ypmc = ypmc;
    }

    public String getJx() {
        return jx;
    }

    public void setJx(String jx) {
        this.jx = jx;
    }

    public String getGg() {
        return gg;
    }

    public void setGg(String gg) {
        this.gg = gg;
    }

    public String getJldw() {
        return jldw;
    }

    public void setJldw(String jldw) {
        this.jldw = jldw;
    }

    public String getYpdj() {
        return ypdj;
    }

    public void setYpdj(String ypdj) {
        this.ypdj = ypdj;
    }

    public String getSfdj() {
        return sfdj;
    }

    public void setSfdj(String sfdj) {
        this.sfdj = sfdj;
    }

    public String getSflb() {
        return sflb;
    }

    public void setSflb(String sflb) {
        this.sflb = sflb;
    }

    public String getSccj() {
        return sccj;
    }

    public void setSccj(String sccj) {
        this.sccj = sccj;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public MedicineResult(String ypbm, String ypmc, String jx, String gg, String jldw, String ypdj, String sfdj, String sflb, String sccj, String bz) {
        this.ypbm = ypbm;
        this.ypmc = ypmc;
        this.jx = jx;
        this.gg = gg;
        this.jldw = jldw;
        this.ypdj = ypdj;
        this.sfdj = sfdj;
        this.sflb = sflb;
        this.sccj = sccj;
        this.bz = bz;
    }

    public MedicineResult() {
    }

    @Override
    public String toString() {
        return "MedicineResult{" +
                "ypbm='" + ypbm + '\'' +
                ", ypmc='" + ypmc + '\'' +
                ", jx='" + jx + '\'' +
                ", gg='" + gg + '\'' +
                ", jldw='" + jldw + '\'' +
                ", ypdj='" + ypdj + '\'' +
                ", sfdj='" + sfdj + '\'' +
                ", sflb='" + sflb + '\'' +
                ", sccj='" + sccj + '\'' +
                ", bz='" + bz + '\'' +
                '}';
    }
}
