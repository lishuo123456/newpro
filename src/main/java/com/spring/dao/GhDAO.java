package com.spring.dao;

import com.spring.entity.*;
import com.spring.result.AbolishGhBody;
import com.spring.result.AppointmentGhBody;
import com.spring.result.QueryDoctorGhDetail;
import com.spring.result.queryDoctorByKsSchedualBody;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GhDAO {

    public List<DoctorByKsSchedual> queryDoctorByKsSchedual(String ks);


    public void ghInGhbase(AppointmentGhBody appointmentGhBody);

    public void ghInGhmx(AppointmentGhBody appointmentGhBody);

    public List queryDoctorGhCount(@Param("ghks") String ghks ,@Param("time") String time);

    public List<DctCode> queryAllDctByKs(String ghks);

    public QueryDoctorGhDetail queryDoctorGhDetail(@Param("ghks") String ghks,@Param("dctcode") String dctcode,@Param("time") String time,@Param("startTime") String startTime,@Param("endTime") String endTime);

    public int queryDoctorGhSy(AppointmentGhBody appointmentGhBody);

    public void ghInDctSchedual(AppointmentGhBody appointmentGhBody);

    public DctCode queryDctCodeById(String dctcode);

    public PersonRegeist queryPersonRegeistById(String patid);

    public String queryBlid(AppointmentGhBody appointmentGhBody);

    public List<DctSchedual> queryDctSchedual(AppointmentGhBody appointmentGhBody);

    public KsCode queryKsCode(AppointmentGhBody appointmentGhBody);

    public Ghmx queryGhmx(AppointmentGhBody appointmentGhBody);

    public Ghbase queryGhbase(AppointmentGhBody appointmentGhBody);

    public List<DctSchedual> AGQueryDctSchedual(AbolishGhBody abolishGhBody);

    public void deleteByAG(AbolishGhBody abolishGhBody);

    public Ghmx queryGhmxByAG(AbolishGhBody abolishGhBody);

    public void insertGhmxByAG(Ghmx ghmx);

    public void updateGhmxByAG(Ghmx ghmx);


}
