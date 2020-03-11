package com.example.demo.controller;/*
 * @author p78o2
 * @date 2020/3/11
 */

import com.example.demo.entity.R;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @RequestMapping(value = "/getAllSetting")
    @ResponseBody
//    获取配置列表
    public R getAllSetting(){
        return new R (true,200,taskService.getAllTimeSetting(),"");
    }

}
