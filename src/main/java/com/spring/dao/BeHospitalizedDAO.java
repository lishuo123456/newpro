package com.spring.dao;

import com.spring.entity.Inbase;
import com.spring.result.CostDetailedBody;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BeHospitalizedDAO {

    public Inbase queryHospitalizedDetail(CostDetailedBody costDetailedBody);

    public Inbase queryHospitalizedDetailNorq(CostDetailedBody costDetailedBody);
}
