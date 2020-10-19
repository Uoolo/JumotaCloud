package com.uoolo.jumota.auth.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.extension.api.R;
import com.uoolo.jumota.auth.entity.Demo;
import com.uoolo.jumota.auth.service.DemoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/demo")
public class DemoController {
    private DemoService demoService;

    private static Integer[] reqCache = new Integer[100]; // 请求 ID 存储集合
    private static Integer reqCacheCounter = 0; // 请求计数器（指示 ID 存储的位置）

    @GetMapping("/get-demo/{id}")
    public String getDemo(@PathVariable("id") Integer id){
        // 非空判断(忽略)...
        synchronized (this.getClass()) {
            // 重复请求判断
            if (Arrays.asList(reqCache).contains(id)) {
                // 重复请求
                System.out.println("请勿重复提交！！！" + id);
                return "执行失败";
            }
            // 记录请求 ID
            if (reqCacheCounter >= reqCache.length) reqCacheCounter = 0; // 重置计数器
            reqCache[reqCacheCounter] = id; // 将 ID 保存到缓存
            reqCacheCounter++; // 下标往后移一位
        }
        // 业务代码...
        System.out.println("添加用户ID:" + id);
        return "执行成功！" + JSONUtils.toJSONString(Arrays.asList(reqCache));
        //return R.ok(demoService.getDemoById(id));
    }

    @PostMapping("/create-demo")
    public R createDemo(@RequestBody Demo demo){
        return R.ok(demoService.createDemo(demo));
    }
}
