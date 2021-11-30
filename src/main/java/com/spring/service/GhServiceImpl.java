package com.spring.service;

import com.spring.dao.GhDAO;
import com.spring.entity.*;
import com.spring.result.AbolishGhBody;
import com.spring.result.AppointmentGhBody;
import com.spring.result.QueryDoctorGhDetail;
import com.spring.result.queryDoctorByKsSchedualBody;
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
    public void ghInGhbase(AppointmentGhBody appointmentGhBody) {
        ghDAO.ghInGhbase(appointmentGhBody);
    }

    @Override
    public void ghInGhmx(AppointmentGhBody appointmentGhBody) {
        ghDAO.ghInGhmx(appointmentGhBody);
    }

    @Override
    public List queryDoctorGHCount(String ghks, String time) {
        return ghDAO.queryDoctorGhCount(ghks,time);
    }

    @Override
    public List<DctCode> queryAllDctByKs(String ghks) {
        return ghDAO.queryAllDctByKs(ghks);
    }

    @Override
    public QueryDoctorGhDetail queryDoctorGhDetail(String ghks, String dctcode, String time, String startTime, String endTime) {
        return ghDAO.queryDoctorGhDetail(ghks,dctcode,time,startTime,endTime);
    }

    @Override
    public int queryDoctorGhSy(AppointmentGhBody appointmentGhBody) {
        return ghDAO.queryDoctorGhSy(appointmentGhBody);
    }

    @Override
    public void ghInDctSchedual(AppointmentGhBody appointmentGhBody) {
        ghDAO.ghInDctSchedual(appointmentGhBody);
    }

    @Override
    public DctCode queryDctCodeById(String dctcode) {
        return ghDAO.queryDctCodeById(dctcode);
    }

    @Override
    public PersonRegeist queryPersonRegeistById(String patid) {
        return ghDAO.queryPersonRegeistById(patid);
    }

    @Override
    public String queryBlid(AppointmentGhBody appointmentGhBody) {
        return ghDAO.queryBlid(appointmentGhBody);
    }

    @Override
    public List<DctSchedual> queryDctSchedual(AppointmentGhBody appointmentGhBody) {
        return ghDAO.queryDctSchedual(appointmentGhBody);
    }

    @Override
    public KsCode queryKsCode(AppointmentGhBody appointmentGhBody) {
        return ghDAO.queryKsCode(appointmentGhBody);
    }

    @Override
    public Ghmx queryGhmx(AppointmentGhBody appointmentGhBody) {
        return ghDAO.queryGhmx(appointmentGhBody);
    }

    @Override
    public Ghbase queryGhbase(AppointmentGhBody appointmentGhBody) {
        return ghDAO.queryGhbase(appointmentGhBody);
    }

    @Override
    public List<DctSchedual> AGQueryDctSchedual(AbolishGhBody abolishGhBody) {
        return ghDAO.AGQueryDctSchedual(abolishGhBody);
    }

    @Override
    public void deleteByAG(AbolishGhBody abolishGhBody) {
        ghDAO.deleteByAG(abolishGhBody);
    }

    @Override
    public Ghmx queryGhmxByAG(AbolishGhBody abolishGhBody) {
        return ghDAO.queryGhmxByAG(abolishGhBody);
    }

    @Override
    public void insertGhmxByAG(Ghmx ghmx) {
        ghDAO.insertGhmxByAG(ghmx);
    }

    @Override
    public void updateGhmxByAG(Ghmx ghmx) {
        ghDAO.updateGhmxByAG(ghmx);
    }
}
