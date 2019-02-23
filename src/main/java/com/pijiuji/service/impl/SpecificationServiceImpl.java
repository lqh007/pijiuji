package com.pijiuji.service.impl;

import com.pijiuji.bean.*;
import com.pijiuji.mapper.*;
import com.pijiuji.service.SpecificationService;
import com.pijiuji.service.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 规格接口实现类
 *
 * @author lenovo
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private FatMapper fatMapper;
    @Autowired
    private LevelUserMapper levelUserMapper;
    @Autowired
    private ShopSpecificationMapper shopSpecificationMapper;
    @Autowired
    private SpecificationMapper specificationMapper;
    @Autowired
    private UserPjjMapper userPjjMapper;
    @Autowired
    private PjjMapper pjjMapper;

    /**
     * 查询是否够出酒
     *
     * @param request
     */
    @Override
    public void findIsChu(HttpServletRequest request) {
        String specId = request.getParameter("specId");
        if (StringUtils.isEmpty(specId)) {
            throw new ServiceException("机器id错误");
        }
        String productId = request.getParameter("productId");
        if (StringUtils.isEmpty(productId)) {
            throw new ServiceException("商品id错误");
        }
        String productSize = request.getParameter("productSize");
        if (StringUtils.isEmpty(productSize)) {
            throw new ServiceException("规格错误");
        }
        UserPjj userPjj = userPjjMapper.selectByPrimaryKey(specId);
        Fat fat = fatMapper.selectByPrimaryKey(userPjj.getPjjJiuCode());
        if (!fat.getFatProductId().equals(productId)) {
            Fat fat2 = fatMapper.selectByPrimaryKey(userPjj.getPjjJiuCodes());
            if (Double.valueOf(fat2.getFatNum()) < Double.valueOf(productSize)) {
                throw new ServiceException("酒容量不足,请联系工作人员更换酒桶");
            }
        } else {
            if (Double.valueOf(fat.getFatNum()) < Double.valueOf(productSize)) {
                throw new ServiceException("酒容量不足,请联系工作人员更换酒桶");
            }
        }
    }

    /**
     * 查询商品的规格
     *
     * @param request
     * @return
     */
    @Override
    public List<Map<String, String>> findSpecification(HttpServletRequest request) {
        String pjjId = request.getParameter("pjjId");
        if (StringUtils.isEmpty(pjjId)) {
            throw new ServiceException("机器编号不允许为空");
        }
        String productId = request.getParameter("productId");
        if (StringUtils.isEmpty(productId)) {
            throw new ServiceException("啤酒不允许为空");
        }
        //查询啤酒机的id
        Pjj p = pjjMapper.selectByPjjId(pjjId);
        ArrayList<Map<String, String>> maps = new ArrayList<>();
        //根据啤酒id查询出所有对应的规格的id
        List<Specification> specificationIds = specificationMapper.selectSpecificationByProductId(productId);
        for (Specification specificationId : specificationIds) {
            String speId = specificationId.getSpeId();
            Map<String, String> map = specificationMapper.findSpecification(p.getPjjId().toString(),speId);
            maps.add(map);
        }
        return maps;
    }

    /**
     * 查询公众号段商品规格
     * @param request
     * @return
     */
    @Override
    public List<Map<String, String>> findWxSpecification(HttpServletRequest request) {
        String employeeId = request.getParameter("employeeId");
        if (StringUtils.isEmpty(employeeId)) {
            throw new ServiceException("员工编号不允许为空");
        }
        String productId = request.getParameter("productId");
        if (StringUtils.isEmpty(productId)) {
            throw new ServiceException("商品id不允许为空");
        }
        LevelUser levelUser = levelUserMapper.selectByPrimaryKey(employeeId);
        if (levelUser == null) {
            throw new ServiceException("编号错误");
        }
        if (StringUtils.isNotEmpty(levelUser.getLevelUserParentOpenid())){
            //获取上级
            LevelUser levelUser1 = levelUserMapper.selectParent(levelUser.getLevelUserParentOpenid());
            List<UserPjj> list = userPjjMapper.selectUserPjj(levelUser1.getLevelUserId());
            if (list != null && list.size() > 0) {
                ArrayList<Map<String, String>> maps = new ArrayList<>();
                //获取机器编号
                String pjjId = list.get(0).getPjjId();
                //根据啤酒id查询出所有对应的规格的id
                List<Specification> specificationIds = specificationMapper.selectSpecificationByProductId(productId);
                for (Specification specificationId : specificationIds) {
                    String speId = specificationId.getSpeId();
                    Map<String, String> map = specificationMapper.findSpecification(pjjId,speId);
                    maps.add(map);
                }
                return maps;
            } else {
                List<Map<String, String>> li = specificationMapper.selectSpecificationAll(productId);
                return li;
            }
        }
        List<Map<String, String>> li = specificationMapper.selectSpecificationAll(productId);
        return li;
    }
}
