package com.example.demo.controller;/*
 * @author p78o2
 * @date 2020/3/11
 */

import com.example.demo.entity.R;
import com.example.demo.entity.TimeSetting;
import com.example.demo.entity.TimeTask;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping(value = "/getAllSetting")
    @ResponseBody
//    获取配置列表
    public R getAllSetting(){
        return new R (true,200,taskService.getAllTimeSetting(),"");
    }
//    添加或者修改配置
    @PostMapping(value = "/ioeTimeSetting")
    @ResponseBody
    public R ioeTimeSetting(@RequestBody TimeSetting timeSetting){
        int result  = taskService.ioeTimeSetting(timeSetting);
        switch (result){
            case 0:{
                return new R(false,201,false,"设置的键不能重名");
            }
            case 1:{
                return new R(true,200,true,"操作成功");
            }
            case 2:{
                return new R(false,300,false,"操作失败");
            }
            default:
                return new R(false,500,false,"操作异常");
        }
    }
//    删除配置
    @PostMapping(value = "/deleteTimeSetting")
    @ResponseBody
    public R deleteTimeSetting(@RequestBody TimeSetting timeSetting){
        boolean result  = taskService.deleteTimeSetting(timeSetting);
        if(result){
            return new R(true,200,result,"操作成功");
        }else{
            return new R(false,300,result,"操作失败");
        }
    }
//    根据创建人id分页获取任务列表
    @GetMapping(value = "/getAllTaskByUserId")
    @ResponseBody
    public R getAllTaskByUserId(@RequestParam int userId,@RequestParam int page,@RequestParam int pageSize){
        return new R(true,200,taskService.getAllTaskByUserId(userId,page,pageSize),"查询成功");
    }
//    添加或修改日志任务
    @PostMapping(value = "/ioeTimeTask")
    @ResponseBody
    public R ioeTimeTask(@RequestBody TimeTask timeTask){
        int result  = taskService.ioeTimeTask(timeTask);
        switch (result){
            case 0:{
                return new R(false,201,false,"设置的键不能重名");
            }
            case 1:{
                return new R(true,200,true,"操作成功");
            }
            case 2:{
                return new R(false,300,false,"操作失败");
            }
            default:
                return new R(false,500,false,"操作异常");
        }
    }
//    删除任务
    @PostMapping(value = "/deleteTimeTask")
    @ResponseBody
    public R deleteTimeTask(@RequestBody TimeTask timeTask){
        boolean result  = taskService.deleteTimeTask(timeTask);
        if(result){
            return new R(true,200,result,"操作成功");
        }else{
            return new R(false,300,result,"操作失败");
        }
    }
}
