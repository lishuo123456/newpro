package com.spring.service;

import com.spring.dao.KsCodeDAO;
import com.spring.entity.DctCode;
import com.spring.entity.KsCode;
import com.spring.entity.Medicine;
import com.spring.entity.WJ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class KsCodeServiceImpl implements KsCodeService{

    @Autowired
    private KsCodeDAO ksCodeDAO;
    @Override
    public List<KsCode> queryKsCode() {
        return ksCodeDAO.queryKsCode();
    }

    @Override
    public List<DctCode> queryDoctorByKs(String kscode) {
        return ksCodeDAO.queryDoctorByKs(kscode);
    }

    @Override
    public List<Medicine> queryMedicine() {
        return ksCodeDAO.queryMedicine();
    }

    @Override
    public List<WJ> queryWJ(String pagetop,String pagesize, String pageno) {
        return ksCodeDAO.queryWJ(pagetop,pagesize,pageno);
    }

}
