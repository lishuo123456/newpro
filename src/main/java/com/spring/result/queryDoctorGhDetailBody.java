package com.spring.result;

public class queryDoctorGhDetailBody {

    private String  orgCode;

    private String sign;

    private String requesttime;

    private String ysdm;

    private String pbmxid;

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

    public String getRequesttime() {
        return requesttime;
    }

    public void setRequesttime(String requesttime) {
        this.requesttime = requesttime;
    }

    public String getYsdm() {
        return ysdm;
    }

    public void setYsdm(String ysdm) {
        this.ysdm = ysdm;
    }

    public String getPbmxid() {
        return pbmxid;
    }

    public void setPbmxid(String pbmxid) {
        this.pbmxid = pbmxid;
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

    public queryDoctorGhDetailBody(String orgCode, String sign, String requesttime, String ysdm, String pbmxid, String ksdm, String startTime, String endTime) {
        this.orgCode = orgCode;
        this.sign = sign;
        this.requesttime = requesttime;
        this.ysdm = ysdm;
        this.pbmxid = pbmxid;
        this.ksdm = ksdm;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public queryDoctorGhDetailBody() {
    }

    @Override
    public String toString() {
        return "queryDoctorGhDetailBody{" +
                "orgCode='" + orgCode + '\'' +
                ", sign='" + sign + '\'' +
                ", requesttime='" + requesttime + '\'' +
                ", ysdm='" + ysdm + '\'' +
                ", pbmxid='" + pbmxid + '\'' +
                ", ksdm='" + ksdm + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
