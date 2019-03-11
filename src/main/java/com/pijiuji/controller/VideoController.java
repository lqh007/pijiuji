package com.pijiuji.controller;

import com.pijiuji.VideoService;
import com.pijiuji.bean.FileEntity;
import com.pijiuji.bean.ResponseResult;
import com.pijiuji.util.FileUploadTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@Api("视频接口")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @RequestMapping(value = "/updateVideo", method={RequestMethod.POST,RequestMethod.GET})
    @ApiOperation("修改视频")
    public ResponseResult<Map<String, Object>> updateVideo(@RequestParam(value = "file", required = false) MultipartFile multipartFile,
                                                           HttpServletRequest request, ModelMap map){

        String message = "";
        FileEntity entity = new FileEntity();
        FileUploadTool fileUploadTool = new FileUploadTool();
        try {
            entity = fileUploadTool.createFile(multipartFile, request);
            if (entity != null) {
//                service.saveFile(entity);
                message = "上传成功";
                map.put("entity", entity);
                map.put("result", message);
            } else {
                message = "上传失败";
                map.put("result", message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return videoService.updateVideo(entity.getPath());
    }

}
