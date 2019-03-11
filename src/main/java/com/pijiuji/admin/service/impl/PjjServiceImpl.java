package com.pijiuji.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pijiuji.admin.service.PjjService;
import com.pijiuji.bean.*;
import com.pijiuji.mapper.*;
import com.pijiuji.util.MapTrunBean;
import com.pijiuji.util.Param;
import com.pijiuji.util.TimesUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class PjjServiceImpl implements PjjService {

    @Autowired
    private LevelUserMapper levelUserMapper;
    @Autowired
    private PjjMapper pjjMapper;
    @Autowired
    private ShopSpecificationMapper shopSpecificationMapper;
    @Autowired
    private SpecificationMapper specificationMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private ProPjjMapper proPjjMapper;

    /**
     * 为啤酒机分配啤酒
     * @param request
     * @return
     */
    @Override
    public ResponseResult allocation(HttpServletRequest request) {
        String pjjCode = request.getParameter("pjjCode");
        if(StringUtils.isEmpty(pjjCode)){
            return new ResponseResult(500,"啤酒机编号不允许为空");
        }
        String productIds = request.getParameter("productIds");
        if(StringUtils.isEmpty(productIds)){
            proPjjMapper.deletePjjProductByPjjCode(pjjCode);
        }else{
            proPjjMapper.deletePjjProductByPjjCode(pjjCode);
            String[] split = productIds.split(",");
            for (String s : split) {
                if(StringUtils.isNotEmpty(s)){
                    ProPjj proPjj = new ProPjj();
                    proPjj.setPropjjId(UUID.randomUUID().toString().replace("-",""));
                    proPjj.setPropjjPjjCode(pjjCode);
                    proPjj.setPropjjPjjProid(s);
                    int insert = proPjjMapper.insert(proPjj);
                    if(insert <= 0 ){
                        return new ResponseResult(500,"服务器错误");
                    }
                }
            }
        }
        return new ResponseResult(200,"执行成功");
    }

    @Override
    public ResponseResult findAdminAllPjj(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        if (StringUtils.isEmpty(userId)) {
            return new ResponseResult(500, "还没登录");
        }
        PjjExample pjjExample = new PjjExample();
        PjjExample.Criteria criteria = pjjExample.createCriteria();
        List<Map> resultList = new ArrayList<>();
        //根据用户id查询
        criteria.andPjjUserIdEqualTo(userId);
        List<Pjj> pjjs = pjjMapper.selectByExample(pjjExample);
        for (Pjj pjj : pjjs) {
            Map<String, Object> pjjMap = MapTrunBean.beanToMap(pjj);
            resultList.add(pjjMap);
        }


        for (int i = 0; i < resultList.size(); i++) {
            String pjjStatus = resultList.get(i).get("pjjStatus").toString();
            if ("0".equals(pjjStatus)) {
                resultList.get(i).put("pjjToStatus", "异常");
            } else if ("1".equals(pjjStatus)) {
                resultList.get(i).put("pjjToStatus", "正常");
            } else {
                resultList.get(i).put("pjjToStatus", "回收");
            }
            long s1 = resultList.get(i).get("pjjTime") == null ? 0l : ((Date) resultList.get(i).get("pjjTime")).getTime();
            String time = TimesUtils.stampToDate(s1);
            resultList.get(i).put("pjjTime", time);
        }

        return new ResponseResult(200, "查询成功", resultList);
    }

    /**
     * 查询当前啤酒机上所展示的商品
     *
     * @param request
     * @return
     */
    @Override
    public ResponseResult product(HttpServletRequest request) {
        String pjjCode = request.getParameter("pjjCode");
        if (StringUtils.isEmpty(pjjCode)) {
            return new ResponseResult(500, "啤酒机编号不允许为空");
        }
        List<Map<String,String>> list = proPjjMapper.selectPjjProductByPjjCode(pjjCode);
        return new ResponseResult(200,"查询成功",list);
    }

    @Override
    public ResponseResult savePjj(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        Pjj pjj = new Pjj();
        String pjjCode = request.getParameter("pjjCode");
        pjj.setPjjCode(pjjCode);
        pjj.setPjjUserId(userId);
        int i = pjjMapper.insertSelective(pjj);
        //查询出来所有规格
        SpecificationExample specificationExample = new SpecificationExample();
        specificationExample.createCriteria();
        List<Specification> specifications = specificationMapper.selectByExample(specificationExample);
        ShopSpecification shopSpecification = new ShopSpecification();
        int i1 = 0;
        for (Specification specification : specifications) {
            shopSpecification.setPjjId(pjj.getPjjId());
            shopSpecification.setSpecId(specification.getSpeId());
            i1 += shopSpecificationMapper.insertSelective(shopSpecification);
        }
        if (i > 0 && i1 >= specifications.size()) {
            return new ResponseResult(200, "添加成功");
        }

        return new ResponseResult(500, "添加失败");
    }

    @Override
    public ResponseResult updatePjj(HttpServletRequest request) {
        String pjjIds = request.getParameter("pjjIds");
        String userId = request.getParameter("userId");
        String loginUserId = request.getParameter("loginUserId");
        Pjj pjj = new Pjj();
        PjjExample pjjExample = new PjjExample();
        PjjExample.Criteria criteria = pjjExample.createCriteria();
        criteria.andPjjUserIdEqualTo(userId);
        List<Pjj> pjjs = pjjMapper.selectByExample(pjjExample);
        for (Pjj pjj1 : pjjs) {
            pjj1.setPjjUserId(loginUserId);
            pjjMapper.updateByPrimaryKeySelective(pjj1);
        }
        if (StringUtils.isEmpty(userId)) {
            return new ResponseResult(500, "分配的用户id不能为空");
        }
        if (pjjIds != null && "" != pjjIds) {
            String[] split = pjjIds.split(",");
            for (String pjjId : split) {
                pjj.setPjjUserId(userId);
                pjj.setPjjId(Integer.valueOf(pjjId));
                pjjMapper.updateByPrimaryKeySelective(pjj);
            }
        }

        return new ResponseResult(200, "分配成功");
    }

    @Override
    public ResponseResult findPjj(HttpServletRequest request) {
        String page = request.getParameter("page");
        PageHelper.startPage(Integer.valueOf(page), Param.pageSize);
        PjjExample pjjExample = new PjjExample();
        pjjExample.createCriteria();
        List<Pjj> pjjs = pjjMapper.selectByExample(pjjExample);
        List<Map> resultList = new ArrayList();
        for (int i = 0; i < pjjs.size(); i++) {
            Date pjjTime = pjjs.get(i).getPjjTime();
            String s = TimesUtils.stampToDate(pjjTime.getTime());
            Map<String, Object> pjjMap = MapTrunBean.beanToMap(pjjs.get(i));
            pjjMap.put("pjjTime", s);
            resultList.add(pjjMap);
        }

        for (int i = 0; i < resultList.size(); i++) {
            String pjjStatus = resultList.get(i).get("pjjStatus").toString();
            if ("0".equals(pjjStatus)) {
                resultList.get(i).put("pjjToStatus", "异常");
            } else if ("1".equals(pjjStatus)) {
                resultList.get(i).put("pjjToStatus", "正常");
            } else {
                resultList.get(i).put("pjjToStatus", "回收");
            }
        }


        PageInfo pageInfo = new PageInfo(resultList);
        return new ResponseResult(200, "查询成功", pageInfo);
    }

    /**
     * 搜索啤酒机
     * @param request
     * @return
     */
    @Override
    public ResponseResult searchPjj(HttpServletRequest request) {
        String pjjCode = request.getParameter("pjjCode");
        String address = request.getParameter("address");
        String status = request.getParameter("status");
        String page = request.getParameter("page");
        PageHelper.startPage(Integer.valueOf(page),Param.pageSize);
        Pjj pjj = new Pjj();
        pjj.setPjjCode(pjjCode);
        pjj.setPjjStatus(status);
        pjj.setPjjAddress(address);
        List<Pjj> pjjs = pjjMapper.searchPjj(pjj);
        PageInfo pageInfo = new PageInfo(pjjs);
        return new ResponseResult(200,"查询成功",pageInfo);
    }
}
