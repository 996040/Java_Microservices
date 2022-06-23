package com.zensar.contributor;

import org.springframework.boot.actuate.info.Info.Builder;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;


@Component
public class Info_Contributor implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		Map<String, Object> studentDetails = new HashMap<String,Object>();
		studentDetails.put("Created By", "Neeraj");
		studentDetails.put("Modification", "23 july 2022");
		studentDetails.put("Training", "Java_Microservices&Core_Java");
		builder.withDetail("Student", studentDetails);
		
	}

}
