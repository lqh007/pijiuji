package com.pijiuji.mapper;

import com.pijiuji.bean.ShopSpecification;
import com.pijiuji.bean.ShopSpecificationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ShopSpecificationMapper {
    int countByExample(ShopSpecificationExample example);

    int deleteByExample(ShopSpecificationExample example);

    int deleteByPrimaryKey(Integer id);

    /**
     * 根据规格id删除所有啤酒机对应的规格
     * @param specId
     */
    void deleteBySpeId(String specId);

    int insert(ShopSpecification record);

    int insertSelective(ShopSpecification record);

    List<ShopSpecification> selectByExample(ShopSpecificationExample example);

    ShopSpecification selectByPrimaryKey(Integer id);

    /**
     * 查询商家单条规格信息
     * @param id
     * @return
     */
    Map<String, String> selectMessageById(String id);

    /**
     * 根据啤酒机id查询商家自己管理的啤酒机规格
     * @param pjjId
     * @return
     */
    List<Map<String, Object>> selectSpecByPjjId(Integer pjjId);

    int updateByExampleSelective(@Param("record") ShopSpecification record, @Param("example") ShopSpecificationExample example);

    int updateByExample(@Param("record") ShopSpecification record, @Param("example") ShopSpecificationExample example);

    int updateByPrimaryKeySelective(ShopSpecification record);

    int updateByPrimaryKey(ShopSpecification record);
}