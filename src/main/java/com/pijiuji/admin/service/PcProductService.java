package com.pijiuji.admin.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface PcProductService {

    /**
     * 添加商品
     * @param request
     */
    void add(HttpServletRequest request);

    /**
     * 删除商品
     * @param request
     */
    void delete(HttpServletRequest request);

    /**
     * 查询商品
     * @param request
     * @return
     */
    List<Map<String, Object>> list(HttpServletRequest request);

    /**
     * 查询单独的每个商品信息
     * @param request
     * @return
     */
    Map<String, Object> selectProduct(HttpServletRequest request);

    /**
     * 修改商品
     * @param request
     */
    void update(HttpServletRequest request);

    /**
     * 商品的上下架修改
     * @param request
     */
    void updateStatus(HttpServletRequest request);
}
