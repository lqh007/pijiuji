package com.pijiuji.service.impl;

import com.github.sd4324530.fastweixin.api.OauthAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.response.GetUserInfoResponse;
import com.github.sd4324530.fastweixin.api.response.OauthGetTokenResponse;
import com.pijiuji.bean.Lottery;
import com.pijiuji.bean.User;
import com.pijiuji.bean.UserLottery;
import com.pijiuji.bean.UserLotteryExample;
import com.pijiuji.mapper.LotteryMapper;
import com.pijiuji.mapper.UserLotteryMapper;
import com.pijiuji.mapper.UserMapper;
import com.pijiuji.service.LotteryService;
import com.pijiuji.service.exception.ServiceException;
import com.pijiuji.util.DrawLotteryUtil;
import com.pijiuji.util.Redeem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 抽奖service实现类
 */
@Service
public class LotteryServiceImpl implements LotteryService {

    @Autowired
    private LotteryMapper lotteryMapper;
    @Value("${lottery.count}")
    private Integer count;
    @Value("${lottery.url}")
    private String address;
    @Autowired
    private UserLotteryMapper userLotteryMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 点击抽奖
     * @return
     */
    @Override
    public Map<String, Object> findLottery() {
        List<Map<String,Object>> list = lotteryMapper.select();
        for (Map<String, Object> map : list) {
            String s = String.valueOf(map.get("lotteryGailv"));
            Double i = Double.valueOf(s)/100;
            map.put("lotteryGailv",i);
        }
        int index = DrawLotteryUtil.drawGift(list);
        Map<String, Object> map = list.get(index);
        map.put("img",address + map.get("img"));
        if("谢谢参与".equals(map.get("lotteryName"))){
            map.put("QRcode","");
            map.put("cdKey","");
        }else{
            String s = Redeem.idToCode(System.currentTimeMillis());
            map.put("QRcode",address+"/lottery/getLottery?cdKey="+s+"&lotteryId="+map.get("lotteryId"));
            map.put("cdKey",s);
        }
        return map;
    }

    /**
     * 绑定用户与奖品信息
     * @param code
     * @param state
     */
    @Override
    public Map<String, String> getUserInfo(ApiConfig apiConfig, String code, String state) {
        String accessToken = apiConfig.getAccessToken();
        System.err.println(accessToken);
        OauthAPI oauthAPI = new OauthAPI(apiConfig);
        OauthGetTokenResponse oauthGetTokenResponse = oauthAPI.getToken(code);
        GetUserInfoResponse userInfoResponse = oauthAPI.getUserInfo(oauthGetTokenResponse.getAccessToken(),
                oauthGetTokenResponse.getOpenid());
        //拿到用户的信息
        String openid = userInfoResponse.getOpenid();
        String headimgurl = userInfoResponse.getHeadimgurl();
        Integer sex = userInfoResponse.getSex();
        String nickname = userInfoResponse.getNickname();
        String city = userInfoResponse.getCity();
        //先判断数据库是否保存过该用户的信息
        User user = userMapper.selectByWxOpenid(openid);
        if(user == null){
            User u = new User();
            u.setUserHeadimg(headimgurl);
            u.setUserName(nickname);
            if(sex == 1){
                u.setUserSex("男");
            }else if(sex == 2){
                u.setUserSex("女");
            }else{
                u.setUserSex("未知");
            }
            u.setUserOpenid(openid);
            u.setUserAddress(city);
            userMapper.insertSelective(u);
        }
        String[] split = state.split("/");
        Lottery lottery = lotteryMapper.selectByPrimaryKey(Integer.valueOf(split[1]));
        //查询该优惠卷是否被绑定
        Integer i = userLotteryMapper.selectUserIsLottery(split[0]);
        if(i > 0){
            throw new ServiceException("该优惠券已被领取");
        }
        //进行绑定
        /**
         *   `ul_status` varchar(5) NOT NULL COMMENT '是否已使用(0未使用  1已使用)',
         */
        //查询用户当前所有拥有过的优惠卷
        UserLotteryExample userLotteryExample = new UserLotteryExample();
        UserLotteryExample.Criteria criteria = userLotteryExample.createCriteria();
        criteria.andUlUserOpenidEqualTo(openid);
        List<UserLottery> userLotteries = userLotteryMapper.selectByExample(userLotteryExample);
        if(userLotteries!= null && userLotteries.size() > 0){
            for (UserLottery userLottery : userLotteries) {
                if(userLottery.getUlStatus().equals("0")){
                    throw new ServiceException("您还有未使用的优惠卷,领取失败！");
                }
            }
        }
        UserLottery ul = new UserLottery();
        String replace = UUID.randomUUID().toString().replace("-", "");
        ul.setUlId(replace);
        ul.setUlUserOpenid(openid);
        ul.setUlLotteryName(lottery.getLotteryName());
        ul.setUlLotteryImg(lottery.getLotteryImg());
        ul.setUlStatus("0");
        ul.setUlLotteryType(lottery.getLotteryType());
        ul.setUlLotteryDetail(lottery.getLotteryTypedetail());
        ul.setUlCdkey(split[0]);
        int j = userLotteryMapper.insertSelective(ul);
        if(j <= 0){
            throw new ServiceException("领取失败！");
        }
        Map<String, String> map = new HashMap<>();
        map.put("lotteryName",lottery.getLotteryName());
        map.put("img",address+lottery.getLotteryImg());
        map.put("cdKey",split[0]);
        return map;
    }

    /**
     * 查询所有的奖品
     * @return
     */
    @Override
    public List<Map<String,Object>> select() {
        List<Map<String,Object>> list = lotteryMapper.select();
        for (Map<String, Object> map : list) {
            map.put("img",address + map.get("img"));
            map.put("code",Integer.valueOf(map.get("code").toString()));
        }
        return list;
    }
}
