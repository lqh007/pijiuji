package com.pijiuji.admin.service.impl;

import com.pijiuji.admin.service.PcShopSpecService;
import com.pijiuji.bean.Pjj;
import com.pijiuji.bean.ShopSpecification;
import com.pijiuji.bean.UserPjj;
import com.pijiuji.mapper.PjjMapper;
import com.pijiuji.mapper.ShopSpecificationMapper;
import com.pijiuji.mapper.UserPjjMapper;
import com.pijiuji.service.exception.ServiceException;
import com.pijiuji.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PcShopSpecServiceImpl implements PcShopSpecService {

    @Autowired
    private UserPjjMapper userPjjMapper;
    @Autowired
    private PjjMapper pjjMapper;
    @Autowired
    private ShopSpecificationMapper shopSpecificationMapper;

    /**
     * 商家规格管理列表
     * @param request
     * @return
     */
    @Override
    public ArrayList<Object> list(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        if(StringUtils.isEmpty(userId)){
            throw new ServiceException("用户id不允许为空");
        }
        ArrayList<Object> objects = new ArrayList<>();
        //TODO 交给陈哥去分页吧。。。这里实在实现不了分页
        //查询用户所有的啤酒机
        List<UserPjj> userPjjs = userPjjMapper.selectUserPjj(userId);
        for (UserPjj userPjj : userPjjs) {
            Pjj pjj = pjjMapper.selectByPjjId(userPjj.getPjjId());
            List<Map<String,Object>> li = shopSpecificationMapper.selectSpecByPjjId(Integer.valueOf(pjj.getPjjId()));
            objects.add(li);
        }
        return objects;
    }

    /**
     * 商家规格单条查询
     * @param request
     * @return
     */
    @Override
    public Map<String, String> selectShopSpec(HttpServletRequest request) {
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            throw new ServiceException("id不允许为空");
        }
        Map<String, String> map = shopSpecificationMapper.selectMessageById(id);
        return map;
    }

    /**
     * 修改价格
     * @param request
     */
    @Override
    public void update(HttpServletRequest request) {
        String id = request.getParameter("id");
        if(StringUtils.isEmpty(id)){
            throw new ServiceException("id不允许为空");
        }
        String price = request.getParameter("price");
        if(StringUtils.isEmpty(price)){
            throw new ServiceException("价格不允许为空");
        }
        ShopSpecification shopSpecification = shopSpecificationMapper.selectByPrimaryKey(Integer.valueOf(id));
        shopSpecification.setUpdateTime(DateUtil.getCurrentTimeS2());
        shopSpecification.setPrice(price);
        shopSpecification.setUpdateTime(DateUtil.getCurrentTimeS2());
        int i = shopSpecificationMapper.updateByPrimaryKeySelective(shopSpecification);
        if(i <= 0){
            throw new ServiceException("修改失败");
        }
    }
}
