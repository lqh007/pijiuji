package com.pijiuji.service;

import com.github.sd4324530.fastweixin.api.config.ApiConfig;

import java.util.List;
import java.util.Map;

/**
 * 抽奖service
 */
public interface LotteryService {

    /**
     * 点击抽奖
      * @return
     */
    Map<String, Object> findLottery();

    /**
     * 绑定信息
     * @param code
     * @param state
     */
    void getUserInfo(ApiConfig apiConfig, String code, String state);

    /**
     * 查询所有奖品
     * @return
     */
    List<Map<String,Object>> select();

}
