package com.duopei.spring.ioc.way2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //表明此类是一个配置类，意味着这个类有０个或多个＠Bean的注解。没有@ComponentScan则因为所有的Bean都在类中自定义了。
public class JavaConfig {
	
	@Bean // 表明此方法返回一个Bean，Bean的名称为方法名
	public FunctionService functionService(){
		return new FunctionService();
	}
	
	// 方式1 方法
	@Bean
	public UserFunctionService userFunctionService(){
		UserFunctionService userFuncService = new UserFunctionService();
		userFuncService.setFunService(functionService()); // 注入UserFunctionService直接调用functionSerice
		return userFuncService; 
	}
	
	/*
	// 方式2 参数
	@Bean // 另一种方式：直接将FunctionService作为参数给userFunctionService，这也是Spring容器的一个功能，在Sping容器中，只要容器中存在某个Bean，就可以在另一个Bean中声明方法的参数中写入
	public UserFunctionService userFunctionService2(FunctionService functionSerice){
		UserFunctionService userFuncService = new UserFunctionService();
		userFuncService.setFunService(functionSerice);
		return userFuncService; 
	}
	*/
	
}
