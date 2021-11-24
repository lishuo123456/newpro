package com.spring.entity;

public class KsCode {
    //科室编码
    private String mzkscode;
    //科室名称
    private String mzksname;
    //拼音
    private String py;

    private String Note;

    private String flag;

    public String getMzkscode() {
        return mzkscode;
    }

    public void setMzkscode(String mzkscode) {
        this.mzkscode = mzkscode;
    }

    public String getMzksname() {
        return mzksname;
    }

    public void setMzksname(String mzksname) {
        this.mzksname = mzksname;
    }

    public String getPy() {
        return py;
    }

    public void setPy(String py) {
        this.py = py;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public KsCode(String mzkscode, String mzksname, String py, String note, String flag) {
        this.mzkscode = mzkscode;
        this.mzksname = mzksname;
        this.py = py;
        Note = note;
        this.flag = flag;
    }

    public KsCode() {
    }

    @Override
    public String toString() {
        return "KsCodeBody{" +
                "mzkscode='" + mzkscode + '\'' +
                ", mzksname='" + mzksname + '\'' +
                ", py='" + py + '\'' +
                ", Note='" + Note + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
