package com.pijiuji.mapper;

import com.pijiuji.bean.UserPjj;
import com.pijiuji.bean.UserPjjExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserPjjMapper {
    int countByExample(UserPjjExample example);

    int deleteByExample(UserPjjExample example);

    int deleteByPrimaryKey(String pjjId);

    int insert(UserPjj record);

    int insertSelective(UserPjj record);

    List<UserPjj> selectByExample(UserPjjExample example);

    UserPjj selectByPrimaryKey(String pjjId);

    /**
     * 查询上级所拥有的啤酒机
     * @param levelUserId
     * @return
     */
    List<UserPjj> selectUserPjj(String levelUserId);

    int updateByExampleSelective(@Param("record") UserPjj record, @Param("example") UserPjjExample example);

    int updateByExample(@Param("record") UserPjj record, @Param("example") UserPjjExample example);

    int updateByPrimaryKeySelective(UserPjj record);

    int updateByPrimaryKey(UserPjj record);

    /**
     * 修改啤酒机地址
     * @param pjjCode
     * @param address
     * @return
     */
    int updateUserPjjAddress(@Param("pjjId") String pjjCode,@Param("address") String address);
}