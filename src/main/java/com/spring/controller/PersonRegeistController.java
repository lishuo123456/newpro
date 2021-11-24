package com.spring.controller;



import com.alibaba.fastjson.JSONObject;
import com.spring.entity.PersonRegeist;
import com.spring.result.PersonRegeistResult;
import com.spring.result.Result;
import com.spring.service.PersonRegeistService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@RestController
public class PersonRegeistController {
    @Autowired
    private PersonRegeistService personRegeistService;
    //患者建档同步
    @RequestMapping(value = "/PersonRegeist",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object Hello(@RequestBody PersonRegeist person) throws NoSuchAlgorithmException {
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
                return result;
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
            return result;
        } else {
            Result result = new Result();
            result.setCode(0);
            result.setMessage("验签失败");
            return result;

        }

    }
}
