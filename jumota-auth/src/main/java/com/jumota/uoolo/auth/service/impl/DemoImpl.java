package com.jumota.uoolo.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jumota.uoolo.auth.entity.Demo;
import com.jumota.uoolo.auth.mapper.DemoMapper;
import com.jumota.uoolo.auth.service.DemoService;
import lombok.AllArgsConstructor;
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
