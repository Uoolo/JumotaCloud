package com.jumota.uoolo.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jumota.uoolo.auth.entity.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DemoMapper {

    Demo getDemoById(@Param("id") Integer id);
    Integer createDemo(Demo demo);
}
