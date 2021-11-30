package com.spring.controller;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.spring.entity.PersonRegeist;
import com.spring.result.AbolishGhBody;
import com.spring.result.PersonRegeistResult;
import com.spring.result.Result;
import com.spring.service.PersonRegeistService;
import com.spring.utils.AESCipher;
import com.spring.utils.DataGet;
import com.spring.utils.DataSet;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@RestController
public class PersonRegeistController {
    @Autowired
    private PersonRegeistService personRegeistService;

    private String key = "5c564342841efs21";
    //患者建档同步
    @RequestMapping(value = "/PersonRegeist",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object Hello(@RequestBody DataGet data) throws NoSuchAlgorithmException {
        String de = AESCipher.de(data.getData(), key);
        JSONObject jsonObject = JSON.parseObject(de);
        PersonRegeist person = jsonObject.toJavaObject(PersonRegeist.class);


        String salt = "77889910";
        String sign = person.getSign();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String sign1 = DigestUtils.md5Hex(person.getOrgCode() + person.getRequesttime() + salt);
        if (sign.equals(sign1)) {

            //通过身份证号验证数据库是否存在该用户
            PersonRegeist personRegeistres = personRegeistService.queryPersonRegeist(person.getIdcard());
            System.out.println(personRegeistres);
            if (null != personRegeistres) {
                Result result = new Result();
                result.setCode(1);
                result.setMessage("成功");

                PersonRegeistResult personRegeistResult = new PersonRegeistResult();
                personRegeistResult.setPatid(personRegeistres.getPatid());
                personRegeistResult.setCardno(personRegeistres.getMedicalCard());
                personRegeistResult.setCardtype(personRegeistres.getMedicalCardType());
                personRegeistResult.setHzxm(personRegeistres.getMemberName());
                personRegeistResult.setGender(personRegeistres.getGender());
                personRegeistResult.setSfzh(personRegeistres.getIdcard());
                personRegeistResult.setLxdz(personRegeistres.getIdcardAddress());
                personRegeistResult.setBlh(null);
                personRegeistResult.setBirth(personRegeistres.getBirth());
                result.setObject(personRegeistResult);
                JSONObject jsonResult = (JSONObject) JSONObject.toJSON(result);

                String datas = jsonResult.toJSONString();
                String en = AESCipher.en(datas, key);
                DataSet dataSet = new DataSet();
                dataSet.setObject(en);
                JSONObject jsonResults = (JSONObject) JSONObject.toJSON(dataSet);
                return jsonResults;
            }
            //对数据进行数据库添加操作（PersonRegeist）
            personRegeistService.insertPersonRegeist(person);
            //通过身份证查询
            PersonRegeist personRegeistre = personRegeistService.queryPersonRegeist(person.getIdcard());
            PersonRegeistResult personRegeistResult = new PersonRegeistResult();
            personRegeistResult.setPatid(personRegeistre.getPatid());
            personRegeistResult.setCardno(personRegeistre.getMedicalCard());
            personRegeistResult.setCardtype(personRegeistre.getMedicalCardType());
            personRegeistResult.setHzxm(personRegeistre.getMemberName());
            personRegeistResult.setGender(personRegeistre.getGender());
            personRegeistResult.setSfzh(personRegeistre.getIdcard());
            personRegeistResult.setLxdz(personRegeistre.getIdcardAddress());
            personRegeistResult.setBlh(null);
            personRegeistResult.setBirth(personRegeistre.getBirth());

            Result result = new Result();
            result.setCode(1);
            result.setMessage("成功");
            result.setObject(personRegeistResult);
            JSONObject jsonResult = (JSONObject) JSONObject.toJSON(result);

            String datas = jsonResult.toJSONString();
            String en = AESCipher.en(datas, key);
            DataSet dataSet = new DataSet();
            dataSet.setObject(en);
            JSONObject jsonResults = (JSONObject) JSONObject.toJSON(dataSet);
            return jsonResults;
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
