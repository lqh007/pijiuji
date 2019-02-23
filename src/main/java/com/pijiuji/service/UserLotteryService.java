package com.pijiuji.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface UserLotteryService {

    /**
     * 修改兑换码的状态
     * @param request
     */
    void updateCdkey(HttpServletRequest request);

    Map<String,String> writeCdkey(HttpServletRequest request);

}
