package com.spring.result;

import java.util.Date;

public class queryDoctorByKsSchedualBody {

    private String orgCode;

    private String sign;

    private Long requesttime;

    private String ksdm;

    private String startTime;

    private String endTime;

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

    public String getKsdm() {
        return ksdm;
    }

    public void setKsdm(String ksdm) {
        this.ksdm = ksdm;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public queryDoctorByKsSchedualBody(String orgCode, String sign, Long requesttime, String ksdm, String startTime, String endTime) {
        this.orgCode = orgCode;
        this.sign = sign;
        this.requesttime = requesttime;
        this.ksdm = ksdm;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public queryDoctorByKsSchedualBody() {
    }

    @Override
    public String toString() {
        return "queryDoctorByKsSchedualBody{" +
                "orgCode='" + orgCode + '\'' +
                ", sign='" + sign + '\'' +
                ", requesttime=" + requesttime +
                ", ksdm='" + ksdm + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
