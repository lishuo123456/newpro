package com.spring.service;

import com.spring.dao.GhDAO;
import com.spring.entity.DoctorByKsSchedual;
import com.spring.entity.DoctorGhDetail;
import com.spring.result.AppointmentGhBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class GhServiceImpl implements GhService{
    @Autowired
    private GhDAO ghDAO;

    @Override
    public List<DoctorByKsSchedual> queryDoctorByKsSchedual(String ks) {
        return ghDAO.queryDoctorByKsSchedual(ks);
    }

    @Override
    public List<DoctorGhDetail> DoctorGhDetail(String dctcode, String ks) {
        return ghDAO.queryDoctorGhDetail(dctcode,ks);
    }

    @Override
    public void ghInGhbase(AppointmentGhBody appointmentGhBody) {
        ghDAO.ghInGhbase(appointmentGhBody);
    }

    @Override
    public void ghInGhmx(AppointmentGhBody appointmentGhBody) {
        ghDAO.ghInGhmx(appointmentGhBody);
    }
}
