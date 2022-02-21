package com.wpf.common_base.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateUtil {
    public static String formatDate(long date, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format, Locale.getDefault());
        return dateFormat.format(new Date(date));
    }

    public static String formatDate(Date date, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format, Locale.getDefault());
        return dateFormat.format(date);
    }

    /*** 日期long格式化为yyyy/MM/dd HH:mm:ss ***/
    public static String formatDate(long date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date(date));
    }

    /*** 日期long格式化为yyyy/MM/dd HH:mm:ss ***/
    public static String formatDateYYMMDDHHMM(long date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return dateFormat.format(new Date(date));
    }
    /*** 日期long格式化为yyyy/MM/dd HH:mm:ss ***/
    public static String formatDateYYMMDD(long date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date(date));
    }
    /*** 日期long格式化为yyyy/MM/dd HH:mm:ss ***/
    public static String formatDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }

    /*** 日期long格式化为HH ***/
    public static String formatDate1(long date) {
        DateFormat dateFormat = new SimpleDateFormat("MM月dd日");
        return dateFormat.format(new Date(date));
    }

    /*** 日期long格式化为yyyy/MM/dd HH:mm ***/
    public static String formatDate3(long date) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        return dateFormat.format(new Date(date));
    }

    /**
     * 将毫秒转时分秒
     *
     * @param time
     * @return
     */
    public static String generateTime(long time) {
        int totalSeconds = (int) (time / 1000);
        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours = totalSeconds / 3600;

        return hours > 0 ? String.format("%02d:%02d:%02d", hours, minutes, seconds) : String.format("%02d:%02d", minutes, seconds);
    }

    /*** 日期long格式化为yyyy/MM/dd HH:mm ***/
    public static String formatDate3(String date) {
        long l = Long.parseLong(date);
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        return dateFormat.format(new Date(l));
    }

    /*** 日期long格式化为yyyy/MM/dd HH:mm ***/
    public static String formatDate4(String date) {
        try {
            long l = Long.parseLong(date);
            DateFormat dateFormat = new SimpleDateFormat("MM月dd日");
            return dateFormat.format(new Date(l));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "";
        }
    }

    /*** 日期long格式化为yyyy/MM/dd HH:mm ***/
    public static int formatHour(long date) {
        Date date1 = new Date(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour;
    }

    public static String getChinaYMD(long date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        return dateFormat.format(new Date(date));
    }

    /*** 日期long格式化为yyyy/MM/dd HH:mm ***/
    public static String getDate(long date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date(date));
    }

    /*** 日期date格式化为yyyy-MM-dd ***/
    public static String getDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    /*** 日期date格式化为yyyy-MM-dd ***/
    public static String getTime(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        return dateFormat.format(date);
    }

    /*** 日期long格式化为yyyy/MM/dd HH:mm ***/
    public static String getDaydd(long date) {
        DateFormat dateFormat = new SimpleDateFormat("dd");
        return dateFormat.format(new Date(date));
    }

    /*** 日期long格式化为yyyy-MM-dd ***/
    public static String getDateYYMMDD(long date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date(date));
    }

    /*** 日期long格式化为yyyy/MM/dd HH:mm ***/
    public static String getDateYYMMDDPoint(String date) {
        try {
            long l = Long.parseLong(date);
            DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
            return dateFormat.format(new Date(l));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "";
        }
    }

    /*** 日期yyyy-MM-dd HH:mm:ss--->DATE类型 ***/
    public static Date getDate(String dateStr) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /*** 日期yyyy-MM-dd HH:mm:ss--->DATE类型 ***/
    public static Date getDateYYMMDD_(String dateStr) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @param dateStr yyyy-mm-dd
     * @param day     加上的天数
     * @return
     */
    public static String getAddDayDateString(String dateStr, int day) {
        Date dateYYMMDD_ = getDateYYMMDD_(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateYYMMDD_);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + day);
        Date date2 = calendar.getTime();
        return getDate(date2);
    }

    /*** 日期long格式化为yyyy/MM/dd HH:mm ***/
    public static String getDateHHmm(String dateStr) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(dateStr);
            return dateToString(date, "MM月dd日");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /*** 日期yyyy-MM-dd格式化为时间戳字符串 ***/
    public static long getDateLong(String dateStr) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(dateStr);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /*** 日期yyyy.MM.dd -> yyyy-MM-dd ***/
    public static String getDateyyyyMMdd(String dateStr) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        try {
            date = sdf.parse(dateStr);
            return dateToString(date, "yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /*** 日期yyyy-MM-dd -> yyyy年MM月dd日 ***/
    public static String getDateyyyy_MM_ddToyyyy(String dateStr) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(dateStr);
            return dateToString(date, "yyyy年MM月dd日");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /*** 日期yyyy-MM-dd -> MM/dd/yyyy年 ***/
    public static String getDateyyyy_MM_dd(String dateStr) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(dateStr);
            return dateToString(date, "dd/MM/yyyy");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /*** 日期yyyy-MM-dd -> yyyy年MM月dd日 ***/
    public static String getDateyyyyMMddToMMdd(String dateStr, String formatStr) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        try {
            date = sdf.parse(dateStr);
            return dateToString(date, formatStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /*** 日期 yyyy年MM月dd日 -->> ***/
    public static String getDateyyyyMMToMMdd(String dateStr, String formatStr) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
        try {
            date = sdf.parse(dateStr);
            return dateToString(date, formatStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * @param dateStr
     * @return
     */
    public static String getDateyyyyMMToyyyy(String dateStr) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        try {
            date = sdf.parse(dateStr);
            return dateToString(date, "yyyy年MM月");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /*** 日期long格式化为yyyy/MM/dd HH:mm ***/
    public static String getDateyyyyHHmm(String cacheMonth, String dateStr) {
        String resultDate = "";
        try {
            Date date = new Date();
            date.setTime(Long.parseLong(dateStr));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            if (!TextUtils.isEmpty(cacheMonth)) {
                Date lastDate = new Date();
                lastDate.setTime(Long.parseLong(cacheMonth));
                Calendar lastCalendar = Calendar.getInstance();
                lastCalendar.setTime(lastDate);
                if (calendar.get(Calendar.MONTH) == lastCalendar.get(Calendar.MONTH)) {
                    resultDate = new SimpleDateFormat("dd").format(date);
                } else {
                    resultDate = new SimpleDateFormat("MM/dd").format(date);
                }
            } else {
                resultDate = new SimpleDateFormat("MM/dd").format(date);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return resultDate;
    }

    public static String getWeek(long date, String... strArray) {
        Date date1 = new Date(date);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date1);
        return getWeek(instance, strArray);
    }

    /*获取星期几*/
    public static String getWeek(Calendar calendar, String... strArray) {
        if (calendar == null) {
            calendar = Calendar.getInstance();
        }
        String str = "";
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        if (strArray != null && strArray.length > 0) {
            str = strArray[0];
        } else {
            str = "周";
        }
        switch (i) {
            case 1:
                return str + "日";
            case 2:
                return str + "一";
            case 3:
                return str + "二";
            case 4:
                return str + "三";
            case 5:
                return str + "四";
            case 6:
                return str + "五";
            case 7:
                return str + "六";
            default:
                return "";
        }
    }

    /*获取星期几*/
    public static String getWeek(int week) {
        String str = "每周";
        switch (week) {
            case 1:
                return str + "一";
            case 2:
                return str + "二";
            case 3:
                return str + "三";
            case 4:
                return str + "四";
            case 5:
                return str + "五";
            case 6:
                return str + "日";
            case 7:
                return str + "六";
            default:
                return str;
        }
    }

    /*获取星期几*/
    public static String getMonth(int month) {
        String str = "每月";
        switch (month) {
            case 32:
                return str + "最后一日";
            default:
                return str + month + "号";
        }
    }

    /**
     * 获取现在时间
     *
     * @return 返回短时间字符串格式yyyy-MM-dd
     */
    public static String getDateLine() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static String getDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日");
        String dateString = formatter.format(currentTime);
        String week = getWeek(null);
        String showDate = dateString + " " + week;
        return showDate;
    }

    public static String getDate_() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM月dd");
        String dateString = formatter.format(currentTime);
        String week = getWeek(null);
        String showDate = week + "," + dateString;
        return showDate;
    }

    /**
     * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     *
     * @return
     */
    public static String getCurrentHHmmss() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        String[] strings = dateString.split(" ");
        return strings[1];
    }

    /**
     * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     *
     * @return
     */
    public static String getCurrentDay() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        String dateString = formatter.format(currentTime);
        return dateString;

    }

    public static String getCurrentMonth() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static String getCurrentMonthYYMM(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * 获取指定日期的上一个月
     *
     * @param date
     * @return
     */
    public static String getLastMonthYYMM(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
        String dateString = formatter.format(calendar.getTime());
        return dateString;
    }

    /**
     * 获取指定日期的下一个月
     *
     * @param date
     * @return
     */
    public static String getNextMonthYYMM(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, +1);
        SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
        String dateString = formatter.format(calendar.getTime());
        return dateString;
    }


    /**
     * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     *
     * @return
     */
    public static String getCurrentYYMMDDHHmm() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateString = formatter.format(currentTime);
//        String[] strings = dateString.split(" ");
        return dateString;
    }

    /**
     * 获取当前的时间
     *
     * @return
     */
    public static String getCurrentYYMMDD() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
//        String[] strings = dateString.split(" ");
        return dateString;
    }

    public static String convertDate(int dateInt, String dateString, int dateType) {
        String date = "";
        switch (dateType) {
            case 0:
                date = dateString.substring(5, 10);
                date = date.substring(0, 2) + "/" + date.substring(3, 5);

                break;
            case 1:
                date = dateInt + "周";
                break;
            case 2:
                date = dateInt + "月";
                break;
            case 3:
                date = dateInt + "年";
                break;
        }
        return date;
    }

    /*** 日期Long转换为yyyy-MM-dd HH:mm:ss***/
    public static String stampToDate(String s) {
        if (s == null || s.equals(""))
            return "No date";
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //yyyy-MM-dd HH:mm:ss
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    public static String getYear(long date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        return dateFormat.format(new Date(date));
    }

    public static String getMonth(long date) {
        DateFormat dateFormat = new SimpleDateFormat("MM");
        return dateFormat.format(new Date(date));
    }

    public static String getDay(long date) {
        DateFormat dateFormat = new SimpleDateFormat("dd");
        return dateFormat.format(new Date(date));
    }

    public static String getHour(long date) {
        DateFormat dateFormat = new SimpleDateFormat("HH");
        return dateFormat.format(new Date(date));
    }

    public static String getMinute(long date) {
        DateFormat dateFormat = new SimpleDateFormat("mm");
        return dateFormat.format(new Date(date));
    }

    public static String getMonthAndYear() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        return String.format("%s %d", getMonthEN(month), year);
    }

    public static String getMonthEN(int month) {
        switch (month) {
            case 0:
                return "January";
            case 1:
                return "February";
            case 2:
                return "March";
            case 3:
                return "April";
            case 4:
                return "May";
            case 5:
                return "June";
            case 6:
                return "July";
            case 7:
                return "August";
            case 8:
                return "September";
            case 9:
                return "October";
            case 10:
                return "November";
            case 11:
                return "December";
            default:
                return "";
        }
    }

    public static String getMonthZH(int month) {
        switch (month) {
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "七";
            case 8:
                return "八";
            case 9:
                return "九";
            case 10:
                return "十";
            case 11:
                return "十一";
            case 12:
                return "十二";
            default:
                return "";
        }
    }

    public static String getSecond(long date) {
        DateFormat dateFormat = new SimpleDateFormat("ss");
        return dateFormat.format(new Date(date));
    }

    // date类型转换为String类型
    // formatType格式为yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
    // data Date类型的时间
    public static String dateToString(Date data, String formatType) {
        return new SimpleDateFormat(formatType).format(data);
    }


    // long类型转换为String类型
    // currentTime要转换的long类型的时间
    // formatType要转换的string类型的时间格式
    public static String longToString(long currentTime, String formatType)
            throws ParseException {
        Date date = longToDate(currentTime, formatType); // long类型转成Date类型
        String strTime = dateToString(date, formatType); // date类型转成String
        return strTime;
    }

    // string类型转换为date类型
    // strTime要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日
    // HH时mm分ss秒，
    // strTime的时间格式必须要与formatType的时间格式相同
    public static Date stringToDate(String strTime, String formatType)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }

    // long转换为Date类型
    // currentTime要转换的long类型的时间
    // formatType要转换的时间格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
    public static Date longToDate(long currentTime, String formatType)
            throws ParseException {
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
        String sDateTime = dateToString(dateOld, formatType); // 把date类型的时间转换为string
        Date date = stringToDate(sDateTime, formatType); // 把String类型转换为Date类型
        return date;
    }

    public static long stringToLong(String strTime, String formatType) throws ParseException {
        Date date = stringToDate(strTime, formatType);
        if (date == null) {
            return 0;
        } else {
            long currentTime = dateToLong(date);
            return currentTime;
        }
    }

    // date类型转换为long类型
    // date要转换的date类型的时间
    public static long dateToLong(Date date) {
        return date.getTime();
    }


    public static String getDateStr(long date) {
        return formatDate(date);
    }

    public static String getTimeStr(long date) {
        return getHour(date) + ":" + getMinute(date);

    }

    /**
     * 获取当年最后一天
     *
     * @return
     */
    public static String getCuYearLastDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_YEAR, ca.getActualMaximum(Calendar.DAY_OF_YEAR));
        String str1 = format.format(ca.getTime());
        System.out.println("=============str1:" + str1);
        return str1;
    }

    /**
     * 获取当年第一天
     *
     * @return
     */
    public static String getCuYearFirstDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_YEAR, ca.getActualMinimum(Calendar.DAY_OF_YEAR));
        String str1 = format.format(ca.getTime());
        System.out.println("=============str1:" + str1);
        return str1;
    }

    /**
     * 获取当年最后一天
     *
     * @return
     */
    public static String getCuYearLastMonth() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_YEAR, ca.getActualMaximum(Calendar.DAY_OF_YEAR));
        String str1 = format.format(ca.getTime());
        System.out.println("=============str1:" + str1);
        return str1;
    }

    /**
     * 获取当年第一天
     *
     * @return
     */
    public static String getCuYearFirstMonth() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_YEAR, ca.getActualMinimum(Calendar.DAY_OF_YEAR));
        String str1 = format.format(ca.getTime());
        System.out.println("=============str1:" + str1);
        return str1;
    }

    /**
     * 获取当月第一个天
     *
     * @return
     */
    public static String getCuMonthFirstDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取当前月第一天：
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        String str = format.format(c.getTime());
        System.out.println("===========str:" + str);
        return str;
    }

    /**
     * 获取当月最后一天
     *
     * @return
     */
    public static String getCuMonthLastDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String str1 = format.format(ca.getTime());
        System.out.println("=============str1:" + str1);
        return str1;
    }

    /**
     * 获取周最后一天
     *
     * @return
     */
    public static String getCurWeekLastDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_WEEK, ca.getActualMaximum(Calendar.DAY_OF_WEEK));
        String str1 = format.format(ca.getTime());
        System.out.println("=============str1:" + str1);
        return str1;
    }

    /**
     * 获取周第一天 周一
     *
     * @return
     */
    public static String getCurWeekFirstDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_WEEK, 2);
        String str1 = format.format(ca.getTime());
        System.out.println("=============str1:" + str1);
        return str1;
    }

    /**
     * 获取周第一天 周日
     *
     * @return
     */
    public static String getCurWeekFirstSunDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_WEEK, 1);
        String str1 = format.format(ca.getTime());
        System.out.println("=============str1:" + str1);
        return str1;
    }

    /**
     * 获取当月天数
     *
     * @return
     */
    public static int getCurMonthDayNum() {
        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
//        ca.set(Calendar.DAY_OF_WEEK, 2);
        int maximum = ca.getActualMaximum(Calendar.DAY_OF_MONTH);
        return maximum;
    }

    /**
     * 判断是否是周日
     *
     * @return
     */
    public static boolean isSunday(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = format.parse(date);
            Calendar ca = Calendar.getInstance();
            ca.setTime(date1);
            return ca.get(Calendar.DAY_OF_WEEK) == 1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取周一的0点
     */
    public static long getWeekOneTime(Date date) {
        long M24HOURMS = 24 * 60 * 60 * 1000;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        String date1 = dateToString(date, "yyyy-MM-dd");
        long dateMill = getDateLong(date1);
        // 本周的第几天
        int weekNumber = calendar.get(Calendar.DAY_OF_WEEK);
        if (weekNumber == 1) {
            weekNumber = 8;//把周日当作最后一天，而不是当作第一天
        }
        // 获取本周一的毫秒值
        long mondayMill = dateMill - M24HOURMS * (weekNumber - 2);
        return mondayMill;
    }

    /**
     * 获取前一天
     */
    public static Date getLastTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1); //向前走一天
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取后一天
     */
    public static Date getNextTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, +1); //向后走一天
        date = calendar.getTime();
        System.out.println("前一天时间为" + date.toString());
        return date;
    }


    // Begin: Modified by Ganhai for Wechat login exception, 2018.08.01
    public static long getUnixTime(String time) {
        long unixTimestamp = 0;
        if (time != null) {
            String strFormat1 = "yyyy-MM-dd HH:mm:ss";
            String strFormat2 = "yyyy-MM-dd";
            int length1 = strFormat1.length();
            int length2 = strFormat2.length();
            int timeLen = time.length();

            if (timeLen == length1) {
                try {
                    Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(time);
                    unixTimestamp = date.getTime() / 1000;
                } catch (ParseException e) {
                    e.printStackTrace();
                    unixTimestamp = 0;
                }
            } else if (timeLen == length2) {
                unixTimestamp = getUnixTime01(time);
            } else {

            }
        }

        return unixTimestamp;
    }

    public static long getUnixTime01(String time) {
        long unixTimestamp = 0;

        if (time != null) {
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(time);
                unixTimestamp = date.getTime() / 1000;
            } catch (ParseException e) {
                e.printStackTrace();
                unixTimestamp = 0;
            }
        }

        return unixTimestamp;
    }

    public static long getUnixTimeLong(String time) {
        long unixTimestamp = 0;

        if (time != null) {
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(time);
                unixTimestamp = date.getTime();
            } catch (ParseException e) {
                e.printStackTrace();
                unixTimestamp = 0;
            }
        }

        return unixTimestamp;
    }


    public static String getMD(long date) {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd");
        return dateFormat.format(new Date(date));
    }

    public static String stampToDate(long time) {
        String res;
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = new Date(time * 1000);
        res = simpleDateFormat.format(date);
        return res;
    }

    public static String stampToDate02(long time) {
        String res;
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = new Date(time);
        res = simpleDateFormat.format(date);
        return res;
    }

    // 根据年月日计算年龄,birthTimeString:"1994-11-14"
    public static int getAgeFromBirthTime(Date date) {
        // 得到当前时间的年、月、日
        if (date != null) {
            Calendar cal = Calendar.getInstance();
            int yearNow = cal.get(Calendar.YEAR);
            int monthNow = cal.get(Calendar.MONTH) + 1;
            int dayNow = cal.get(Calendar.DATE);
            //得到输入时间的年，月，日
            cal.setTime(date);
            int selectYear = cal.get(Calendar.YEAR);
            int selectMonth = cal.get(Calendar.MONTH) + 1;
            int selectDay = cal.get(Calendar.DATE);
            // 用当前年月日减去生日年月日
            int yearMinus = yearNow - selectYear;
            int monthMinus = monthNow - selectMonth;
            int dayMinus = dayNow - selectDay;
            int age = yearMinus;// 先大致赋值
            if (yearMinus <= 0) {
                age = 0;
            }
            if (monthMinus < 0) {
                age = age - 1;
            } else if (monthMinus == 0) {
                if (dayMinus < 0) {
                    age = age - 1;
                }
            }
            return age;
        }
        return 0;
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss 或者 yyyy-MM-dd 转换为4月5号
     */
    public static String getDayOfMonth(String time) {
        String showDate = "";
        if (time != null) {
            String strFormat1 = "yyyy-MM-dd HH:mm:ss";
            String strFormat2 = "yyyy-MM-dd";
            int length1 = strFormat1.length();
            int length2 = strFormat2.length();
            int timeLen = time.length();
            try {
                Date date;
                if (timeLen == length1) {
                    date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(time);
                } else if (timeLen == length2) {
                    date = new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(time);
                } else {

                    return showDate;
                }
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                String month = (cal.get(Calendar.MONTH) + 1) + "";
                String day = cal.get(Calendar.DAY_OF_MONTH) + "";
                showDate = month + "月" + day + "号";
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return showDate;
    }

    public static int getDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        return i;
    }

    /**
     * 根据周获取日期
     *
     * @param week 0-6周一到周
     * @return
     */
    public static Date getDateOfWeek(int week) {
        String yyyyMMdd = DateUtil.getDate(new Date());
        List<Long> bet = DateUtil.getWeekDayList(yyyyMMdd, "yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(bet.get(week));
        return calendar.getTime();
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss 或者 yyyy-MM-dd 转换为4月5号
     */
    public static Integer getYear_(String time) {
        Integer year = 2019;
        if (time != null) {
            String strFormat1 = "yyyy年MM月dd日 HH:mm:ss";
            String strFormat2 = "yyyy年MM月dd日";
            int length1 = strFormat1.length();
            int length2 = strFormat2.length();
            int timeLen = time.length();
            try {
                Date date;
                if (timeLen == length1) {
                    date = new SimpleDateFormat(strFormat1, Locale.US).parse(time);
                } else if (timeLen == length2) {
                    date = new SimpleDateFormat(strFormat2, Locale.US).parse(time);
                } else {

                    return year;
                }
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                year = cal.get(Calendar.YEAR);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return year;
    }

    public static String getNumToWeek(int weekNum) {
        switch (weekNum) {
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "日";
            default:
                return "";
        }
    }


    /**
     * 获取日期中的年
     *
     * @param dateStr
     * @return
     */
    public static int getYear(String dateStr, String formatStr) {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        try {
            Date date = null;
            try {
                date = format.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int year = calendar.get(Calendar.YEAR);
            return year;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取日期中的月
     *
     * @param dateStr
     * @return
     */
    public static int getMonth(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = null;
            try {
                date = format.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int month = calendar.get(Calendar.MONTH);
            return month + 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取日期中的月
     *
     * @param dateStr
     * @return
     */
    public static int getMonthByYYMM(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        try {
            Date date = null;
            try {
                date = format.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int month = calendar.get(Calendar.MONTH);
            return month + 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取日期中的  日
     *
     * @param dateStr
     * @return
     */
    public static int getDay(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = null;
            try {
                date = format.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            return day;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获得指定日期的前一天
     *
     * @param specifiedDay
     * @return
     * @throws
     */
    public static String getSpecifiedDayBefore(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);

        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayBefore;
    }

    /**
     * 获得指定日期的后一天
     *
     * @param specifiedDay
     * @return
     */
    public static String getSpecifiedDayAfter(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + 1);

        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayAfter;
    }


    /**
     * 获取过去或者未来 任意天内的日期数组
     *
     * @param intervals intervals天内
     * @return 日期数组
     */
    public static ArrayList<String> test(int intervals) {
        ArrayList<String> pastDaysList = new ArrayList<>();
        ArrayList<String> fetureDaysList = new ArrayList<>();
        for (int i = 0; i < intervals; i++) {
            pastDaysList.add(getPastDate(i));
            fetureDaysList.add(getFetureDate(i));
        }
        return pastDaysList;
    }

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        String result = "";
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
            Date today = calendar.getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            result = format.format(today);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取未来 第 past 天的日期
     *
     * @param past
     * @return
     */
    public static String getFetureDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }

    /**
     * @param dateStr format yyyy-MM-dd
     * @return 是否是今天
     */
    public static boolean isToday(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        String currentDateStr = format.format(currentDate);
        return currentDateStr.equals(dateStr);
    }

    /**
     * @param date date
     * @return 是否是今天
     */
    public static boolean isToday(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        String currentDateStr = format.format(currentDate);
        return currentDateStr.equals(getDate(date));
    }

    /**
     * @param date date
     * @return 是否是同一天
     */
    public static boolean isEquesDay(Date date, Date date2) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateStr = format.format(date2);
        return currentDateStr.equals(getDate(date));
    }

    /**
     * @param date date
     * @return 是否是同一天
     */
    public static boolean isEquesDay(Date date, String date2) {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        String currentDateStr = format.format(date2);
        return date2.equals(getDate(date));
    }

    /**
     * @param startDate date
     * @return 获取更小的一天
     */
    public static String getTooSmallDate(String startDate, String endDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startTime = format.parse(startDate);
            Date endTime = format.parse(endDate);
            return startTime.getTime() < endTime.getTime() ? startDate : endDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return startDate;
    }

    /**
     * @param startDate date
     * @return 获取更小的一月
     */
    public static String getTooSmallMoth(String startDate, String endDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        try {
            Date startTime = format.parse(startDate);
            Date endTime = format.parse(endDate);
            return startTime.getTime() < endTime.getTime() ? startDate : endDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return startDate;
    }

    /**
     * @param startDate date
     * @return 是否包含
     */
    public static boolean isContainsTheDate(String startDate, String endDate, String currentDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startTime = format.parse(startDate);
            Date endTime = format.parse(endDate);
            Date currentTime = format.parse(currentDate);
            return !(currentTime.getTime() < startTime.getTime() || currentTime.getTime() > endTime.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<String> getWeekDayListStr(String date) {
        List<Long> weekDayList = getWeekDayList(date, "yyyy-MM-dd");
        List<String> dayList = new ArrayList<>();
        for (long weeikDay : weekDayList) {
            dayList.add(getDate(weeikDay));
        }
        return dayList;
    }

    /**
     * 获取两个日期的区间天，连续天
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<String> getDateRangeListStr(String startDate, String endDate) {
        try {
            List<String> dayList = new ArrayList<>();
            long M24HOURMS = 24 * 60 * 60 * 1000;
            long lastDateMill = getMillis(startDate, "yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(lastDateMill);

            long endDateMill = getMillis(endDate, "yyyy-MM-dd");
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(endDateMill);

            long betweenDateNum = (endDateMill - lastDateMill) / M24HOURMS + 1;
            betweenDateNum = Math.max(0, Math.min(10000, betweenDateNum));

            for (int i = 0; i < betweenDateNum; i++) {
                long l = lastDateMill + M24HOURMS * i;
                dayList.add(getDate(l));
            }
            return dayList;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取两个日期的所有月份
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<String> getDateRangeMonthListStr(String startDate, String endDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            // 获取开始年份和开始月份
            Calendar bef = Calendar.getInstance();
            bef.setTime(sdf.parse(startDate));
            int startYear = bef.get(Calendar.YEAR);
            int startMonth = bef.get(Calendar.MONTH);

            // 获取结束年份和结束月份
            Calendar aft = Calendar.getInstance();
            aft.setTime(sdf.parse(endDate));
            int endYear = aft.get(Calendar.YEAR);
            int endMonth = aft.get(Calendar.MONTH);

            /*int surplus = aft.get(Calendar.DATE) - bef.get(Calendar.DATE);
            int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
            int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
            System.out.println(surplus);
            surplus = surplus <= 0 ? 1 : 0;
            System.out.println(surplus);
            int sumMontNum = Math.abs(month + result) + surplus;
            System.out.println("相差月份：" + sumMontNum);*/

            List<String> list = new ArrayList<>();
            for (int i = startYear; i <= endYear; i++) {
                String date = "";
                if (startYear == endYear) {
                    for (int j = startMonth; j <= endMonth; j++) {
                        if (j < 9) {
                            date = i + "-0" + (j + 1);
                        } else {
                            date = i + "-" + (j + 1);
                        }
                        list.add(date);
                    }
                } else {
                    if (i == startYear) {
                        for (int j = startMonth; j < 12; j++) {
                            if (j < 9) {
                                date = i + "-0" + (j + 1);
                            } else {
                                date = i + "-" + (j + 1);
                            }
                            list.add(date);
                        }
                    } else if (i == endYear) {
                        for (int j = 0; j <= endMonth; j++) {
                            if (j < 9) {
                                date = i + "-0" + (j + 1);
                            } else {
                                date = i + "-" + (j + 1);
                            }
                            list.add(date);
                        }
                    } else {
                        for (int j = 0; j < 12; j++) {
                            if (j < 9) {
                                date = i + "-0" + (j + 1);
                            } else {
                                date = i + "-" + (j + 1);
                            }
                            list.add(date);
                        }
                    }
                }
            }
            return list;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getCurDayYYYYMMDD() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        String currentDateStr = format.format(currentDate);
        return currentDateStr;
    }

    /**
     * 获取当前周列表  格式yyyy-MM-dd
     *
     * @return
     */
    public static List<String> getCurWeekDayListYYYYMMDD() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        String currentDateStr = format.format(currentDate);
        List<Long> weekDayList = getWeekDayList(currentDateStr, "yyyy-MM-dd");
        List<String> dayList = new ArrayList<>();
        for (long weekDay : weekDayList) {
            dayList.add(getDate(weekDay));
        }
        return dayList;
    }

    /**
     * 获取当周，天的列表  格式 dd
     *
     * @return
     */
    public static List<String> getCurWeekDayListStr() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        String currentDateStr = format.format(currentDate);
        List<Long> weekDayList = getWeekDayList(currentDateStr, "yyyy-MM-dd");
        List<String> dayList = new ArrayList<>();
        for (long weekDay : weekDayList) {
            dayList.add(getDaydd(weekDay));
        }
        return dayList;
    }

    public static List<String> getCurWeekListStr() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        String currentDateStr = format.format(currentDate);
        List<Long> weekDayList = getWeekDayList(currentDateStr, "yyyy-MM-dd");
        List<String> dayList = new ArrayList<>();
        for (long weekDay : weekDayList) {
            dayList.add(getWeek(weekDay, ""));
        }
        return dayList;
    }


    /**
     * 获取一周每一天的日期
     *
     * @param date
     * @param formatSrt
     * @return
     */
    public static List<Long> getWeekDayList(String date, String formatSrt) {
        long M24HOURMS = 24 * 60 * 60 * 1000;
        // 存放每一天时间的集合
        List<Long> weekMillisList = new ArrayList<Long>();
        long dateMill = 0;
        try {
            // 获取date的毫秒值
            dateMill = getMillis(date, formatSrt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(dateMill);
        // 本周的第几天
        int weekNumber = calendar.get(Calendar.DAY_OF_WEEK);

        if (weekNumber == 1) {
            weekNumber = 8;//把周日当作最后一天，而不是当作第一天
        }
        // 获取本周一的毫秒值
        long mondayMill = dateMill - M24HOURMS * (weekNumber - 2);

        for (int i = 0; i < 7; i++) {
            weekMillisList.add(mondayMill + M24HOURMS * i);
        }

        return weekMillisList;
    }

    /**
     * 把格式化过的时间转换毫秒值
     *
     * @param time      时间
     * @param formatSrt 时间格式 如 yyyy-MM-dd
     * @return 当前日期的毫秒值
     */
    public static long getMillis(String time, String formatSrt) throws ParseException {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat(formatSrt);
        return format.parse(time).getTime();
    }


    public static long getTodayZero() {
        Date date = new Date();
        long l = 24 * 60 * 60 * 1000; //每天的毫秒数
        //date.getTime()是现在的毫秒数，它 减去 当天零点到现在的毫秒数（ 现在的毫秒数%一天总的毫秒数，取余。），理论上等于零点的毫秒数，不过这个毫秒数是UTC+0时区的。
        //减8个小时的毫秒值是为了解决时区的问题。
        return (date.getTime() - (date.getTime() % l) - 8 * 60 * 60 * 1000);
    }

    /**
     * 获取某一天的零点
     *
     * @param time
     * @return
     */
    public static long getZero(long time) {
        Date date = new Date();
        date.setTime(time);
        long l = 24 * 60 * 60 * 1000; //每天的毫秒数
        //date.getTime()是现在的毫秒数，它 减去 当天零点到现在的毫秒数（ 现在的毫秒数%一天总的毫秒数，取余。），理论上等于零点的毫秒数，不过这个毫秒数是UTC+0时区的。
        //减8个小时的毫秒值是为了解决时区的问题。
        return (date.getTime() - (date.getTime() % l) - 8 * 60 * 60 * 1000);
    }

    public static boolean isLastDay(long time) {
        return getTodayZero() - getZero(time) == 24 * 60 * 60 * 1000;
    }

    public static boolean isLastDay2(long time) {
        String curDay = getCurDayYYYYMMDD();
        time += 24 * 60 * 60 * 1000;
        String date = getDate(time);
        return date.equals(curDay);
    }

    public static String toMinutesOfMill(long mill) {
        return toMinutesOfSecond(mill / 1000);
    }

    public static String toMinutesOfSecond(long second) {
        int sec = (int) (second % 60);
        int minute = (int) (second / 60);
        StringBuilder sb = new StringBuilder();
        if (minute < 10) {
            sb.append("0");
        }
        sb.append(minute);
        sb.append(":");
        if (sec <= 9) {
            sb.append("0");
        }
        sb.append(sec);
        return sb.toString();
    }

    public static final int N = 0;
    public static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * @Title: getMonDay
     * @Description: TODO(获取当前所在周的星期一)
     * @return date
     */

    public static Date getMonDayToDate() {

        Calendar cal = Calendar.getInstance();
        // N：0-表示本周，1-表示下周，-1-表示上周
        cal.add(Calendar.DATE, N * 7);
        // Calendar.MONDAY 表示获取周一的日期; Calendar.WEDNESDAY:表示周三的日期
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    /**
     * @Title: getMonDay
     * @Description: TODO(根据指定日期获取当周周一)
     * @param date
     * @return date
     */
    public static Date getMonDayToDate(String date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getStringFormatToDate(date));
        // N：0-表示本周，1-表示下周，-1-表示上周
        cal.add(Calendar.DATE, N * 7);
        // Calendar.MONDAY 表示获取周一的日期; Calendar.WEDNESDAY:表示周三的日期
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    /**
     * @Title: convertToDate
     * @Description: TODO(将日期字符串转化为："yyyy-MM-dd"格式的Date日期)
     * @param date
     * @return
     */
    public static Date getStringFormatToDate(String date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        if (date.equals("")) {
            return new Date();
        }
        try {
            return df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    /**
     * 将日期格式为：yyyy-MM-dd字符串
     *
     * @param date
     * @return
     * @throws Exception
     */
    public static String getDateFormatToString(Date date) {
        if (date == null) {
            return "";
        }
        return df.format(date);
    }
    /**
     * @Title: getMonDay
     * @Description: TODO(获取当前所在周的星期一)
     * @return strDate
     */
    public static String getMonDayToString() {
        Calendar cal = Calendar.getInstance();
        // N：0-表示本周，1-表示下周，-1-表示上周
        cal.add(Calendar.DATE, N * 7);
        // Calendar.MONDAY 表示获取周一的日期; Calendar.WEDNESDAY:表示周三的日期
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return getDateFormatToString(cal.getTime());
    }
    /**
     * @Title: getMonDay
     * @Description: TODO(根据指定日期获取当周周一)
     * @param date
     * @return strDate
     */
    public static String getMonDayToString(String date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getStringFormatToDate(date));
        // N：0-表示本周，1-表示下周，-1-表示上周
        cal.add(Calendar.DATE, N * 7);
        // Calendar.MONDAY 表示获取周一的日期; Calendar.WEDNESDAY:表示周三的日期
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return getDateFormatToString(cal.getTime());
    }




}
