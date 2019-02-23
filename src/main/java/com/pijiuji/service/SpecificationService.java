package com.pijiuji.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 规格接口类
 * @author lenovo
 */
public interface SpecificationService {

    /**
     * 查询是否够出酒
     * @param request
     */
    void findIsChu(HttpServletRequest request);

    /**
     * 查询规格
     * @param request
     * @return
     */
    List<Map<String,String>> findSpecification(HttpServletRequest request);

    /**
     * 查询公众号端的商品规格
     * @param request
     * @return
     */
    List<Map<String, String>> findWxSpecification(HttpServletRequest request);
}
