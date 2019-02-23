package com.pijiuji.util.weixin.entity;

/**
 * ͳһ�µ�΢�ŷ��صĲ�����
 * @author iYjrg_xiebin
 * @date 2015��11��26������10:16:51
 */
public class UnifiedorderResult {
	private String appid;//appid
	private String mch_id;//�̼�id
	private String device_info;//�豸��
	private String nonce_str;//����ַ���
	private String sign;//ǩ��
	private String result_code;//������
	private String err_code;//�������
	private String err_code_des;//���󷵻ص���Ϣ����
	private String trade_type;//���ýӿ��ύ�Ľ������ͣ�ȡֵ���£�JSAPI��NATIVE��APP
	private String prepay_id;//΢�����ɵ�Ԥ֧���ػ���ʶ�����ں����ӿڵ�����ʹ�ã���ֵ��Ч��Ϊ2Сʱ
	private String code_url;//trade_typeΪNATIVE���з��أ��ɽ��ò���ֵ���ɶ�ά��չʾ��������ɨ��֧��
	
	private String return_code;//����״̬��SUCCESS/FAIL���ֶ���ͨ�ű�ʶ���ǽ��ױ�ʶ�������Ƿ�ɹ���Ҫ�鿴result_code���ж�
	private String return_msg;//������Ϣ
	public String getAppid() {
		return appid;
	}
	public String getMch_id() {
		return mch_id;
	}
	public String getDevice_info() {
		return device_info;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public String getSign() {
		return sign;
	}
	public String getResult_code() {
		return result_code;
	}
	public String getErr_code() {
		return err_code;
	}
	public String getErr_code_des() {
		return err_code_des;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public String getPrepay_id() {
		return prepay_id;
	}
	public String getCode_url() {
		return code_url;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}
	public void setCode_url(String code_url) {
		this.code_url = code_url;
	}
	public String getReturn_code() {
		return return_code;
	}
	public String getReturn_msg() {
		return return_msg;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

}
