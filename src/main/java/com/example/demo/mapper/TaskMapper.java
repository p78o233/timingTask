package com.example.demo.mapper;/*
 * @author p78o2
 * @date 2020/3/11
 */

import com.example.demo.entity.PageInfo;
import com.example.demo.entity.TimeSetting;
import com.example.demo.entity.TimeTask;
import com.example.demo.entity.TimeTaskLog;
import org.apache.ibatis.annotations.*;

import javax.annotation.security.PermitAll;
import java.util.Date;
import java.util.List;

@Mapper
public interface TaskMapper {
//    获取配置文件
    @Select("select * from time_setting where isdel = 0 order by id desc")
    List<TimeSetting> getAllSetting();
//    设置表新增时检查是否有重名键
    @Select("select count(*) from time_setting where isdel = 0 and settingKey = #{settingKey}")
    int getInsertCountSetting(@Param("settingKey")String settingKey);
    @Insert("insert into time_setting (setttingName,settingKey,settingValue,createAdminId,createTime,modifyAdminId,modifyTime) values " +
            "(#{t.setttingName},#{t.settingKey},#{t.settingValue},#{t.createAdminId},#{t.createTime},#{t.modifyAdminId},#{t.modifyTime}")
    int insertTimeSetting(@Param("t")TimeSetting timeSetting);
//    设置表修改时检查是否有重名键
    @Select("select count(*) from time_setting where isdel = 0 and settingKey = #{settingKey} and id != #{id}")
    int getEditCountSetting(@Param("settingKey")String settingKey,@Param("id")int id);
    @Update("update time_setting set settingName = #{t.settingName},settingKey = #{t.settingKey},settingValue = #{t.settingValue}," +
            "modifyAdminId = #{t.modifyAdminId},modifyTime = #{t.modifyTime} where id = #{t.id}")
    int updateTimeSetting(@Param("t")TimeSetting timeSetting);
//    删除设置表记录
    @Update("update time_setting set modifyAdminId = #{t.modifyAdminId},modifyTime = #{t.modifyTime},isdel = 1 where id = #{t.id}")
    int deleteTimeSetting(@Param("t")TimeSetting timeSetting);

//    根据创建人id获取任务列表
    @Select("select count(*) from time_task where createAdminId = #{createAdminId} and isdel = 0")
    int getTimeTaskCount(@Param("createAdminId")int createAdminId);
    @Select("select * from time_task where createAdminId = #{createAdminId} and isdel = 0 order by modifyTime desc limit #{start},#{page}")
    List<TimeTask> getTimeTaskPage(@Param("createAdminId")int createAdminId,@Param("start")int start,@Param("page")int page);
//    检查同一个用户新增定时任务时有没有重名任务
    @Select("select count(*) from time_task where taskName = #{taskName} and createAdminId = #{createAdminId} and isdel = 0")
    int getInsertTimeTast(@Param("taskName")String taskName,@Param("createAdminId")int createAdminId);
    @Insert("insert into time_task (taskName,taskCategory,emailAddress,requestAddress,taskParam,personInCharge,emailContent,createAdminId,createTime,modifyAdminId,modifyTime," +
            "isAppoin,frequency,appoinDate,emailSubject,requestMode) values " +
            "(#{t.taskName},#{t.taskCategory},#{t.emailAddress},#{t.requestAddress},#{t.taskParam},#{t.personInCharge},#{t.emailContent},#{t.createAdminId},#{t.createTime}," +
            "#{t.modifyAdminId},#{t.modifyTime},#{t.isAppoin},#{t.frequency},#{t.appoinDate},#{t.emailSubject},#{t.requestMode})")
    @Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
    void insertTimeTask(@Param("t")TimeTask timeTask);
//    日志表新增
    @Insert("insert into time_task_log (taskId,nextTime,isExec) values (#{t.taskId},#{t.nextTime},0)")
    int insertTimeTaskLog(@Param("t")TimeTaskLog timeTaskLog);
//    检查同一个用户修改定时任务有没有重名任务
    @Select("select count(*) from time_task where taskName = #{taskName} and createAdminId = #{createAdminId} and isdel = 0 and id != #{id}")
    int getEditTimeTask(@Param("taskName")String taskName,@Param("createAdminId")int createAdminId,@Param("id")int id);
    @Update("update time_task set taskName = #{t.taskName},taskCategory = #{t.taskCategory},emailAddress = #{t.emailAddress},requestAddress = #{t.requestAddress}," +
            "taskParam = #{t.taskParam},personInCharge = #{t.personInCharge},emailContent = #{t.emailContent},modifyAdminId = #{t.modifyAdminId},modifyTime = #{t.modifyTime}," +
            "isAppoin = #{t.isAppoin},frequency = #{t.frequency},appoinDate = #{t.appoinDate},emailSubject = #{t.emailSubject},requestMode = #{t.requestMode} where id = #{t.id}")
    int updateTimeTask(@Param("t")TimeTask timeTask);
//    日志表修改
    @Update("update time_task_log set nextTime = #{nextTime} where taskId = #{taskId} and isExec = 0 and isdel = 0")
    int updateTimeTaskLog(@Param("nextTime") Date nextTime,@Param("taskId")int taskId);
//    删除定时任务
    @Update("update time_task set isdel  = 1 ,modifyAdminId = #{t.modifyAdminId},modifyTime = #{t.modifyTime} where id = #{t.id}")
    int deleteTimeTask(@Param("t")TimeTask timeTask);
    @Update("update time_task_log set isdel = 1 where taskId = #{taskId}")
    int deleteTimeTaskLog(@Param("taskId")int taskId);
//    获取最近一条任务日志表数据
    @Select("select * from time_task_log where taskId = #{taskId} and isExec = 0 and isdel = 0")
    TimeTaskLog getLastestTimeTaskLog(@Param("taskId")int taskId);
}
