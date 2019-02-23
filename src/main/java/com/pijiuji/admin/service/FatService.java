package com.pijiuji.admin.service;

import com.pijiuji.bean.Fat;
import com.pijiuji.bean.ResponseResult;

import javax.servlet.http.HttpServletRequest;

public interface FatService {
    /**
     * 查询所有酒桶列表
     * @param request
     * @return
     */
    ResponseResult findAllFat(HttpServletRequest request);

    /**
     * 增加酒桶
     * @param fat
     * @return
     */
    ResponseResult saveFat(Fat fat);

    /**
     * 修改酒桶
     * @param fat
     * @return
     */
    ResponseResult updateFat(Fat fat);

    /**
     * 删除酒桶
     * @param fatId
     * @return
     */
    ResponseResult deleteFat(String fatId);
}
