package com.pijiuji.admin.controller;

import com.pijiuji.admin.service.FatService;
import com.pijiuji.bean.Fat;
import com.pijiuji.bean.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("fat")
public class FatController {
    @Autowired
    private FatService fatService;

    @GetMapping("findAllFat")
    public ResponseResult findAllFat(HttpServletRequest request){
        return fatService.findAllFat(request);
    }

    /**
     * 增加酒桶
     */
    @PostMapping("saveFat")
    public ResponseResult saveFat(Fat fat){
        return fatService.saveFat(fat);
    }

    /**
     * 修改酒桶
     * @param fat
     * @return
     */
    @PostMapping("updateFat")
    public ResponseResult updateFat(Fat fat){
        return fatService.updateFat(fat);
    }

        /**
     * 删除酒桶
     * @param fatId 酒桶编号
     */
    @PostMapping("deleteFat")
    public ResponseResult deleteFat(String fatId){
        return fatService.deleteFat(fatId);
    }

    /**
     * 搜索酒桶
     */
    @GetMapping("searchFat")
    public ResponseResult searchFat(HttpServletRequest request){
        return fatService.searchFat(request);
    }
}
