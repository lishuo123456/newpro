package com.spring.result;

public class KsCodeBody {

    private String orgCode;//医院编码

    private String sign;//签名

    private Long requesttime;//时间戳


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


    public KsCodeBody() {
    }

    public KsCodeBody(String orgCode, String sign, Long requesttime) {
        this.orgCode = orgCode;
        this.sign = sign;
        this.requesttime = requesttime;
    }

    @Override
    public String toString() {
        return "KsCodeBody{" +
                "orgCode='" + orgCode + '\'' +
                ", sign='" + sign + '\'' +
                ", requesttime=" + requesttime +
                '}';
    }
}
