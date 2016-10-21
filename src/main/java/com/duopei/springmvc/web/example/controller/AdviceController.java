package com.duopei.springmvc.web.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duopei.springmvc.web.example.dto.Book;

/**
 * 涉及类：ExceptionHandlerAdvice
 * 
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/advice")
public class AdviceController {

	@RequestMapping(value="/err")
	public String getSomeThing(@ModelAttribute("msg") String msg, Book book){
		throw new IllegalArgumentException("非常抱歉，参数有误 / " +"来至@ModelAttribute=" +msg);
	}
	
}
