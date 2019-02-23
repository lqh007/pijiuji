package com.pijiuji.util.weixin.Utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;

public class ParseXMLUtils {

	/**
	 * 1��DOM����
	 */
	@SuppressWarnings("rawtypes")
	public static void parseXml(String xml){
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(xml); // ���ַ���תΪXML
			Element rootElt = doc.getRootElement(); // ��ȡ���ڵ�smsReport
			System.out.println("���ڵ��ǣ�"+rootElt.getName());
			String return_code=rootElt.elementTextTrim("return_code");
			String return_msg=rootElt.elementTextTrim("return_msg");
			
			Iterator iters = rootElt.elementIterator("sendResp"); // ��ȡ���ڵ��µ��ӽڵ�sms
			while (iters.hasNext()) {
				Element recordEle1 = (Element) iters.next();
				Iterator iter = recordEle1.elementIterator("sms");
				while (iter.hasNext()) {
					Element recordEle = (Element) iter.next();
					String phone = recordEle.elementTextTrim("phone"); // �õ�sms�ڵ��µ��ӽڵ�statֵ
					String smsID = recordEle.elementTextTrim("smsID"); // �õ�sms�ڵ��µ��ӽڵ�statֵ
					System.out.println(phone+":"+smsID);
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 2��DOM4j����XML��֧��xpath��
	 * ������ʱ���Զ�ȥ��CDMA
	 * @param xml
	 */
	public static void xpathParseXml(String xml){
		try { 
			StringReader read = new StringReader(xml);
			SAXReader saxReader = new SAXReader();
			Document doc = saxReader.read(read);
			String xpath ="/xml/appid";
			System.out.print(doc.selectSingleNode(xpath).getText());  
		} catch (DocumentException e) {
			e.printStackTrace();
		}  
	}

	/**
	 * 3��JDOM����XML
	 * ������ʱ���Զ�ȥ��CDMA
	 * @param xml
	 */
	@SuppressWarnings("unchecked")
	public static void jdomParseXml(String xml){
		try { 
			StringReader read = new StringReader(xml);
			// �����µ�����ԴSAX ��������ʹ�� InputSource ������ȷ����ζ�ȡ XML ����
			InputSource source = new InputSource(read);
			// ����һ���µ�SAXBuilder
			SAXBuilder sb = new SAXBuilder();
			// ͨ������Դ����һ��Document
			Document doc;
			doc = (Document) sb.build(source);
			Element root = doc.getRootElement();// ָ����ڵ�
			List<Element> list = ((org.jdom.Element) root).getChildren();
			if(list!=null&&list.size()>0){
				for (Element element : list) {
					System.out.println("key�ǣ�"+element.getName()+"��ֵ�ǣ�"+element.getText());
				}
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}




	


}
