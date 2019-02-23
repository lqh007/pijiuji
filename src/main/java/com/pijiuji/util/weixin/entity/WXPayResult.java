package com.pijiuji.util.weixin.entity;

/**
 * ΢��֧��������صĲ���
 * @author iYjrg_xiebin
 * @date 2015��11��24������5:33:20
 */
public class WXPayResult {

	private String appid;//�����˺�ID
	private String mch_id;//΢��֧��������̻���
	private String device_info;//΢��֧��������ն��豸�ţ�
	private String nonce_str;//����ַ�����32λ������+��д��ĸ���
	private String sign;//ǩ�����ص���ʱ����Ҫ��У��
	private String result_code;//SUCCESS/FAIL
	private String err_code;//���󷵻ص���Ϣ����
	private String err_code_des;//���󷵻ص���Ϣ����
	private String openid;//�û����̻�appid�µ�Ψһ��ʶ
	private String is_subscribe;//�û��Ƿ��ע�����˺ţ�Y-��ע��N-δ��ע�����ڹ����˺�����֧����Ч
	private String trade_type;//��������:JSAPI��NATIVE��APP
	private String bank_type;//��������:ICBC_DEBIT:�������У���ǿ���;ICBC_CREDIT:�������У����ÿ���;
	private int total_fee;//�����ܽ���λΪ��;1Ԫ=100�֣�
	private String fee_type;//�������࣬����ISO4217��׼����λ��ĸ���룬Ĭ������ң�CNY
	private int cash_fee;//ʵ��֧�����ֽ�֧�������ֽ�֧�����
	private String cash_fee_type;//�������ͣ�����ISO4217��׼����λ��ĸ���룬Ĭ������ң�CNY
	private int coupon_fee;//�Ż�ȯ�ܽ�����ȯ�������Żݽ��<=�����ܽ������ܽ��-����ȯ�������Żݽ��=�ֽ�֧�����
	private int coupon_count;//�Ż�ȯ��������1��
	private String coupon_id_0;//����ȯ�������Ż�ID,$nΪ�±꣬��0��ʼ���;Ŀǰһ������ֻ����һ���Ż�ȯ��(������Ҫ����Ļ����Ӳ���)
	private int coupon_fee_0;//��������ȯ�������Ż�֧�����,$nΪ�±꣬��0��ʼ���
	private String transaction_id;//΢��֧��������:1217752501201407033233368018
	private String out_trade_no;//�̻�ϵͳ�Ķ����ţ�������һ�¡����׵��ţ�1212321211201407033568112322
	private String attach;//�̼����ݰ���ԭ������:���簢�ϴ�˹������Ь����ɫ��35
	private String time_end;//֧�����ʱ�䣬��ʽΪyyyyMMddHHmmss����2009��12��25��9��10��10���ʾΪ20091225091010
	private String return_code;//SUCCESS/FAIL ���ֶ���ͨ�ű�ʶ���ǽ��ױ�ʶ�������Ƿ�ɹ���Ҫ�鿴result_code���ж�
	private String return_msg;//������Ϣ����ǿգ�Ϊ����ԭ��
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
	public String getOpenid() {
		return openid;
	}
	public String getIs_subscribe() {
		return is_subscribe;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public String getBank_type() {
		return bank_type;
	}
	public int getTotal_fee() {
		return total_fee;
	}
	public String getFee_type() {
		return fee_type;
	}
	public int getCash_fee() {
		return cash_fee;
	}
	public String getCash_fee_type() {
		return cash_fee_type;
	}
	public int getCoupon_fee() {
		return coupon_fee;
	}
	public int getCoupon_count() {
		return coupon_count;
	}
	public String getCoupon_id_0() {
		return coupon_id_0;
	}
	public int getCoupon_fee_0() {
		return coupon_fee_0;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public String getAttach() {
		return attach;
	}
	public String getTime_end() {
		return time_end;
	}
	public String getReturn_code() {
		return return_code;
	}
	public String getReturn_msg() {
		return return_msg;
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
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}
	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	public void setCash_fee(int cash_fee) {
		this.cash_fee = cash_fee;
	}
	public void setCash_fee_type(String cash_fee_type) {
		this.cash_fee_type = cash_fee_type;
	}
	public void setCoupon_fee(int coupon_fee) {
		this.coupon_fee = coupon_fee;
	}
	public void setCoupon_count(int coupon_count) {
		this.coupon_count = coupon_count;
	}
	public void setCoupon_id_0(String coupon_id_0) {
		this.coupon_id_0 = coupon_id_0;
	}
	public void setCoupon_fee_0(int coupon_fee_0) {
		this.coupon_fee_0 = coupon_fee_0;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}
	

}
