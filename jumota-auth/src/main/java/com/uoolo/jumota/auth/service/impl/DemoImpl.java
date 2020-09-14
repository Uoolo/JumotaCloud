package com.uoolo.jumota.auth.service.impl;

import com.uoolo.jumota.auth.entity.Demo;
import com.uoolo.jumota.auth.mapper.DemoMapper;
import com.uoolo.jumota.auth.service.DemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class DemoImpl implements DemoService {
    @Resource
    private DemoMapper demoMapper; //使用Resource注解

    @Override
    public Demo getDemoById(Integer id){
        return demoMapper.getDemoById(id);
    }

    @Override
    public Integer createDemo(Demo demo){
        demo.setCreateTime(new Date());
        demo.setDelFlag("0");
        return demoMapper.createDemo(demo);
    }
}
