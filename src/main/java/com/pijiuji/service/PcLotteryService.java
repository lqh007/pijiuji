package com.pijiuji.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface PcLotteryService {

    /**
     * 查询所有奖品
     * @return
     */
    List<Map<String,Object>> selectLotteryAll();

    /**
     * 修改奖品
     * @param request
     */
    void updateLottery(HttpServletRequest request);
}
