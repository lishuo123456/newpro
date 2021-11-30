package com.spring.utils;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 时间转化工具 date转为时间戳 时间戳转date 互相与String的转换
 * 所有出现的String time 格式都必须为(yyyy-MM-dd HH:mm:ss)，否则出错
 *
 * @author 杨首长
 */
@Slf4j
public class TimeUtil {

    /**
     * 获取 n天后的0点时间
     */
    public static Integer getNDayStartTime(Integer n) {
        //获得当天0点时间
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        long temp = cal.getTimeInMillis();
        // 时间戳转Date
        Timestamp ts = new Timestamp(temp);
        Date date = new Date();
        try {
            date = ts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //计算n天后的日期
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, n); //把日期往后n天,整数  往后推,负数往前移动
        date = calendar.getTime(); //这个时间就是日期往后推n天的结果
        // Date转10时间戳
        ts = new Timestamp(date.getTime());
        return (int) ((ts.getTime()) / 1000);
    }

    /*public static void main(String[] args) {
        Integer startTime = getNDayStartTime(1);
        Integer endTime = getNDayStartTime(2 + 1);
        System.out.println(startTime);
        System.out.println(endTime);
    }*/

    /**
     * 获取从某天0点的 n天后的0点时间
     */
    public static Integer getDateToNDayStartTime(Integer time, Integer n) {
        //获得某天0点时间
        long temp = (long) time * 1000;
        // 时间戳转Date
        Timestamp ts = new Timestamp(temp);
        Date date = new Date();
        try {
            date = ts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //计算n天后的日期
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, n); //把日期往后n天,整数  往后推,负数往前移动
        date = calendar.getTime(); //这个时间就是日期往后推n天的结果
        // Date转10时间戳
        ts = new Timestamp(date.getTime());
        return (int) ((ts.getTime()) / 1000);
    }

    /**
     * String(yyyy-MM-dd HH:mm:ss) 转 Date
     *
     * @param time
     * @return
     * @throws ParseException
     */
    public static Date StringToDate(String time, Integer type) throws ParseException {
        Date date = new Date();
        // 注意format的格式要与日期String的格式相匹配
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (type == 1) {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        if (type == 2) {
            dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        }
        try {
            date = dateFormat.parse(time);
            System.out.println(date.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * Date转为String(yyyy-MM-dd HH:mm:ss)
     *
     * @param time
     * @return
     */
    public static String DateToString(Date time, Integer hasHour) {
        String dateStr = "";
        DateFormat dateFormat;
        if (hasHour == 1) {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:ii:ss");
        } else {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        }
        try {
            dateStr = dateFormat.format(time);
            System.out.println(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateStr;
    }

    /**
     * String(yyyy-MM-dd HH:mm:ss)转10位时间戳
     *
     * @param time
     * @return
     */
    public static Integer StringToTimestamp(String time) {
        int times = 0;
        try {
            if (time.length() == 10) {
                time = time + " 00:00:00";
            }
            times = (int) ((Timestamp.valueOf(time).getTime()) / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (times == 0) {
            System.out.println("String转10位时间戳失败");
        }
        return times;
    }


    /*public static void main(String[] args) {
        System.out.println(StringToTimestamp("2020-01-01"));
    }*/

    //获得当天0点时间
    public static Integer getTodayStart() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (int) (cal.getTimeInMillis() / 1000);
    }

    //获得当天24点时间
    public static Integer getTodayEnd() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (int) (cal.getTimeInMillis() / 1000);
    }


    //获取某个日期的开始时间戳
    public static Long getDayStartTime(String dateStr) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        Date d = StringToDate(dateStr, 0);
        if (null != d) {
            calendar.setTime(d);
        }
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis() / 1000;
    }

    //获取某个日期的结束时间戳
    public static Long getDayEndTime(String dateStr) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        Date d = StringToDate(dateStr, 0);
        if (null != d) {
            calendar.setTime(d);
        }
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTimeInMillis() / 1000;
    }


    /**
     * 10位int型的时间戳转换为String(yyyy-MM-dd HH:mm:ss)
     *
     * @param time
     * @return
     */
    public static String timestampToString(Integer time, Integer type) {
        //int转long时，先进行转型再进行计算，否则会是计算结束后在转型
        long temp = (long) time * 1000;
        Timestamp ts = new Timestamp(temp);
        String tsStr = "";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (type != 0) {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        }
        try {
            //方法一
            tsStr = dateFormat.format(ts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tsStr;
    }

    /**
     * 10位时间戳转Date
     *
     * @param time
     * @return
     */
    public static Date TimestampToDate(Integer time) {
        long temp = (long) time * 1000;
        Timestamp ts = new Timestamp(temp);
        Date date = new Date();
        try {
            date = ts;
            //System.out.println(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * Date类型转换为10位时间戳
     *
     * @param time
     * @return
     */
    public static Integer DateToTimestamp(Date time) {
        Timestamp ts = new Timestamp(time.getTime());
        return (int) ((ts.getTime()) / 1000);
    }

    /**
     * 获取当前日期字符串
     */
    public static String getDateStr(Integer type) {
        SimpleDateFormat sdf;
        if (type == 0) {
            sdf = new SimpleDateFormat("yyyyMMdd");
        } else {
            sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        }
        return sdf.format(new Date());
    }

    /**
     * 获取系统时间戳（10位）
     *
     * @return
     */
    public static Integer getTimestamp() {
        long time = System.currentTimeMillis() / 1000;
        String timeStr = Long.toString(time);
        return Integer.parseInt(timeStr);
    }


    /**
     * 计算明天日期
     *
     * @param date
     * @return
     */
    public static Date nextDay(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1); //把日期往后增加一天,整数  往后推,负数往前移动
        date = calendar.getTime(); //这个时间就是日期往后推一天的结果
        return date;
    }

    /**
     * 判断是否是周六日
     *
     * @param date
     * @return
     */
    public static Boolean isWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 获取两个日期区间所有日期
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static List<String> getDateRangeData(Integer startTime, Integer endTime) {
        List<String> result = new ArrayList<>();
        for (; startTime <= endTime; ) {
            result.add(timestampToString(startTime, 1));
            startTime += 86400;
        }
        return result;
    }

    /**
     * 比较 时分 字符串时间和当前的 时分 时间大小
     *
     * @param reqDate 传入需要判断日期的开始时间
     * @param timeStr 字符串 时分(HH:mm) 时间
     * @return true传入参数大
     */
    public static boolean compareSize(String timeStr, Integer reqDate) {
        Integer todayStartTime = getTodayStart();
        if (!todayStartTime.equals(reqDate)) {
            return true;
        }
        Date date = new Date();
        SimpleDateFormat dateFormatReq = new SimpleDateFormat("yyyy-MM-dd");
        // yyyy-MM-dd HH:mm:ss
        String dateStrReq = dateFormatReq.format(date) + " " + timeStr + ":00";
        long dateReq = Timestamp.valueOf(dateStrReq).getTime();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateStr = dateFormat.format(date) + ":00";
        long time = Timestamp.valueOf(dateStr).getTime();

        return dateReq >= time;
    }


    /**
     * int hour -> string hour
     *
     * @param hour
     * @return
     */
    public static String intHourToStrHour(Integer hour) {
        String hourStr = String.valueOf(hour);
        if (hour < 10) {
            hourStr = "0" + hourStr;
        }
        return hourStr + ":00:00";
    }

    /*public static void main(String[] args) {
        if (compareSize("18:49")) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }*/
    public static String getAmRandomHour(){
        int max = 11;
        int min = 8;
        Random random = new Random();

        int s = random.nextInt(max)%(max-min+1) + min;
        String s1 = String.valueOf(s);
        String s2=s1;
        if(s1.length()==1){
            s2 = "0"+s1;
        }
        return s2;
    }
    public static String getPmRandomHour(){
        int max = 17;
        int min = 14;
        Random random = new Random();

        int s = random.nextInt(max)%(max-min+1) + min;
        String s1 = String.valueOf(s);
        String s2=s1;
        if(s1.length()==1){
            s2 = "0"+s1;
        }
        return s2;
    }
    public static String getMm(){
        int max = 59;
        int min = 0;
        Random random = new Random();

        int s = random.nextInt(max)%(max-min+1) + min;
        String s1 = String.valueOf(s);
        String s2=s1;
        if(s1.length()==1){
            s2 = "0"+s1;
        }
        return s2;
    }
}