package com.lz.snappy.myXmlTemplate.template;

import com.lz.snappy.myXmlTemplate.model.H2010Entry;
import com.lz.snappy.myXmlTemplate.model.RequestMessage;

/**
 * 使用模板模式，对之前h2010-public-proxy-sdk中的拼接xml字符串的环节进行实现，此类为抽象模板类
 * @author lzz
 *
 */
public abstract class XmlTemplate {

	// 定义生成xml文件模板模式的基本样式的生成逻辑
	public String xmlBuilder(RequestMessage requestMessage,H2010Entry h2010Entry) {
		// 分别调用三个方法来生成一个完整的xml文件
		StringBuilder xmlData = new StringBuilder();
		xmlData.append(xmlHead(requestMessage.getNameType()));
		xmlData.append(xmlBody(requestMessage,h2010Entry));
		xmlData.append(xmlFoot(requestMessage.getNameType()));
		return xmlData.toString();
	}

	// xml文件的头格式生成
	public String xmlHead(String headLable) {
		StringBuilder xmlHead = new StringBuilder();
		xmlHead.append("<?xml version=\"1.0\"?>");
		xmlHead.append("<" + headLable + " xmlns=\"http://h2000.com.cn/Imc/"
				+ headLable.toLowerCase() + ".xsd\" \r");
		xmlHead.append(" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" \r");
		xmlHead.append(" xsi:schemaLocation=\"http://h2000.com.cn/Ims/" + headLable.toLowerCase()
				+ ".xsd C:\\H2000_DOC\\IMS\\设计文档及需求\\Schemas\\" + headLable + ".xsd\"> \r");
		return xmlHead.toString();
	}

	// xml文件的体格式生成，定义为抽象方法，由子类具体实现
	public abstract String xmlBody(RequestMessage requestMessage,H2010Entry h2010Entry);

	// xml文件的尾格式生成
	private String xmlFoot(String footLableName) {
		return "</" + footLableName + ">";
	}

}
