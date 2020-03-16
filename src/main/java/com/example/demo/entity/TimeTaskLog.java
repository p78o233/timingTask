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
    private boolean isExec;
//    执行时间
    private Date execTime;
//    是否删除
    private boolean isdel;

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

    public boolean isExec() {
        return isExec;
    }

    public void setExec(boolean exec) {
        isExec = exec;
    }

    public Date getExecTime() {
        return execTime;
    }

    public void setExecTime(Date execTime) {
        this.execTime = execTime;
    }

    public boolean isIsdel() {
        return isdel;
    }

    public void setIsdel(boolean isdel) {
        this.isdel = isdel;
    }

    public TimeTaskLog(Integer id, int taskId, Date nextTime, boolean isExec, Date execTime, boolean isdel) {
        this.id = id;
        this.taskId = taskId;
        this.nextTime = nextTime;
        this.isExec = isExec;
        this.execTime = execTime;
        this.isdel = isdel;
    }
}
