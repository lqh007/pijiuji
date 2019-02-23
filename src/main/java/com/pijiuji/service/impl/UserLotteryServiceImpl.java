package com.pijiuji.service.impl;

import com.pijiuji.bean.Fat;
import com.pijiuji.bean.Order;
import com.pijiuji.bean.UserLottery;
import com.pijiuji.bean.UserPjj;
import com.pijiuji.mapper.FatMapper;
import com.pijiuji.mapper.OrderMapper;
import com.pijiuji.mapper.UserLotteryMapper;
import com.pijiuji.mapper.UserPjjMapper;
import com.pijiuji.service.UserLotteryService;
import com.pijiuji.service.exception.ServiceException;
import com.pijiuji.util.IdWorker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserLotteryServiceImpl implements UserLotteryService {

    @Autowired
    private UserPjjMapper userPjjMapper;
    @Autowired
    private UserLotteryMapper userLotteryMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private FatMapper fatMapper;

    /**
     * 生成订单并出酒
     * @param request
     */
    @Override
    public void updateCdkey(HttpServletRequest request) {
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
            fat2.setFatNum(Double.valueOf(fat2.getFatNum())-Double.valueOf(productSize)+"");
            fatMapper.updateByPrimaryKeySelective(fat2);
        }else{
            fat.setFatNum(Double.valueOf(fat.getFatNum())-Double.valueOf(productSize)+"");
            fatMapper.updateByPrimaryKeySelective(fat);
        }
        //兑换码类型
        String type = request.getParameter("type");
        //如果是再来一杯的话，app上需要走这个判断。公众号的并不需要
        if(StringUtils.isNotEmpty(type) && type.equals("2")){
            //使用的是再来一杯，因为不走支付，所以需要在这里生成订单信息
            IdWorker idworker = new IdWorker();
            Order order = new Order();
            order.setOrderId(idworker+"");
            order.setOrderProductId(productId);
            order.setOrderSize(productSize);
            order.setOrderEmployeeId("");
            order.setOrderMoney("0.0");
            order.setOrderNum("1");
            order.setOrderPoint("");
            order.setOrderSpecId(specId);
            order.setOrderTransactionId("");
            order.setOrderIsChujiu("1");
            order.setOrderStatus("1");
            order.setOrderCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            order.setOrderPaytime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            orderMapper.insertSelective(order);
        }
    }

    /**
     * 输入兑换码
     * @param request
     * @return
     */
    @Override
    public Map<String, String> writeCdkey(HttpServletRequest request) {
        String cdkey = request.getParameter("cdkey");
        if (StringUtils.isEmpty(cdkey)) {
            throw new ServiceException("兑换码不能为空");
        }
        //数据库查看有没有这个兑换码
        UserLottery userLottery = userLotteryMapper.findUserLottery(cdkey);
        if (userLottery == null) {
            throw new ServiceException("没有这个兑换码");
        }
        if (userLottery.getUlStatus().equals("1")) {
            throw new ServiceException("抽奖码已经使用过");
        }
        //创建返回的Map
        HashMap<String, String> map = new HashMap<>();
        //如果是0 证明是优惠券
        if (userLottery.getUlLotteryType().equals("0")) {
            //返回值 和 类型，让安卓去判断。
            map.put("number",userLottery.getUlLotteryDetail());
            map.put("type","0");
        } else if (userLottery.getUlLotteryType().equals("1")) {
            map.put("number",userLottery.getUlLotteryDetail());
            map.put("type","1");
        } else {
            map.put("number","");
            map.put("type","2");
        }
        return map;
    }
}
