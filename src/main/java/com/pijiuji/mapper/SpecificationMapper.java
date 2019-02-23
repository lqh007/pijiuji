package com.pijiuji.mapper;

import com.pijiuji.bean.Specification;
import com.pijiuji.bean.SpecificationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SpecificationMapper {
    int countByExample(SpecificationExample example);

    int deleteByExample(SpecificationExample example);

    int deleteByPrimaryKey(String speId);

    /**
     * 删除商品对应的规格
     * @param productId
     * @return
     */
    int deleteSpeByProductId(String productId);

    /**
     * 根据机器的编号查询规格以及价格
     * @param pjjId
     * @return
     */
    Map<String, String> findSpecification(@Param("pjjId") String pjjId,@Param("speId") String speId);

    int insert(Specification record);

    int insertSelective(Specification record);

    List<Specification> selectByExample(SpecificationExample example);

    Specification selectByPrimaryKey(String speId);

    /**
     * 查询每个规格信息
     * @param specId
     * @return
     */
    Map<String, Object> selectSpec(String specId);

    /**
     * 根据商品id查询所有默认的规格及价格
     * @return
     */
    List<Map<String, String>> selectSpecificationAll(String productId);

    /**
     * 根据商品id查询出对应的规格
     * @param productId
     * @return
     */
    List<Specification> selectSpecificationByProductId(String productId);

    /**
     * 查询后台所有规格
     * @return
     */
    List<Map<String, Object>> selectSpecificationList();

    int updateByExampleSelective(@Param("record") Specification record, @Param("example") SpecificationExample example);

    int updateByExample(@Param("record") Specification record, @Param("example") SpecificationExample example);

    int updateByPrimaryKeySelective(Specification record);

    int updateByPrimaryKey(Specification record);
}