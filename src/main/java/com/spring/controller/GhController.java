package com.spring.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.spring.entity.*;
import com.spring.result.*;
import com.spring.service.GhService;
import com.spring.utils.AESCipher;
import com.spring.utils.DataGet;
import com.spring.utils.DataSet;
import com.spring.utils.TimeUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class GhController {

    @Autowired
    private GhService ghService;

    private String key = "5c564342841efs21";



    @RequestMapping(value = "/queryDoctorByKsSchedual",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object queryDoctorByKsSchedual(@RequestBody DataGet data) throws ParseException, NoSuchAlgorithmException {
        String de = AESCipher.de(data.getData(), key);
        JSONObject jsonObject = JSON.parseObject(de);
        queryDoctorByKsSchedualBody queryDoctorByKsSchedualBody = jsonObject.toJavaObject(queryDoctorByKsSchedualBody.class);


        String salt = "77889910";
        String sign = queryDoctorByKsSchedualBody.getSign();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String sign1 = DigestUtils.md5Hex(queryDoctorByKsSchedualBody.getOrgCode() + queryDoctorByKsSchedualBody.getRequesttime() + salt);
        if(sign.equals(sign1)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String ghks = queryDoctorByKsSchedualBody.getKsdm();
            Integer integer = TimeUtil.StringToTimestamp(queryDoctorByKsSchedualBody.getStartTime());
            Integer integer2 = TimeUtil.StringToTimestamp(queryDoctorByKsSchedualBody.getEndTime());
            List<String> dateRangeData = TimeUtil.getDateRangeData(integer, integer2);
            List<DoctorGhCount> list = new ArrayList<>();
            List<List> lists = new ArrayList<>();
            List<queryDoctorByKsSchedualResult> resultList = new ArrayList<>();

            for(int i = 0;i<dateRangeData.size();i++){
                if(TimeUtil.isWeek(sdf.parse(dateRangeData.get(i)))){
                    System.out.println("__"+dateRangeData.get(i));
                    dateRangeData.remove(dateRangeData.get(i));
                }else{
                    System.out.println(")))))))))))))"+dateRangeData.get(i));
                }

            }
            System.out.println(dateRangeData);

            String status = "0";
            for(int i = 0; i< dateRangeData.size();i++){
                System.out.println(dateRangeData.get(i).substring(0,10));
                list = ghService.queryDoctorGHCount(ghks,dateRangeData.get(i).substring(0,10));
                for(int j = 0;j<list.size();j++){
                    if(null==list.get(j).getKghhyzs()){
                        list.get(j).setKghhyzs("20");
                    }
                    if(null==list.get(j).getGhtime()){
                        list.get(j).setGhtime(dateRangeData.get(i).substring(0,10));
                    }
                    int kghhyzs = Integer.valueOf(list.get(j).getKghhyzs()).intValue();

                    if(null==list.get(j).getRegTypeName()){
                        list.get(j).setRegTypeName(list.get(j).getYsmc());
                    }
                    if(kghhyzs>0){
                        status = "1";
                    }


                }
                String month = dateRangeData.get(i).substring(5,7);
                String day = dateRangeData.get(i).substring(8,10);
                Date date = sdf.parse(dateRangeData.get(i).substring(0,10));
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                int w = cal.get(Calendar.DAY_OF_WEEK)-1;
                String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
                String weekStr =weekDays[w];
                lists.add(list);
                queryDoctorByKsSchedualResult qResult = new queryDoctorByKsSchedualResult();
                qResult.setMonth(month);
                qResult.setDay(day);
                qResult.setDate(dateRangeData.get(i).substring(0,10));
                qResult.setWeekStr(weekStr);
                qResult.setStatus(status);
                qResult.setDoctorList(list);
                resultList.add(qResult);

            }








            Result result = new Result();
            result.setCode(1);
            result.setMessage("成功");
            result.setObject(resultList);
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


        /*List<queryDoctorByKsSchedualResult> resultList = new ArrayList<>();
        Map<String,List<DoctorGhCount>> map = list.stream().collect(Collectors.groupingBy(DoctorGhCount::getGhtime));
        Integer integer = TimeUtil.StringToTimestamp(queryDoctorByKsSchedualBody.getStartTime());
        Integer integer2 = TimeUtil.StringToTimestamp(queryDoctorByKsSchedualBody.getEndTime());
        List<String> dateRangeData = TimeUtil.getDateRangeData(integer, integer2);
        //List listt = new ArrayList();


        for (Map.Entry<String, List<DoctorGhCount>> entry : map.entrySet()) {

            int kghhyzs = 20 - entry.getValue().stream().mapToInt(DoctorGhCount::getHycount).sum();

            queryDoctorByKsSchedualResult qResult = new queryDoctorByKsSchedualResult("","","","","",null);
            qResult.setDate(entry.getKey());
            qResult.setMonth(month.toString());
            qResult.setDay(day);
            qResult.setWeekStr(weekStr);
            qResult.setStatus(kghhyzs > 0 ? "1" : "0");
            qResult.setDoctorList(kghhyzs > 0 ? entry.getValue() : null);
            resultList.add(qResult);
            System.out.println(dateRangeData.contains(entry.getKey()));
        }*/
    }

    @RequestMapping(value = "/queryDoctorGhDetail",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object queryDoctorGhDetail(@RequestBody DataGet data) throws ParseException, NoSuchAlgorithmException {
        String de = AESCipher.de(data.getData(), key);
        JSONObject jsonObject = JSON.parseObject(de);
        queryDoctorGhDetailBody queryDoctorGhDetailBody = jsonObject.toJavaObject(queryDoctorGhDetailBody.class);

        String salt = "77889910";
        String sign = queryDoctorGhDetailBody.getSign();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String sign1 = DigestUtils.md5Hex(queryDoctorGhDetailBody.getOrgCode() + queryDoctorGhDetailBody.getRequesttime() + salt);
        if(sign.equals(sign1)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String ghks = queryDoctorGhDetailBody.getKsdm();
            String dctcode = queryDoctorGhDetailBody.getYsdm();
            String amStartTime = "08:00:00";
            String amEndTime = "12:00:00";
            String pmStartTime = "14:00:00";
            String pmEndTime = "18:00:00";
            Integer integer = TimeUtil.StringToTimestamp(queryDoctorGhDetailBody.getStartTime());
            Integer integer2 = TimeUtil.StringToTimestamp(queryDoctorGhDetailBody.getEndTime());
            List<String> dateRangeData = TimeUtil.getDateRangeData(integer, integer2);
            List<queryDoctorGhDetailResult> resultList = new ArrayList<>();

            for(int i = 0;i<dateRangeData.size();i++){
                if(TimeUtil.isWeek(sdf.parse(dateRangeData.get(i)))){
                    dateRangeData.remove(dateRangeData.get(i));
                }

            }

            for(int i = 0;i <dateRangeData.size();i++){
                UUID uuid = UUID.randomUUID();
                String uuidA = String.valueOf(uuid);

                UUID uuid2 = UUID.randomUUID();
                String uuidP = String.valueOf(uuid2);


                List<QueryDoctorGhDetail> ams = new ArrayList<>();
                List<QueryDoctorGhDetail> pms = new ArrayList<>();
                QueryDoctorGhDetail queryDoctorGhDetailA = ghService.queryDoctorGhDetail(ghks, dctcode, dateRangeData.get(i).substring(0, 10), amStartTime, amEndTime);
                QueryDoctorGhDetail queryDoctorGhDetailP = ghService.queryDoctorGhDetail(ghks, dctcode, dateRangeData.get(i).substring(0, 10), pmStartTime, pmEndTime);
                if(null==queryDoctorGhDetailA.getSy()){
                    queryDoctorGhDetailA.setGhtime(dateRangeData.get(i).substring(0, 10));
                    queryDoctorGhDetailA.setSy("10");

                }
                queryDoctorGhDetailA.setTimeStart(amStartTime.substring(0,5));
                queryDoctorGhDetailA.setTimeEnd(amEndTime.substring(0,5));
                queryDoctorGhDetailA.setZjbz(queryDoctorGhDetailA.getYsmc());
                ams.add(queryDoctorGhDetailA);
                if(null==queryDoctorGhDetailP.getSy()){
                    queryDoctorGhDetailP.setGhtime(dateRangeData.get(i).substring(0, 10));
                    queryDoctorGhDetailP.setSy("10");
                }
                if(null==queryDoctorGhDetailA.getPbmxid()||queryDoctorGhDetailA.getPbmxid().isEmpty()){
                    String[] split = queryDoctorGhDetailA.getGhtime().split("-");
                    String time = split[0]+split[1]+split[2];
                    queryDoctorGhDetailA.setPbmxid(uuidA+"am1"+queryDoctorGhDetailA.getKsdm()+queryDoctorGhDetailA.getYsdm()+time);
                }

                if(null==queryDoctorGhDetailP.getPbmxid()||queryDoctorGhDetailP.getPbmxid().isEmpty()){
                    String[] split = queryDoctorGhDetailP.getGhtime().split("-");
                    String time = split[0]+split[1]+split[2];
                    queryDoctorGhDetailP.setPbmxid(uuidP+"pm1"+queryDoctorGhDetailP.getKsdm()+queryDoctorGhDetailP.getYsdm()+time);
                }

                queryDoctorGhDetailP.setTimeStart(pmStartTime.substring(0,5));
                queryDoctorGhDetailP.setTimeEnd(pmEndTime.substring(0,5));
                queryDoctorGhDetailP.setZjbz(queryDoctorGhDetailP.getYsmc());
                pms.add(queryDoctorGhDetailP);




                Date date = sdf.parse(dateRangeData.get(i).substring(0,10));
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                int w = cal.get(Calendar.DAY_OF_WEEK)-1;
                String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
                String weekStr =weekDays[w];

                queryDoctorGhDetailResult qr = new queryDoctorGhDetailResult();
                qr.setMonth(dateRangeData.get(i).substring(5,7));
                qr.setDay(dateRangeData.get(i).substring(8,10));
                qr.setWeeh(weekStr);
                qr.setDate(dateRangeData.get(i).substring(0,10));
                qr.setAm(Integer.valueOf(queryDoctorGhDetailA.getSy()));
                qr.setPm(Integer.valueOf(queryDoctorGhDetailP.getSy()));
                qr.setKsdm(queryDoctorGhDetailA.getKsdm());
                qr.setYsdm(queryDoctorGhDetailA.getYsdm());
                qr.setYsmc(queryDoctorGhDetailA.getYsmc());
                qr.setAppointmentType("1");
                qr.setAms(ams);
                qr.setPms(pms);
                resultList.add(qr);

            }
            //resultList.sort(Comparator.comparing(queryDoctorGhDetailResult::getDate ));
            Result result = new Result();
            result.setCode(1);
            result.setMessage("成功");
            result.setObject(resultList);
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

    @RequestMapping(value = "/appointmentGh",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object appointmentGh(@RequestBody DataGet data) throws ParseException, NoSuchAlgorithmException {
        String de = AESCipher.de(data.getData(), key);
        JSONObject jsonObject = JSON.parseObject(de);
        AppointmentGhBody appointmentGhBody = jsonObject.toJavaObject(AppointmentGhBody.class);

        String salt = "77889910";
        String sign = appointmentGhBody.getSign();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String sign1 = DigestUtils.md5Hex(appointmentGhBody.getOrgCode() + appointmentGhBody.getRequesttime() + salt);
        if(sign.equals(sign1)){
            PersonRegeist personRegeist = ghService.queryPersonRegeistById(appointmentGhBody.getPatid());
            if(null==personRegeist){
                Result result  = new Result();
                result.setCode(0);
                result.setMessage("查无此人");
                JSONObject jsonResult = (JSONObject) JSONObject.toJSON(result);

                String datas = jsonResult.toJSONString();
                String en = AESCipher.en(datas, key);
                DataSet dataSet = new DataSet();
                dataSet.setObject(en);
                JSONObject jsonResults = (JSONObject) JSONObject.toJSON(dataSet);
                return jsonResults;
            }else{
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                AppointmentGhResult ar = new AppointmentGhResult();
                String amStartTime = "08:00:00";
                String amEndTime = "12:00:00";
                String pmStartTime = "14:00:00";
                String pmEndTime = "18:00:00";
                if(appointmentGhBody.getYyhx().length()!=50){
                    Result result  = new Result();
                    result.setCode(0);
                    result.setMessage("您的信息有误,请重新预约");
                    JSONObject jsonResult = (JSONObject) JSONObject.toJSON(result);

                    String datas = jsonResult.toJSONString();
                    String en = AESCipher.en(datas, key);
                    DataSet dataSet = new DataSet();
                    dataSet.setObject(en);
                    JSONObject jsonResults = (JSONObject) JSONObject.toJSON(dataSet);
                    return jsonResults;
                }
                String ghks = appointmentGhBody.getYyhx().substring(39,40);
                String dctcode = appointmentGhBody.getYyhx().substring(40,42);
                String ghTime = "";
                String ampm = appointmentGhBody.getYyhx().substring(36,39);
                String date  =  appointmentGhBody.getYyhx().substring(42,50);
                if(null==ghks || null == dctcode || null == ampm || null == date){
                    Result result  = new Result();
                    result.setCode(0);
                    result.setMessage("您的信息有误,请重新预约");
                    JSONObject jsonResult = (JSONObject) JSONObject.toJSON(result);

                    String datas = jsonResult.toJSONString();
                    String en = AESCipher.en(datas, key);
                    DataSet dataSet = new DataSet();
                    dataSet.setObject(en);
                    JSONObject jsonResults = (JSONObject) JSONObject.toJSON(dataSet);
                    return jsonResults;
                }

                date = date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6,8);
                appointmentGhBody.setDate(date);
                appointmentGhBody.setKsdm(ghks);
                appointmentGhBody.setYsdm(dctcode);
                appointmentGhBody.setDctname(ghService.queryDctCodeById(dctcode).getDctname());
                appointmentGhBody.setZwname(personRegeist.getMemberName());
                appointmentGhBody.setIdcard(personRegeist.getIdcard());
                appointmentGhBody.setSex(personRegeist.getGender());
                String birth = personRegeist.getIdcard().substring(6, 14);
                String birthday = birth.substring(0,4)+"-"+birth.substring(4,6)+"-"+birth.substring(6,8);
                Date date1 = sdf.parse(birthday);
                appointmentGhBody.setBirthday(date1);
                Integer timestamp = TimeUtil.getTimestamp();
                String ghid = "Yy"+timestamp;
                appointmentGhBody.setGhid(ghid);
                String year = appointmentGhBody.getPayTime().substring(0,4);
                String mon = appointmentGhBody.getPayTime().substring(4,6);
                String day = appointmentGhBody.getPayTime().substring(6,8);
                String hour = appointmentGhBody.getPayTime().substring(8,10);
                String MM = appointmentGhBody.getPayTime().substring(10,12);
                String mm = appointmentGhBody.getPayTime().substring(12,14);
                String payTime = year+"-"+mon+"-"+day+" "+hour+":"+MM+":"+mm;
                Date date2 = TimeUtil.StringToDate(payTime, 1);
                appointmentGhBody.setZwdate(date2);


                int i = 0;
                if(ampm.equals("am1")){
                    appointmentGhBody.setTimeStart(amStartTime);
                    appointmentGhBody.setTimeEnd(amEndTime);
                    ghTime = TimeUtil.getAmRandomHour()+":"+ TimeUtil.getMm()+":00";
                    appointmentGhBody.setGhTime(ghTime);
                    i = ghService.queryDoctorGhSy(appointmentGhBody);
                    if(i==10){
                        Result result = new Result();
                        result.setCode(0);
                        result.setMessage("号源已满");
                        JSONObject jsonResult = (JSONObject) JSONObject.toJSON(result);

                        String datas = jsonResult.toJSONString();
                        String en = AESCipher.en(datas, key);
                        DataSet dataSet = new DataSet();
                        dataSet.setObject(en);
                        JSONObject jsonResults = (JSONObject) JSONObject.toJSON(dataSet);
                        return jsonResults;
                    }else{

                        List<DctSchedual> listdct = ghService.queryDctSchedual(appointmentGhBody);


                        if(listdct.size()>=1){
                            Result result  = new Result();
                            result.setCode(0);
                            result.setMessage("当天已存在预约信息,请不要重复预约");
                            JSONObject jsonResult = (JSONObject) JSONObject.toJSON(result);

                            String datas = jsonResult.toJSONString();
                            String en = AESCipher.en(datas, key);
                            DataSet dataSet = new DataSet();
                            dataSet.setObject(en);
                            JSONObject jsonResults = (JSONObject) JSONObject.toJSON(dataSet);
                            return jsonResults;
                        }
                        ghService.ghInDctSchedual(appointmentGhBody);
                        Ghbase ghbase = ghService.queryGhbase(appointmentGhBody);
                        if(null==ghbase){
                            ghService.ghInGhbase(appointmentGhBody);
                        }
                        String blid= null;
                        blid = ghService.queryBlid(appointmentGhBody);
                        System.out.println(blid);
                        appointmentGhBody.setBlid(blid);
                        ghService.ghInGhmx(appointmentGhBody);
                    }

                }else if(ampm.equals("pm1")){
                    appointmentGhBody.setTimeStart(pmStartTime);
                    appointmentGhBody.setTimeEnd(pmEndTime);
                    ghTime = TimeUtil.getPmRandomHour()+":"+ TimeUtil.getMm()+":00";
                    appointmentGhBody.setGhTime(ghTime);
                    i = ghService.queryDoctorGhSy(appointmentGhBody);
                    if(i==10){
                        Result result = new Result();
                        result.setCode(0);
                        result.setMessage("号源已满");
                        JSONObject jsonResult = (JSONObject) JSONObject.toJSON(result);

                        String datas = jsonResult.toJSONString();
                        String en = AESCipher.en(datas, key);
                        DataSet dataSet = new DataSet();
                        dataSet.setObject(en);
                        JSONObject jsonResults = (JSONObject) JSONObject.toJSON(dataSet);
                        return jsonResults;
                    }else{
                        List<DctSchedual> listdct = ghService.queryDctSchedual(appointmentGhBody);
                        if(listdct.size()>=1){
                            Result result  = new Result();
                            result.setCode(0);
                            result.setMessage("当天已存在预约信息,请不要重复预约");
                            JSONObject jsonResult = (JSONObject) JSONObject.toJSON(result);

                            String datas = jsonResult.toJSONString();
                            String en = AESCipher.en(datas, key);
                            DataSet dataSet = new DataSet();
                            dataSet.setObject(en);
                            JSONObject jsonResults = (JSONObject) JSONObject.toJSON(dataSet);
                            return jsonResults;
                        }
                        ghService.ghInDctSchedual(appointmentGhBody);
                        Ghbase ghbase = ghService.queryGhbase(appointmentGhBody);
                        if(null==ghbase){
                            ghService.ghInGhbase(appointmentGhBody);
                        }
                        String blid= null;
                        blid = ghService.queryBlid(appointmentGhBody);
                        System.out.println(blid);
                        appointmentGhBody.setBlid(blid);
                        ghService.ghInGhmx(appointmentGhBody);
                    }
                }

                ar.setReDoctorNo(String.valueOf(i+1));
                ar.setYyxh(appointmentGhBody.getYyhx());
                ar.setVisitPosition(ghService.queryKsCode(appointmentGhBody).getMzksname());
                ar.setFph(ghService.queryGhmx(appointmentGhBody).getGhid());
                ar.setRegReciptId(ghService.queryGhmx(appointmentGhBody).getGhid());




                Result result  = new Result();
                result.setCode(1);
                result.setMessage("预约挂号成功");
                result.setObject(ar);
                JSONObject jsonResult = (JSONObject) JSONObject.toJSON(result);

                String datas = jsonResult.toJSONString();
                String en = AESCipher.en(datas, key);
                DataSet dataSet = new DataSet();
                dataSet.setObject(en);
                JSONObject jsonResults = (JSONObject) JSONObject.toJSON(dataSet);

                return jsonResults;
            }
        }else{
            Result result  = new Result();
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

    @RequestMapping(value = "/AbolishGh",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object AbolishGh(@RequestBody DataGet data) throws ParseException, NoSuchAlgorithmException {
        String de = AESCipher.de(data.getData(), key);
        JSONObject jsonObject = JSON.parseObject(de);
        AbolishGhBody abolishGhBody = jsonObject.toJavaObject(AbolishGhBody.class);

        String salt = "77889910";
        String sign = abolishGhBody.getSign();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String sign1 = DigestUtils.md5Hex(abolishGhBody.getOrgCode() + abolishGhBody.getRequesttime() + salt);

        if(sign.equals(sign1)){
            SimpleDateFormat sbf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            PersonRegeist personRegeist = ghService.queryPersonRegeistById(abolishGhBody.getPatid());
            if(null == personRegeist){
                Result result  = new Result();
                result.setCode(0);
                result.setMessage("查无此人");
                JSONObject jsonResult = (JSONObject) JSONObject.toJSON(result);

                String datas = jsonResult.toJSONString();
                String en = AESCipher.en(datas, key);
                DataSet dataSet = new DataSet();
                dataSet.setObject(en);
                JSONObject jsonResults = (JSONObject) JSONObject.toJSON(dataSet);
                System.out.println(jsonResults);
                return jsonResults;
            }
            if(abolishGhBody.getYyhx().length()!=50){
                Result result  = new Result();
                result.setCode(0);
                result.setMessage("您的信息有误");
                JSONObject jsonResult = (JSONObject) JSONObject.toJSON(result);

                String datas = jsonResult.toJSONString();
                String en = AESCipher.en(datas, key);
                DataSet dataSet = new DataSet();
                dataSet.setObject(en);
                JSONObject jsonResults = (JSONObject) JSONObject.toJSON(dataSet);
                System.out.println(jsonResults);
                return jsonResults;
            }
            String ghks = abolishGhBody.getYyhx().substring(39,40);
            String dctcode = abolishGhBody.getYyhx().substring(40,42);
            String date  =  abolishGhBody.getYyhx().substring(42,50);
            date = date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6,8);
            abolishGhBody.setDate(date);
            abolishGhBody.setDctcode(dctcode);
            abolishGhBody.setDctks(ghks);
            List<DctSchedual> dctScheduals = ghService.AGQueryDctSchedual(abolishGhBody);
            if(dctScheduals.size()==0){
                Result result  = new Result();
                result.setCode(0);
                result.setMessage("查无预约信息");
                JSONObject jsonResult = (JSONObject) JSONObject.toJSON(result);

                String datas = jsonResult.toJSONString();
                String en = AESCipher.en(datas, key);
                DataSet dataSet = new DataSet();
                dataSet.setObject(en);
                JSONObject jsonResults = (JSONObject) JSONObject.toJSON(dataSet);
                System.out.println(jsonResults);

                return jsonResults;
            }else{
                ghService.deleteByAG(abolishGhBody);
                Ghmx ghmx = ghService.queryGhmxByAG(abolishGhBody);
                Date dateTime = new Date();
                String date1 = sbf.format(dateTime);
                Date date2 = TimeUtil.StringToDate(date1, 1);
                ghmx.setZfrq(date2);
                ghmx.setZfr("MT");
                ghService.updateGhmxByAG(ghmx);

                ghmx.setGhid("A"+ghmx.getGhid());
                ghmx.setSfmoney("-"+ghmx.getSfmoney());
                ghmx.setZwdate(date2);

                ghService.insertGhmxByAG(ghmx);

                AbolishGhResult ar = new AbolishGhResult();
                ar.setPatid(abolishGhBody.getPatid());
                Result result  = new Result();
                result.setCode(1);
                result.setMessage("成功");
                result.setObject(ar);
                JSONObject jsonResult = (JSONObject) JSONObject.toJSON(result);

                String datas = jsonResult.toJSONString();
                String en = AESCipher.en(datas, key);
                DataSet dataSet = new DataSet();
                dataSet.setObject(en);
                JSONObject jsonResults = (JSONObject) JSONObject.toJSON(dataSet);
                System.out.println(jsonResults);
                return jsonResults;
            }




        }else{
            Result result  = new Result();
            result.setCode(0);
            result.setMessage("验签失败");
            JSONObject jsonResult = (JSONObject) JSONObject.toJSON(result);

            String datas = jsonResult.toJSONString();
            String en = AESCipher.en(datas, key);
            DataSet dataSet = new DataSet();
            dataSet.setObject(en);
            JSONObject jsonResults = (JSONObject) JSONObject.toJSON(dataSet);
            System.out.println(jsonResults);
            return jsonResults;
        }


    }

}
