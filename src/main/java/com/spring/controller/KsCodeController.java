package com.spring.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.spring.entity.*;
import com.spring.result.*;
import com.spring.service.KsCodeService;
import com.spring.utils.AESCipher;
import com.spring.utils.DataGet;
import com.spring.utils.DataSet;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class KsCodeController {

    @Autowired
    private KsCodeService ksCodeService;

    private String key = "5c564342841efs21";

    @RequestMapping(value = "/queryKsCode",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
        public Object queryKsCode(@RequestBody DataGet data) throws NoSuchAlgorithmException {
        String de = AESCipher.de(data.getData(), key);
        JSONObject jsonObject = JSON.parseObject(de);
        KsCodeBody kscd = jsonObject.toJavaObject(KsCodeBody.class);






        String salt = "77889910";
        String sign = kscd.getSign();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String sign1 = DigestUtils.md5Hex(kscd.getOrgCode() + kscd.getRequesttime() + salt);
        if(sign.equals(sign1)){
            List<KsCodeResult> list = new ArrayList<>();
            //查出科室数据后进行遍历，重新组装
            List<KsCode> ksCodes = ksCodeService.queryKsCode();
            for(int i = 0;i<ksCodes.size();i++){
                KsCodeResult kr = new KsCodeResult();
                KsCode ksCode = ksCodes.get(i);
                kr.setKsdm(ksCode.getMzkscode());
                kr.setKsmc(ksCode.getMzksname());
                kr.setPy(ksCode.getPy());
                kr.setKsjj(null);
                kr.setWb(null);
                list.add(kr);

            }
            Result result = new Result();
            result.setCode(1);
            result.setMessage("成功");
            result.setObject(list);
            JSONObject jsonResult = (JSONObject) JSONObject.toJSON(result);

            String datas = jsonResult.toJSONString();
            String en = AESCipher.en(datas, key);
            DataSet dataSet = new DataSet();
            dataSet.setObject(en);
            JSONObject jsonResults = (JSONObject) JSONObject.toJSON(dataSet);
            return jsonResults;
        }else{
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

    @RequestMapping(value = "/queryDoctorByKs",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object queryDoctorByKs(@RequestBody DataGet data) throws NoSuchAlgorithmException {
        String de = AESCipher.de(data.getData(), key);
        JSONObject jsonObject = JSON.parseObject(de);
        DoctorByKsBody doctorByKsBody = jsonObject.toJavaObject(DoctorByKsBody.class);




        String salt = "77889910";
        String sign = doctorByKsBody.getSign();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String sign1 = DigestUtils.md5Hex(doctorByKsBody.getOrgCode() + doctorByKsBody.getRequesttime() + salt);
        if(sign.equals(sign1)){
            String ksdm = doctorByKsBody.getKsdm();
            List<DoctorByKsResult> list = new ArrayList<>();
            //查出指定科室下医生数据后进行遍历，重新组装
            List<DctCode> dctCodes = ksCodeService.queryDoctorByKs(ksdm);
            if(!dctCodes.isEmpty()){
                for(int i = 0;i<dctCodes.size();i++){
                    DoctorByKsResult dr = new DoctorByKsResult();
                    DctCode dctCode = dctCodes.get(i);
                    dr.setYsdm(dctCode.getDctcode());
                    dr.setYsmc(dctCode.getDctname());
                    dr.setYsjs(null);
                    dr.setYszc(null);
                    dr.setZjbj(null);
                    list.add(dr);
                }
                Result result = new Result();
                result.setCode(1);
                result.setMessage("成功");
                result.setObject(list);
                JSONObject jsonResult = (JSONObject) JSONObject.toJSON(result);

                String datas = jsonResult.toJSONString();
                String en = AESCipher.en(datas, key);
                DataSet dataSet = new DataSet();
                dataSet.setObject(en);
                JSONObject jsonResults = (JSONObject) JSONObject.toJSON(dataSet);
                return jsonResults;
            }else{
                Result result = new Result();
                result.setCode(1);
                result.setMessage("成功");
                result.setObject(list);
                JSONObject jsonResult = (JSONObject) JSONObject.toJSON(result);

                String datas = jsonResult.toJSONString();
                String en = AESCipher.en(datas, key);
                DataSet dataSet = new DataSet();
                dataSet.setObject(en);
                JSONObject jsonResults = (JSONObject) JSONObject.toJSON(dataSet);
                return jsonResults;
            }

        }else{
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

    /*@RequestMapping(value = "/queryMedicine",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object queryMedicine(@RequestBody MedicineBody medicineBody) throws NoSuchAlgorithmException {
        System.out.println(medicineBody);
        String salt = "77889910";
        String sign = medicineBody.getSign();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String sign1 = DigestUtils.md5Hex(medicineBody.getOrgCode() + medicineBody.getRequesttime() + salt);
        if(sign.equals(sign1)){
            List<Medicine> medicines = ksCodeService.queryMedicine();
            List<MedicineResult> list = new ArrayList<>();
            if(!medicines.isEmpty()){
                for(int i = 0 ;i<medicines.size();i++){
                    MedicineResult mr = new MedicineResult();
                    Medicine medicine = medicines.get(i);
                    mr.setYpbm(medicine.getYpcode());
                    mr.setYpmc(medicine.getPm());
                    mr.setGg(medicine.getGg());
                    mr.setYpdj(medicine.getDj());
                    mr.setJldw(medicine.getDw());
                    mr.setJx(medicine.getJx());
                    list.add(mr);
                }
                Result result = new Result();
                result.setCode(1);
                result.setMessage("成功");
                result.setObject(list);
                return result;
            }else{
                Result result = new Result();
                result.setCode(1);
                result.setMessage("成功");
                result.setObject(list);
                return result;
            }

        }else{
            Result result = new Result();
            result.setCode(0);
            result.setMessage("验签失败");
            return result;
        }

    }


    @RequestMapping(value = "/queryWJ",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object queryWJ(@RequestBody WJBody wjBody){
        System.out.println(wjBody);
        String pagesize = wjBody.getPagesize();
        String pageno = wjBody.getPageno();
        List<WJ> wjs = ksCodeService.queryWJ(pagesize,pagesize,pageno);
        List<WJResult> list = new ArrayList<>();
        for(int i = 0;i<wjs.size();i++){
            WJResult wr = new WJResult();
            WJ wj = wjs.get(i);
            wr.setXmbm(wj.getYpcode());
            wr.setXmmc(wj.getPm());
            wr.setYbxmbm(wj.getYpcode());
            wr.setYbxmmc(wj.getPm());
            wr.setJldw(wj.getDw());
            wr.setDj(wj.getLbdj());
            list.add(wr);
        }
        Result result = new Result();
        result.setCode(1);
        result.setMessage("成功");
        result.setObject(list);


        return result;
    }*/




}
