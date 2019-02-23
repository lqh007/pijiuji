package com.pijiuji.util;

import com.pijiuji.service.exception.ServiceException;
import com.pijiuji.util.weixin.Utils.WeixinPayUtil;
import org.dom4j.DocumentException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class WeixinPayUtils {

    /**
     * 充值_微信统一下单(预支付)
     * @param request
     * @return
     */
    public static Map update_app_weixin_perpayInCharge(HttpServletRequest request,String out_trade_no,String body){
        //传过来的信息
        Map rMap = null;
        try {
            rMap = WeixinPayUtil.perpay(request,out_trade_no,body);
        } catch (DocumentException e) {
            throw new ServiceException(e.getMessage());
        }
        String object= String.valueOf(rMap.get("code"));
        if("1".equals(object)){
            Map content=(Map) rMap.get("content");
            String prepay_id=(String) content.get("prepayid");
            System.err.println("返回的预支付perpay_id:"+prepay_id);
            System.out.println("支付成功");
        }
        return rMap;
    }

    /**
     * 小程序微信统一下单(预支付)
     * @param request
     * @return
     */
    public static Map applet_weixin_perpayInCharge(HttpServletRequest request,String out_trade_no,String body){
        //传过来的信息
        Map rMap = null;
        try {
            rMap = WeixinPayUtil.applet_perpay(request,out_trade_no,body,"");
        } catch (DocumentException e) {
            throw new ServiceException(e.getMessage());
        }
        String object= String.valueOf(rMap.get("code"));
        if("1".equals(object)){
            Map content=(Map) rMap.get("content");
            String prepay_id=(String) content.get("prepayid");
            System.err.println("返回的预支付perpay_id:"+prepay_id);
            System.out.println("支付成功");
        }
        return rMap;
    }

}
