package com.spring.result;

public class MedicineBody {
    private String orgCode;

    private String sign;

    private Long requesttime;

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

    public MedicineBody(String orgCode, String sign, Long requesttime) {
        this.orgCode = orgCode;
        this.sign = sign;
        this.requesttime = requesttime;
    }

    public MedicineBody() {
    }

    @Override
    public String toString() {
        return "MedicineBody{" +
                "orgCode='" + orgCode + '\'' +
                ", sign='" + sign + '\'' +
                ", requesttime=" + requesttime +
                '}';
    }
}
