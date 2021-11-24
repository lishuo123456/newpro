package com.spring.result;

public class WJBody {

    private String orgCode;//医院编码

    private String sign;//签名

    private Long requesttime;//时间戳

    private String pagesize;//条数

    private String pageno;//页数

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

    public String getPagesize() {
        return pagesize;
    }

    public void setPagesize(String pagesize) {
        this.pagesize = pagesize;
    }

    public String getPageno() {
        return pageno;
    }

    public void setPageno(String pageno) {
        this.pageno = pageno;
    }

    public WJBody(String orgCode, String sign, Long requesttime, String pagesize, String pageno) {
        this.orgCode = orgCode;
        this.sign = sign;
        this.requesttime = requesttime;
        this.pagesize = pagesize;
        this.pageno = pageno;
    }

    public WJBody() {
    }

    @Override
    public String toString() {
        return "WJBody{" +
                "orgCode='" + orgCode + '\'' +
                ", sign='" + sign + '\'' +
                ", requesttime=" + requesttime +
                ", pagesize='" + pagesize + '\'' +
                ", pageno='" + pageno + '\'' +
                '}';
    }
}
