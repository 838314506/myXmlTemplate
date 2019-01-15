package com.lz.snappy.myXmlTemplate.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class H2010EntryHead implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String entryId;//海关编号
	private String preEntryId;//预录入号码
	private String iEFlag;//进出口标志
	private String declPort;//申报口岸代码
	private LocalDateTime dDate;//申报日期
	private String iEPort;//进出口岸代码
	private LocalDateTime iEDate;//进出口日期
	private String trafMode;//运输方式代码
	
	

}
