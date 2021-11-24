package com.spring.result;

public class AppointmentGhResult {

    private String yyxh;

    private String ysfwf;

    private String ysje;

    private String zje;

    private String nextStepAddr;

    private String reDoctorNo;

    private String visitPosition;

    private String fph;

    private String fpurl;

    private String bz;

    public String getYyxh() {
        return yyxh;
    }

    public void setYyxh(String yyxh) {
        this.yyxh = yyxh;
    }

    public String getYsfwf() {
        return ysfwf;
    }

    public void setYsfwf(String ysfwf) {
        this.ysfwf = ysfwf;
    }

    public String getYsje() {
        return ysje;
    }

    public void setYsje(String ysje) {
        this.ysje = ysje;
    }

    public String getZje() {
        return zje;
    }

    public void setZje(String zje) {
        this.zje = zje;
    }

    public String getNextStepAddr() {
        return nextStepAddr;
    }

    public void setNextStepAddr(String nextStepAddr) {
        this.nextStepAddr = nextStepAddr;
    }

    public String getReDoctorNo() {
        return reDoctorNo;
    }

    public void setReDoctorNo(String reDoctorNo) {
        this.reDoctorNo = reDoctorNo;
    }

    public String getVisitPosition() {
        return visitPosition;
    }

    public void setVisitPosition(String visitPosition) {
        this.visitPosition = visitPosition;
    }

    public String getFph() {
        return fph;
    }

    public void setFph(String fph) {
        this.fph = fph;
    }

    public String getFpurl() {
        return fpurl;
    }

    public void setFpurl(String fpurl) {
        this.fpurl = fpurl;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public AppointmentGhResult(String yyxh, String ysfwf, String ysje, String zje, String nextStepAddr, String reDoctorNo, String visitPosition, String fph, String fpurl, String bz) {
        this.yyxh = yyxh;
        this.ysfwf = ysfwf;
        this.ysje = ysje;
        this.zje = zje;
        this.nextStepAddr = nextStepAddr;
        this.reDoctorNo = reDoctorNo;
        this.visitPosition = visitPosition;
        this.fph = fph;
        this.fpurl = fpurl;
        this.bz = bz;
    }

    public AppointmentGhResult() {
    }

    @Override
    public String toString() {
        return "AppointmentGhResult{" +
                "yyxh='" + yyxh + '\'' +
                ", ysfwf='" + ysfwf + '\'' +
                ", ysje='" + ysje + '\'' +
                ", zje='" + zje + '\'' +
                ", nextStepAddr='" + nextStepAddr + '\'' +
                ", reDoctorNo='" + reDoctorNo + '\'' +
                ", visitPosition='" + visitPosition + '\'' +
                ", fph='" + fph + '\'' +
                ", fpurl='" + fpurl + '\'' +
                ", bz='" + bz + '\'' +
                '}';
    }
}
