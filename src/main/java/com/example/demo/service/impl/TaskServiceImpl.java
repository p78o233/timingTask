package com.example.demo.service.impl;/*
 * @author p78o2
 * @date 2020/3/11
 */

import com.example.demo.entity.*;
import com.example.demo.mapper.TaskMapper;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;
    @Override
    public List<TimeSetting> getAllTimeSetting() {
        return taskMapper.getAllSetting();
    }

    @Override
    public int ioeTimeSetting(TimeSetting timeSetting) {
        //0 有重名  1新增成功  2新增失败
        if(timeSetting.getId()==null){
//            新增
            if(taskMapper.getInsertCountSetting(timeSetting.getSettingKey())>0)
                return 0;
            timeSetting.setCreateTime(new Date());
            timeSetting.setModifyTime(new Date());
            if(taskMapper.insertTimeSetting(timeSetting)>0)
                return 1;
            else
                return 2;
        }else{
//            修改
            if(taskMapper.getEditCountSetting(timeSetting.getSettingKey(),timeSetting.getId())>0)
                return 0;
            timeSetting.setModifyTime(new Date());
            if(taskMapper.updateTimeSetting(timeSetting)>0)
                return 1;
            else
                return 2;
        }
    }

    @Override
    public boolean deleteTimeSetting(TimeSetting timeSetting) {
        timeSetting.setModifyTime(new Date());
        if(taskMapper.deleteTimeSetting(timeSetting)>0)
            return true;
        return false;
    }

    @Override
    public PageInfo getAllTaskByUserId(int userId, int page, int pageSize) {
        int start = (page-1)*pageSize;
        int count = taskMapper.getTimeTaskCount(userId);
        List<TimeTask> list = new ArrayList<>();
        list = taskMapper.getTimeTaskPage(userId,start,pageSize);
        PageInfo<TimeTask> pageInfo = new PageInfo<>();
        pageInfo.setCount(count);
        pageInfo.setList(list);
        return pageInfo;
    }

    @Override
    public int ioeTimeTask(TimeTask timeTask) {
        //0 有重名  1新增成功  2新增失败
        if(timeTask.getId()==null){
//            新增
            if (taskMapper.getInsertTimeTast(timeTask.getTaskName(),timeTask.getCreateAdminId())>0)
                return 0;
            else{
                timeTask.setCreateTime(new Date());
                timeTask.setModifyTime(new Date());
                taskMapper.insertTimeTask(timeTask);
                if(timeTask.getId()>0) {
                    TimeTaskLog ttl = new TimeTaskLog();
                    ttl.setTaskId(timeTask.getId());
                    if(timeTask.isAppoin()==false){
//                        不指定日期，即定时多少分钟执行一次
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        long longTimeStamp = new Date().getTime()+timeTask.getFrequency()*60*1000;
                        ttl.setNextTime(new Date(longTimeStamp));
                    }else{
//                        指定某个日期
                        ttl.setNextTime(timeTask.getAppoinDate());
                    }
                    if(taskMapper.insertTimeTaskLog(ttl)>0)
                        return 1;
                    return 2;
                }else{
                    return 2;
                }
            }
        }else{
//            修改
            if(taskMapper.getEditTimeTask(timeTask.getTaskName(),timeTask.getCreateAdminId(),timeTask.getId())>0)
                return 0;
            else {
                timeTask.setModifyTime(new Date());
                if(taskMapper.updateTimeTask(timeTask)>0){
                    TimeTaskLog ttl = new TimeTaskLog();
                    if(timeTask.isAppoin()==false){
//                        不指定日期，即定时多少分钟执行一次
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        long longTimeStamp = new Date().getTime()+timeTask.getFrequency()*60*1000;
                        ttl.setNextTime(new Date(longTimeStamp));
                    }else{
//                        指定某个日期
                        ttl.setNextTime(timeTask.getAppoinDate());
                    }
                    if(taskMapper.updateTimeTaskLog(ttl.getNextTime(),ttl.getTaskId())>0)
                        return 1;
                    return 2;
                }else {
                    return 2;
                }
            }
        }
    }

    @Override
    public boolean deleteTimeTask(TimeTask timeTask) {
        timeTask.setModifyTime(new Date());
        if(taskMapper.deleteTimeTask(timeTask)>0){
            if(taskMapper.deleteTimeTaskLog(timeTask.getId())>0)
                return true;
            return false;
        }else{
            return false;
        }
    }

    @Override
    public R login(String account, String pwd) {
        return null;
    }

    @Override
    public int updatePwd(String account, String oldPwd, String newPwd) {
        return 0;
    }
}
