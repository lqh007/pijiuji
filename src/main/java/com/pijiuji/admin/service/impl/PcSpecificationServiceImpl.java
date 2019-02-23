package com.pijiuji.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pijiuji.admin.service.PcSpecificationService;
import com.pijiuji.bean.Pjj;
import com.pijiuji.bean.ShopSpecification;
import com.pijiuji.bean.Specification;
import com.pijiuji.mapper.PjjMapper;
import com.pijiuji.mapper.ShopSpecificationMapper;
import com.pijiuji.mapper.SpecificationMapper;
import com.pijiuji.service.exception.ServiceException;
import com.pijiuji.util.DateUtil;
import com.pijiuji.util.Param;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class PcSpecificationServiceImpl implements PcSpecificationService {

    @Autowired
    private SpecificationMapper specificationMapper;
    @Autowired
    private PjjMapper pjjMapper;
    @Autowired
    private ShopSpecificationMapper shopSpecificationMapper;

    /**
     * 添加规格
     * @param request
     */
    @Override
    public void add(HttpServletRequest request) {
        String productId = request.getParameter("productId");
        if (StringUtils.isEmpty(productId)) {
            throw new ServiceException("商品id不允许为空");
        }
        String specSize = request.getParameter("specSize");
        if(StringUtils.isEmpty(specSize)){
            throw new ServiceException("规格大小不允许为空");
        }
        String specPrice = request.getParameter("specPrice");
        if(StringUtils.isEmpty(specPrice)){
            throw new ServiceException("价格不允许为空");
        }
        //进行增加规格
        /**
         * TODO 添加规格的同时，也要为所有的啤酒机添加规格
         * TODO 当然，添加啤酒机的时候也要对应的添加上所有的规格
         */
        Specification specification = new Specification();
        specification.setSpeId(UUID.randomUUID().toString().replace("-",""));
        specification.setSpePrice(specPrice);
        specification.setSpeProId(productId);
        specification.setSpeSize(specSize);
        int i = specificationMapper.insertSelective(specification);
        if(i <= 0){
            throw new ServiceException("添加失败");
        }
        //查询所有的啤酒机
        List<Pjj> list = pjjMapper.selectPjjIdAll();
        for (Pjj pjj : list) {
            //为每一台啤酒机添加该规格
            ShopSpecification shopSpecification = new ShopSpecification();
            shopSpecification.setPjjId(pjj.getPjjId());
            shopSpecification.setPrice(specPrice);
            shopSpecification.setSpecId(specification.getSpeId());
            shopSpecification.setUpdateTime(DateUtil.getCurrentTimeS2());
            shopSpecificationMapper.insertSelective(shopSpecification);
        }
    }

    /**
     * 删除规格
     * @param request
     */
    @Override
    public void delete(HttpServletRequest request) {
        String specId = request.getParameter("specId");
        if(StringUtils.isEmpty(specId)){
            throw new ServiceException("规格id不允许为空");
        }
        Specification specification = specificationMapper.selectByPrimaryKey(specId);
        if(specification == null){
            throw new ServiceException("规格id错误");
        }
        int i = specificationMapper.deleteByPrimaryKey(specId);
        //TODO 需要删除对应的所有啤酒机对应的此规格
        shopSpecificationMapper.deleteBySpeId(specId);
        if(i <= 0){
            throw new ServiceException("删除失败");
        }
    }

    /**
     * 查询规格列表
     * @param request
     * @return
     */
    @Override
    public PageInfo<Map<String, Object>> list(HttpServletRequest request) {
        String page = request.getParameter("page");
        if(StringUtils.isEmpty(page)){
            page = "1";
        }
        PageHelper.startPage(Integer.valueOf(page), Param.pageSize);
        List<Map<String,Object>> list = specificationMapper.selectSpecificationList();
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(list);
        return pageInfo;
    }

    /**
     * 查询每个规格的信息
     * @param request
     * @return
     */
    @Override
    public Map<String, Object> selectSpec(HttpServletRequest request) {
        String specId = request.getParameter("specId");
        if(StringUtils.isEmpty(specId)){
            throw new ServiceException("规格id错误");
        }
        Map<String, Object> map = specificationMapper.selectSpec(specId);
        return map;
    }

    /**
     * 修改规格
     * @param request
     */
    @Override
    public void update(HttpServletRequest request) {
        String speId = request.getParameter("speId");
        if (StringUtils.isEmpty(speId)) {
            throw new ServiceException("规格id不允许为空");
        }
        String productId = request.getParameter("productId");
        if (StringUtils.isEmpty(productId)) {
            throw new ServiceException("商品id不允许为空");
        }
        String specSize = request.getParameter("specSize");
        if(StringUtils.isEmpty(specSize)){
            throw new ServiceException("规格大小不允许为空");
        }
        String specPrice = request.getParameter("specPrice");
        if(StringUtils.isEmpty(specPrice)){
            throw new ServiceException("价格不允许为空");
        }
        Specification specification = specificationMapper.selectByPrimaryKey(speId);
        specification.setSpeSize(specSize);
        specification.setSpeProId(productId);
        specification.setSpePrice(specPrice);
        int i = specificationMapper.updateByPrimaryKeySelective(specification);
        if(i <= 0){
            throw new ServiceException("修改失败");
        }
    }
}
