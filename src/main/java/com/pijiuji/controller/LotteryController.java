package com.pijiuji.controller;

import com.github.sd4324530.fastweixin.api.OauthAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.enums.OauthScope;
import com.pijiuji.bean.ResponseResult;
import com.pijiuji.service.LotteryService;
import com.pijiuji.service.exception.ServiceException;
import com.pijiuji.util.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 抽奖
 */
@Controller
@RequestMapping("/lottery")
public class LotteryController {

    @Autowired
    private LotteryService lotteryServiceImpl;
    public static final ApiConfig apiConfig = new ApiConfig (Param.APPID, Param.APPSECRET,true);
    @Value("${lottery.url}")
    private String address;

    /**
     * 查询所有奖品
     * @return
     */
    @ResponseBody
    @RequestMapping("/select")
    public ResponseResult<List<Map<String,Object>>> select(){
        ResponseResult<List<Map<String,Object>>> result = null;
        try {
            //判断系统编号为不为空
            List<Map<String,Object>> list = lotteryServiceImpl.select();
            result = new ResponseResult<List<Map<String,Object>>>(200,"查询成功",list);
        } catch (ServiceException e) {
            result = new ResponseResult<List<Map<String,Object>>>(500,e.getMessage());
        }
        return result;
    }

    /**
     * 点击抽奖
     * @return
     */
    @ResponseBody
    @RequestMapping("/findLottery")
    public ResponseResult<Map<String,Object>> findLottery(){
        ResponseResult<Map<String,Object>> result = null;
        try {
            //判断系统编号为不为空
            Map<String,Object> map = lotteryServiceImpl.findLottery();
            result = new ResponseResult<Map<String,Object>>(200,"抽奖成功",map);
        } catch (ServiceException e) {
            result = new ResponseResult<Map<String,Object>>(500,e.getMessage());
        }
        return result;
    }

    /**
     * 扫码领取奖品
     * @return
     */
    @ResponseBody
    @RequestMapping("/getLottery")
    public void getLottery(String cdKey,String lotteryId, HttpServletResponse response){
        System.err.println("进来了");
        OauthAPI api = new OauthAPI(apiConfig);
        String string = api.getOauthPageUrl(address+"/lottery/getUserInfo", OauthScope.SNSAPI_USERINFO, cdKey+"/"+lotteryId);
        try {
            response.sendRedirect(string);
        } catch (Exception e){
            throw new ServiceException(e);
        }
    }

    /**
     * 获取用户信息，并跳转页面
     * @param code
     * @param state
     * @return
     */

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public String getUserInfo(String code, String state, Model model) {
        try {
            lotteryServiceImpl.getUserInfo(apiConfig,code,state);
            model.addAttribute("message","领取成功");
        } catch (ServiceException e) {
            model.addAttribute("message",e.getMessage());
        }
            return "success";
    }
}
