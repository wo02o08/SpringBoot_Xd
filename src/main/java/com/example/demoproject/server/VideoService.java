package com.example.demoproject.server;

import com.example.demoproject.domain.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoService {
    List<Video> listVideo();
}
