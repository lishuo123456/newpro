package com.spring.result;

public class CostDetailedBody {

    private String orgCode;

    private String sign;

    private Long requesttime;

    private String memberName;

    private String idcard;

    private String patid;

    private String ksrq;

    private String jsrq;

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

    public String getPatid() {
        return patid;
    }

    public void setPatid(String patid) {
        this.patid = patid;
    }

    public String getKsrq() {
        return ksrq;
    }

    public void setKsrq(String ksrq) {
        this.ksrq = ksrq;
    }

    public String getJsrq() {
        return jsrq;
    }

    public void setJsrq(String jsrq) {
        this.jsrq = jsrq;
    }

    public CostDetailedBody(String orgCode, String sign, Long requesttime, String memberName, String idcard, String patid, String ksrq, String jsrq) {
        this.orgCode = orgCode;
        this.sign = sign;
        this.requesttime = requesttime;
        this.memberName = memberName;
        this.idcard = idcard;
        this.patid = patid;
        this.ksrq = ksrq;
        this.jsrq = jsrq;
    }


    public CostDetailedBody() {
    }

    @Override
    public String toString() {
        return "CostDetailedBody{" +
                "orgCode='" + orgCode + '\'' +
                ", sign='" + sign + '\'' +
                ", requesttime=" + requesttime +
                ", memberName='" + memberName + '\'' +
                ", idcard='" + idcard + '\'' +
                ", patid='" + patid + '\'' +
                ", ksrq='" + ksrq + '\'' +
                ", jsrq='" + jsrq + '\'' +
                '}';
    }
}
