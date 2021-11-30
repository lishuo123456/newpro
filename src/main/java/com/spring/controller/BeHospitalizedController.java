package com.spring.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.spring.entity.Inbase;
import com.spring.result.CostDetailedBody;
import com.spring.result.CostDetailedResult;
import com.spring.result.KsCodeBody;
import com.spring.result.Result;
import com.spring.service.BeHospitalizedService;
import com.spring.utils.AESCipher;
import com.spring.utils.DataGet;
import com.spring.utils.DataSet;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;


@RestController
public class BeHospitalizedController {
    @Autowired
    private BeHospitalizedService beHospitalizedService;

    private String key = "5c564342841efs21";

    @RequestMapping(value = "/CostDetailed", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object CostDetailed(@RequestBody DataGet data) throws NoSuchAlgorithmException {
        String de = AESCipher.de(data.getData(), key);
        JSONObject jsonObject = JSON.parseObject(de);
        CostDetailedBody costDetailedBody = jsonObject.toJavaObject(CostDetailedBody.class);




        System.out.println(costDetailedBody);
        String salt = "77889910";
        String sign = costDetailedBody.getSign();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String sign1 = DigestUtils.md5Hex(costDetailedBody.getOrgCode() + costDetailedBody.getRequesttime() + salt);
        if (sign.equals(sign1)) {
            Inbase inbase = new Inbase();
            if (!costDetailedBody.getKsrq().isEmpty() && !costDetailedBody.getJsrq().isEmpty()) {
                inbase = beHospitalizedService.queryHospitalizedDetail(costDetailedBody);
            } else {
                inbase = beHospitalizedService.queryHospitalizedDetailNorq(costDetailedBody);
            }
            if (null != inbase) {
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
                JSONObject jsonResult = (JSONObject) JSONObject.toJSON(result);

                String datas = jsonResult.toJSONString();
                String en = AESCipher.en(datas, key);
                DataSet dataSet = new DataSet();
                dataSet.setObject(en);
                JSONObject jsonResults = (JSONObject) JSONObject.toJSON(dataSet);
                return jsonResults;
            } else {
                CostDetailedResult costDetailedResult = new CostDetailedResult();
                Result result = new Result();
                result.setCode(1);
                result.setMessage("查无结果");
                result.setObject(costDetailedResult);
                JSONObject jsonResult = (JSONObject) JSONObject.toJSON(result);

                String datas = jsonResult.toJSONString();
                String en = AESCipher.en(datas, key);
                DataSet dataSet = new DataSet();
                dataSet.setObject(en);
                JSONObject jsonResults = (JSONObject) JSONObject.toJSON(dataSet);
                return jsonResults;

            }

        } else {
            Result result = new Result();
            result.setCode(0);
            result.setMessage("验签失败");
            JSONObject jsonResult = (JSONObject) JSONObject.toJSON(result);

            String datas = jsonResult.toJSONString();
            String en = AESCipher.en(datas, key);
            DataSet dataSet = new DataSet();
            dataSet.setObject(en);
            JSONObject jsonResults = (JSONObject) JSONObject.toJSON(dataSet);
            return jsonResults;
        }


    }

}
