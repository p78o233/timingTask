package com.example.demo.mapper;/*
 * @author p78o2
 * @date 2020/3/19
 */

import com.example.demo.entity.TimeTask;
import com.example.demo.entity.TimeTaskLog;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface MainScheduledTaskMapper {
    @Select("select * from time_task_log where isdel = 0 and isExec = 0 and nextTime < #{nextTime} order by id asc")
    List<TimeTaskLog> getTimeTaskLogs(@Param("nextTime")Date nextTime);

    @Select("select * from time_task where id = #{id} and isdel = 0")
    TimeTask getTimeTask(@Param("id")int id);

    @Update("update time_task_log set isExec = 1 , execTime = #{execTime} where id = #{id}")
    int updateExecStatus(@Param("execTime") Date execTime,@Param("id")int id);

    @Insert("insert into time_task_log (taskId,nextTime) values (#{t.taskId},#{t.nextTime})")
    int insertTimeTaskLog(@Param("t")TimeTaskLog timeTaskLog);

}
