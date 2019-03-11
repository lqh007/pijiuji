package com.pijiuji.service;

import com.pijiuji.bean.ResponseResult;
import com.pijiuji.bean.Video;

import java.util.Map;

public interface VideoService {
    ResponseResult<Map<String,Object>> updateVideo(String path);

    Map<String,Object> getVideo();
}
