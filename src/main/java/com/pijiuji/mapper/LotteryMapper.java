package com.pijiuji.mapper;

import com.pijiuji.bean.Lottery;
import com.pijiuji.bean.LotteryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface LotteryMapper {
    int countByExample(LotteryExample example);

    int deleteByExample(LotteryExample example);

    int deleteByPrimaryKey(Integer lotteryId);

    int insert(Lottery record);

    int insertSelective(Lottery record);

    /**
     * 查询所有奖品
     * @return
     */
    List<Map<String, Object>> select();

    /**
     * 查询优惠卷信息
     * @param s
     * @return
     */
    Lottery selectByCdKey(String s);

    List<Lottery> selectByExample(LotteryExample example);

    Lottery selectByPrimaryKey(Integer lotteryId);

    /**
     * 查询所有的奖品
     * @return
     */
    List<Map<String, Object>> selectLotteryAll();

    int updateByExampleSelective(@Param("record") Lottery record, @Param("example") LotteryExample example);

    int updateByExample(@Param("record") Lottery record, @Param("example") LotteryExample example);

    int updateByPrimaryKeySelective(Lottery record);

    int updateByPrimaryKey(Lottery record);
}