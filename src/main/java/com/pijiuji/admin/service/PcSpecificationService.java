package com.pijiuji.admin.service;

import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface PcSpecificationService {

    /**
     * 添加规格
     * @param request
     */
    void add(HttpServletRequest request);

    /**
     * 删除规格
     * @param request
     */
    void delete(HttpServletRequest request);

    /**
     * 规格管理列表
     * @param request
     * @return
     */
    PageInfo<Map<String, Object>> list(HttpServletRequest request);

    /**
     * 查询每个规格的信息
     * @param request
     * @return
     */
    Map<String, Object> selectSpec(HttpServletRequest request);

    /**
     * 修改规格
     * @param request
     */
    void update(HttpServletRequest request);
}
