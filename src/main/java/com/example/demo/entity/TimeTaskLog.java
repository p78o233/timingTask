package com.example.demo.entity;/*
 * @author p78o2
 * @date 2020/3/16
 */

import java.util.Date;

//定时任务日志表
public class TimeTaskLog {
    private Integer id;
//    任务id
    private int taskId;
//    下次执行时间
    private Date nextTime;
//    是否执行
    private int isExec;
//    执行时间
    private Date execTime;
//    是否删除
    private int isdel;

    @Override
    public String toString() {
        return "TimeTaskLog{" +
                "id=" + id +
                ", taskId=" + taskId +
                ", nextTime=" + nextTime +
                ", isExec=" + isExec +
                ", execTime=" + execTime +
                ", isdel=" + isdel +
                '}';
    }

    public TimeTaskLog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public Date getNextTime() {
        return nextTime;
    }

    public void setNextTime(Date nextTime) {
        this.nextTime = nextTime;
    }



    public Date getExecTime() {
        return execTime;
    }

    public void setExecTime(Date execTime) {
        this.execTime = execTime;
    }

    public TimeTaskLog(Integer id, int taskId, Date nextTime, int isExec, Date execTime, int isdel) {
        this.id = id;
        this.taskId = taskId;
        this.nextTime = nextTime;
        this.isExec = isExec;
        this.execTime = execTime;
        this.isdel = isdel;
    }

    public int getIsExec() {
        return isExec;
    }

    public void setIsExec(int isExec) {
        this.isExec = isExec;
    }

    public int getIsdel() {
        return isdel;
    }

    public void setIsdel(int isdel) {
        this.isdel = isdel;
    }
}
