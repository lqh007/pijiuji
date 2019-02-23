package com.pijiuji.controller;

import com.pijiuji.bean.ResponseResult;
import com.pijiuji.service.ProductService;
import com.pijiuji.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("product")
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 查询所有商品
     * @param systemNumber
     * @return
     */
    @RequestMapping("findProduct")
    @ResponseBody
    public ResponseResult<Object> findProduct(String systemNumber) {
        ResponseResult<Object> result = null;
        try {
            //判断系统编号为不为空
            result = productService.findProductById(systemNumber);
        } catch (ServiceException e) {
            result = new ResponseResult<>(500, e.getMessage());
        }
        return result;
    }

    /**
     * 查询商品
     * @return
     */
    @RequestMapping("findProductAll")
    @ResponseBody
    public ResponseResult<Object> findProductAll() {
        ResponseResult<Object> result = null;
        try {
            result = productService.findProductAll();
        } catch (ServiceException e) {
            result = new ResponseResult<>(500, e.getMessage());
        }
        return result;
    }
}
