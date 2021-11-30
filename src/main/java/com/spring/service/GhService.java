package com.spring.service;

import com.spring.entity.*;
import com.spring.result.AbolishGhBody;
import com.spring.result.AppointmentGhBody;
import com.spring.result.QueryDoctorGhDetail;
import com.spring.result.queryDoctorByKsSchedualBody;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GhService {
    List<DoctorByKsSchedual> queryDoctorByKsSchedual(String ks);



    void ghInGhbase(AppointmentGhBody appointmentGhBody);

    void ghInGhmx(AppointmentGhBody appointmentGhBody);

    List<DoctorGhCount> queryDoctorGHCount(String ghks,String time);

    List<DctCode> queryAllDctByKs(String ghks);

    public QueryDoctorGhDetail queryDoctorGhDetail(String ghks,String dctcode,String time,String startTime,String endTime);

    public int queryDoctorGhSy(AppointmentGhBody appointmentGhBody);

    public void ghInDctSchedual(AppointmentGhBody appointmentGhBody);

    public DctCode queryDctCodeById(String dctcode);

    public PersonRegeist queryPersonRegeistById(String patid);

    public String queryBlid(AppointmentGhBody appointmentGhBody);

    public List<DctSchedual> queryDctSchedual(AppointmentGhBody appointmentGhBody);

    public KsCode queryKsCode(AppointmentGhBody appointmentGhBody);

    public Ghmx queryGhmx(AppointmentGhBody appointmentGhBody);

    public Ghbase queryGhbase(AppointmentGhBody appointmentGhBody);

    public List<DctSchedual> AGQueryDctSchedual(AbolishGhBody appointmentGhBody);

    public void deleteByAG(AbolishGhBody abolishGhBody);

    public Ghmx queryGhmxByAG(AbolishGhBody abolishGhBody);

    public void insertGhmxByAG(Ghmx ghmx);

    public void updateGhmxByAG(Ghmx ghmx);


}
