package com.pijiuji.util.weixin.Utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ΢�ŵ����ò���
 * @author iYjrg_xiebin
 * @date 2015��11��25������4:19:57
 */
@SuppressWarnings("unused")
public class WeixinConfigUtils {

	private static final Log log = LogFactory.getLog(WeixinConfigUtils.class);


	public static String appid;
	public static String mch_id;
	public static String notify_url;

	static {
		/*ResourceBundle bundle = ResourceBundle.getBundle("resources/sys");
		appid = bundle.getString("appid");
		mch_id = bundle.getString("mch_id");
		notify_url = bundle.getString("notify_url");*/

		try{
			InputStream is = WeixinConfigUtils.class.getResourceAsStream("/resources/sys.properties");
			Properties properties = new Properties();
			properties.load(is);
			
			appid = properties.getProperty("appid");
			mch_id = properties.getProperty("mch_id");
			notify_url = properties.getProperty("notify_url");
		}catch(Exception ex){
			log.debug("���������ļ���"+ex.getMessage());
		}
	}


	public static void main(String[] args) throws IOException {
		InputStream is = WeixinConfigUtils.class.getResourceAsStream("/resources/sys.properties");

		Properties properties = new Properties();

		properties.load(is);

		is.close();
		String appid = properties.getProperty("appid");
		System.out.println(appid);
	}

}
