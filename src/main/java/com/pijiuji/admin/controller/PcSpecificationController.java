package com.pijiuji.admin.controller;

import com.github.pagehelper.PageInfo;
import com.pijiuji.admin.service.PcSpecificationService;
import com.pijiuji.bean.ResponseResult;
import com.pijiuji.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 规格管理
 */
@Controller
@RequestMapping("/pcspec")
public class PcSpecificationController {

    @Autowired
    private PcSpecificationService pcSpecificationServiceImpl;

    /**
     * 规格列表
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public ResponseResult<PageInfo<Map<String,Object>>> list(HttpServletRequest request){
        ResponseResult<PageInfo<Map<String,Object>>> result = null;
        try{
            PageInfo<Map<String,Object>> list = pcSpecificationServiceImpl.list(request);
            result = new ResponseResult<PageInfo<Map<String,Object>>>(200,"查询成功",list);
        }catch(ServiceException e){
            result = new ResponseResult<PageInfo<Map<String,Object>>>(500,e);
        }
        return result;
    }

    /**
     * 添加规格
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public ResponseResult<Void> add(HttpServletRequest request){
        ResponseResult<Void> result = null;
        try{
            pcSpecificationServiceImpl.add(request);
            result = new ResponseResult<Void>(200,"添加成功");
        }catch(ServiceException e){
            result = new ResponseResult<Void>(500,e);
        }
        return result;
    }

    /**
     * 每个规格信息的查询
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectSpec")
    public ResponseResult<Map<String,Object>> selectSpec(HttpServletRequest request){
        ResponseResult<Map<String,Object>> result = null;
        try{
            Map<String,Object> map = pcSpecificationServiceImpl.selectSpec(request);
            result = new ResponseResult<Map<String,Object>>(200,"查询成功",map);
        }catch(ServiceException e){
            result = new ResponseResult<Map<String,Object>>(500,e);
        }
        return result;
    }

    /**
     * 修改规格
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public ResponseResult<Void> update(HttpServletRequest request){
        ResponseResult<Void> result = null;
        try{
            pcSpecificationServiceImpl.update(request);
            result = new ResponseResult<Void>(200,"修改成功");
        }catch(ServiceException e){
            result = new ResponseResult<Void>(500,e);
        }
        return result;
    }

    /**
     * 删除规格
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public ResponseResult<Void> delete(HttpServletRequest request){
        ResponseResult<Void> result = null;
        try{
            pcSpecificationServiceImpl.delete(request);
            result = new ResponseResult<Void>(200,"删除成功");
        }catch(ServiceException e){
            result = new ResponseResult<Void>(500,e);
        }
        return result;
    }

}
