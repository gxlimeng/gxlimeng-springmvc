package com.duopei.spring.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);  //声明AnnotationConfigApplicationContext为Spring的容器，接受一个配置类作为参数
		UserFunctionService userFunService = ctx.getBean(UserFunctionService.class); // 获得Spring容器中的Bean实例
		String rtnstr = userFunService.sayHello("你好");
		System.out.println(rtnstr);
		ctx.close();
	}
}
