package com.pijiuji.service.impl;

import com.pijiuji.bean.Fat;
import com.pijiuji.bean.Order;
import com.pijiuji.bean.ResponseResult;
import com.pijiuji.bean.UserPjj;
import com.pijiuji.mapper.*;
import com.pijiuji.service.GuanliService;
import com.pijiuji.service.exception.ServiceException;
import groovy.util.logging.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Service
public class GuanliServiceImpl implements GuanliService {

    private static ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
    @Autowired
    PjjMapper pjjMapper;
    @Autowired
    private GuanliMapper guanliMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserPjjMapper userPjjMapper;
    @Autowired
    private FatMapper fatMapper;

    @Override
    public ResponseResult goGuan(String systemCode) {
        if (StringUtils.isEmpty(systemCode)) {
            return new ResponseResult(500, "系统编号不能为空");
        }
        //查询员工编号
        String leverUserId = guanliMapper.findSystemcode(systemCode);
        if (leverUserId != null) {
            return new ResponseResult(200, "匹配成功", leverUserId);
        }
        return new ResponseResult(500, "匹配失败");
    }

    @Override
    public ResponseResult findOrderByEmployee(String employeeId) {
        if (StringUtils.isEmpty(employeeId)) {
            return new ResponseResult(500, "id不能为空");
        }
        Map result = new HashMap();
        result.put("employeeId", employeeId);
        result.put("orderIsChujiu", "0");
        List<Map<String,String>> order = guanliMapper.findOrderById(result);
        for (Map<String, String> stringStringMap : order) {
            Integer chuNum = Integer.valueOf(stringStringMap.get("chuNum"));
            Integer num = Integer.valueOf(stringStringMap.get("num"));
            stringStringMap.put("chuNum",num-chuNum+"");
            Integer size = Integer.valueOf(stringStringMap.get("size"));
            String sss = stringStringMap.get("sss");
            if(StringUtils.isNotEmpty(sss) && num-chuNum != 1){
                int i = Integer.valueOf(size-Integer.valueOf(sss)) / (num - 1);
                stringStringMap.put("num",i+"");
            }else if(StringUtils.isNotEmpty(sss) && num-chuNum == 1){
                stringStringMap.put("num",sss);
            }else{
                stringStringMap.put("num",size/num+"");
            }
            stringStringMap.remove("sss");

        }
        return new ResponseResult(200, "查询成功", order);
    }

    /**
     * 修改机器的地址
     * @param request
     */
    @Override
    public void updateAddress(HttpServletRequest request) {
        newCachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                String pjjCode = request.getParameter("pjjCode");
                if(StringUtils.isEmpty(pjjCode)){
                    throw new ServiceException("啤酒机编号不允许为空");
                }
                String address = request.getParameter("address");
                if(StringUtils.isEmpty(address)){
                    throw new ServiceException("地址不允许为空");
                }
                int i = pjjMapper.updatePjjAddress(pjjCode,address);
                if(i <= 0){
                    System.err.println("修改失败的啤酒机编号为："+pjjCode+"\r\n接收到的参数地址为:"+address);
                    throw new ServiceException("修改失败");
                }
                int j = userPjjMapper.updateUserPjjAddress(pjjCode,address);
                if(j <= 0){
                    System.err.println("修改失败的啤酒机编号为："+pjjCode+"\r\n接收到的参数地址为:"+address);
                    throw new ServiceException("修改失败");
                }
            }
        });
    }

    @Override
    public String updateOrder(HttpServletRequest request) {
        String result = "";
        String orderId = request.getParameter("orderId");
        if (StringUtils.isEmpty(orderId)) {
            throw new ServiceException("订单id不允许为空");
        }
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null) {
            throw new ServiceException("订单id错误");
        }
        String specId = request.getParameter("specId");
        if(StringUtils.isEmpty(specId)){
            throw new ServiceException("机器id错误");
        }
        String productId = request.getParameter("productId");
        if(StringUtils.isEmpty(productId)){
            throw new ServiceException("商品id错误");
        }
        String productSize = request.getParameter("productSize");
        if(StringUtils.isEmpty(productSize)){
            throw new ServiceException("规格错误");
        }
        UserPjj userPjj = userPjjMapper.selectByPrimaryKey(specId);
        Fat fat = fatMapper.selectByPrimaryKey(userPjj.getPjjJiuCode());
        if(!fat.getFatProductId().equals(productId)){
            Fat fat2 = fatMapper.selectByPrimaryKey(userPjj.getPjjJiuCodes());
            if(Double.valueOf(fat2.getFatNum()) < Double.valueOf(productSize)){
                throw new ServiceException("酒容量不足,请联系工作人员更换酒桶");
            }
            fat2.setFatNum(Double.valueOf(fat2.getFatNum())-Double.valueOf(productSize)+"");
            fatMapper.updateByPrimaryKeySelective(fat2);
        }else{
            if(Double.valueOf(fat.getFatNum()) < Double.valueOf(productSize)){
                throw new ServiceException("酒容量不足,请联系工作人员更换酒桶");
            }
            fat.setFatNum(Double.valueOf(fat.getFatNum())-Double.valueOf(productSize)+"");
            fatMapper.updateByPrimaryKeySelective(fat);
        }
        //出酒储量
        Integer chuNum = Integer.valueOf(order.getOrderChuNum());
        if (chuNum + 1 >= Integer.valueOf(order.getOrderNum())) {
            order.setOrderChuNum(order.getOrderNum());
            order.setOrderIsChujiu("1");
            //完成出酒
            result = "1";
        } else {
            //未完成出酒
            result = "0";
            order.setOrderChuNum(chuNum + 1 + "");
        }
        int i = orderMapper.updateByPrimaryKeySelective(order);
        if (i <= 0) {
            throw new ServiceException("网络异常,请联系工作人员");
        }
        return result;
    }

    @Override
    public ResponseResult findSurplus(String pjjId) {
        if (StringUtils.isEmpty(pjjId)) {
            return new ResponseResult(500, "机器id不能为空");
        }
        UserPjj userPjj = userPjjMapper.selectByPrimaryKey(pjjId);
        Fat fat = fatMapper.selectByPrimaryKey(userPjj.getPjjJiuCode());
        Fat fat1 = fatMapper.selectByPrimaryKey(userPjj.getPjjJiuCodes());
        HashMap<String, Object> map = new HashMap<>();
        map.put("jiu1",fat.getFatNum());
        map.put("jiu2",fat1.getFatNum());
        map.put("qi",userPjj.getPjjQiNum());
        return new ResponseResult(200, "查询成功", map);
    }

    @Override
    public ResponseResult updatePjj(UserPjj userPjj) {
        Fat fat = new Fat();
        if(StringUtils.isNotEmpty(userPjj.getPjjJiuCode())){
            fat.setFatId(userPjj.getPjjJiuCode());
        }
        fat.setFatStatus("1");
        userPjjMapper.updateByPrimaryKeySelective(userPjj);
        if(StringUtils.isNotEmpty(userPjj.getPjjJiuCodes())){
            fat.setFatId(userPjj.getPjjJiuCodes());
        }
        fatMapper.updateByPrimaryKeySelective(fat);
        int i1 = userPjjMapper.updateByPrimaryKeySelective(userPjj);
        if (i1 > 0) {
            return new ResponseResult(200, "修改成功");
        }
        return new ResponseResult(500, "修改失败");
    }

    /**
     * 恢复气容量
     * @param request
     */
    @Override
    public void updateQi(HttpServletRequest request) {
        String specId = request.getParameter("specId");
        if(StringUtils.isEmpty(specId)){
            throw new ServiceException("机器id不允许为空");
        }
        UserPjj userPjj = userPjjMapper.selectByPrimaryKey(specId);
        userPjj.setPjjQiNum("100");
        int i = userPjjMapper.updateByPrimaryKeySelective(userPjj);
        if(i <= 0){
            throw new ServiceException("恢复失败");
        }
    }
}
