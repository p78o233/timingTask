package com.example.demo.mapper;/*
 * @author p78o2
 * @date 2020/3/11
 */

import com.example.demo.entity.TimeSetting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TaskMapper {
//    获取配置文件
    @Select("select * from time_setting where isdel = 0 order by id desc")
    List<TimeSetting> getAllSetting();
//    设置表新增时检查是否有重名键
    @Select("select count(*) from time_setting where isdel = 0 and settingKey = #{settingKey}")
    int getInsertCountSetting(@Param("settingKey")String settingKey);
//    设置表修改时检查是否有重名键
//    @Select("select count(*) from ")
}
