package com.pijiuji.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.pijiuji.bean.ResponseResult;
import com.pijiuji.service.AliPayService;
import com.pijiuji.service.exception.ServiceException;
import com.pijiuji.util.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("Alipay")
public class AliPayController {

    @Autowired
    private AliPayService aliPayService;

    /**
     * 支付宝支付
     * @param request
     * @return
     */
    @RequestMapping("aliPay")
    @ResponseBody
    public ResponseResult<Map<String,String>> aliPay(HttpServletRequest request){
        ResponseResult<Map<String,String>> result = null;
        try{
            Map<String,String> map = aliPayService.aliPay(request);
            result = new ResponseResult<>(200,"生成成功",map);
        }catch(ServiceException e){
            result = new ResponseResult<>(500,e);
        }
        return result;
    }

    @RequestMapping("notify")
    @ResponseBody
    public String notify(HttpServletRequest request) {
        try {
            String notify = aliPayService.notify(request);
            return notify;
        } catch (ServiceException e) {
            return "error";
        }
    }

    @PostMapping("findAliPay")
    @ResponseBody
    public ResponseResult findAliPay(String orderId){
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", Param.ALIPAYAPPID,Param.PRIVATEKAY,"json","UTF-8",Param.PUBLICKEY,"RSA2");
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        AlipayTradeQueryModel alipayTradeQueryModel = new AlipayTradeQueryModel();
        alipayTradeQueryModel.setOutTradeNo(orderId);
        request.setBizModel(alipayTradeQueryModel);
        AlipayTradeQueryResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if(response.isSuccess()){
            if(response.getTotalAmount().equals(response.getBuyerPayAmount()) && response.getTotalAmount().equals(response.getReceiptAmount())){
                return new ResponseResult(200,"支付成功");
            }else{
                return new ResponseResult(500,"支付失败");
            }
        } else {
            return new ResponseResult(500,"支付失败");
        }
    }
}
