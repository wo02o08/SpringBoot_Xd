package com.example.demoproject.controller;

import com.example.demoproject.Config.WxConfig;
import com.example.demoproject.utils.JsonData;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("test")
@PropertySource("classpath:pay.properties")
public class TestController {

    @Autowired
    private WxConfig wxConfig;

    @GetMapping("/config")
    public JsonData test() {
        Map<String,String> map = new HashMap<>();
        map.put("id",wxConfig.getAPPID());
        map.put("secret",wxConfig.getSECRET());
        map.put("machId",wxConfig.getMCH_ID());
        return JsonData.buildSuccess(map);
    }

    @GetMapping("/exception")
    public JsonData test2() {
        int i = 1/0;
        return JsonData.buildSuccess("test2");
    }
}
