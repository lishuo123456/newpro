package com.spring.dao;

import com.spring.entity.DctCode;
import com.spring.entity.KsCode;
import com.spring.entity.Medicine;
import com.spring.entity.WJ;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KsCodeDAO {
    //查询科室信息
    public List<KsCode> queryKsCode();

    public List<DctCode> queryDoctorByKs(String kscode);

    public List<Medicine> queryMedicine();

    public List<WJ> queryWJ(@Param("pagetop")String pagetop,@Param("pagesize") String pagesize, @Param("pageno")String pageno);
}
