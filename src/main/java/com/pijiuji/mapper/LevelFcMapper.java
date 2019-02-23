package com.pijiuji.mapper;

import com.pijiuji.bean.LevelFc;
import com.pijiuji.bean.LevelFcExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LevelFcMapper {
    int countByExample(LevelFcExample example);

    int deleteByExample(LevelFcExample example);

    int deleteByPrimaryKey(Integer fcId);

    int insert(LevelFc record);

    int insertSelective(LevelFc record);

    List<LevelFc> selectByExample(LevelFcExample example);

    /**
     * 根据用户级别搜索分成
     * @param levelUserLevel
     * @return
     */
    LevelFc selectByLevelId(String levelUserLevel);

    LevelFc selectByPrimaryKey(Integer fcId);

    int updateByExampleSelective(@Param("record") LevelFc record, @Param("example") LevelFcExample example);

    int updateByExample(@Param("record") LevelFc record, @Param("example") LevelFcExample example);

    int updateByPrimaryKeySelective(LevelFc record);

    int updateByPrimaryKey(LevelFc record);
}