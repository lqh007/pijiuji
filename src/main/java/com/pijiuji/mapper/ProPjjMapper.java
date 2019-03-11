package com.pijiuji.mapper;

import com.pijiuji.bean.ProPjj;
import com.pijiuji.bean.ProPjjExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProPjjMapper {
    int countByExample(ProPjjExample example);

    int deleteByExample(ProPjjExample example);

    int deleteByPrimaryKey(String propjjId);

    /**
     * 删除啤酒机所展示的商品
     * @param pjjCode
     */
    void deletePjjProductByPjjCode(String pjjCode);

    int insert(ProPjj record);

    int insertSelective(ProPjj record);

    List<ProPjj> selectByExample(ProPjjExample example);

    ProPjj selectByPrimaryKey(String propjjId);

    /**
     * 查询啤酒机上展示的商品
     * @param pjjCode
     * @return
     */
    List<Map<String, String>> selectPjjProductByPjjCode(String pjjCode);

    int updateByExampleSelective(@Param("record") ProPjj record, @Param("example") ProPjjExample example);

    int updateByExample(@Param("record") ProPjj record, @Param("example") ProPjjExample example);

    int updateByPrimaryKeySelective(ProPjj record);

    int updateByPrimaryKey(ProPjj record);
}