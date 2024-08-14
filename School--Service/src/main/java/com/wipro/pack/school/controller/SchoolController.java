package com.wipro.pack.school.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SchoolController {
	
	
	RestTemplate res=new RestTemplate();
	
	@RequestMapping(value="getSchoolDetails/{schoolname}",method=RequestMethod.GET)
	public String getStudents(@PathVariable String schoolname) {
		System.out.println(" details for the school "+schoolname);
		String response=res.exchange("http://students-service/getStudentsBySchool/{schoolname}", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
			
		},schoolname).getBody();
		System.out.println("response received as "+response);
		return "School Name- "+ schoolname +"\n student details - " +response;
	}
	
	
	
	
}
