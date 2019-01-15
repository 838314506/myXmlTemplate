package com.lz.snappy.myXmlTemplate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestMessage {

	private String stepId;
	private String customsCode;
	private String businessId;
	private String channel;
	private String entryStatus;
	private String nameType;
	private String additional;
}
