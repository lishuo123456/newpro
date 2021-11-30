package com.spring.result;

import lombok.Data;

import java.util.List;
@Data
public class queryDoctorGhDetailResult {


    private String ysdm;

    private String ysmc;

    private String ksdm;

    private String appointmentType;

    private String weeh;

    private String month;

    private String day;

    private String date;

    private List    ams;

    private List    pms;

    private Integer am;

    private Integer pm;

}
