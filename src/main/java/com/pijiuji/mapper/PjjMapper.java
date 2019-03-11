package com.pijiuji.mapper;

import com.pijiuji.bean.Pjj;
import com.pijiuji.bean.PjjExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PjjMapper {
    int countByExample(PjjExample example);

    int deleteByExample(PjjExample example);

    int deleteByPrimaryKey(Integer pjjId);

    int insert(Pjj record);

    int insertSelective(Pjj record);

    List<Pjj> selectByExample(PjjExample example);

    /**
     * 查询啤酒机的id
     * @param pjjId
     * @return
     */
    Pjj selectByPjjId(String pjjId);

    Pjj selectByPrimaryKey(Integer pjjId);

    /**
     * 查询所有的啤酒机
     * @return
     */
    List<Pjj> selectPjjIdAll();

    int updateByExampleSelective(@Param("record") Pjj record, @Param("example") PjjExample example);

    int updateByExample(@Param("record") Pjj record, @Param("example") PjjExample example);

    int updateByPrimaryKeySelective(Pjj record);

    int updateByPrimaryKey(Pjj record);

    /**
     * 修改啤酒机地址
     * @param pjjCode
     * @param address
     * @return
     */
    int updatePjjAddress(@Param("pjjCode") String pjjCode,@Param("pjjAddress") String address);

    List<Pjj> searchPjj(Pjj pjj);
}