package com.pijiuji.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.sd4324530.fastweixin.api.OauthAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.response.GetUserInfoResponse;
import com.github.sd4324530.fastweixin.api.response.OauthGetTokenResponse;
import com.pijiuji.bean.LevelUser;
import com.pijiuji.bean.User;
import com.pijiuji.mapper.LevelUserMapper;
import com.pijiuji.mapper.OrderMapper;
import com.pijiuji.mapper.TixianMapper;
import com.pijiuji.mapper.UserMapper;
import com.pijiuji.service.EmployeeService;
import com.pijiuji.service.exception.ServiceException;
import com.pijiuji.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private LevelUserMapper levelUserMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private TixianMapper tixianMapper;

    /**
     * 申请
     *
     * @param request
     * @return
     */
    @Override
    public String applyFor(HttpServletRequest request) {
        String identity = request.getParameter("identity");
        if (StringUtils.isEmpty(identity)) {
            throw new ServiceException("身份不允许为空");
        }
        String name = request.getParameter("name");
        if (StringUtils.isEmpty(name)) {
            throw new ServiceException("申请姓名不允许为空");
        }
        String phone = request.getParameter("phone");
        if (StringUtils.isEmpty(phone)) {
            throw new ServiceException("联系电话不允许为空");
        }
        String address = request.getParameter("address");
        if (StringUtils.isEmpty(address)) {
            throw new ServiceException("联系地址不允许为空");
        }
        String userOpenid = request.getParameter("userOpenid");
        if (StringUtils.isEmpty(userOpenid)) {
            throw new ServiceException("用户标识错误");
        }
        User user = userMapper.selectByWxOpenid(userOpenid);
        LevelUser levelUser1 = levelUserMapper.selectIsLevelUser(userOpenid);
        if(levelUser1 != null){
            throw new ServiceException("已提交申请,请等待审核");
        }
        String result = "申请成功,请等待审核...";
        LevelUser lu = new LevelUser();
        lu.setLevelUserId(System.currentTimeMillis()+"");
        lu.setLevelUserAddress(address);
        lu.setLevelUserLevel(identity);
        lu.setLevelUserName(name);
        lu.setLevelUserPhone(phone);
        lu.setLevelUserHeadimg(user.getUserHeadimg());
        lu.setLevelUserWxOpenid(userOpenid);
        //需要去查询和判断上级的id。
        if (identity.equals("3")) {
            String parentName = request.getParameter("parentName");
            if (StringUtils.isEmpty(parentName)) {
                throw new ServiceException("上级姓名不允许为空");
            }
            String parentPhone = request.getParameter("parentPhone");
            if (StringUtils.isEmpty(parentPhone)) {
                throw new ServiceException("上级联系方式不允许为空");
            }
            System.err.println("获取到的上级姓名为：" + parentName);
            //查询是否有该上级信息，并是否是终端店的
            LevelUser levelUser = levelUserMapper.selectLevelUserByParam(parentName, parentPhone);
            if (levelUser == null) {
                throw new ServiceException("上级信息错误");
            }
            if (!levelUser.getLevelUserLevel().equals("2")) {
                throw new ServiceException("对不起，您的上级必须是终端店");
            }
            lu.setLevelUserPassword(MD5Util.MD5Encode("123456"));
            //TODO  发送短信通知用户密码是什么

            lu.setLevelUserParentOpenid(levelUser.getLevelUserWxOpenid());
            lu.setLevelUserApplyStatus("1");
            result = "申请成功";
        }
        int i = levelUserMapper.insertSelective(lu);
        if (i <= 0) {
            throw new ServiceException("网络异常,请重试");
        }
        return result;
    }

    /**
     * 获取用户信息
     * @param apiConfig
     * @param code
     * @return
     */
    @Override
    public String getUserInfo(ApiConfig apiConfig, String code) {
        String accessToken = apiConfig.getAccessToken();
        System.err.println(accessToken);
        System.err.println("code="+code);
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
        User user = userMapper.selectByWxOpenid(openid);
        if (user == null) {
            User u = new User();
            u.setUserOpenid(openid);
            if(sex == 1){
                u.setUserSex("男");
            }else if(sex == 2){
                u.setUserSex("女");
            }else{
                u.setUserSex("未知");
            }
            u.setUserName(nickname);
            u.setUserHeadimg(headimgurl);
            u.setUserAddress(city);
            int i = userMapper.insertSelective(u);
            if (i <= 0) {
                throw new ServiceException("网络异常,请重试");
            }
            return openid;
        }
        return user.getUserOpenid();
    }

    /**
     * 查询个人中心
     *
     * @param request
     * @return
     */
    @Override
    public Map<String, Object> getUserMessage(HttpServletRequest request) {
        String userOpenid = request.getParameter("userOpenid");
        if (StringUtils.isEmpty(userOpenid)) {
            throw new ServiceException("网络异常,值空");
        }
        LevelUser levelUser = levelUserMapper.selectIsLevelUser(userOpenid);
        HashMap<String, Object> map = new HashMap<>();
        map.put("userHeadimg", levelUser.getLevelUserHeadimg());
        map.put("userName", levelUser.getLevelUserName());
        map.put("userMoney", levelUser.getLevelUserMoney());
        if (levelUser.getLevelUserLevel().equals("3")) {
            map.put("childProxy", "0");
            map.put("proxyJiBie", "服务推广员");
        } else {
            Integer i = levelUserMapper.selectChildLevelUser(userOpenid);
            map.put("childProxy", i + "");
            if (levelUser.getLevelUserLevel().equals("0")) {
                map.put("proxyJiBie", "城市创始人");
            } else if (levelUser.getLevelUserLevel().equals("1")) {
                map.put("proxyJiBie", "城市合作伙伴");
            } else if (levelUser.getLevelUserLevel().equals("2")) {
                map.put("proxyJiBie", "终端店");
            }
        }
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MONTH,-6);
        Date t = instance.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        String time = format.format(t);
        List<Map<String,String>> list =  orderMapper.selectTongji(userOpenid,time);
        ArrayList<Map<String, String>> maps = new ArrayList<>();
        HashMap<String, String> hashMap = new HashMap<>();
        for (Map<String, String> stringStringMap : list) {
            try {
                String time2 = stringStringMap.get("time");
                Date time1 = format.parse(time2);
                String format1 = format.format(time1);
                if(hashMap.get("time") == null){
                    hashMap.put("time",format1);
                    hashMap.put("money",stringStringMap.get("money"));
                }else{
                    if(hashMap.get("time").equals(format1)){
                        String money = Double.valueOf(hashMap.get("money"))+Double.valueOf(stringStringMap.get("money"))+"";
                        hashMap.put("money",money);
                    }else{
                        maps.add(hashMap);
                        hashMap = new HashMap<>();
                        hashMap.put("time",format1);
                        hashMap.put("money",stringStringMap.get("money"));
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        maps.add(hashMap);
        map.put("tongji",maps);
        return map;
    }

    @Override
    public Map<String, String> getUserOpenid(HttpServletRequest request) {
        String userOpenid = request.getParameter("userOpenid");
        HashMap<String, String> map = new HashMap<>();
        map.put("userWxOpenid", userOpenid);
        System.err.println("获取到的userOpenid为："+userOpenid);
        LevelUser levelUser = levelUserMapper.selectIsLevelUser(userOpenid);
        if(levelUser != null){
            if (levelUser.getLevelUserLevel().equals("")) {
                //需要进入申请页
                map.put("userId", "");
                map.put("status", "0");
            }
            if(!levelUser.getLevelUserApplyStatus().equals("1")){
                map.put("userId", "");
                map.put("status", "0");
            }else{
                //不需要进入申请页
                map.put("userId", levelUser.getLevelUserId());
                map.put("status", "1");
            }
            if(levelUser.getLevelUserStatus().equals("1")){
                map.put("userId", "");
                map.put("status", "0");
            }
        }else{
            map.put("userId", "");
            map.put("status", "0");
        }
        return map;
    }

    /**
     *
     * @param request
     * @return
     */
    @Override
    public PageInfo tixianList(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        if(StringUtils.isEmpty(userId)){
            throw new ServiceException("用户id不允许为空");
        }
        String page = request.getParameter("page");
        if(StringUtils.isEmpty(page)){
            page = "1";
        }
        PageHelper.startPage(Integer.valueOf(page),10);
        List<Map<String,Object>> list = tixianMapper.selectTixianByUserId(userId);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MONTH,-6);
        Date time = instance.getTime();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM");
        String format1 = format.format(time);
        System.err.println(format1);
    }
}
