package com.uoolo.jumota.auth.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.uoolo.jumota.auth.entity.Demo;
import com.uoolo.jumota.auth.service.DemoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/demo")
public class DemoController {
    private DemoService demoService;

    @GetMapping("/get-demo/{id}")
    public R getDemo(@PathVariable("id") Integer id){

        return R.ok(demoService.getDemoById(id));
    }

    @PostMapping("/create-demo")
    public R createDemo(@RequestBody Demo demo){
        return R.ok(demoService.createDemo(demo));
    }
}
