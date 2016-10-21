package com.duopei.springmvc.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *  拦截器（interceptor）实现对每个请求处理前后进行相关业务操作处理，类似于Servlet的Filter
 *   	让普通的Bean实现HandlerInterceptorAdapter 或 继承HandlerInterceptor接口 来实现自定义拦截器
 *   
 *   通过重写WebMvcConfigurerAdapter的addInterceptors方法来注册自定义的拦截器。
 *   
 *   本例子来实现每次请求的处理时间
 * @author Administrator
 *
 */
public class ExampleInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 请求发生前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		super.preHandle(request, response, handler);
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return true;
	}

	/**
	 * 请求完成后执行
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
		Long startTime = (Long) request.getAttribute("startTime");
		System.out.println("本次请求处理时间为1：" + ( System.currentTimeMillis() - startTime ) +" ms");
		request.removeAttribute("startTime");
	}
	
}
