package com.spring.result;

public class DoctorByKsBody {
    private String orgCode;//医院编码

    private String sign;//签名

    private Long requesttime;//时间戳

    private String ksdm;//科室代码

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

    public DoctorByKsBody(String orgCode, String sign, Long requesttime, String ksdm) {
        this.orgCode = orgCode;
        this.sign = sign;
        this.requesttime = requesttime;
        this.ksdm = ksdm;
    }

    public DoctorByKsBody() {
    }

    @Override
    public String toString() {
        return "DoctorByKsBody{" +
                "orgCode='" + orgCode + '\'' +
                ", sign='" + sign + '\'' +
                ", requesttime=" + requesttime +
                ", ksdm='" + ksdm + '\'' +
                '}';
    }
}
