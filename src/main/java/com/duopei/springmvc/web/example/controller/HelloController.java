package com.duopei.springmvc.web.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	
	//@RequestMapping(value = "/xx")
	@RequestMapping(value = "/xxx")
	public String hello(){
		return "index"; // 通过WebConfig的viewResolver的bean配置，返回值为index。说明我们页面放置路径为/WEB-INF/classes/views/index.jsp
	}
}
