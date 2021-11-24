package com.spring.result;

public class WJResult {

    private String xmbm;//项目编码

    private String xmmc;//项目名称

    private String ybxmbm;//医保项目编码

    private String ybxmmc;//医保项目名称

    private String jldw;//计量单位

    private String dj;//单价

    private String sfdj;//收费等级

    private String sflb;//收费类别

    private String zxksbm;//执行科室编码

    private String zxks;//执行科室

    private String bz;//备注

    public String getXmbm() {
        return xmbm;
    }

    public void setXmbm(String xmbm) {
        this.xmbm = xmbm;
    }

    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    public String getYbxmbm() {
        return ybxmbm;
    }

    public void setYbxmbm(String ybxmbm) {
        this.ybxmbm = ybxmbm;
    }

    public String getYbxmmc() {
        return ybxmmc;
    }

    public void setYbxmmc(String ybxmmc) {
        this.ybxmmc = ybxmmc;
    }

    public String getJldw() {
        return jldw;
    }

    public void setJldw(String jldw) {
        this.jldw = jldw;
    }

    public String getDj() {
        return dj;
    }

    public void setDj(String dj) {
        this.dj = dj;
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

    public String getZxksbm() {
        return zxksbm;
    }

    public void setZxksbm(String zxksbm) {
        this.zxksbm = zxksbm;
    }

    public String getZxks() {
        return zxks;
    }

    public void setZxks(String zxks) {
        this.zxks = zxks;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public WJResult(String xmbm, String xmmc, String ybxmbm, String ybxmmc, String jldw, String dj, String sfdj, String sflb, String zxksbm, String zxks, String bz) {
        this.xmbm = xmbm;
        this.xmmc = xmmc;
        this.ybxmbm = ybxmbm;
        this.ybxmmc = ybxmmc;
        this.jldw = jldw;
        this.dj = dj;
        this.sfdj = sfdj;
        this.sflb = sflb;
        this.zxksbm = zxksbm;
        this.zxks = zxks;
        this.bz = bz;
    }

    public WJResult() {
    }

    @Override
    public String toString() {
        return "WJResult{" +
                "xmbm='" + xmbm + '\'' +
                ", xmmc='" + xmmc + '\'' +
                ", ybxmbm='" + ybxmbm + '\'' +
                ", ybxmmc='" + ybxmmc + '\'' +
                ", jldw='" + jldw + '\'' +
                ", dj='" + dj + '\'' +
                ", sfdj='" + sfdj + '\'' +
                ", sflb='" + sflb + '\'' +
                ", zxksbm='" + zxksbm + '\'' +
                ", zxks='" + zxks + '\'' +
                ", bz='" + bz + '\'' +
                '}';
    }
}
