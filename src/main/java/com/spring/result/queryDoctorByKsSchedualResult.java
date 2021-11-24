package com.spring.result;

public class queryDoctorByKsSchedualResult {
    private String month;
    private String day;
    private String weekStr;
    private String date;
    private String status;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getWeekStr() {
        return weekStr;
    }

    public void setWeekStr(String weekStr) {
        this.weekStr = weekStr;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public queryDoctorByKsSchedualResult(String month, String day, String weekStr, String date, String status) {
        this.month = month;
        this.day = day;
        this.weekStr = weekStr;
        this.date = date;
        this.status = status;
    }

    public queryDoctorByKsSchedualResult() {
    }

    @Override
    public String toString() {
        return "queryDoctorByKsSchedualResult{" +
                "month='" + month + '\'' +
                ", day='" + day + '\'' +
                ", weekStr='" + weekStr + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
