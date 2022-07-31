package com.example.demoproject.mapper;

import com.example.demoproject.domain.Video;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VideoMapper {

    private static final Map<String, Video> videoMap = new HashMap<>();
    static {
        videoMap.put("1", new Video(1, "视频1"));
        videoMap.put("2", new Video(2, "视频2"));
        videoMap.put("3", new Video(3, "视频3"));
        videoMap.put("4", new Video(4, "视频4"));
        videoMap.put("5", new Video(5, "视频5"));
    }

    public List<Video> listVideo() {
        return new ArrayList<>(videoMap.values());
    }


}
