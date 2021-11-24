package com.spring.service;

import com.spring.entity.DctCode;
import com.spring.entity.KsCode;
import com.spring.entity.Medicine;
import com.spring.entity.WJ;

import java.util.List;

public interface KsCodeService {

    //查询科室信息
    public List<KsCode> queryKsCode();

    public List<DctCode> queryDoctorByKs(String kscode);

    public List<Medicine> queryMedicine();

    public List<WJ> queryWJ(String pagetop,String pagesize,String pageno);
}
