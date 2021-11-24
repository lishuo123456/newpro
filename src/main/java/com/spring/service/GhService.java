package com.spring.service;

import com.spring.entity.DoctorByKsSchedual;
import com.spring.entity.DoctorGhDetail;
import com.spring.result.AppointmentGhBody;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GhService {
    public List<DoctorByKsSchedual> queryDoctorByKsSchedual(String ks);

    public List<DoctorGhDetail>  DoctorGhDetail(@Param("dctcode") String dctcode, @Param("ks") String ks);

    public void ghInGhbase(AppointmentGhBody appointmentGhBody);

    public void ghInGhmx(AppointmentGhBody appointmentGhBody);
}
