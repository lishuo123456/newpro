package com.spring.service;

import com.spring.dao.BeHospitalizedDAO;
import com.spring.entity.Inbase;
import com.spring.result.CostDetailedBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BeHospitalizedServiceImpl implements BeHospitalizedService{

    @Autowired
    private BeHospitalizedDAO beHospitalizedDAO;
    @Override
    public Inbase queryHospitalizedDetail(CostDetailedBody costDetailedBody) {
        return beHospitalizedDAO.queryHospitalizedDetail(costDetailedBody);
    }

    @Override
    public Inbase queryHospitalizedDetailNorq(CostDetailedBody costDetailedBody) {
        return beHospitalizedDAO.queryHospitalizedDetailNorq(costDetailedBody);
    }
}
