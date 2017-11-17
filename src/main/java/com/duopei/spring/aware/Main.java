package com.duopei.spring.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AwareConfig.class);
		AwareService awareService = ctx.getBean(AwareService.class);
		awareService.outputResult();
		ctx.close();
	}

}
