package com.pijiuji.util.weixin.entity;
/**
 * ͳһ�µ��ύΪ΢�ŵĲ���
 * @author iYjrg_xiebin
 * @date 2015��11��26������10:17:06
 */
public class Unifiedorder {
	
	private String appid;
	private String mch_id;
	private String nonce_str;
	private String sign;
	private String body;
	private String out_trade_no;
	private String total_fee;
	private String spbill_create_ip;
	private String notify_url;
	private String trade_type;
	
	public String getAppid() {
		return appid;
	}
	public String getMch_id() {
		return mch_id;
	}
	public String getNotify_url() {
		return notify_url;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public String getSign() {
		return sign;
	}
	public String getBody() {
		return body;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public String getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public void setBody(String body) {
		this.body = body;
	}
 
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}
	 
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
 

}
