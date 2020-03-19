package com.example.demo.controller;/*
 * @author p78o2
 * @date 2020/3/19
 */

import com.example.demo.service.MainScheduledTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/main_scheduled_task")
public class MainScheduledTaskController {
    @Autowired
    private MainScheduledTaskService service;
//    间隔1秒执行一次定时任务
    @Scheduled(fixedRate=1000)
    @GetMapping(value = "/handMake")
    public void configureTasks() {
        service.getTask();
    }
}
