package com.spring.service;

import com.spring.entity.DctCode;
import com.spring.entity.DctScheduals;

import java.util.List;

public interface DctSchedualService {

    public List<DctCode> queryAllDoctor();

    public void insertDctSchedual(DctScheduals dctScheduals);

    public List<DctScheduals> queryHaveInDctScheduals(DctScheduals dctScheduals);

    public DctCode queryOneDoctor(String dctcode);

    public void deleteDctSchedualsByDctCode(String dctcode);

    public String  queryMaxDate(String  dctcode);
}
