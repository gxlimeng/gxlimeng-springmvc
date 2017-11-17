package com.duopei.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(GxlimengConfiguration.class);
		DemoService service = ctx.getBean(DemoService.class);
		service.outputResult();
		ctx.close();
	}
}
