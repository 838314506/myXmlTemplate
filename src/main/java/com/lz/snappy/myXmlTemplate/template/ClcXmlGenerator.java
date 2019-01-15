package com.lz.snappy.myXmlTemplate.template;

import com.lz.snappy.myXmlTemplate.model.H2010Entry;
import com.lz.snappy.myXmlTemplate.model.RequestMessage;
import com.lz.snappy.myXmlTemplate.util.XmlUtil;

public class ClcXmlGenerator extends XmlTemplate {

	@Override
	public String xmlBody(RequestMessage requestMessage, H2010Entry h2010Entry) {
		if (h2010Entry == null || requestMessage == null) {
			return "";
		}
		return "<ENTRY_ID>" + XmlUtil.strIsNull(h2010Entry.getEntryHead().getEntryId())
				+ "</ENTRY_ID> \r";
	}

}
