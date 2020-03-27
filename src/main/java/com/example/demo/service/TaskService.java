package com.example.demo.service;/*
 * @author p78o2
 * @date 2020/3/11
 */

import com.example.demo.entity.PageInfo;
import com.example.demo.entity.R;
import com.example.demo.entity.TimeSetting;
import com.example.demo.entity.TimeTask;
import com.example.demo.entity.dto.TimeTaskDto;

import java.util.List;

public interface TaskService {
//    获取全部配置
    public List<TimeSetting> getAllTimeSetting();
//    添加或者修改配置
    public int ioeTimeSetting(TimeSetting timeSetting);
//    删除配置
    public boolean deleteTimeSetting(TimeSetting timeSetting);

//    根据创建人id获取自己创建的任务列表
    public PageInfo getAllTaskByUserId(int userId,int taskCategory,int page,int pageSize);
//    添加或修改任务配置
    public int ioeTimeTask(TimeTaskDto timeTask);
//    删除任务
    public boolean deleteTimeTask(TimeTask timeTask);

//    用户登陆
    public R login(String account,String pwd);
//    修改密码
    public int updatePwd(String account,String oldPwd,String newPwd);
}
