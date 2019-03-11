package com.pijiuji.mapper;

import com.pijiuji.bean.Fat;
import com.pijiuji.bean.FatExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FatMapper {
    int countByExample(FatExample example);

    int deleteByExample(FatExample example);

    int deleteByPrimaryKey(String fatId);

    int insert(Fat record);

    int insertSelective(Fat record);

    List<Fat> selectByExample(FatExample example);

    Fat selectByPrimaryKey(String fatId);

    int updateByExampleSelective(@Param("record") Fat record, @Param("example") FatExample example);

    int updateByExample(@Param("record") Fat record, @Param("example") FatExample example);

    int updateByPrimaryKeySelective(Fat record);

    int updateByPrimaryKey(Fat record);

    List<Fat> searchFat(Fat fat);
}