package com.example.demo.service.impl;/*
 * @author p78o2
 * @date 2020/3/19
 */

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.TimeTask;
import com.example.demo.entity.TimeTaskLog;
import com.example.demo.mapper.MainScheduledTaskMapper;
import com.example.demo.service.MainScheduledTaskService;
import com.example.demo.utils.HttpUtils;
import com.example.demo.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MainScheduledTaskServiceImpl implements MainScheduledTaskService {
    @Autowired
    private JavaMailSender sender;
    @Autowired
    private MainScheduledTaskMapper taskMapper;

    @Override
    public void getTask() {
//        获取时间任务的日志
        List<TimeTaskLog> listLog = new ArrayList<TimeTaskLog>();
        listLog = getTimeTaskLogs();
        for(TimeTaskLog log : listLog){
            //根据taskId获取任务详细
            TimeTask timeTask = new TimeTask();
            timeTask = getTimeTask(log.getTaskId());
            if(timeTask.getTaskCategory()==1){
//                发送邮件
                MailUtils.sendSimpleMail(sender, timeTask.getEmailAddress(), timeTask.getEmailSubject(), timeTask.getEmailContent());
//                判断是否循环任务
            }else if(timeTask.getTaskCategory()==2){
//                访问接口
                switch (timeTask.getRequestMode()){
                    case 1:{
//                        get请求
                        Map<String,Object> params = new HashMap<String,Object>();
                        params = JSONObject.parseObject(timeTask.getTaskParam());
                        String result = HttpUtils.get(timeTask.getRequestAddress(),params);
                        System.out.println("任务id："+timeTask.getId()+"::::::"+result);
                        break;
                    }
                    case 2:{
//                        application/json
                        String result = HttpUtils.post(timeTask.getRequestAddress(),timeTask.getTaskParam());
                        System.out.println("任务id："+timeTask.getId()+"::::::"+result);
                        break;
                    }
                }
            }
//                更改日志表里面的发送状态
            taskMapper.updateExecStatus(new Date(),log.getId());
//            判断是否指定日期
            if (timeTask.getIsAppoin()==1){
//                    指定日期，不进行任何操作

            }else{
//                    循环任务
//                计算下一个执行时间
                Date nextTime = new Date(timeTask.getFrequency()*60*1000+new Date().getTime());
                TimeTaskLog thisLog = new TimeTaskLog();
                thisLog.setNextTime(nextTime);
                thisLog.setTaskId(timeTask.getId());
//                插入到日志表新增新的日志
                taskMapper.insertTimeTaskLog(thisLog);
            }
        }
    }

    public List<TimeTaskLog> getTimeTaskLogs(){
//        获取未执行但是下一次执行时间小于当前时间的日志数据
        return taskMapper.getTimeTaskLogs(new Date());
    }

    public TimeTask getTimeTask(int id){
//        根据日志表中的taskId获取任务详细
        return taskMapper.getTimeTask(id);
    }
}
