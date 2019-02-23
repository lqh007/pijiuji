package com.pijiuji.mapper;

import com.pijiuji.bean.Tixian;
import com.pijiuji.bean.TixianExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TixianMapper {
    int countByExample(TixianExample example);

    int deleteByExample(TixianExample example);

    int deleteByPrimaryKey(String txId);

    int insert(Tixian record);

    int insertSelective(Tixian record);

    List<Tixian> selectByExample(TixianExample example);

    Tixian selectByPrimaryKey(String txId);

    /**
     * 查询用户的提现列表
     * @param userId
     * @return
     */
    List<Map<String,Object>> selectTixianByUserId(String userId);

    int updateByExampleSelective(@Param("record") Tixian record, @Param("example") TixianExample example);

    int updateByExample(@Param("record") Tixian record, @Param("example") TixianExample example);

    int updateByPrimaryKeySelective(Tixian record);

    int updateByPrimaryKey(Tixian record);
}