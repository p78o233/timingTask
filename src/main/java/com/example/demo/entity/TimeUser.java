package com.example.demo.entity;/*
 * @author p78o2
 * @date 2020/3/11
 */

import java.util.Date;

public class TimeUser {
//    用户表
    private Integer id;
//    账号
    private String account;
//    密码
    private String pwd;
//    创建时间
    private Date createTime;
//    修改时间
    private Date modifyTime;
//    是否删除
    private boolean isdel;

    @Override
    public String toString() {
        return "TimeUser{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", pwd='" + pwd + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", isdel=" + isdel +
                '}';
    }

    public TimeUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public TimeUser(Integer id, String account, String pwd, Date createTime, Date modifyTime, boolean isdel) {
        this.id = id;
        this.account = account;
        this.pwd = pwd;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
        this.isdel = isdel;
    }
}
