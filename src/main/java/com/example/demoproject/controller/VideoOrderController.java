package com.example.demoproject.controller;

import com.example.demoproject.utils.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//下单借口
@RestController
@RequestMapping("/order")
public class VideoOrderController {

    @RequestMapping("/save")
    private JsonData saveOrder() {
        return JsonData.buildSuccess("下单成功");
    }
}
