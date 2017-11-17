package com.duopei.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AopConifg.class);
		
		AnnotationService annotationService = ctx.getBean(AnnotationService.class);
		annotationService.add();
		
		MethodService methodService = ctx.getBean(MethodService.class);
		methodService.add();
		
		ctx.close();
	}
	
}
