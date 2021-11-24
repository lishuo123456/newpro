package com.spring.result;

import java.sql.Timestamp;

public class AppointmentGhBody {

    private String orgCode;

    private String sign;

    private Long requesttime;

    private String patid;

    private Timestamp timeStart;

    private Timestamp timeEnd;

    private Timestamp date;

    private String pbmxid;

    private String memberName;

    private String idcard;

    private Integer type;

    private String ksdm;

    private String ysdm;

    private String yyhx;

    private Integer tradingChannels;

    private String payNumber;

    private String payTime;

    private String subFee;

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Long getRequesttime() {
        return requesttime;
    }

    public void setRequesttime(Long requesttime) {
        this.requesttime = requesttime;
    }

    public String getPatid() {
        return patid;
    }

    public void setPatid(String patid) {
        this.patid = patid;
    }

    public Timestamp getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Timestamp timeStart) {
        this.timeStart = timeStart;
    }

    public Timestamp getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Timestamp timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getPbmxid() {
        return pbmxid;
    }

    public void setPbmxid(String pbmxid) {
        this.pbmxid = pbmxid;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getKsdm() {
        return ksdm;
    }

    public void setKsdm(String ksdm) {
        this.ksdm = ksdm;
    }

    public String getYsdm() {
        return ysdm;
    }

    public void setYsdm(String ysdm) {
        this.ysdm = ysdm;
    }

    public String getYyhx() {
        return yyhx;
    }

    public void setYyhx(String yyhx) {
        this.yyhx = yyhx;
    }

    public Integer getTradingChannels() {
        return tradingChannels;
    }

    public void setTradingChannels(Integer tradingChannels) {
        this.tradingChannels = tradingChannels;
    }

    public String getPayNumber() {
        return payNumber;
    }

    public void setPayNumber(String payNumber) {
        this.payNumber = payNumber;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getSubFee() {
        return subFee;
    }

    public void setSubFee(String subFee) {
        this.subFee = subFee;
    }

    public AppointmentGhBody(String orgCode, String sign, Long requesttime, String patid, Timestamp timeStart, Timestamp timeEnd, Timestamp date, String pbmxid, String memberName, String idcard, Integer type, String ksdm, String ysdm, String yyhx, Integer tradingChannels, String payNumber, String payTime, String subFee) {
        this.orgCode = orgCode;
        this.sign = sign;
        this.requesttime = requesttime;
        this.patid = patid;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.date = date;
        this.pbmxid = pbmxid;
        this.memberName = memberName;
        this.idcard = idcard;
        this.type = type;
        this.ksdm = ksdm;
        this.ysdm = ysdm;
        this.yyhx = yyhx;
        this.tradingChannels = tradingChannels;
        this.payNumber = payNumber;
        this.payTime = payTime;
        this.subFee = subFee;
    }

    public AppointmentGhBody() {
    }

    @Override
    public String toString() {
        return "AppointmentGhBody{" +
                "orgCode='" + orgCode + '\'' +
                ", sign='" + sign + '\'' +
                ", requesttime=" + requesttime +
                ", patid='" + patid + '\'' +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", date=" + date +
                ", pbmxid='" + pbmxid + '\'' +
                ", memberName='" + memberName + '\'' +
                ", idcard='" + idcard + '\'' +
                ", type=" + type +
                ", ksdm='" + ksdm + '\'' +
                ", ysdm='" + ysdm + '\'' +
                ", yyhx='" + yyhx + '\'' +
                ", tradingChannels=" + tradingChannels +
                ", payNumber='" + payNumber + '\'' +
                ", payTime='" + payTime + '\'' +
                ", subFee='" + subFee + '\'' +
                '}';
    }
}
