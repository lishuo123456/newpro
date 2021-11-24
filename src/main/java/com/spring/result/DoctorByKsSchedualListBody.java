package com.spring.result;

public class DoctorByKsSchedualListBody {

    private String ysdm;

    private String ysmc;

    private String pbmxid;

    private String kghhyzs;

    public String getYsdm() {
        return ysdm;
    }

    public void setYsdm(String ysdm) {
        this.ysdm = ysdm;
    }

    public String getYsmc() {
        return ysmc;
    }

    public void setYsmc(String ysmc) {
        this.ysmc = ysmc;
    }

    public String getPbmxid() {
        return pbmxid;
    }

    public void setPbmxid(String pbmxid) {
        this.pbmxid = pbmxid;
    }

    public String getKghhyzs() {
        return kghhyzs;
    }

    public void setKghhyzs(String kghhyzs) {
        this.kghhyzs = kghhyzs;
    }

    public DoctorByKsSchedualListBody(String ysdm, String ysmc, String pbmxid, String kghhyzs) {
        this.ysdm = ysdm;
        this.ysmc = ysmc;
        this.pbmxid = pbmxid;
        this.kghhyzs = kghhyzs;
    }

    public DoctorByKsSchedualListBody() {
    }

    @Override
    public String toString() {
        return "DoctorByKsSchedualListBody{" +
                "ysdm='" + ysdm + '\'' +
                ", ysmc='" + ysmc + '\'' +
                ", pbmxid='" + pbmxid + '\'' +
                ", kghhyzs='" + kghhyzs + '\'' +
                '}';
    }
}
