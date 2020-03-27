package com.example.demo.entity;/*
 * @author p78o2
 * @date 2020/3/10
 */

public class R {

    private boolean ret;

    private int status;  //200 正常  201 重名  300操作失败  301密码错误  302 账号错误

    private Object data;
    private String msg;

    @Override
    public String toString() {
        return "R{" +
                "ret=" + ret +
                ", status=" + status +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }

    public R() {
    }

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public R(boolean ret, int status, Object data, String msg) {
        this.ret = ret;
        this.status = status;
        this.data = data;
        this.msg = msg;
    }
}
