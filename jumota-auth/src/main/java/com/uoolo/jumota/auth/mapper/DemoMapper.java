package com.uoolo.jumota.auth.mapper;

import com.uoolo.jumota.auth.entity.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DemoMapper {

    Demo getDemoById(@Param("id") Integer id);
    Integer createDemo(Demo demo);
}
