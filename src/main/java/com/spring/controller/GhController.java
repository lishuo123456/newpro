package com.spring.controller;

import com.spring.entity.DoctorByKsSchedual;
import com.spring.entity.DoctorGhDetail;
import com.spring.result.*;
import com.spring.service.GhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class GhController {

    @Autowired
    private GhService ghService;

    @RequestMapping(value = "/queryDoctorByKsSchedual",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object queryDoctorByKsSchedual(@RequestBody queryDoctorByKsSchedualBody queryDoctorByKsSchedualBody){
        System.out.println(queryDoctorByKsSchedualBody);
        List<DoctorByKsSchedual> doctorByKsScheduals = ghService.queryDoctorByKsSchedual(queryDoctorByKsSchedualBody.getKsdm());
        List<DoctorByKsSchedualListBody> list = new ArrayList<>();
        for(int i = 0;i<doctorByKsScheduals.size();i++){
            DoctorByKsSchedualListBody db =  new DoctorByKsSchedualListBody();
            DoctorByKsSchedual doctorByKsSchedual = doctorByKsScheduals.get(i);
            db.setYsdm(doctorByKsSchedual.getDctcode());
            db.setYsmc(doctorByKsSchedual.getDctname());
            db.setPbmxid("1");
            db.setKghhyzs("10");
            list.add(db);
        }
        SimpleDateFormat dateformat = new SimpleDateFormat(
                "yyyy-MM-dd");

        System.out.println(dateformat.format(new Date()));
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(cal.MONTH)+1);
        System.out.println(cal.get(cal.DATE));
        System.out.println("周"+(cal.get(cal.DAY_OF_WEEK)-1));
        String Day = ""+(cal.get(cal.DATE));
        String Month = ""+(cal.get(cal.MONTH)+1);
        String Week = ""+(cal.get(cal.DAY_OF_WEEK)-1);

        queryDoctorByKsSchedualResult qr = new queryDoctorByKsSchedualResult();
        qr.setDate(dateformat.format(new Date()));
        qr.setDay(Day);
        qr.setMonth(Month);
        qr.setWeekStr(Week);
        qr.setStatus("1");


        ResultInDoctorByKs result = new ResultInDoctorByKs();
        result.setCode(1);
        result.setMessage("成功");
        result.setObject(qr);
        result.setObject2(list);
        return result;
    }

    @RequestMapping(value = "/queryDoctorGhDetail",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object queryDoctorGhDetail(@RequestBody queryDoctorGhDetailBody queryDoctorGhDetailBody){
        System.out.println(queryDoctorGhDetailBody);
        List<DoctorGhDetail> doctorGhDetails = ghService.DoctorGhDetail(queryDoctorGhDetailBody.getYsdm(),queryDoctorGhDetailBody.getKsdm());


        queryDoctorGhDetailResult queryDoctorGhDetailResult = new queryDoctorGhDetailResult();
        Result result = new Result();



        return doctorGhDetails;
    }

    @RequestMapping(value = "/appointmentGh",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object appointmentGh(@RequestBody AppointmentGhBody appointmentGhBody){
        System.out.println(appointmentGhBody);

        ghService.ghInGhbase(appointmentGhBody);
        ghService.ghInGhmx(appointmentGhBody);

        AppointmentGhResult ar = new AppointmentGhResult();
        ar.setYyxh("1");
        ar.setYsfwf(appointmentGhBody.getSubFee());
        ar.setYsje(appointmentGhBody.getSubFee());
        ar.setZje(appointmentGhBody.getSubFee());
        ar.setNextStepAddr("1");
        ar.setReDoctorNo("1");
        ar.setVisitPosition("1");
        ar.setFph("1");
        ar.setFpurl("1");
        ar.setBz("1");

        Result result = new Result();
        result.setCode(1);
        result.setMessage("成功");
        result.setObject(ar);








        return result;
    }

    @RequestMapping(value = "/AbolishGh",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object AbolishGh(@RequestBody AbolishGhBody abolishGhBody){
        System.out.println(abolishGhBody);

        return "";
    }

    @RequestMapping(value = "/LockGh",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object LockGh(){

        return null;
    }
}
