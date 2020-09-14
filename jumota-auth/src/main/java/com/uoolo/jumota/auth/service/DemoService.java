package com.uoolo.jumota.auth.service;

import com.uoolo.jumota.auth.entity.Demo;

public interface DemoService {

    Demo getDemoById(Integer id);

    Integer createDemo(Demo demo);
}
