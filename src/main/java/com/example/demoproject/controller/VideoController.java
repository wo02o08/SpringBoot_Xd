package com.example.demoproject.controller;


import com.example.demoproject.domain.Video;
import com.example.demoproject.server.VideoService;
import com.example.demoproject.utils.JsonData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/list")
    public Object list() throws JsonProcessingException {
        List<Video> list = videoService.listVideo();

        // 将list转换为json格式 序列化
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonStr = objectMapper.writeValueAsString(list);
//        System.out.println("jsonStr: " + jsonStr);

        return JsonData.buildSuccess(list);
    }

    @PostMapping("save_video")
    public JsonData saveVideoChapter(@RequestBody Video video) {
        System.out.println("video: " + video);
        return JsonData.buildSuccess(video);
    }

}

