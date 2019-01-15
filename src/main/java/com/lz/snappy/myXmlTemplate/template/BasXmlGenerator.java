package com.lz.snappy.myXmlTemplate.template;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.lz.snappy.myXmlTemplate.model.H2010Entry;
import com.lz.snappy.myXmlTemplate.model.H2010EntryHead;
import com.lz.snappy.myXmlTemplate.model.RequestMessage;
import com.lz.snappy.myXmlTemplate.template.fileReplace.XmlParser;
import com.lz.snappy.myXmlTemplate.util.XmlUtil;

import freemarker.template.TemplateException;

public class BasXmlGenerator extends XmlTemplate {

	@Override
	public String xmlBody(RequestMessage requestMessage,H2010Entry h2010Entry) {
		if (h2010Entry == null || requestMessage == null) {
			return "";
		}
		H2010EntryHead entryHead = h2010Entry.getEntryHead();
		StringBuilder xmlBody = new StringBuilder();
		xmlBody.append("<ENTRY_ID>");
		xmlBody.append(XmlUtil.strIsNull(entryHead.getEntryId()) + "</ENTRY_ID>" + "\r");
		xmlBody.append("<CHANNEL>");
		xmlBody.append(XmlUtil.strIsNull(requestMessage.getChannel()) + "</CHANNEL>" + "\r");
		xmlBody.append("<I_E_FLAG>");
		xmlBody.append(XmlUtil.strIsNull(entryHead.getIEFlag()) + "</I_E_FLAG>" + "\r");
		xmlBody.append("<DECL_PORT>");
		xmlBody.append(XmlUtil.strIsNull(entryHead.getDeclPort()) + "</DECL_PORT>" + "\r");
		xmlBody.append("<D_DATE>");
		xmlBody.append(XmlUtil.dateIsNull(entryHead.getDDate()) + "</D_DATE>" + "\r");
		xmlBody.append("<I_E_PORT>");
		xmlBody.append(XmlUtil.strIsNull(entryHead.getIEPort()) + "</I_E_PORT>" + "\r");
		xmlBody.append("<I_E_DATE>");
		xmlBody.append(XmlUtil.dateIsNull(entryHead.getIEDate()) + "</I_E_DATE>" + "\r");
		xmlBody.append("<TRAF_MODE>");
		xmlBody.append(XmlUtil.strIsNull(entryHead.getTrafMode()) + "</TRAF_MODE>" + "\r");
		xmlBody.append("<ENTRY_STATUS>");
		xmlBody.append(
				XmlUtil.strIsNull(requestMessage.getEntryStatus()) + "</ENTRY_STATUS>" + "\r");
		xmlBody.append("<DUTY_P_DATE></DUTY_P_DATE>" + "\r");
		xmlBody.append("<TAX_ID></TAX_ID>" + "\r");
		return xmlBody.toString();
	}

	public static void main(String[] args) {
//			RequestMessage message = RequestMessage.builder().businessId("525252").channel("G")
//					.customsCode("5656").entryStatus("1000").nameType("BAS_CUSTOMS_RESULT").build();
//			H2010Entry h2010Entry2 = H2010Entry.builder()
//					.entryHead(H2010EntryHead.builder().dDate(LocalDateTime.now()).declPort("declProt")
//							.entryId("1000652").iEDate(LocalDateTime.now()).iEFlag("ieflag")
//							.iEPort("8080").trafMode("5622").build())
//					.build();
//			XmlTemplate xml = null;
//			if(message.getNameType().equals("BAS_CUSTOMS_RESULT")) {
//				xml = new BasXmlGenerator();
//			}else if(message.getNameType().equals("CLC_CUSTOMS_RESULT")) {
//				xml = new ClcXmlGenerator();
//			}
//			System.out.println(xml.xmlBuilder(message,h2010Entry2));
		long start = System.currentTimeMillis();
		Map<String,Object> map = new HashMap<>();
		map.put("entryId", "1000652");
		map.put("dDate", LocalDateTime.now());
		map.put("channel", "G");
		map.put("iEFlag", "ieflag");
		map.put("declProt", "declProt");
		map.put("iEPort", "iEPort");
		map.put("iEDate", LocalDateTime.now());
		map.put("trafMode", "trafMode");
		map.put("entryStatus", 1000);
		
		XmlParser parser = new XmlParser();
		try {
			String result = parser.writerToFile(map, "basCustomsResult.ftl");
			System.out.println(result);
		} catch (IOException | TemplateException e) {
			System.out.println("出现了错误！");
		}
		//使用替换xml文件单个耗时315毫秒,所以应该采取，模板模式来进行完成
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

}
