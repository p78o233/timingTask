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

    @Override
    public String toString() {
        return "TimeSetting{" +
                "id=" + id +
                ", settingName='" + settingName + '\'' +
                ", settingKey='" + settingKey + '\'' +
                ", settingValue='" + settingValue + '\'' +
                ", createAdminId=" + createAdminId +
                ", createTime=" + createTime +
                ", modifyAdminId=" + modifyAdminId +
                ", modifyTime=" + modifyTime +
                ", isdel=" + isdel +
                '}';
    }

    public TimeSetting() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSettingName() {
        return settingName;
    }

    public void setSettingName(String settingName) {
        this.settingName = settingName;
    }

    public String getSettingKey() {
        return settingKey;
    }

    public void setSettingKey(String settingKey) {
        this.settingKey = settingKey;
    }

    public String getSettingValue() {
        return settingValue;
    }

    public void setSettingValue(String settingValue) {
        this.settingValue = settingValue;
    }

    public int getCreateAdminId() {
        return createAdminId;
    }

    public void setCreateAdminId(int createAdminId) {
        this.createAdminId = createAdminId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getModifyAdminId() {
        return modifyAdminId;
    }

    public void setModifyAdminId(int modifyAdminId) {
        this.modifyAdminId = modifyAdminId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public boolean isIsdel() {
        return isdel;
    }

    public void setIsdel(boolean isdel) {
        this.isdel = isdel;
    }

    public TimeSetting(Integer id, String settingName, String settingKey, String settingValue, int createAdminId, Date createTime, int modifyAdminId, Date modifyTime, boolean isdel) {
        this.id = id;
        this.settingName = settingName;
        this.settingKey = settingKey;
        this.settingValue = settingValue;
        this.createAdminId = createAdminId;
        this.createTime = createTime;
        this.modifyAdminId = modifyAdminId;
        this.modifyTime = modifyTime;
        this.isdel = isdel;
    }
}
