package com.example.demo.info;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class InfoContri implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		Map<String, Object> studentDetails = new HashMap<String,Object>();
		studentDetails.put("Created By", "Neeraj Nikam");
		studentDetails.put("Modification", "22 july 2022");
		studentDetails.put("Training", "Core_Java & Java_Microservices");
		builder.withDetail("Student", studentDetails);
		
	}

}
