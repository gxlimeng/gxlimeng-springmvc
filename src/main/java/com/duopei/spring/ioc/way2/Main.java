package com.duopei.spring.ioc.way2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=  new AnnotationConfigApplicationContext(JavaConfig.class);
		
		// 方式1 JavaConfig 方法获取
		UserFunctionService userFunService = ctx.getBean(UserFunctionService.class);
		System.out.println("userFunService="+userFunService.sayHello("世界"));
		
		// 方式2 JavaConfig 参数获取
		//UserFunctionService userFunService2 = (UserFunctionService) ctx.getBean("userFunctionService2");
		//System.out.println("userFunService2="+userFunService2.sayHello("中国"));
		ctx.close();
	}
	
}
