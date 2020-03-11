package com.example.demo.entity;/*
 * @author p78o2
 * @date 2020/3/11
 */

import java.util.Date;

//设置表
public class TimeSetting {
//    主键
    private Integer id;
//    设置名字
    private String settingName;
//    设置的键
    private String settingKey;
//    设置的值
    private String settingValue;
    //    创建人id
    private int createAdminId;
    //    创建时间
    private Date createTime;
    //    修改人
    private int modifyAdminId;
    //    修改时间
    private Date modifyTime;
    //    是否删除
    private boolean isdel;

}
