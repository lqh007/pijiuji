package com.pijiuji.controller;

import com.github.pagehelper.PageInfo;
import com.github.sd4324530.fastweixin.api.OauthAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.enums.OauthScope;
import com.pijiuji.bean.ResponseResult;
import com.pijiuji.service.EmployeeService;
import com.pijiuji.service.exception.ServiceException;
import com.pijiuji.util.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    public static final ApiConfig apiConfig = new ApiConfig(Param.APPID, Param.APPSECRET, true);
    @Value("${lottery.url}")
    private String address;
    @Autowired
    private EmployeeService employeeService;

    /**
     * 申请
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "applyFor")
    public ResponseResult<Void> applyFor(HttpServletRequest request) {
        ResponseResult<Void> result;
        try {
            String res = employeeService.applyFor(request);
            result = new ResponseResult<>(200, res);
        } catch (ServiceException e) {
            result = new ResponseResult<>(500, e);
        }
        return result;
    }

    /**
     * 授权获取用户信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUserMessage")
    public void getLottery(HttpServletResponse response) {
        System.err.println("进来了");
        OauthAPI api = new OauthAPI(apiConfig);
        String string = api.getOauthPageUrl(address + "/employee/getUserInfo", OauthScope.SNSAPI_USERINFO, null);
        try {
            response.sendRedirect(string);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
//        return "shouquan";
    }

    /**
     * 获取用户信息，并跳转页面
     *
     * @param code
     * @param state
     * @return
     */
    @RequestMapping("/getUserInfo")
    public String getUserInfo(String code, String state, Model model) {
        String userOpenid = employeeService.getUserInfo(apiConfig, code);
        model.addAttribute("userOpenid", userOpenid);
        return "shouquan";
    }

    /**
     * 个人中心
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUser")
    public ResponseResult<Map<String, Object>> getUserMessage(HttpServletRequest request) {
        ResponseResult<Map<String, Object>> result;
        try {
            Map<String, Object> map = employeeService.getUserMessage(request);
            result = new ResponseResult<Map<String, Object>>(200, "查询成功", map);
        } catch (ServiceException e) {
            result = new ResponseResult<Map<String, Object>>(500, e);
        }
        return result;
    }

    /**
     * 获取用户的openid
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUserOpenid")
    public ResponseResult<Map<String, String>> getUserOpenid(HttpServletRequest request) {
        ResponseResult<Map<String, String>> result;
        try {
            Map<String, String> map = employeeService.getUserOpenid(request);
            result = new ResponseResult<>(200, "查询成功", map);
        } catch (ServiceException e) {
            result = new ResponseResult<>(500, e);
        }
        return result;
    }

    /**
     * 提现列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/tixianList")
    public ResponseResult<PageInfo> tixianList(HttpServletRequest request) {
        ResponseResult<PageInfo> result;
        try {
            PageInfo map = employeeService.tixianList(request);
            result = new ResponseResult<>(200, "查询成功", map);
        } catch (ServiceException e) {
            result = new ResponseResult<>(500, e);
        }
        return result;
    }

}