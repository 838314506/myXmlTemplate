package com.lz.snappy.myXmlTemplate.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;

import lombok.Data;

public class JSONUTIL {
	ObjectMapper obj = new ObjectMapper();
	String jsonString = "{\"name\":\"tom\";\"age\":18}";
	
	public String objToJson() {
		try {
			Student student = obj.readValue(jsonString, Student.class);
			System.out.println(student);
//			obj.enable(SerializationConfig.f)
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}

@Data
class Student{
	private String name;
	private int age;
	
}
