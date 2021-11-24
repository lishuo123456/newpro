package com.spring.result;

import java.util.List;

public class queryDoctorGhDetailResult {

    private String pbmxid;

    private String ysdm;

    private String ysmc;

    private String ksdm;

    private String appointmentType;

    private String weeh;

    private String month;

    private String day;

    private String date;

    private List    ams;

    private List    pms;

    private Integer am;

    private Integer pm;

    public String getPbmxid() {
        return pbmxid;
    }

    public void setPbmxid(String pbmxid) {
        this.pbmxid = pbmxid;
    }

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

    public String getKsdm() {
        return ksdm;
    }

    public void setKsdm(String ksdm) {
        this.ksdm = ksdm;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public String getWeeh() {
        return weeh;
    }

    public void setWeeh(String weeh) {
        this.weeh = weeh;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List getAms() {
        return ams;
    }

    public void setAms(List ams) {
        this.ams = ams;
    }

    public List getPms() {
        return pms;
    }

    public void setPms(List pms) {
        this.pms = pms;
    }

    public Integer getAm() {
        return am;
    }

    public void setAm(Integer am) {
        this.am = am;
    }

    public Integer getPm() {
        return pm;
    }

    public void setPm(Integer pm) {
        this.pm = pm;
    }

    public queryDoctorGhDetailResult(String pbmxid, String ysdm, String ysmc, String ksdm, String appointmentType, String weeh, String month, String day, String date, List ams, List pms, Integer am, Integer pm) {
        this.pbmxid = pbmxid;
        this.ysdm = ysdm;
        this.ysmc = ysmc;
        this.ksdm = ksdm;
        this.appointmentType = appointmentType;
        this.weeh = weeh;
        this.month = month;
        this.day = day;
        this.date = date;
        this.ams = ams;
        this.pms = pms;
        this.am = am;
        this.pm = pm;
    }

    public queryDoctorGhDetailResult() {
    }

    @Override
    public String toString() {
        return "queryDoctorGhDetailResult{" +
                "pbmxid='" + pbmxid + '\'' +
                ", ysdm='" + ysdm + '\'' +
                ", ysmc='" + ysmc + '\'' +
                ", ksdm='" + ksdm + '\'' +
                ", appointmentType='" + appointmentType + '\'' +
                ", weeh='" + weeh + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                ", date='" + date + '\'' +
                ", ams=" + ams +
                ", pms=" + pms +
                ", am=" + am +
                ", pm=" + pm +
                '}';
    }
}
