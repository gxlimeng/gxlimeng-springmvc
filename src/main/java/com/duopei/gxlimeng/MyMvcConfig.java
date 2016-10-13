package com.duopei.gxlimeng;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc // @EnableWebMvc注解会开启对Spirng mvc的支持，一些默认设置
@ComponentScan("com.duopei.gxlimeng")
// Spring定制配置需要继承WebMvcConfigurerAdapter类，并在类中使用@EnableWebMvc注解来开启对Spring
// mvc的支持。 这样就可以重写这个类的方法完成我们的常用配置
public class MyMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	
	// json转换器
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter convert = new MappingJackson2HttpMessageConverter();
		List<MediaType> list = new ArrayList<MediaType>();
		list.add(MediaType.TEXT_HTML);
		list.add(MediaType.APPLICATION_JSON_UTF8);
		convert.setSupportedMediaTypes(list);
		return convert;
	}

	// addResourceLocations指的是文件放置目录，addResourceHandler指的是对外暴露的访问路径，静态资源映射
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(mappingJackson2HttpMessageConverter());
	}

	/*
	 * @SuppressWarnings("rawtypes")
	 * 
	 * @Bean public HttpMessageConverter getMappingJaskson() {
	 * MappingJackson2HttpMessageConverter convert = new
	 * MappingJackson2HttpMessageConverter(); List<MediaType>
	 * supportedMediaTypes = new ArrayList<MediaType>();
	 * supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
	 * supportedMediaTypes.add(MediaType.APPLICATION_XML);
	 * convert.setSupportedMediaTypes(supportedMediaTypes); return convert; }
	 */

}
