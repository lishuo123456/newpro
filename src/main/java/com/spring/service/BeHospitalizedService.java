package com.spring.service;

import com.spring.entity.Inbase;
import com.spring.result.CostDetailedBody;

public interface BeHospitalizedService {

    public Inbase queryHospitalizedDetail(CostDetailedBody costDetailedBody);

    public Inbase queryHospitalizedDetailNorq(CostDetailedBody costDetailedBody);
}
