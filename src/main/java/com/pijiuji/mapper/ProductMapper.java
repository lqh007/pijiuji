package com.pijiuji.mapper;

import com.pijiuji.bean.Product;
import com.pijiuji.bean.ProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductMapper {
    int countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(String productId);

    /**
     * 查询所有商品
     * @return
     */
    List<Product> findProductAll();

    String findVideo();

    int insert(Product record);

    int insertSelective(Product record);

    /**
     * 查询商品
     * @return
     */
    List<Map<String, Object>> selectAll();

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(String productId);

    /**
     * 查询每个商品的信息
     * @param productId
     * @return
     */
    Map<String, Object> selectProduct(String productId);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}