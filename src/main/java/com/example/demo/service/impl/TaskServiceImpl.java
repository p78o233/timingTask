package com.example.demo.service.impl;/*
 * @author p78o2
 * @date 2020/3/11
 */

import com.example.demo.entity.PageInfo;
import com.example.demo.entity.R;
import com.example.demo.entity.TimeSetting;
import com.example.demo.entity.TimeTask;
import com.example.demo.mapper.TaskMapper;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return 0;
    }

    @Override
    public boolean deleteTimeSetting(TimeSetting timeSetting) {
        return false;
    }

    @Override
    public PageInfo getAllTaskByUserId(int userId, int page, int pageSize) {
        return null;
    }

    @Override
    public int ioeTimeTask(TimeTask timeTask) {
        return 0;
    }

    @Override
    public boolean deleteTimeTask(TimeTask timeTask) {
        return false;
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
