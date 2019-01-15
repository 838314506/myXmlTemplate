package com.lz.snappy.myXmlTemplate.template.fileReplace;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
/**
 * 此类使用ftl文件，采用freemarker中的api来实现替换文件中的占位符最后返回替换后的文件字符串
 * @author lzz
 *
 */
public class XmlParser {
	
	private static Configuration cfg;
	
	public static void initCfg() {
		//类存储了常用设置，定义了想要在所有模板中使用的变量，并且负责template的创建和缓存
		//也就是说，在这里设置它的一些变量，只要设置一次即可
		cfg = new freemarker.template.Configuration();
		cfg.setNumberFormat("#");//不设置格式如果输入值为1000，则显示1,000
		cfg.setDefaultEncoding("utf-8");
		cfg.setClassForTemplateLoading(XmlParser.class, File.separator + "freeMakerTemplates");
	}
	
	public String writerToFile(Object data,String templateName) throws IOException, TemplateException {
		//使用这种方式来创建一个template的话，configuration中的配置会影响到每一个template
		//并且使用这种方式，在创建出模板的时候会写一份进入缓存中，在下次，检测到不同的时候会
		//自动的载入和解析模板
		Template template = cfg.getTemplate(templateName);
		//out一定要调用close()方法关闭流
		CharArrayWriter out = new CharArrayWriter();
		template.process(data, out);
		char[] chars = out.toCharArray();
		return new String(chars);
		
	}
	

}
