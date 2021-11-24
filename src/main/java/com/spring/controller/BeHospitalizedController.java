package com.spring.controller;

import com.spring.entity.Inbase;
import com.spring.result.CostDetailedBody;
import com.spring.result.CostDetailedResult;
import com.spring.result.Result;
import com.spring.service.BeHospitalizedService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@RestController
public class BeHospitalizedController {
    @Autowired
    private BeHospitalizedService beHospitalizedService;

    @RequestMapping(value = "/CostDetailed",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object  CostDetailed(@RequestBody CostDetailedBody costDetailedBody) throws NoSuchAlgorithmException {
        System.out.println(costDetailedBody);

        String salt = "77889910";
        String sign = costDetailedBody.getSign();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String sign1 = DigestUtils.md5Hex(costDetailedBody.getOrgCode()+costDetailedBody.getRequesttime()+salt);
        if(sign.equals(sign1)){
            Inbase inbase =  new Inbase();
            if(!costDetailedBody.getKsrq().isEmpty() && !costDetailedBody.getJsrq().isEmpty()){
                System.out.println("1111111111");
                inbase = beHospitalizedService.queryHospitalizedDetail(costDetailedBody);
            }else{
                System.out.println("2222222222");
                inbase = beHospitalizedService.queryHospitalizedDetailNorq(costDetailedBody);
            }
            if(null!=inbase){
                CostDetailedResult costDetailedResult = new CostDetailedResult();
                costDetailedResult.setZyxh(inbase.getZyxh());
                costDetailedResult.setRyrq(inbase.getRyrq());
                costDetailedResult.setYjjlj(inbase.getYjjlj());
                costDetailedResult.setZje(inbase.getZje());
                costDetailedResult.setYsmc(inbase.getYsmc());

                Result result = new Result();
                result.setCode(1);
                result.setMessage("成功");
                result.setObject(costDetailedResult);
                return result;
            }else{
                CostDetailedResult costDetailedResult = new CostDetailedResult();
                Result result = new Result();
                result.setCode(1);
                result.setMessage("查无结果");
                result.setObject(costDetailedResult);
                return result;

            }

        }else{
            Result result = new Result();
            result.setCode(0);
            result.setMessage("验签失败");
            return result;
        }


    }

}
