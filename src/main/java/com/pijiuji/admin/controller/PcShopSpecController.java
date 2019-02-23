package com.pijiuji.admin.controller;

import com.pijiuji.admin.service.PcShopSpecService;
import com.pijiuji.bean.ResponseResult;
import com.pijiuji.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;

/**
 * 商家规格管理
 */
@Controller
@RequestMapping("/pcShopSpec")
public class PcShopSpecController {

    @Autowired
    private PcShopSpecService pcShopSpecServiceImpl;

    /**
     * 商家规格列表
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public ResponseResult<ArrayList<Object>> list(HttpServletRequest request){
        ResponseResult<ArrayList<Object>> result = null;
        try{
            ArrayList<Object> list = pcShopSpecServiceImpl.list(request);
            result = new ResponseResult<ArrayList<Object>>(200,"查询成功",list);
        }catch(ServiceException e){
            result = new ResponseResult<ArrayList<Object>>(500,e);
        }
        return result;
    }

    /**
     * 商家规格单条列表
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectShopSpec")
    public ResponseResult<Map<String,String>> selectShopSpec(HttpServletRequest request){
        ResponseResult<Map<String,String>> result = null;
        try{
            Map<String,String> list = pcShopSpecServiceImpl.selectShopSpec(request);
            result = new ResponseResult<Map<String,String>>(200,"查询成功",list);
        }catch(ServiceException e){
            result = new ResponseResult<Map<String,String>>(500,e);
        }
        return result;
    }

    /**
     * 商家规格单条修改
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public ResponseResult<Void> update(HttpServletRequest request){
        ResponseResult<Void> result = null;
        try{
            pcShopSpecServiceImpl.update(request);
            result = new ResponseResult<Void>(200,"修改成功");
        }catch(ServiceException e){
            result = new ResponseResult<Void>(500,e);
        }
        return result;
    }

}
