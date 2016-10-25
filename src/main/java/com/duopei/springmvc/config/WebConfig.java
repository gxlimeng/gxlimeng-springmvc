package com.duopei.springmvc.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.duopei.springmvc.config.interceptor.ExampleInterceptor;

@Configuration
@EnableScheduling
@ComponentScan("com.duopei.springmvc")
@EnableWebMvc // 开启Spring mvc支持（@EnableWebMvc并会开启一些默认配置，如ViewResolver  或者MessageConverter等）
@PropertySource(value = "classpath:config.properties", encoding = "UTF-8") //
public class WebConfig extends WebMvcConfigurerAdapter {

	/**
	 * 配置了一个jsp的viewResolver,jsp视图解析器的bean
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}

	/*
	 * 避免IE执行AJAX时,返回JSON出现下载文件
	 */
	@Bean
	public MappingJackson2HttpMessageConverter jacksonMessageConverter() {
		MappingJackson2HttpMessageConverter jacksonMessageConverter = new MappingJackson2HttpMessageConverter();
		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
		supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		supportedMediaTypes.add(MediaType.valueOf(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"));
		supportedMediaTypes.add(MediaType.valueOf(MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8"));
		jacksonMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
		return jacksonMessageConverter;
	}

	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {
		StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(
				Charset.forName("UTF-8"));
		List<MediaType> mediaTypeList = new ArrayList<MediaType>();
		mediaTypeList.add(MediaType.valueOf(MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8"));
		mediaTypeList.add(MediaType.valueOf(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"));
		stringHttpMessageConverter.setSupportedMediaTypes(mediaTypeList);
		return stringHttpMessageConverter;
	}

	/**
	 * 静态资源访问
	 * addResourceLocations指的是文件放置目录，addResourceHandler只的是对外暴露的路径
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
		super.extendMessageConverters(messageConverters);
		messageConverters.add(jacksonMessageConverter());
	}

	/**
	 * 拦截器 相关配置 
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		registry.addInterceptor(exampleInterceptor());
	}

	@Bean
	public ExampleInterceptor exampleInterceptor() {
		return new ExampleInterceptor();
	}

	/**
	 * 配置简单页面跳转（简化配置）
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		super.addViewControllers(registry);
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/sse").setViewName("sse");
		registry.addViewController("/async").setViewName("async");
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		super.configurePathMatch(configurer);
		configurer.setUseSuffixPatternMatch(true);
	}

	/**
	 * 文件上传配置
	 */
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(1000000);
		return multipartResolver;
	}
	
	/**
	 * 异步线程支持
	 */
	/*
	  @Override
	  public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
	       configurer.setDefaultTimeout(30*1000L); //tomcat默认10秒
	       configurer.setTaskExecutor(mvcTaskExecutor());//所借助的TaskExecutor
	   }
	  
	   @Bean
	   public ThreadPoolTaskExecutor mvcTaskExecutor(){
	        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	        executor.setCorePoolSize(10);
	        executor.setQueueCapacity(100);
	        executor.setMaxPoolSize(25);
	        return executor;
	    }
*/
	
}
