package com.pijiuji.controller;

import com.pijiuji.bean.ResponseResult;
import com.pijiuji.service.SpecificationService;
import com.pijiuji.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 规格Controller
 * @author lenovo
 */
@Controller
@RequestMapping("/specification")
public class SpecificationController {

    @Autowired
    private SpecificationService specificationServiceImpl;

    /**
     * 查询商品的规格
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/findSpecification")
    public ResponseResult<List<Map<String,String>>> findSpecification(HttpServletRequest request){
        ResponseResult<List<Map<String,String>>> response = null;
        try{
            List<Map<String,String>> map = specificationServiceImpl.findSpecification(request);
            response = new ResponseResult<List<Map<String,String>>>(200,"查询成功",map);
        }catch (ServiceException e){
            response = new ResponseResult<List<Map<String,String>>>(500,e.getMessage());
        }
        return response;
    }

    /**
     * 查询剩余容量是否够
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/findIsChu")
    public ResponseResult<Void> findIsChu(HttpServletRequest request){
        ResponseResult<Void> response = null;
        try{
            specificationServiceImpl.findIsChu(request);
            response = new ResponseResult<Void>(200,"正常");
        }catch (ServiceException e){
            response = new ResponseResult<Void>(500,e.getMessage());
        }
        return response;
    }

    /**
     * 公众号查询商品的规格
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/findWxSpecification")
    public ResponseResult<List<Map<String,String>>> findWxSpecification(HttpServletRequest request){
        ResponseResult<List<Map<String,String>>> response = null;
        try{
            List<Map<String,String>> map = specificationServiceImpl.findWxSpecification(request);
            response = new ResponseResult<List<Map<String,String>>>(200,"查询成功",map);
        }catch (ServiceException e){
            response = new ResponseResult<List<Map<String,String>>>(500,e.getMessage());
        }
        return response;
    }

}
