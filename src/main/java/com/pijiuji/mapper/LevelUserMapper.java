package com.pijiuji.mapper;

import com.pijiuji.bean.LevelUser;
import com.pijiuji.bean.LevelUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface LevelUserMapper {
    int countByExample(LevelUserExample example);

    int deleteByExample(LevelUserExample example);

    int deleteByPrimaryKey(String levelUserId);

    /**
     * 根据员工编号查询员工
     * @param orderEmployeeId
     * @return
     */
    LevelUser findEmployeeById(String orderEmployeeId);

    int insert(LevelUser record);

    int insertSelective(LevelUser record);

    List<LevelUser> selectByExample(LevelUserExample example);

    LevelUser selectByPrimaryKey(String levelUserId);

    /**
     * 查询下级代理人数
     * @param userOpenid
     * @return
     */
    Integer selectChildLevelUser(String userOpenid);

    /**
     * 根据用户微信的openid查询用户
     * @param openid
     * @return
     */
    LevelUser selectIsLevelUser(String openid);

    /**
     * 查询用户上级
     * @param parentName
     * @param parentPhone
     * @return
     */
    LevelUser selectLevelUserByParam(@Param("parentName") String parentName, @Param("parentPhone") String parentPhone);

    /**
     * 根据员工上级标识查询用户
     * @param levelUserParentOpenid
     * @return
     */
    LevelUser selectParent(String levelUserParentOpenid);

    int updateByExampleSelective(@Param("record") LevelUser record, @Param("example") LevelUserExample example);

    int updateByExample(@Param("record") LevelUser record, @Param("example") LevelUserExample example);

    int updateByPrimaryKeySelective(LevelUser record);

    int updateByPrimaryKey(LevelUser record);

    List<LevelUser> searchLevelUser(Map param);
}