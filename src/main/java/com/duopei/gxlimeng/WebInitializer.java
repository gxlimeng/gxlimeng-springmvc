package com.duopei.gxlimeng;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * WebApplicationInitializer是Spring提供用来配置servlet3.0+配置接口。从而实现了提到原web.xml配置文件。
 *  实现此接口将会自动被SpringServletContainerInitalizer（用来启动servlet3.0+容器）所获取
 * @author GXLIMENG
 *
 */
public class WebInitializer implements WebApplicationInitializer { 

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(MyMvcConfig.class);
		ctx.setServletContext(servletContext); // 新建WebApplicationContext，注册配置类，并将其与当前servletContext关联

		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx)); // 注册Spring mvc的DispatcherServlet
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

}
