package com.pijiuji.service;


import com.pijiuji.bean.ResponseResult;

public interface ProductService {

    ResponseResult<Object> findProductAll();

    ResponseResult<Object> findProductById(String systemNumber);
}
