package com.spring.result;

public class PersonRegeistResult {

    private String patid;//病人唯一码
    private String cardno;//卡号
    private String cardtype;//卡类型
    private String hzxm;//姓名
    private String gender;//性别
    private String sfzh;//身份证号
    private String lxdz;//联系地址
    private String blh;//病历号
    private String birth;//生日

    public String getPatid() {
        return patid;
    }

    public void setPatid(String patid) {
        this.patid = patid;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public String getHzxm() {
        return hzxm;
    }

    public void setHzxm(String hzxm) {
        this.hzxm = hzxm;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getLxdz() {
        return lxdz;
    }

    public void setLxdz(String lxdz) {
        this.lxdz = lxdz;
    }

    public String getBlh() {
        return blh;
    }

    public void setBlh(String blh) {
        this.blh = blh;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public PersonRegeistResult(String patid, String cardno, String cardtype, String hzxm, String gender, String sfzh, String lxdz, String blh, String birth) {
        this.patid = patid;
        this.cardno = cardno;
        this.cardtype = cardtype;
        this.hzxm = hzxm;
        this.gender = gender;
        this.sfzh = sfzh;
        this.lxdz = lxdz;
        this.blh = blh;
        this.birth = birth;
    }

    public PersonRegeistResult() {
    }

    @Override
    public String toString() {
        return "PersonRegeistResult{" +
                "patid='" + patid + '\'' +
                ", cardno='" + cardno + '\'' +
                ", cardtype='" + cardtype + '\'' +
                ", hzxm='" + hzxm + '\'' +
                ", gender='" + gender + '\'' +
                ", sfzh='" + sfzh + '\'' +
                ", lxdz='" + lxdz + '\'' +
                ", blh='" + blh + '\'' +
                ", birth='" + birth + '\'' +
                '}';
    }
}
