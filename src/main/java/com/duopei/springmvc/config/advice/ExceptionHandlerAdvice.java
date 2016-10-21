package com.duopei.springmvc.config.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice // @ControllerAdvice声明一个控制器建言，
public class ExceptionHandlerAdvice {

	@ExceptionHandler(value = Exception.class) // @ExceptionHandler此处定义为全局变量，通过value可以过滤拦截条件，可以拦截所有的Exception
	public ModelAndView exception(Exception exception , WebRequest request ){
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("errorMsg", exception.getMessage());
		return modelAndView;
	}
	
	@ModelAttribute // @ModelAttribute注解将键值对添加到全局，所有注解@RequestMapping的方法都可以获得此键
	public void addAttribute(Model model){
		model.addAttribute("msg", "附加信息>>>>>>>>>");
	}
	
	@InitBinder // @InitBinder 定制WebDataBinder
	public void initBinder(WebDataBinder binder){
		binder.setDisallowedFields("id");
	}
	
}
