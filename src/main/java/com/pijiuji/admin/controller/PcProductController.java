package com.pijiuji.admin.controller;

import com.pijiuji.admin.service.PcProductService;
import com.pijiuji.bean.ResponseResult;
import com.pijiuji.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 商品管理
 */
@Controller
@RequestMapping("/pcproduct")
public class PcProductController {

    @Autowired
    private PcProductService pcProductServiceImpl;

    /**
     * 商品列表
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public ResponseResult<List<Map<String,Object>>> list(HttpServletRequest request){
        ResponseResult<List<Map<String,Object>>> result = null;
        try{
            List<Map<String,Object>> list = pcProductServiceImpl.list(request);
            result = new ResponseResult<List<Map<String,Object>>>(200,"查询成功",list);
        }catch(ServiceException e){
            result = new ResponseResult<List<Map<String,Object>>>(500,e);
        }
        return result;
    }

    /**
     * 查询单独的每个商品
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectProduct")
    public ResponseResult<Map<String,Object>> selectProduct(HttpServletRequest request){
        ResponseResult<Map<String,Object>> result = null;
        try{
            Map<String,Object> list = pcProductServiceImpl.selectProduct(request);
            result = new ResponseResult<Map<String,Object>>(200,"查询成功",list);
        }catch(ServiceException e){
            result = new ResponseResult<Map<String,Object>>(500,e);
        }
        return result;
    }

    /**
     * 添加商品
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public ResponseResult<Void> add(HttpServletRequest request){
        ResponseResult<Void> result = null;
        try{
            pcProductServiceImpl.add(request);
            result = new ResponseResult<Void>(200,"添加成功,请添加该商品规格");
        }catch(ServiceException e){
            result = new ResponseResult<Void>(500,e);
        }
        return result;
    }

    /**
     * 修改商品
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public ResponseResult<Void> update(HttpServletRequest request){
        ResponseResult<Void> result = null;
        try{
            pcProductServiceImpl.update(request);
            result = new ResponseResult<Void>(200,"修改成功");
        }catch(ServiceException e){
            result = new ResponseResult<Void>(500,e);
        }
        return result;
    }

    /**
     * 修改商品状态
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateStatus")
    public ResponseResult<Void> updateStatus(HttpServletRequest request){
        ResponseResult<Void> result = null;
        try{
            pcProductServiceImpl.updateStatus(request);
            if(request.getParameter("status").equals("0")){
                result = new ResponseResult<Void>(200,"上架成功");
            }else{
                result = new ResponseResult<Void>(200,"下架成功");
            }
        }catch(ServiceException e){
            result = new ResponseResult<Void>(500,e);
        }
        return result;
    }

    /**
     * 删除商品
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public ResponseResult<Void> delete(HttpServletRequest request){
        ResponseResult<Void> result = null;
        try{
            pcProductServiceImpl.delete(request);
            result = new ResponseResult<Void>(200,"删除成功");
        }catch(ServiceException e){
            result = new ResponseResult<Void>(500,e);
        }
        return result;
    }

}
