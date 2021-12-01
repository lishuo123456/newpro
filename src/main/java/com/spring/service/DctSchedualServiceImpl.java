package com.spring.service;

import com.spring.dao.DctSchedualDAO;
import com.spring.entity.DctCode;
import com.spring.entity.DctScheduals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DctSchedualServiceImpl implements DctSchedualService{

    @Autowired
    private DctSchedualDAO dctSchedualDAO;

    @Override
    public List<DctCode> queryAllDoctor() {
        return dctSchedualDAO.queryAllDoctor();
    }

    @Override
    public void insertDctSchedual(DctScheduals dctScheduals) {
        dctSchedualDAO.insertDctSchedual(dctScheduals);
    }

    @Override
    public List<DctScheduals> queryHaveInDctScheduals(DctScheduals dctScheduals) {
        return dctSchedualDAO.queryHaveInDctScheduals(dctScheduals);
    }

    @Override
    public DctCode queryOneDoctor(String dctcode) {
        return dctSchedualDAO.queryOneDoctor(dctcode);
    }

    @Override
    public void deleteDctSchedualsByDctCode(String dctcode) {
        dctSchedualDAO.deleteDctSchedualsByDctCode(dctcode);
    }

    @Override
    public String  queryMaxDate(String  dctcode) {
        return dctSchedualDAO.queryMaxDate(dctcode);
    }
}
