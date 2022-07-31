package com.example.demoproject.server.impl;

import com.example.demoproject.domain.Video;
import com.example.demoproject.mapper.VideoMapper;
import com.example.demoproject.server.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    //数据住进来

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> listVideo() {
        return videoMapper.listVideo();
    }


}
