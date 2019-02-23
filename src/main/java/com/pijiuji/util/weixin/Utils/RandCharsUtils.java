package com.pijiuji.util.weixin.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * nonce_str�漴�ַ���
 * @author iYjrg_xiebin
 * @date 2015��11��25������5:10:32
 */
public class RandCharsUtils {
	private static SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

	public static String getRandomString(int length) { //length��ʾ�����ַ����ĳ���
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";   
		Random random = new Random();   
		StringBuffer sb = new StringBuffer();
		int number = 0;
		for (int i = 0; i < length; i++) {   
			number = random.nextInt(base.length());   
			sb.append(base.charAt(number));   
		}   
		return sb.toString();   
	}   
	
	/*
	 * ������ʼ���׵�ʱ��
	 */
	public static String timeStart(){
		return df.format(new Date());
	}
	
	/*
	 * ����ʧЧ��ʱ��
	 */
	public static String timeExpire(){
		Calendar now=Calendar.getInstance();
		now.add(Calendar.MINUTE,30);
		return df.format(now.getTimeInMillis());
	}


	public static void main(String[] args) {
		/*for (int i = 0; i < 10; i++) {
			System.out.println("��"+i+"���ǣ�"+getRandomString(32));
		}*/
		

		System.out.println("��ʼʱ���ǣ�"+timeStart());
		System.out.println("��ʼʱ���ǣ�"+timeExpire());
	}

}
