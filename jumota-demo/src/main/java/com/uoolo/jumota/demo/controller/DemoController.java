package com.uoolo.jumota.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * TODO
 *
 * @Author: WuChao
 * @Date: Create in 2022/11/18 2:56 PM
 */
@RestController
@RequestMapping("/demo")
@RefreshScope
public class DemoController {

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @RequestMapping("/test")
    public String getTestData() {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("", "");

        return "test:" + useLocalCache;
    }
}
