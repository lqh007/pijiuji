package com.pijiuji.service.impl;

import com.pijiuji.VideoService;
import com.pijiuji.bean.ResponseResult;
import com.pijiuji.bean.Video;
import com.pijiuji.bean.VideoExample;
import com.pijiuji.mapper.VideoMapper;
import com.pijiuji.util.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VideoServiceImpl implements VideoService{
    @Resource
    private VideoMapper videoMapper;

    @Override
    public ResponseResult<Map<String, Object>> updateVideo(String path) {
        ResponseResult responseResult = new ResponseResult();
        VideoExample videoExample = new  VideoExample();
        List<Video> videos = videoMapper.selectByExample(videoExample);
        Map<String,Object> res = new HashMap<>();
        if(!CollectionUtil.isEmpty(videos)){
            Video video = videos.get(0);
            video.setVideoUrl(path);
            int i = videoMapper.updateByPrimaryKey(video);
            if(i>0){
                responseResult.setMessage("修改成功！");
                responseResult.setState(0);
                responseResult.setData(path);
                return responseResult;
            }

        }
        responseResult.setState(1);
        responseResult.setMessage("修改失败!");
        return responseResult;
    }
}
