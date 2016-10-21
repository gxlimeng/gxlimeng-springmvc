package com.duopei.springmvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer { // WebApplicationInitializer是Spring提供用来配置Servlet3.0+的配置接口。从而实现替代了web.xml位置。
																														// 实现此接口将会自动被SpringServletContainerInitializer（用来启动servlet3.0）

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebConfig.class);
		ctx.setServletContext(servletContext);  // 新建WebApplicationContext，注册配置类，必将其和当前servletContext关联
		
		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx)); // 注册Spring mvc的DispatcherServlet
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		servlet.setAsyncSupported(true); // 开启异步支持
	}

}
