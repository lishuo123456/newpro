package com.spring.result;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class AppointmentGhBody {

    private String orgCode;

    private String sign;

    private Long requesttime;

    private String patid;

    private String  timeStart;

    private String timeEnd;

    private String  date;

    private String pbmxid;

    private String memberName;

    private String idcard;

    private Integer type;

    private String ksdm;

    private String ysdm;

    private String yyhx;

    private Integer tradingChannels;

    private String payNumber;

    private String payTime;

    private String subFee;

    private String ghTime;

    private String dctname;

    private String zwname;

    private String sex;

    private Date birthday;

    private String ghid;

    private String blid;

    private Date zwdate;

}
