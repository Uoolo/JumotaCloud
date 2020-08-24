package com.jumota.uoolo.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jumota.uoolo.auth.entity.Demo;

public interface DemoService {

    Demo getDemoById(Integer id);

    Integer createDemo(Demo demo);
}
