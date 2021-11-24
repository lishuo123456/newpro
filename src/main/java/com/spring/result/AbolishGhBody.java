package com.spring.result;

public class AbolishGhBody {


    private String orgCode;

    private String sign;

    private Long requesttime;

    private String patid;

    private String yyxh;

    private String memberName;

    private String idcard;

    private String refundNumber;

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

    public String getYyxh() {
        return yyxh;
    }

    public void setYyxh(String yyxh) {
        this.yyxh = yyxh;
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

    public String getRefundNumber() {
        return refundNumber;
    }

    public void setRefundNumber(String refundNumber) {
        this.refundNumber = refundNumber;
    }

    public AbolishGhBody(String orgCode, String sign, Long requesttime, String patid, String yyxh, String memberName, String idcard, String refundNumber) {
        this.orgCode = orgCode;
        this.sign = sign;
        this.requesttime = requesttime;
        this.patid = patid;
        this.yyxh = yyxh;
        this.memberName = memberName;
        this.idcard = idcard;
        this.refundNumber = refundNumber;
    }

    public AbolishGhBody() {
    }

    @Override
    public String toString() {
        return "AbolishGhBody{" +
                "orgCode='" + orgCode + '\'' +
                ", sign='" + sign + '\'' +
                ", requesttime=" + requesttime +
                ", patid='" + patid + '\'' +
                ", yyxh='" + yyxh + '\'' +
                ", memberName='" + memberName + '\'' +
                ", idcard='" + idcard + '\'' +
                ", refundNumber='" + refundNumber + '\'' +
                '}';
    }
}
