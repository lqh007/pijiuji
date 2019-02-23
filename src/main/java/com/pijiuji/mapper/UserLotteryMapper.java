package com.pijiuji.mapper;

import com.pijiuji.bean.UserLottery;
import com.pijiuji.bean.UserLotteryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserLotteryMapper {
    int countByExample(UserLotteryExample example);

    int deleteByExample(UserLotteryExample example);

    int deleteByPrimaryKey(String ulId);

    /**
     * 根据兑换码查询是否有该奖品
     * @param cdkey
     * @return
     */
    UserLottery findUserLottery(String cdkey);

    int insert(UserLottery record);

    int insertSelective(UserLottery record);

    List<UserLottery> selectByExample(UserLotteryExample example);

    UserLottery selectByPrimaryKey(String ulId);

    /**
     * 查询奖品是否被绑定
     * @param s
     * @return
     */
    Integer selectUserIsLottery(String s);

    int updateByExampleSelective(@Param("record") UserLottery record, @Param("example") UserLotteryExample example);

    int updateByExample(@Param("record") UserLottery record, @Param("example") UserLotteryExample example);

    int updateByPrimaryKeySelective(UserLottery record);

    int updateByPrimaryKey(UserLottery record);
}