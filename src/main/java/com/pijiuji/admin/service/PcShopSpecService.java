package com.pijiuji.admin.service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;

public interface PcShopSpecService {

    /**
     * 商家规格管理列表
     * @param request
     * @return
     */
    ArrayList<Object> list(HttpServletRequest request);

    /**
     * 商家规格单条查询
     * @param request
     * @return
     */
    Map<String, String> selectShopSpec(HttpServletRequest request);

    /**
     * 商家规格修改
     * @param request
     */
    void update(HttpServletRequest request);
}
