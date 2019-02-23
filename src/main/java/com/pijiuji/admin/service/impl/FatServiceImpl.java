package com.pijiuji.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pijiuji.admin.service.FatService;
import com.pijiuji.bean.Fat;
import com.pijiuji.bean.FatExample;
import com.pijiuji.bean.Product;
import com.pijiuji.bean.ResponseResult;
import com.pijiuji.mapper.FatMapper;
import com.pijiuji.mapper.ProductMapper;
import com.pijiuji.util.Param;
import com.sun.org.apache.bcel.internal.generic.FADD;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class FatServiceImpl implements FatService {

    @Autowired
    private FatMapper fatMapper;


    @Autowired
    private ProductMapper productMapper;
    @Override
    public ResponseResult findAllFat(HttpServletRequest request) {
        String page = request.getParameter("page");
        if (StringUtils.isEmpty(page)) {
            page = "1";
        }
        PageHelper.startPage(Integer.valueOf(page), Param.pageSize);
        FatExample fatExample = new FatExample();
        fatExample.createCriteria();
        List<Fat> fats = fatMapper.selectByExample(fatExample);
        for (int i = 0; i < fats.size(); i++) {
            String fatStatus = fats.get(i).getFatStatus();
            if ("0".equals(fatStatus)) {
                fats.get(i).setFatStatus("未使用");
            }else if ("1".equals(fatStatus)) {
                fats.get(i).setFatStatus("已使用");
            }
            String fatProductId = fats.get(i).getFatProductId();
            Product product = productMapper.selectByPrimaryKey(fatProductId);
            fats.get(i).setFatProductId(product.getProductName());
        }
        //查询所有的酒桶
        PageInfo pageInfo = new PageInfo(fats);
        return new ResponseResult(200,"查询成功",pageInfo);
    }

    @Override
    public ResponseResult saveFat(Fat fat) {
        if (StringUtils.isEmpty(fat.getFatNum())) {
            return new ResponseResult(500,"酒桶容量不能为空");
        }
        if (StringUtils.isEmpty(fat.getFatProductId())) {
            return new ResponseResult(500,"商品id不能为空");
        }
        if (StringUtils.isEmpty(fat.getFatId())) {
            return new ResponseResult(500,"酒桶编号不能为空");
        }
       fat.setFatStatus("0");
        int i = fatMapper.insertSelective(fat);
        if (i > 0) {
            return new ResponseResult(200,"添加成功");
        }

        return new ResponseResult(500,"添加失败");
    }

    @Override
    public ResponseResult updateFat(Fat fat) {
        if (StringUtils.isEmpty(fat.getFatId())) {
            return new ResponseResult(500,"酒桶编号不能为空");
        }
        int i = fatMapper.updateByPrimaryKeySelective(fat);
        if (i > 0) {
            return new ResponseResult(200,"修改成功");
        }
        return new ResponseResult(500,"修改失败");
    }

    @Override
    public ResponseResult deleteFat(String fatId) {
        if (StringUtils.isEmpty(fatId)) {
            return new ResponseResult(500,"酒桶编号不能为空");
        }
        int i = fatMapper.deleteByPrimaryKey(fatId);
        if (i > 0 ){
            return new ResponseResult(200,"删除成功");
        }

        return new ResponseResult(500,"删除失败");
    }
}
