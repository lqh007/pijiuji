package com.pijiuji.mapper;

import com.pijiuji.bean.ProPjj;
import com.pijiuji.bean.ProPjjExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProPjjMapper {
    int countByExample(ProPjjExample example);

    int deleteByExample(ProPjjExample example);

    int deleteByPrimaryKey(String propjjId);

    int insert(ProPjj record);

    int insertSelective(ProPjj record);

    List<ProPjj> selectByExample(ProPjjExample example);

    ProPjj selectByPrimaryKey(String propjjId);

    int updateByExampleSelective(@Param("record") ProPjj record, @Param("example") ProPjjExample example);

    int updateByExample(@Param("record") ProPjj record, @Param("example") ProPjjExample example);

    int updateByPrimaryKeySelective(ProPjj record);

    int updateByPrimaryKey(ProPjj record);
}