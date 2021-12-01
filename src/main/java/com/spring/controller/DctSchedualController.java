package com.spring.controller;

import com.spring.entity.DctCode;

import com.spring.entity.DctScheduals;
import com.spring.service.DctSchedualService;
import com.spring.utils.TimeUtil;
import com.spring.utils.VO;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class DctSchedualController {
    @Autowired
    private DctSchedualService dctSchedualService;

    @RequestMapping(value = "/Schedual")
    public String queryDoctorByKsSchedual(Model model){
        List<DctCode> dctSchedualsList = dctSchedualService.queryAllDoctor();

        model.addAttribute("dctSchedualsList", dctSchedualsList);
        return "bb";
    }


    @RequestMapping(value = "/YJPB")
    @ResponseBody
    public String YJPB() throws ParseException {
        List<DctCode> dlist = dctSchedualService.queryAllDoctor();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < dlist.size(); i++) {
            list.add(dlist.get(i).getDctcode());
        }
        for (int i = 0; i < list.size(); i++) {
            String dctcode = list.get(i);
            String s = dctSchedualService.queryMaxDate(dctcode);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String nextMonDate = "";
            String nextDay = "";
            if (null == s) {
                df = new SimpleDateFormat("yyyy-MM-dd");
                Calendar c = Calendar.getInstance();
                Date date = new Date();
                c.setTime(date);
                c.add(Calendar.MONTH, 1);
                nextMonDate = df.format(c.getTime());

                //获取明天的日期
                SimpleDateFormat smdate = new SimpleDateFormat("yyyy-MM-dd");
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(new Date());
                calendar.add(Calendar.DATE, 1);
                nextDay = smdate.format(calendar.getTime());
            } else {
                //获取id下最大日期+1天
                SimpleDateFormat smdate = new SimpleDateFormat("yyyy-MM-dd");
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(smdate.parse(s));
                calendar.add(Calendar.DATE, 1);
                nextDay = smdate.format(calendar.getTime());

                //id下最大日期+1天加一个月
                df = new SimpleDateFormat("yyyy-MM-dd");
                Calendar c = Calendar.getInstance();
                Date date = df.parse(nextDay);
                c.setTime(date);
                c.add(Calendar.MONTH, 1);
                nextMonDate = df.format(c.getTime());
            }


            //取明天到一月后的所有时间存在list中
            Integer integer = TimeUtil.StringToTimestamp(nextDay);
            Integer integer2 = TimeUtil.StringToTimestamp(nextMonDate);

            List<String> dateRangeData = TimeUtil.getDateRangeData(integer, integer2);
            List<DctCode> dctSchedualsList = dctSchedualService.queryAllDoctor();


            for (int j = 0; j < dateRangeData.size(); j++) {
                if (TimeUtil.isWeek(df.parse(dateRangeData.get(j)))) {
                    dateRangeData.remove(dateRangeData.get(j));
                    j -= 1;
                }
            }
            String am = "08:00:00-12:00:00";
            String pm = "14:00:00-18:00:00";
            for (int x = 0; x < dateRangeData.size(); x++) {
                DctScheduals ds = new DctScheduals();
                ds.setDctcode(dctcode);
                ds.setDate(dateRangeData.get(x));
                if (dctSchedualService.queryHaveInDctScheduals(ds).size() == 0) {
                    for (int y = 0; y < 10; y++) {
                        DctScheduals dd = new DctScheduals();
                        DctCode dctCode = dctSchedualService.queryOneDoctor(dctcode);
                        dd.setDate(dateRangeData.get(x));
                        dd.setDctcode(dctCode.getDctcode());
                        dd.setDctks(dctCode.getDctks());
                        dd.setDctname(dctCode.getDctname());
                        dd.setDctstatus("0");
                        dd.setId(UUID.randomUUID().toString());
                        dd.setStatus("0");
                        dd.setTime(am);
                        dctSchedualService.insertDctSchedual(dd);
                    }

                    for (int y = 0; y < 10; y++) {
                        DctScheduals dd = new DctScheduals();
                        DctCode dctCode = dctSchedualService.queryOneDoctor(dctcode);
                        dd.setDate(dateRangeData.get(x));
                        dd.setDctcode(dctCode.getDctcode());
                        dd.setDctks(dctCode.getDctks());
                        dd.setDctname(dctCode.getDctname());
                        dd.setDctstatus("0");
                        dd.setId(UUID.randomUUID().toString());
                        dd.setStatus("0");
                        dd.setTime(pm);
                        dctSchedualService.insertDctSchedual(dd);
                    }
                }
            }


        }
        return "";


}

    @RequestMapping(value = "/DCTPB",method = RequestMethod.GET)
    @ResponseBody
    public String DCTPB(String dctcode) throws ParseException {
        String s = dctSchedualService.queryMaxDate(dctcode);
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String nextMonDate = "";
        String nextDay = "";
        if(null==s){
            df=new SimpleDateFormat("yyyy-MM-dd");
            Calendar c=Calendar.getInstance();
            Date date=new Date();
            c.setTime(date);
            c.add(Calendar.MONTH,1);
            nextMonDate=df.format(c.getTime());

            //获取明天的日期
            SimpleDateFormat smdate = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, 1);
            nextDay = smdate.format(calendar.getTime());
        }else{
            //获取id下最大日期+1天
            SimpleDateFormat smdate = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(smdate.parse(s));
            calendar.add(Calendar.DATE, 1);
            nextDay = smdate.format(calendar.getTime());

            //id下最大日期+1天加一个月
            df=new SimpleDateFormat("yyyy-MM-dd");
            Calendar c=Calendar.getInstance();
            Date date=df.parse(nextDay);
            c.setTime(date);
            c.add(Calendar.MONTH,1);
            nextMonDate=df.format(c.getTime());
        }






        //取明天到一月后的所有时间存在list中
        Integer integer = TimeUtil.StringToTimestamp(nextDay);
        Integer integer2 = TimeUtil.StringToTimestamp(nextMonDate);

        List<String> dateRangeData = TimeUtil.getDateRangeData(integer, integer2);
        List<DctCode> dctSchedualsList = dctSchedualService.queryAllDoctor();


        for(int i = 0;i<dateRangeData.size();i++){
            if(TimeUtil.isWeek(df.parse(dateRangeData.get(i)))){
                dateRangeData.remove(dateRangeData.get(i));
                i-=1;
            }
        }
        String am = "08:00:00-12:00:00";
        String pm = "14:00:00-18:00:00";
        for(int i=0;i<dateRangeData.size();i++){
            DctScheduals ds = new DctScheduals();
            ds.setDctcode(dctcode);
            ds.setDate(dateRangeData.get(i));
            if(dctSchedualService.queryHaveInDctScheduals(ds).size()==0){
                for(int y = 0;y<10;y++){
                    DctScheduals dd = new DctScheduals();
                    DctCode dctCode = dctSchedualService.queryOneDoctor(dctcode);
                    dd.setDate(dateRangeData.get(i));
                    dd.setDctcode(dctCode.getDctcode());
                    dd.setDctks(dctCode.getDctks());
                    dd.setDctname(dctCode.getDctname());
                    dd.setDctstatus("0");
                    dd.setId(UUID.randomUUID().toString());
                    dd.setStatus("0");
                    dd.setTime(am);
                    dctSchedualService.insertDctSchedual(dd);
                }

                for(int y = 0;y<10;y++){
                    DctScheduals dd = new DctScheduals();
                    DctCode dctCode = dctSchedualService.queryOneDoctor(dctcode);
                    dd.setDate(dateRangeData.get(i));
                    dd.setDctcode(dctCode.getDctcode());
                    dd.setDctks(dctCode.getDctks());
                    dd.setDctname(dctCode.getDctname());
                    dd.setDctstatus("0");
                    dd.setId(UUID.randomUUID().toString());
                    dd.setStatus("0");
                    dd.setTime(pm);
                    dctSchedualService.insertDctSchedual(dd);
                }
            }
        }

        return "";
    }



    @RequestMapping(value = "/QXDCTPB",method = RequestMethod.GET)
    @ResponseBody
    public String QXDCTPB(String dctcode) throws ParseException {
        dctSchedualService.deleteDctSchedualsByDctCode(dctcode);
        return "";
    }

}
