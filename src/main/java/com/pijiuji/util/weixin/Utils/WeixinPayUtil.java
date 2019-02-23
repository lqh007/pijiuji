package com.pijiuji.util.weixin.Utils;

import com.pijiuji.util.Param;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


/**
 * 微信支付测试
 * @author xiebin
 * @date 2015年11月26日上午9:58:19
 */
public class WeixinPayUtil {


	public static void main(String[] args) throws DocumentException{
//		perpay(null, "213131");
	}

	/**
	 * 小程序统一下单
	 * @param request
	 * @param out_trade_no
	 * @param body
	 * @return
	 */
	public static Map applet_perpay(HttpServletRequest request, String out_trade_no, String body,String userOpenid) throws DocumentException  {
		String ip=getIpAddress();
		Map rMap=new HashMap();
		//参数组
		String appid = Param.APPID;
		String mch_id = Param.mch_id;
		//随机字符串
		String nonce_str = RandCharsUtils.getRandomString(16);
		//单位是分
		String total_fee=String.valueOf(Double.parseDouble(request.getParameter("money").toString())*100) ;
		String spbill_create_ip =ip;
		String notify_url = Param.NOTIFY_URL;
		String trade_type = "JSAPI";
		String openid = userOpenid;
        //参数：开始生成签名
        SortedMap<Object,Object> parameters = new TreeMap<Object,Object>();
        parameters.put("appid", appid);
        parameters.put("mch_id", mch_id);
        parameters.put("nonce_str", nonce_str);
        parameters.put("body", body);
        parameters.put("out_trade_no", out_trade_no);
        parameters.put("total_fee", total_fee);
        parameters.put("spbill_create_ip", spbill_create_ip);
        parameters.put("notify_url", notify_url);
        parameters.put("trade_type", trade_type);
        parameters.put("openid", openid);
        //第一次签名
        String sign = WXSignUtils.createSign("UTF-8", parameters);
        parameters.put("sign",sign);
        //构造xml参数
        String xmlInfo = HttpXmlUtils.xmlInfo(parameters);
        System.out.println("统一下单传递的xml字符串为:\n"+xmlInfo);
        String wxUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        String method = "POST";
        String xmlStr = HttpXmlUtils.httpsRequest(wxUrl, method, xmlInfo).toString();
        System.out.println("统一下单返回结果:\n"+xmlStr);
        Document doc = DocumentHelper.parseText(xmlStr);
        Element rootElt = doc.getRootElement(); // 获取根节点
        String return_code=rootElt.elementTextTrim("return_code");
        String result_code=rootElt.elementTextTrim("result_code");
        if(return_code.equalsIgnoreCase("SUCCESS") && result_code.equalsIgnoreCase("SUCCESS")){
            //反校验签名，暂无
            String prepay_id=rootElt.elementTextTrim("prepay_id");
            String timestamp = String.valueOf(System.currentTimeMillis()/1000);
            SortedMap rParam=new TreeMap();
            rParam.put("appid", appid);
            rParam.put("signType", "MD5");
            rParam.put("package", "prepay_id="+prepay_id);
            rParam.put("noncestr", nonce_str);
            rParam.put("timestamp", timestamp);
            //进行签名，返回给客户端
            String sign2 = WXSignUtils.createSign("UTF-8", rParam);
            rParam.put("paySign", sign2);
            rMap.put("code", 1);
            rMap.put("msg", "统一下单成功");
            rMap.put("content", rParam);
            System.out.println("maptostring:"+rParam.toString());
        }else{
            rMap.put("code", 101);
            rMap.put("msg", "统一下单失败");
            rMap.put("content", "");
        }
        return rMap;
	}

	/**
	 * 预支付
	 * @param req
	 * @param out_trade_no
	 * @return
	 * @throws DocumentException
	 */
	public static Map perpay(HttpServletRequest req, String out_trade_no,String body) throws DocumentException {
		String ip=getIpAddress();
		Map rMap=new HashMap();
		//参数组
		String appid = Param.APPID;
		String mch_id = Param.mch_id;
		//随机字符串
		String nonce_str = RandCharsUtils.getRandomString(16);
		//单位是分
		String total_fee=String.valueOf(Double.parseDouble(req.getParameter("money").toString())*100);
        total_fee = "0.01";
		BigDecimal b1 = new BigDecimal(total_fee);
		String spbill_create_ip =ip;
		String notify_url = Param.NOTIFY_URL;
//		String notify_url = req.getParameter("notify_url");
		String trade_type = "APP";
        Integer of = Integer.valueOf(b1.toString().replace(".0", ""));
        System.err.println("转换后的金额为："+of);
		//参数：开始生成签名
		SortedMap<Object,Object> parameters = new TreeMap<Object,Object>();
		parameters.put("appid", appid);
		parameters.put("mch_id", mch_id);
		parameters.put("nonce_str", nonce_str);
		parameters.put("body", body);
		parameters.put("out_trade_no", out_trade_no);
		parameters.put("total_fee", of+"");
		parameters.put("spbill_create_ip", spbill_create_ip);
		parameters.put("notify_url", notify_url);
		parameters.put("trade_type", trade_type);
		//第一次签名
		String sign = WXSignUtils.createSign("UTF-8", parameters);
        parameters.put("sign",sign);

		//构造xml参数
		String xmlInfo = HttpXmlUtils.xmlInfo(parameters);
		System.out.println("统一下单传递的xml字符串为:\n"+xmlInfo);
		String wxUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		String method = "POST";
		String xmlStr = HttpXmlUtils.httpsRequest(wxUrl, method, xmlInfo).toString();
		System.out.println("统一下单返回结果:\n"+xmlStr);
		Document doc = DocumentHelper.parseText(xmlStr);
		Element rootElt = doc.getRootElement(); // 获取根节点 
		String return_code=rootElt.elementTextTrim("return_code");
		String result_code=rootElt.elementTextTrim("result_code");
		if(return_code.equalsIgnoreCase("SUCCESS") && result_code.equalsIgnoreCase("SUCCESS")){
			//反校验签名，暂无
			String prepay_id=rootElt.elementTextTrim("prepay_id");
			String timestamp = String.valueOf(System.currentTimeMillis()/1000);
			SortedMap rParam=new TreeMap();
			rParam.put("appid", appid);
			rParam.put("partnerid", mch_id);
			rParam.put("prepayid", prepay_id);
			rParam.put("package", "Sign=WXPay");
			rParam.put("noncestr", nonce_str);
			rParam.put("timestamp", timestamp);
			//进行签名，返回给客户端
			String sign2 = WXSignUtils.createSign("UTF-8", rParam);
			rParam.put("sign", sign2);
			rMap.put("code", 1);
			rMap.put("msg", "统一下单成功");
			rMap.put("content", rParam);
			System.out.println("maptostring:"+rParam.toString());
		}else{
			rMap.put("code", 101);
			rMap.put("msg", "统一下单失败");
			rMap.put("content", "");
		}
		return rMap;
	}
	/**
	  * 获取客户端的ip地址
	  * @return
	  */
	 public static String getIpAddress() {
		 try{
			 HttpServletRequest request =  ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
				String ip = request.getHeader("x-forwarded-for");
				if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
					ip = request.getHeader("Proxy-Client-IP");
				}
				if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
					ip = request.getHeader("WL-Proxy-Client-IP");
				}
				if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
					ip = request.getHeader("HTTP_CLIENT_IP");
				}
				if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
					ip = request.getHeader("HTTP_X_FORWARDED_FOR");
				}
				if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
					ip = request.getRemoteAddr();
				}
				return ip;
		 }catch (Exception e) {
			return null;
		}
	}
}
