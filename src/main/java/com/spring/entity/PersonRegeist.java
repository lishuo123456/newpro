package com.spring.entity;

import java.io.Serializable;

public class PersonRegeist implements Serializable {
    private String patid;//id
    private String memberName;//姓名
    private String gender;//性别
    private String cardType;//证件类型
    private String idcard;//证件号
    private String birth;//生日
    private String sign;//签名
    private Long requesttime;//时间戳
    private String orgCode;//医院编码
    private String medicalCard;//院内卡
    private String medicalCardType;//院内卡类型
    private String idcardAddress;//证件地址
    private String telephone;//本人电话
    private String nationality;//民族
    private String xzz;//现住址
    private String lxr;//联系人
    private String lxrdh;//联系人电话
    private String plane1;//预留1
    private String plane2;//预留2
    private String plane3;//预留3

    public String getPatid() {
        return patid;
    }

    public void setPatid(String patid) {
        this.patid = patid;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
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

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getMedicalCard() {
        return medicalCard;
    }

    public void setMedicalCard(String medicalCard) {
        this.medicalCard = medicalCard;
    }

    public String getMedicalCardType() {
        return medicalCardType;
    }

    public void setMedicalCardType(String medicalCardType) {
        this.medicalCardType = medicalCardType;
    }

    public String getIdcardAddress() {
        return idcardAddress;
    }

    public void setIdcardAddress(String idcardAddress) {
        this.idcardAddress = idcardAddress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getXzz() {
        return xzz;
    }

    public void setXzz(String xzz) {
        this.xzz = xzz;
    }

    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr;
    }

    public String getLxrdh() {
        return lxrdh;
    }

    public void setLxrdh(String lxrdh) {
        this.lxrdh = lxrdh;
    }

    public String getPlane1() {
        return plane1;
    }

    public void setPlane1(String plane1) {
        this.plane1 = plane1;
    }

    public String getPlane2() {
        return plane2;
    }

    public void setPlane2(String plane2) {
        this.plane2 = plane2;
    }

    public String getPlane3() {
        return plane3;
    }

    public void setPlane3(String plane3) {
        this.plane3 = plane3;
    }

    public PersonRegeist(String patid, String memberName, String gender, String cardType, String idcard, String birth, String sign, Long requesttime, String orgCode, String medicalCard, String medicalCardType, String idcardAddress, String telephone, String nationality, String xzz, String lxr, String lxrdh, String plane1, String plane2, String plane3) {
        this.patid = patid;
        this.memberName = memberName;
        this.gender = gender;
        this.cardType = cardType;
        this.idcard = idcard;
        this.birth = birth;
        this.sign = sign;
        this.requesttime = requesttime;
        this.orgCode = orgCode;
        this.medicalCard = medicalCard;
        this.medicalCardType = medicalCardType;
        this.idcardAddress = idcardAddress;
        this.telephone = telephone;
        this.nationality = nationality;
        this.xzz = xzz;
        this.lxr = lxr;
        this.lxrdh = lxrdh;
        this.plane1 = plane1;
        this.plane2 = plane2;
        this.plane3 = plane3;
    }

    public PersonRegeist() {
    }

    @Override
    public String toString() {
        return "PersonRegeist{" +
                "patid='" + patid + '\'' +
                ", memberName='" + memberName + '\'' +
                ", gender='" + gender + '\'' +
                ", cardType='" + cardType + '\'' +
                ", idcard='" + idcard + '\'' +
                ", birth='" + birth + '\'' +
                ", sign='" + sign + '\'' +
                ", requesttime=" + requesttime +
                ", orgCode='" + orgCode + '\'' +
                ", medicalCard='" + medicalCard + '\'' +
                ", medicalCardType='" + medicalCardType + '\'' +
                ", idcardAddress='" + idcardAddress + '\'' +
                ", telephone='" + telephone + '\'' +
                ", nationality='" + nationality + '\'' +
                ", xzz='" + xzz + '\'' +
                ", lxr='" + lxr + '\'' +
                ", lxrdh='" + lxrdh + '\'' +
                ", plane1='" + plane1 + '\'' +
                ", plane2='" + plane2 + '\'' +
                ", plane3='" + plane3 + '\'' +
                '}';
    }
}
