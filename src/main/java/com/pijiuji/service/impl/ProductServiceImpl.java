package com.pijiuji.service.impl;

import com.pijiuji.bean.*;
import com.pijiuji.mapper.ProPjjMapper;
import com.pijiuji.mapper.ProductMapper;
import com.pijiuji.mapper.VideoMapper;
import com.pijiuji.service.ProductService;
import com.pijiuji.service.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Value("${lottery.url}")
    private String address;
    @Autowired
    private ProPjjMapper proPjjMapper;
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public ResponseResult<Object> findProductAll() {
        Map result = new HashMap();
        List<Product> products =  productMapper.findProductAll();
        for (int i = 0; i < products.size(); i++) {
            String url = address + products.get(i).getProductUrl();
            System.err.println(url);
            products.get(i).setProductUrl(url);
        }
        result.put("products",products);
        return new ResponseResult<>(200,"查询成功",result);
    }

    /**
     * 查询商品和视频
     * @param systemNumber 机器编号
     * @return
     */
    @Override
    public ResponseResult<Object> findProductById(String systemNumber) {
        if(StringUtils.isEmpty(systemNumber)){
            return new ResponseResult<>(500,"机器编号不允许为空");
        }
        Map result = new HashMap();
        //查询每个机器下的商品
        ProPjjExample proPjjExample = new ProPjjExample();
        ProPjjExample.Criteria criteria = proPjjExample.createCriteria();
        criteria.andPropjjPjjCodeEqualTo(systemNumber);
        List<ProPjj> proPjjs = proPjjMapper.selectByExample(proPjjExample);
        List<Product> products = new ArrayList<>();
        for (ProPjj proPjj : proPjjs) {
            String productId = proPjj.getPropjjPjjProid();
            Product product = productMapper.selectByPrimaryKey(productId);
            if (product != null) {
                products.add(product);
                for (int i = 0; i < products.size(); i++) {
                    products.get(i).setProductUrl(address+products.get(i).getProductUrl());
                }
            }
        }
        //查询视频
      String videoUrl =  productMapper.findVideo();
      if (StringUtils.isNotBlank(videoUrl)) {
          result.put("videoUrl",address + videoUrl);
      }else {
          return new ResponseResult<>(500,"没有视频");
      }
      if (products != null && products.size() > 0) {
          result.put("products",products);
      }else{
          return new ResponseResult<>(500,"商品不能为空");
      }
        if (StringUtils.isEmpty(systemNumber)) {
            throw new ServiceException("参数错误");
        }
           return new ResponseResult<>(200,"查询成功",result);
    }

}
