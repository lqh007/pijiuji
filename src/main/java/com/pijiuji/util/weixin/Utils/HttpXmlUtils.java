package com.pijiuji.util.weixin.Utils;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;


/**
 * post�ύxml��ʽ�Ĳ���
 * @author iYjrg_xiebin
 * @date 2015��11��25������3:33:38
 */
public class HttpXmlUtils {

	/**
	 * ��ʼpost�ύ�������ӿ�
	 * �����ܷ���
	 * @param url
	 * @param xml
	 * @param method
	 * @param contentType
	 * @return
	 */
	public static String xmlHttpProxy(String url,String xml,String method,String contentType){
		InputStream is = null;
		OutputStreamWriter os = null;

		try {
			URL _url = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) _url.openConnection();
			conn.setDoInput(true);   
			conn.setDoOutput(true);   
			conn.setRequestProperty("Content-type", "text/xml");
			conn.setRequestProperty("Pragma:", "no-cache");  
			conn.setRequestProperty("Cache-Control", "no-cache");  
			conn.setRequestMethod(method);
			os = new OutputStreamWriter(conn.getOutputStream());
			os.write(new String(xml.getBytes(contentType)));
			os.flush();

			//����ֵ
			is = conn.getInputStream();
			return getContent(is, "utf-8");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if(os!=null){os.close();}
				if(is!=null){is.close();}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * �������ص�ֵ
	 * @param is
	 * @param charset
	 * @return
	 */
	public static String getContent(InputStream is, String charset) {
		String pageString = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		StringBuffer sb = null;
		try {
			isr = new InputStreamReader(is, charset);
			br = new BufferedReader(isr);
			sb = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			pageString = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null){
					is.close();
				}
				if(isr!=null){
					isr.close();
				}
				if(br!=null){
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			sb = null;
		}
		return pageString;
	}

	/**
	 * ����xml����
	 * @return
	 */
	public static String xmlInfo(SortedMap sortedMap){
/**
 *         parameters.put("desc", desc);
 */
		if(sortedMap!=null){
			StringBuffer bf = new StringBuffer();
			bf.append("<xml>");

			bf.append("<mch_appid>");
			bf.append(sortedMap.get("mch_appid"));
			bf.append("</mch_appid>");

			bf.append("<mchid>");
			bf.append(sortedMap.get("mchid"));
			bf.append("</mchid>");

			bf.append("<nonce_str><![CDATA[");
			bf.append(sortedMap.get("nonce_str"));
			bf.append("]]></nonce_str>");

			bf.append("<sign><![CDATA[");
			bf.append(sortedMap.get("sign"));
			bf.append("]]></sign>");

			bf.append("<partner_trade_no><![CDATA[");
			bf.append(sortedMap.get("partner_trade_no"));
			bf.append("]]></partner_trade_no>");

			bf.append("<openid><![CDATA[");
			bf.append(sortedMap.get("openid"));
			bf.append("]]></openid>");

			bf.append("<check_name><![CDATA[");
			bf.append(sortedMap.get("check_name"));
			bf.append("]]></check_name>");

			bf.append("<spbill_create_ip><![CDATA[");
			bf.append(sortedMap.get("spbill_create_ip"));
			bf.append("]]></spbill_create_ip>");

			bf.append("<amount><![CDATA[");
			bf.append(sortedMap.get("amount"));
			bf.append("]]></amount>");

			bf.append("<desc><![CDATA[");
			bf.append(sortedMap.get("desc"));
			bf.append("]]></desc>");

			bf.append("</xml>");
			return bf.toString();
		}

		return "";
	}


	
	
	/**
	 * post���󲢵õ����ؽ��
	 * @param requestUrl
	 * @param requestMethod
	 * @param output
	 * @return
	 */
	public static String httpsRequest(String requestUrl, String requestMethod, String output) {
		try{
			URL url = new URL(requestUrl);
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setRequestMethod(requestMethod);
			if (null != output) {
				OutputStream outputStream = connection.getOutputStream();
				outputStream.write(output.getBytes("UTF-8"));
				outputStream.close();
			}
			// ����������ȡ��������
			InputStream inputStream = connection.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			connection.disconnect();
			return buffer.toString();
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return "";
	}

	/**
	 * 解析申请退款之后微信返回的值并进行存库操作
	 * @throws IOException
	 * @throws JDOMException
	 */
	public static Map<String, String> parseRefundXml(String refundXml) throws JDOMException, IOException{
		ParseXMLUtils.jdomParseXml(refundXml);
		StringReader read = new StringReader(refundXml);
		// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
		InputSource source = new InputSource(read);
		// 创建一个新的SAXBuilder
		SAXBuilder sb = new SAXBuilder();
		// 通过输入源构造一个Document
		org.jdom.Document doc;
		doc = (org.jdom.Document) sb.build(source);
		org.jdom.Element root = doc.getRootElement();// 指向根节点
		List<Element> list = root.getChildren();
		Map<String, String> refundOrderMap = new HashMap<String, String>();
		if(list!=null&&list.size()>0){
			for (org.jdom.Element element : list) {
				refundOrderMap.put(element.getName(), element.getText());
			}
			return refundOrderMap;
		}
		return null;
	}
}
