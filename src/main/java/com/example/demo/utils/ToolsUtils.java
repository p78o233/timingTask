package com.example.demo.utils;/*
 * @author p78o2
 * @date 2019/9/17
 */

import java.util.Date;

public  class ToolsUtils {
    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     * @param date1
     * @param date2
     * @return
     */
    public static long differentDaysByMillisecond(Date date1, Date date2)
    {
        long days =  ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }
}
