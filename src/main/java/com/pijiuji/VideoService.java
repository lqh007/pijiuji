package com.pijiuji;

import com.pijiuji.bean.ResponseResult;
import com.pijiuji.bean.Video;

import java.util.Map;

public interface VideoService {
    ResponseResult<Map<String,Object>> updateVideo(String path);
}
