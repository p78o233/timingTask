package com.example.demo.entity.dto;/*
 * @author p78o2
 * @date 2020/3/20
 */

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public class TimeTaskDto {
    //    主键
    private Integer id;
    //    任务名称
    private String taskName;
    //    任务类别 1、邮件发送 2 接口访问
    private int taskCategory;
    //    邮箱地址
    private String emailAddress;
    //    访问地址
    private String requestAddress;
    //    请求参数 json格式
    private JSONObject taskParam;
    //    负责人
    private String personInCharge;
    //    邮件内容
    private String emailContent;
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
    //    是否指定执行日期 0否 1是
    private int isAppoin;
    //    不指定执行日期的执行频度  单位分钟
    private int frequency;
    //    指定的日期，时分秒
    private Date appoinDate;
    //    邮件主题
    private String emailSubject;
    //    请求方式  1 get  2、post application/json 3、post from
    private Integer requestMode;

    @Override
    public String toString() {
        return "TimeTaskDto{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskCategory=" + taskCategory +
                ", emailAddress='" + emailAddress + '\'' +
                ", requestAddress='" + requestAddress + '\'' +
                ", taskParam=" + taskParam +
                ", personInCharge='" + personInCharge + '\'' +
                ", emailContent='" + emailContent + '\'' +
                ", createAdminId=" + createAdminId +
                ", createTime=" + createTime +
                ", modifyAdminId=" + modifyAdminId +
                ", modifyTime=" + modifyTime +
                ", isdel=" + isdel +
                ", isAppoin=" + isAppoin +
                ", frequency=" + frequency +
                ", appoinDate=" + appoinDate +
                ", emailSubject='" + emailSubject + '\'' +
                ", requestMode=" + requestMode +
                '}';
    }

    public TimeTaskDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getTaskCategory() {
        return taskCategory;
    }

    public void setTaskCategory(int taskCategory) {
        this.taskCategory = taskCategory;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getRequestAddress() {
        return requestAddress;
    }

    public void setRequestAddress(String requestAddress) {
        this.requestAddress = requestAddress;
    }

    public JSONObject getTaskParam() {
        return taskParam;
    }

    public void setTaskParam(JSONObject taskParam) {
        this.taskParam = taskParam;
    }

    public String getPersonInCharge() {
        return personInCharge;
    }

    public void setPersonInCharge(String personInCharge) {
        this.personInCharge = personInCharge;
    }

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
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

    public int getIsAppoin() {
        return isAppoin;
    }

    public void setIsAppoin(int isAppoin) {
        this.isAppoin = isAppoin;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Date getAppoinDate() {
        return appoinDate;
    }

    public void setAppoinDate(Date appoinDate) {
        this.appoinDate = appoinDate;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public Integer getRequestMode() {
        return requestMode;
    }

    public void setRequestMode(Integer requestMode) {
        this.requestMode = requestMode;
    }

    public TimeTaskDto(Integer id, String taskName, int taskCategory, String emailAddress, String requestAddress, JSONObject taskParam, String personInCharge, String emailContent, int createAdminId, Date createTime, int modifyAdminId, Date modifyTime, boolean isdel, int isAppoin, int frequency, Date appoinDate, String emailSubject, Integer requestMode) {
        this.id = id;
        this.taskName = taskName;
        this.taskCategory = taskCategory;
        this.emailAddress = emailAddress;
        this.requestAddress = requestAddress;
        this.taskParam = taskParam;
        this.personInCharge = personInCharge;
        this.emailContent = emailContent;
        this.createAdminId = createAdminId;
        this.createTime = createTime;
        this.modifyAdminId = modifyAdminId;
        this.modifyTime = modifyTime;
        this.isdel = isdel;
        this.isAppoin = isAppoin;
        this.frequency = frequency;
        this.appoinDate = appoinDate;
        this.emailSubject = emailSubject;
        this.requestMode = requestMode;
    }
}
